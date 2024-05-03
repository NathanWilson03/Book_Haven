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

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class createAccountHandlerClass extends User implements EventHandler<ActionEvent> { // mostly front end stuff
    @Override
    public void handle(ActionEvent e) {

        List<String> names = new ArrayList<>();






        ImageView createAccountImage = new ImageView(new Image("https://storage.googleapis.com/pai-images/0ba9ddb6d4e54fff8ca94362f2445994.jpeg"));
        createAccountImage.setFitHeight(600);
        createAccountImage.setFitWidth(600);

        Stage createAccountStage = new Stage();
        VBox createAccountPage = new VBox();
        createAccountPage.setStyle("-fx-background-color: #DEB887;");
        createAccountPage.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Welcome new reader!");
        welcomeLabel.setFont(new Font("Tahoma", 18));
        welcomeLabel.setTextFill(Color.GHOSTWHITE);

        Label createUserNameLabel = new Label("Please enter your UserName");
        createUserNameLabel.setFont(new Font("Tahoma", 18));
        createUserNameLabel.setTextFill(Color.GHOSTWHITE);
        TextField createUserNameText = new TextField();
        createUserNameText.setAlignment(Pos.TOP_CENTER);

        Label createPassWordLabel = new Label("Please enter your Password");
        createPassWordLabel.setFont(new Font("Tahoma", 18));
        createPassWordLabel.setTextFill(Color.GHOSTWHITE);
        TextField createPassWordText = new TextField();
        createPassWordText.setAlignment(Pos.TOP_CENTER);

        Button enterCreateAccount = new Button("Enter");
        enterCreateAccount.setStyle("-fx-background-color: GHOSTWHITE; -fx-border-color: black; -fx-border-width: 2px;");
        Button backToMain = new Button("Back");
        backToMain.setStyle("-fx-background-color: GHOSTWHITE; -fx-border-color: black; -fx-border-width: 2px;");
        backToMain.setAlignment(Pos.BOTTOM_LEFT);
        backToMain.setOnAction(new backButtonHandlerClass());

        createAccountPage.getChildren().addAll(welcomeLabel, createAccountImage, createUserNameLabel, createUserNameText,
                createPassWordLabel, createPassWordText, backToMain, enterCreateAccount);

        createAccountPage.setSpacing(3);

        Scene createScene = new Scene(createAccountPage, 600, 1000);
        createAccountStage.setScene(createScene);
        createAccountStage.show();

        enterCreateAccount.setOnAction(enter -> {  // an action for saving userName and passWord to file

            final String name = createUserNameText.getText(); // retrieving text from userName field
            final String passWord = createPassWordText.getText(); // and passwordField
            User user = new User(name, passWord, null);


            // writing usernames to userName file


            try (BufferedWriter writer = new BufferedWriter(new FileWriter("username.txt", true))) {

                boolean found = false;

                // reading them and making sure that userName does not already exist in file

                try (BufferedReader reader = new BufferedReader(new FileReader("username.txt"))) {
                    String userToString = user.toString();
                    String line;




                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",", 2); // Split at the first comma
                        if (parts.length > 0) {
                            String userName = parts[0].trim(); // Extract the userName before the comma
                            System.out.println(userName); // Print the userName to console
                            names.add(userName); // Add userName to list
                            if (userName.equals(user.getUserName())) {
                                found = true;
                                break;
                            }
                        }
                    }






                } catch (IOException w) {
                    w.printStackTrace();
                }

                if (found) {  // making alert if userName exist
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Username already exists");
                    alert.setContentText("Please choose a different username.");
                    alert.showAndWait();
                } else {

                    String userToString = user.toString();

                    writer.write(userToString);
                    System.out.println(userToString);
                    user.setUserName(name);
                    user.setPassword(passWord);






                    enteredUserHandler enteredHandle = new enteredUserHandler(user); // creating instance of
                    enterCreateAccount.setOnAction(enteredHandle); // otherwise enter shop




                }


            } catch (IOException a) {
                a.printStackTrace();
                throw new RuntimeException(a); // exception handling
            }















        });
    }
}

