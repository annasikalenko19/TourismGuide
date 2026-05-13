package com.example.oop.logic.map.graph;

import com.example.oop.GUI.TripMap;
import com.example.oop.logic.map.station.*;
import javafx.geometry.Point2D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.*;

//generics
public class Graph<T> {
    private final List<Node<T>> nodes = new ArrayList<>(40);
    private static Graph<?> instance = null;
    public Node<T> getNearestCenter(double x,double y){
        double minDistance = Double.MAX_VALUE;
        Node<T> nearest = null;
        for (var node :
                nodes) {
            if (!node.isDestination) {
                double dx = node.x-x;
                double dy = node.y-y;
                double d = Math.sqrt(dx*dx+dy*dy);
                if(d<minDistance){
                    minDistance = d;
                    nearest = node;
                }
            }
        }
        return nearest;
    }
    public static Graph<?> getInstance(){
        if (instance == null) {
            initialiseInstance();
        }
        return instance;
    }
    private static void initialiseInstance(){
        var graph =new Graph<String>();
        //centers
        Node<String> cherkasy = new Node<>("Cherkasy",683,299,false);
        Node<String> chernihiv = new Node<>("Chernihiv",628,89,false);
        Node<String> chernivtsi = new Node<>("Chernivtsi",277,409,false);
        Node<String> dnipro = new Node<>("Dnipro",880,391,false);
        Node<String> donetsk = new Node<>("Donetsk",1059,440,false);
        Node<String> ivanoFrankivsk = new Node<>("Ivano-Frankivsk",195,348,false);
        Node<String> kharkiv = new Node<>("Kharkiv",962,235,false);
        Node<String> kherson = new Node<>("Kherson",720,565,false);
        Node<String> khmelnytskyi = new Node<>("Khmelnytskyi",349,303,false);
        Node<String> kropyvnytskyi = new Node<>("Kropyvnytskyi",693,393,false);
        Node<String> kyiv = new Node<>("Kyiv",583,199,false);
        Node<String> luhansk = new Node<>("Luhansk",1167,381,false);
        Node<String> lutsk = new Node<>("Lutsk",231,161,false);
        Node<String> lviv = new Node<>("Lviv",146,256,false);
        Node<String> mykolaiv = new Node<>("Mykolaiv",679,542,false);
        Node<String> odesa = new Node<>("Odesa",592,595,false);
        Node<String> poltava = new Node<>("Poltava",844,279,false);
        Node<String> rivne = new Node<>("Rivne",300,178,false);
        Node<String> sumy = new Node<>("Sumy",863,153,false);
        Node<String> ternopil = new Node<>("Ternopil",250,282,false);
        Node<String> uzhhorod = new Node<>("Uzhhorod",37,378,false);
        Node<String> vinnytsia = new Node<>("Vinnytsia",454,314,false);
        Node<String> zaporizhzhia = new Node<>("Zaporizhzhia",887,447,false);
        Node<String> zhytomyr = new Node<>("Zhytomyr",462,214,false);
        Node<String> simferopol = new Node<>("Simferopol",819,745,false);
        //destinations
        Node<String> synevyr = new Node<>("Synevyr",212,349,true);
        Node<String> hoverla = new Node<>("Hoverla",184,424,true);
        Node<String> kamianetsPodilskyiCastle = new Node<>("Kamianets-Podilskyi Castle",321,368,true);
        Node<String> dnieperBugEstuary = new Node<>("Dnieper–Bug estuary",669,561,true);
        Node<String> oleshkySands = new Node<>("Oleshky Sands",751,569,true);
        Node<String> aktoveCanyon = new Node<>("Aktove canyon",683,493,true);
        Node<String> tunnelOfLove = new Node<>("Tunnel of Love",282,163,true);
        Node<String> sofiyivka = new Node<>("Sofiyivka",653,283,true);
        Node<String> shatskyLakes = new Node<>("Shatsky Lakes",132,83,true);
        Node<String> askaniaNova = new Node<>("Askania-Nova",832,581,true);


        edge(uzhhorod,synevyr,false);
        edge(uzhhorod,ivanoFrankivsk,true);
        edge(uzhhorod,lviv,true);
        edge(ivanoFrankivsk,synevyr,false);
        edge(lviv,ivanoFrankivsk,true);
        edge(ivanoFrankivsk,hoverla,false);
        edge(ivanoFrankivsk,chernivtsi,true);
        edge(ivanoFrankivsk,ternopil,true);
        edge(chernivtsi,hoverla,false);
        edge(ternopil,lviv,true);
        edge(ternopil,rivne,true);
        edge(ternopil,zhytomyr,true);
        edge(ternopil,khmelnytskyi,true);
        edge(lutsk,lviv,true);
        edge(lutsk,shatskyLakes,false);
        edge(lutsk,tunnelOfLove,false);
        edge(lutsk,rivne,true);
        edge(rivne,tunnelOfLove,false);
        edge(rivne,zhytomyr,true);
        edge(chernivtsi,khmelnytskyi,true);
        edge(chernivtsi,kamianetsPodilskyiCastle,false);
        edge(khmelnytskyi,kamianetsPodilskyiCastle,false);
        edge(khmelnytskyi,vinnytsia,true);
        edge(vinnytsia,kamianetsPodilskyiCastle,false);
        edge(vinnytsia,zhytomyr,true);
        edge(vinnytsia,cherkasy,true);
        edge(vinnytsia,odesa,true);
        edge(odesa,mykolaiv,true);
        edge(zhytomyr,kyiv,true);
        edge(cherkasy,kyiv,true);
        edge(kyiv,sofiyivka,false);
        edge(cherkasy,sofiyivka,false);
        edge(kyiv,chernihiv,true);
        edge(kyiv,sumy,true);
        edge(kyiv,poltava,true);
        edge(cherkasy,kropyvnytskyi,true);
        edge(kropyvnytskyi,poltava,true);
        edge(kropyvnytskyi,mykolaiv,true);
        edge(kropyvnytskyi,dnipro,true);
        edge(sumy,chernihiv,true);
        edge(sumy,poltava,true);
        edge(sumy,kharkiv,true);
        edge(poltava,kharkiv,true);
        edge(poltava,dnipro,true);
        edge(mykolaiv,dnieperBugEstuary,false);
        edge(mykolaiv,aktoveCanyon,false);
        edge(kropyvnytskyi,aktoveCanyon,false);
        edge(mykolaiv,kherson,true);
        edge(kherson,oleshkySands,false);
        edge(kherson,askaniaNova,false);
        edge(kherson,simferopol,true);
        edge(simferopol,oleshkySands,false);
        edge(simferopol,askaniaNova,false);
        edge(kherson,zaporizhzhia,true);
        edge(zaporizhzhia,dnipro,true);
        edge(zaporizhzhia,donetsk,true);
        edge(dnipro,kharkiv,true);
        edge(dnipro,donetsk,true);
        edge(luhansk,donetsk,true);
        edge(luhansk,kharkiv,true);
        edge(zaporizhzhia,askaniaNova,false);

        graph.nodes.addAll(List.of(cherkasy,chernihiv,chernivtsi,dnipro,donetsk,ivanoFrankivsk,kharkiv,
                kherson,khmelnytskyi,kropyvnytskyi,kyiv,luhansk,lutsk,lviv,mykolaiv,odesa,poltava,rivne,
                sumy,ternopil,uzhhorod,vinnytsia,zaporizhzhia,zhytomyr,simferopol
        ));
        graph.nodes.addAll(List.of(synevyr,hoverla,kamianetsPodilskyiCastle,dnieperBugEstuary,oleshkySands,
                aktoveCanyon,tunnelOfLove,sofiyivka,shatskyLakes,askaniaNova));

        instance = graph;
    }
    private static <K> void edge(Node<K> from, Node<K> to, boolean hasStations){
        Edge<K> edge = new Edge<>(from,to,hasStations);
        from.add(edge);
        if(hasStations){
            to.add(edge);
        }
    }
    public List<Edge<T>> findShortestPath(String fromName,String toName){
        var op = nodes.stream().filter(n -> Objects.equals(n.getName(), fromName)).findFirst();
        System.out.printf("from: %s\n",op);
        if (op.isEmpty()) {
            throw new PathBuildingException("Invalid from location name");
        }
        var from = op.get();
        op = nodes.stream().filter(n -> Objects.equals(n.getName(), toName)).findFirst();
        System.out.printf("to: %s\n",op);
        if (op.isEmpty()) {
            throw new PathBuildingException("Invalid destination location name");
        }
        var to = op.get();
        // TODO: 08/05/2023 implement  A* Path Finding Algorithm
        return new ArrayList<>(TripMap.NUMBER_OF_CENTERS + 1) {{
            var curr = from;
            do {//lambda
                // find edge with in H value
                var finalCurr = curr;
                var minEdge = curr.edges.stream()
                        .filter(edge -> {
                            var node = edge.first == finalCurr ? edge.second : edge.first;
                            return node == to || !node.isDestination;
                        })
                        .max((a, b) -> {
                            if (a.first == to || a.second == to)  {
                                return 1;
                            }
                            if (b.first == to || b.second == to) {
                                return -1;
                            }
                            double aH = a.first == finalCurr ? a.second.calcHValue(a.first, to) : a.first.calcHValue(a.second, to);
                            double bH = b.first == finalCurr ? b.second.calcHValue(b.first, to) : b.first.calcHValue(b.second, to);
                            return aH - bH < 0 ? -1 : (Math.abs(aH - bH) < 0.001 ? 0 : 1);
                        });
                if (minEdge.isEmpty()) {
                    throw new PathBuildingException(
                            String.format("there are no edges from Node(%s)\nEdges in the path list yet %s",
                                    curr.getName(), this));
                }
                var edge = minEdge.get();
                curr = edge.first == curr ? edge.second : edge.first;
                add(edge);
            } while (curr != to);
        }};
    }
    // TODO: remove method
    public void displayAllStations(Pane pane){
        throw new UnsupportedOperationException(pane.toString());
//        Set<Edge<String>> set = new HashSet<>(){{
//            for (var node:nodes) {
//                addAll(node.edges);
//            }
//        }};
//
//        set.forEach(edge -> edge.displayStations(pane,0b11111));
//        var node = nodes.stream().filter(n -> Objects.equals(n.locationName, "Kyiv")).findFirst();
//        System.out.println(node);
//        for (var edge:
//                node.get().edges) {
//            edge.displayStations(pane,0b1111);
//        }
    }

