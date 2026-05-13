package com.example.oop.logic.database;


import com.example.oop.logic.ChangeScene;
import com.example.oop.logic.user.UserInfo;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Utils implements Serializable {
    private List<UserInfo> users = new ArrayList<>();
    private static Utils dbUtils;
    transient ChangeScene changeScene = new ChangeScene();

    private Utils() {
        users = loadUsers();
    }

    public static Utils getInstance(){
        if (dbUtils == null){
            dbUtils = new Utils();
            return dbUtils;}
        return dbUtils;
    }

    public void writeUsers() {
        try {
            FileOutputStream fos = new FileOutputStream("src/main/resources/users.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            users.clear();
//            users.add(new UserInfo("1", "1"));
//            users.add(new UserInfo("anna", "1234"));
            oos.writeObject(users);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readUsers() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/users.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            var users = ois.readObject();
            ois.close();
            System.out.println(users);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private List<UserInfo> loadUsers (){
        File usersFile = new File("src/main/resources/users.bin");
        if (!usersFile.exists()) {
            return new ArrayList<>();
        }
        try {
            FileInputStream fis = new FileInputStream(usersFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List<UserInfo> users = (List<UserInfo>) ois.readObject();
            System.out.println("Users are loaded from file: ");
            users.forEach(System.out::println);
            ois.close();
            return users;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public  void signUpUser(ActionEvent event, String username, String password){
        users.add(new UserInfo(username,password));
        writeUsers();
    }
    public  void logInUser(ActionEvent event,String username,String password){
        var op = users.stream().filter(
                // pure lambda function
                user -> Objects.equals(user.login(), username) && Objects.equals(user.password(), password)
        ).findAny();
        if (op.isEmpty()) {
            System.out.println("User not found in the database!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Incorrect login or password!");
            alert.show();
        } else {
            changeScene.changeScene(event, "/welcome-page.fxml", username);
        }
    }

        // Method to write data to database
        public void writeToDatabase(String from, String to) {
            Connection connection = null;
            PreparedStatement psInsert = null;
            PreparedStatement psCheckUserExists = null;
            ResultSet resultSet = null;
            try{
                String url = System.getenv().getOrDefault("TOURISM_DB_URL", "jdbc:mysql://127.0.0.1:3306/fromTO");
                String user = System.getenv().getOrDefault("TOURISM_DB_USER", "root");
                String password = System.getenv().getOrDefault("TOURISM_DB_PASSWORD", "");
                connection = DriverManager.getConnection(url, user, password);

                    psInsert = connection.prepareStatement("INSERT INTO fromTo (from, to) VALUES (?, ?)");
                    psInsert.setString(1,from);
                    psInsert.setString(2,to);

            }catch(SQLException e){
                e.printStackTrace();
            }finally {

                if(psInsert!=null){
                    try {
                        psInsert.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
                if(connection!=null){
                    try {
                        connection.close();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }


}}
