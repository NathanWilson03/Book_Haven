package com.example.bookhaven0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class loginHandlerClass extends User implements EventHandler<ActionEvent> { // front end for login
    @Override
    public void handle(ActionEvent e) {

        List<String> names = new ArrayList<>();

        ImageView loginImage = new ImageView(new Image("https://i.pinimg.com/originals/ae/21/6b/ae216b6c9166bb91c297beba088d0a1e.jpg"));
        loginImage.setFitHeight(600);
        loginImage.setFitWidth(600);

        Stage loginStage = new Stage();
        VBox loginPage = new VBox();
        loginPage.setStyle("-fx-background-color: #DEB887;");
        loginPage.setAlignment(Pos.CENTER);

        Label welcomeBackLabel = new Label("Welcome back reader!");
        welcomeBackLabel.setFont(new Font("Tahoma", 18));
        welcomeBackLabel.setTextFill(Color.GHOSTWHITE);

        Label loginUserNameLabel = new Label("Please enter your UserName");
        loginUserNameLabel.setFont(new Font("Tahoma", 18));
        loginUserNameLabel.setTextFill(Color.GHOSTWHITE);
        TextField loginUserNameText = new TextField();
        loginUserNameText.setAlignment(Pos.TOP_CENTER);

        Label loginPassWordLabel = new Label("Please enter your password");
        loginPassWordLabel.setFont(new Font("Tahoma", 18));
        loginPassWordLabel.setTextFill(Color.GHOSTWHITE);
        TextField loginPassWordText = new TextField();
        loginPassWordText.setAlignment(Pos.TOP_CENTER);

        Button enterLogin = new Button("Enter");
        enterLogin.setStyle("-fx-background-color: GHOSTWHITE; -fx-border-color: black; -fx-border-width: 2px;");
        Button backToMain = new Button("Back");
        backToMain.setStyle("-fx-background-color: GHOSTWHITE; -fx-border-color: black; -fx-border-width: 2px;");
        backToMain.setAlignment(Pos.BOTTOM_LEFT);
        backToMain.setOnAction(new backButtonHandlerClass());


        loginPage.getChildren().addAll(welcomeBackLabel, loginImage, loginUserNameLabel, loginUserNameText,
                loginPassWordLabel, loginPassWordText, enterLogin, backToMain);

        loginPage.setSpacing(3.0);

        Scene loginScene = new Scene(loginPage, 600, 1000);
        loginStage.setScene(loginScene);
        loginStage.show();

        enterLogin.setOnAction(d -> {

            final String name = loginUserNameText.getText(); // retrieving text from userName field
            final String passWord = loginPassWordText.getText(); // and passwordField
            User user = new User(name, passWord, null);


            boolean found = false;

            try (BufferedReader reader = new BufferedReader(new FileReader("username.txt"))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",", 2);
                    if (parts.length > 1) { // Ensure there are two parts before comparing
                        String userNameFromFile = parts[0].trim();
                        String passwordFromFile = parts[1].trim(); // Extract the password
                        if (userNameFromFile.equals(user.getUserName()) && passwordFromFile.equals(user.getPassword())) {
                            found = true;
                            break;
                        }
                    }
                }
            } catch (IOException w) {
                w.printStackTrace();
            }

            if (found) {
                System.out.println("Logged in");


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Username does not exist, or doesn't match password");
                alert.setContentText("Please choose a different username or create account.");
                alert.showAndWait();
            }

            if(passWord.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No password found");
                alert.setContentText("Please enter a password"); // still need to do in createAccount
                alert.showAndWait();
            } else {
                enteredUserHandler loginEntered = new enteredUserHandler(user);
                enterLogin.setOnAction(loginEntered);
                user.setUserName(name);
                user.setPassword(passWord);
            }




        });

    }
}