    public static class Node<T> {

        private final T value;
        public final double x;
        public final double y;
        public final boolean isDestination;
        private final List<Edge<T>> edges = new ArrayList<>(8);
        public Node(T value, double x, double y, boolean isDestination) {
            this.value = value;
            this.x = x;
            this.y = y;
            this.isDestination = isDestination;
        }

        public String getName() {
            if (value instanceof String s) return s;
            return value.toString();
        }
        public void add(Edge<T> edge){
            edges.add(edge);
        }

        // TODO: remove method
        public List<Edge<T>> getEdges(){
            return edges;
        }
        private double calcHValue(Node<?> from, Node<?> to) {
            // consider current Node as C, from - A, to - B
            // calc AC vector coordinates
            double ACx = this.x - from.x;
            double ACy = this.y - from.y;

            // calc AB vector coordinates
            double ABx = to.x - from.x;
            double ABy = to.y - from.y;

            // calc cosine of angle between AB & AC
            double cos = Edge.dotProduct(ACx, ACy, ABx, ABy);

            // TODO: remove sout
            System.out.printf("A = %s\nC = %s\nB = %s\n cos = %f\n",
                    from.getName(), this.getName(), to.getName(), cos);

            return Edge.vectLength(ACx, ACy) * cos;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "locationName='" + value + '\'' +
                    ", x=" + x +
                    ", y=" + y +
                    ", isDestination=" + isDestination +
                    ", edges=" + edges +
                    '}';
        }
    }

