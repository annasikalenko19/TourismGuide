package com.example.oop.GUI;

import com.example.oop.logic.database.Utils;
import com.example.oop.logic.exception.PlaceNotSelectedException;
import com.example.oop.logic.map.graph.Graph;
import com.example.oop.logic.map.station.Cafe;
import com.example.oop.logic.map.station.Station;
import com.example.oop.logic.user.Admin;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class TripMap extends Application {
    public static final int NUMBER_OF_CENTERS = 25;
    public static final int NUMBER_OF_DESTINATIONS = 10;
    public final Stage askStage = new Stage();
    public static final Object mutex = new Object();
    public static Admin currentAdmin = null;
    private ImageView currMark = null;

    {
        Parent root = null;
        try {
            var location = Utils.class.getResource("/com/example/oop/ask-station.fxml");
            System.out.println(location);
            FXMLLoader loader = new FXMLLoader(location);
            root = loader.load();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public TripMap() {}

    @Override
    public void start(Stage stage) throws Exception {
        new TripMap("Vinnytsia", "Askania-Nova", 0b1111);
    }

    public static void showMapOnly() {
        var root = createMapRoot();
        Scene scene = new Scene(root, 1280, 847);
        scene.getStylesheets().addAll(Objects.requireNonNull(TripMap.class.getResource("/style/style.css")).toExternalForm());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        displayDestinationPositions(root);
    }

    public TripMap(String from, String to, int n) throws PlaceNotSelectedException {


        if(from==null || to==null){
            throw new PlaceNotSelectedException();
        }
        var root = createMapRoot();
        Label label = new Label("besfivw");
        root.getChildren().add(label);
        label.setLayoutX(200);
        label.setLayoutY(600);
        //lamda
        root.setOnMouseClicked(event -> {
            System.out.printf("x = %f, y = %f\n",event.getSceneX(),event.getSceneY());
            Graph graph = Graph.getInstance();


            System.out.println(graph.getNearestCenter(event.getSceneX(),event.getSceneY()));
        });

        Scene scene = new Scene(root, 1280, 847);
        scene.getStylesheets().addAll(Objects.requireNonNull(getClass().getResource("/style/style.css")).toExternalForm());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        displayDestinationPositions(root);
        var graph = Graph.getInstance();

        //displayCafe(root);
        // graph.displayAllStations(root);

        var path = graph.findShortestPath(from,to);

        Graph.Edge.addStations(root, path, n);

        var start = path.get(0);

        var mark = Objects.equals(start.first.getName(), from) ?
                displayMarkAt(root, start.first.x, start.first.y) :
                displayMarkAt(root, start.second.x, start.second.y);

        Button startTrip = new Button("Start trip");
        // manually created event handler via lambda
        startTrip.setOnMouseClicked(e -> startTrip(root, path, n, from, mark));
        root.getChildren().add(startTrip);
        startTrip.setLayoutX(112);
        startTrip.setLayoutY(668);
    }

    private static AnchorPane createMapRoot() {
        var root = new AnchorPane();
        root.setPrefSize(1280,847);
        root.setId("pane");
        return root;
    }

    private static void displayDestinationPositions(Pane root) {
        displayDestinationPosition(root, 653, 283,"Sofiyivka");
        displayDestinationPosition(root,184,424,"Hoverla");
        displayDestinationPosition(root,321,368,"Castle");
        displayDestinationPosition(root,669,561,"Dnieper–Bug estuary");
        displayDestinationPosition(root,751,569,"Oleshky Sands");
        displayDestinationPosition(root,683,493,"Aktove canyon");
        displayDestinationPosition(root,282,163,"Tunnel of Love");
        displayDestinationPosition(root,212,349,"Synevyr");
        displayDestinationPosition(root,132,83,"Shatsky");
        displayDestinationPosition(root,832,581,"Askania");
    }
    private void processStation(){
        synchronized (askStage) {
            askStage.show();
        }
        synchronized(mutex){
            try {
                mutex.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    record Pair<F, S>(F first, S second) {
    }

    private boolean haveTravelled = false;

   private void startTrip(Pane pane, List<? extends Graph.Edge<?>> path, int n, String from, ImageView mark) {
       if (haveTravelled) return;
       else haveTravelled = true;
       System.out.println("""


               Trip started
               
               
               """);

       final int DRAW = 0b01;
       final int WAIT = 0b10;
       final AtomicInteger mutex = new AtomicInteger(DRAW);
       Deque<Pair<Point2D, Station>> milestones = new LinkedList<>();
       final AtomicReference<Station> nextStop = new AtomicReference<>(null);

       Thread pathPainter = new Thread(() -> {
            while (true) {
                var next = milestones.pollFirst();
                if (next == null) break;
                var vector = next.first;
                var station = next.second;
                nextStop.set(station == null ?
                             milestones.peek().second :
                             station);
                double dx, dy;
                dx = vector.getX();
                dy = vector.getY();
                System.out.printf("Moving to %s by vector (%f;, %f)\n", station, dx, dy);
                long duration = (long) (Graph.Edge.vectLength(dx, dy) * 20);
                TranslateTransition transition = new TranslateTransition(Duration.millis(duration), mark);
                transition.setByX(dx);
                transition.setByY(dy);
                transition.play();
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    synchronized (mutex) {
                        if (mutex.get() == WAIT && station == nextStop.get()) {
                            System.out.println("Painter is waiting...");
                            mutex.wait();
                            System.out.println("Painter resumed");
                        }
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
       });

       // add all milestones, that will be painted
       System.out.println("<<BUILDING PATH>>");
       for (var edge : path) {
           Graph.Node<?> node;
           System.out.println("Current City: " + from);
           if (Objects.equals(from, edge.first.getName())) {
               node = edge.first;
               from = edge.second.getName();
           } else {
               node = edge.second;
               from = edge.first.getName();
           }
           Point2D begin = new Point2D(node.x, node.y);
           var stops = edge.getStopsFrom(from);
           System.out.println("stops = " + stops.keySet());
           double dx, dy;
           System.out.println("POINTS");
           for (var entry : stops.entrySet()) {
               var point = entry.getKey();
               var station = entry.getValue();              // null if it is not a station
               dx = point.getX() - begin.getX();
               dy = point.getY() - begin.getY();
               var vector = new Point2D(dx, dy);
               System.out.println(begin + " -> " + point + "  by  " + vector);
//               System.out.printf("Moving from (%s; %s) to (%s; %s)\n", begin.getX(), begin.getY(), point.getX(), point.getY());
               milestones.addLast(new Pair<>(vector, station));
               begin = point;
           }
       }

       System.out.println("\n\n<<START ACTUAL TRIP>>");

       pathPainter.start();

       /*while (true) {
           int v;
           try {
               synchronized (state) {
                   System.out.println("WINDOW is waiting");
                   state.wait();
               }
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           synchronized (state) {
               v = state.get();
           }
           if (v == HIDE) {
               askStage.hide();
           } else if (v == SHOW) {
               askStage.show();
           } else if (v == RESUME_MOVEMENT) {
               break;
           } else {
               throw new RuntimeException("invalid state");
           }
       }*/

   }

    private static void showDestination(String name) {
        System.out.println("You're welcome to " + name);
        // todo open new window with destination image
        String destinationImageLocation = "/images/destinations/" + name + ".jpeg";
        Image image = new Image(Objects.requireNonNull(TripMap.class.getResourceAsStream(destinationImageLocation)));
        ImageView imageView = new ImageView(image);


        // show image in new window with title and some description

        String title = "You're welcome to " + name;
    }

    private ImageView displayMarkAt(Pane pane, double x, double y) {
        if (currMark != null) {
            pane.getChildren().remove(currMark);
        }
        var image = new ImageView(new Image(Objects.requireNonNull(
                TripMap.class.getResourceAsStream("/images/position.png")
        )));
        currMark = image;
        pane.getChildren().add(image);
        image.setLayoutX(x-26.5);
        image.setLayoutY(y-53);
        return image;
    }

    public static void displayDestinationPosition(Pane pane, double x, double y,String name) {
        final int iconWidth = 7;
        Label label = new Label(name);
        label.setFont(new Font("Arial",14));
        label.setTextFill(Color.color(0,0,0));
        // create an Image object with the dot image
        Image image = new Image(Objects.requireNonNull(TripMap.class.getResourceAsStream("/images/DotYellow.png")));

        // create an ImageView object with the Image
        ImageView imageView = new ImageView(image);

        // add the ImageView to the Pane
        pane.getChildren().add(imageView);
        pane.getChildren().add(label);
        // set the position of the ImageView on the Pane
        label.applyCss();
        imageView.setLayoutX(x-iconWidth/2);
        imageView.setLayoutY(y-iconWidth/2);
        label.setLayoutX(x-label.prefWidth(-1));
        label.setLayoutY(y-label.prefHeight(-1));
        System.out.println(label.prefHeight(-1));
        System.out.println(label.prefWidth(-1));

    }

    public static void main(String[] args) throws PlaceNotSelectedException {
        launch();
    }
}