    // TODO: remove public
    public static class Edge<T> {

        private final static Random random = new Random(1);

        private static final double[] positions = {0.1, 0.3, 0.5, 0.7, 0.9};
        private final List<Double> occupiedPositions = new ArrayList<>(5);
        public final Node<T> first;
        public final Node<T> second;

        private final List<Station> stations = new ArrayList<>(4);

        public Edge(Node<T> first, Node<T> second, boolean hasStations ) {
            this.first = first;
            this.second = second;
        }

        public static double vectLength(double x, double y) {
            return Math.sqrt(x * x + y * y);
        }

        public static double dotProduct(double x1, double y1, double x2, double y2) {
            return x1 * x2 + y1 * y2;
        }

        public static void addStations(AnchorPane pane, List<? extends Edge<?>> path, int n) {
            List<Integer> stations = new ArrayList<>() {{
               if ((Station.CAFE & n) > 0) add(Station.CAFE);
               if ((Station.EMERGENCY_ROOM & n) > 0) add(Station.EMERGENCY_ROOM);
               if ((Station.GAS_STATION & n) > 0) add(Station.GAS_STATION);
               if ((Station.HOTEL & n) > 0) add(Station.HOTEL);
            }};

            new HashSet<>() {{
               for (int st : stations) {
                   if (this.size() == path.size() - 1) {
                       break;
                   }
                   Edge<?> e;
                   do {
                       e = path.get(random.nextInt(path.size() - 1));
                   } while (contains(e));
                   e.addStations(st);
               }
            }};

            for (int i = 0; i < path.size() - 1; i++) {
                int k = (random.nextInt(4) == 1 ? (Station.CAFE & n) : 0) |
                        (random.nextInt(4) == 1 ? (Station.EMERGENCY_ROOM & n) : 0) |
                        (random.nextInt(4) == 1 ? (Station.HOTEL & n) : 0) |
                        (random.nextInt(4) == 1 ? (Station.GAS_STATION & n) : 0);
                path.get(i).addStations(k);
            }

            path.forEach(edge -> edge.displayStations(pane));
        }

        public Map<Point2D, Station> getStopsFrom(String stationName) {
            Node<T> begin, end;
            if (Objects.equals(stationName, first.getName())) {
                begin = second;
                end = first;
            } else {
                begin = first;
                end = second;
            }
            return new LinkedHashMap<>() {{
               var list = stations.stream().sorted((a, b) -> {
                   double dx = a.x - begin.x;
                   double dy = a.y - begin.y;
                   double aLen = vectLength(dx, dy);
                   dx = b.x - begin.x;
                   dy = b.y - begin.y;
                   double bLen = vectLength(dx, dy);
                   return Double.compare(aLen, bLen);
               }).toList();
                for (var stop : list) {
                    put(new Point2D(stop.x, stop.y), stop);
                }
                put(new Point2D(end.x, end.y), null);
            }};
        }

        @Override
        public String toString() {
            return "\n" + first.getName() +"("+ first.x+" ; " + first.y+ ")" +" <-> " +second.getName()
                    +"("+ second.x+" ; " + second.y +")"+stations.toString();
        }

        public void addStations(int n){
            double xa = first.x;
            double ya = first.y;

            double dx = second.x-first.x;
            double dy = second.y-first.y;
            double alphaCafe;
            do {
                alphaCafe = positions[random.nextInt(5)];
            } while (occupiedPositions.contains(alphaCafe));

            double alphaEmergencyRoom;
            do {
                alphaEmergencyRoom=positions[random.nextInt(5)];
            }while (occupiedPositions.contains(alphaEmergencyRoom));

            double alphaGasStation;
            do {
                alphaGasStation=positions[random.nextInt(5)];
            }while (occupiedPositions.contains(alphaGasStation));

            double alphaHotel;
            do {
                alphaHotel=positions[random.nextInt(5)];
            }while (occupiedPositions.contains(alphaHotel));

            if((n & Station.CAFE) >0){
                double x = xa+alphaCafe*dx;
                double y = ya+alphaCafe*dy;
                stations.add(new Cafe(x,y));
                occupiedPositions.add(alphaCafe);
            }
            if((n & Station.EMERGENCY_ROOM) >0){
                double x = xa+alphaEmergencyRoom*dx;
                double y = ya+alphaEmergencyRoom*dy;
                stations.add(new EmergencyRoom(x,y));
                occupiedPositions.add(alphaEmergencyRoom);
            }
            if((n & Station.GAS_STATION) >0){
                double x = xa+alphaGasStation*dx;
                double y = ya+alphaGasStation*dy;
                stations.add(new GasStation(x,y));
                occupiedPositions.add(alphaGasStation);
            }
            if((n & Station.HOTEL) >0){
                double x = xa+alphaHotel*dx;
                double y = ya+alphaHotel*dy;
                stations.add(new Hotel(x,y));
                occupiedPositions.add(alphaHotel);
            }

        }
        private void displaySingleStation(Station.Icon icon, Pane pane, double x, double y){
            var image = icon.getIcon();
            pane.getChildren().add(image);
            image.setLayoutX(x-Station.ICON_SIZE/2d);
            image.setLayoutY(y-Station.ICON_SIZE);

        }

        public void displayStations(Pane pane){
            for (var station :this.stations) {
                if(station instanceof Cafe){
                    System.out.println("displaying cafe icon at "+ station.x +";"+station.y);
                    displaySingleStation(Station.Icon.CAFE,pane,station.x,station.y);
                }
                else if(station instanceof Hotel){
                    System.out.println("displaying hotel icon at "+ station.x +";"+station.y);

                    displaySingleStation(Station.Icon.HOTEL,pane,station.x,station.y);
                }
                else if(station instanceof EmergencyRoom){
                    System.out.println("displaying emergency room icon at "+ station.x +";"+station.y);

                    displaySingleStation(Station.Icon.FIRST_AID,pane,station.x,station.y);
                }
                else if(station instanceof GasStation){
                    System.out.println("displaying gas station icon at "+ station.x +";"+station.y);

                    displaySingleStation(Station.Icon.GAS_STATION,pane,station.x,station.y);
                }
            }

        }
    }
// custom exceptions
    public static abstract class GraphException extends RuntimeException {
        public GraphException() {
            super("something wrong with a graph");
        }

        public GraphException(String message) {
            super(message);
        }

        public GraphException(String message, Throwable cause) {
            super(message, cause);
        }

        public GraphException(Throwable cause) {
            super("something wrong with a graph", cause);
        }

        public GraphException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

    public static class PathBuildingException extends GraphException {
        public PathBuildingException() {
            super();
        }

        public PathBuildingException(String message) {
            super(message);
        }

        public PathBuildingException(String message, Throwable cause) {
            super(message, cause);
        }

        public PathBuildingException(Throwable cause) {
            super(cause);
        }

        public PathBuildingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }

}
