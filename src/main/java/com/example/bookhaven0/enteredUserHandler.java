package com.example.bookhaven0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class enteredUserHandler extends createAccountHandlerClass implements EventHandler<ActionEvent>  {

    private User user;

    public enteredUserHandler(User user) {
        this.user = user;
    }

    @Override
    public void handle(ActionEvent e) {
        ImageView interfaceImage = new ImageView("https://i.pinimg.com/originals/f6/a9/58/f6a958cc0bb5ea53db40b9cab1a7a0a7.jpg");
        interfaceImage.setFitHeight(600);
        interfaceImage.setFitWidth(500);

        String userName = user.getUserName();


        Stage interfaceStage = new Stage();
        VBox interfacePage = new VBox();
        interfacePage.setStyle("-fx-background-color: #DEB887;");
        interfacePage.setAlignment(Pos.CENTER);
        Label optionsLabel = new Label(userName + ", Pick from one of the following options");
        optionsLabel.setFont(new Font("Tahoma", 18));
        Button seeCollectionButton = new Button("Book Collection");
        seeCollectionButton.setStyle("-fx-background-color: #FFE4C4; -fx-text-fill: #808000;" +
                " -fx-font-weight: bold;" + " -fx-border-color: black; -fx-border-width: 2px;");

        Button bookRecommendationButton = new Button("Book Recommendation");
        bookRecommendationButton.setStyle("-fx-background-color: #FFE4C4; -fx-text-fill: #808000;" +
                " -fx-font-weight: bold;" + " -fx-border-color: black; -fx-border-width: 2px;");
        Button searchBook = new Button("Search for book");
        searchBook.setStyle("-fx-background-color: #FFE4C4; -fx-text-fill: #808000; -fx-font-weight: bold;" +
                " -fx-border-color: black; -fx-border-width: 2px;");

        interfacePage.setSpacing(3.0);


        interfacePage.getChildren().addAll(optionsLabel, interfaceImage, seeCollectionButton,
                bookRecommendationButton, searchBook);

        Scene scene0 = new Scene(interfacePage, 600, 1000);
        interfaceStage.setScene(scene0);
        interfaceStage.show();


        searchBook.setOnAction(d -> {

            ImageView searchImage = new ImageView("https://images.nightcafe.studio/jobs/OILdGFsBbI5oRQKQCAtl/OILdGFsBbI5oRQKQCAtl--1--o970p_5.9524x.jpg?tr=w-1600,c-at_max");
            searchImage.setFitHeight(600);
            searchImage.setFitWidth(500);


            Stage searchStage = new Stage();
            VBox searchBox = new VBox();
            searchBox.setStyle("-fx-background-color: #DEB887;");
            searchBox.setAlignment(Pos.CENTER);
            Label searchLabel = new Label(userName + ", enter the book you desire");
            searchLabel.setFont(new Font("Tahoma", 24));
            TextField desiredBook = new TextField();
            Button search = new Button("Search");
            search.setStyle("-fx-background-color: #FFE4C4; -fx-text-fill: #808000; -fx-font-weight: bold;" +
                    " -fx-border-color: black; -fx-border-width: 2px;");

            searchBox.setSpacing(8.0);

            searchBox.getChildren().addAll(searchLabel, searchImage, desiredBook, search);


            Scene scene = new Scene(searchBox, 600, 1000);
            searchStage.setScene(scene);
            searchStage.show();


            search.setOnAction(t -> {

                String desiredBookText = desiredBook.getText();
                Book searchedBook = new Book();
                ArrayList<String> collection = new ArrayList<>();


                boolean found = false;


                try (BufferedReader libraryReader = new BufferedReader(new FileReader("library.txt"))) {
                    String line;

                    while ((line = libraryReader.readLine()) != null) {
                        String[] parts = line.split(",", 2);
                        if (parts.length > 0) { // Ensure there is at least one part before comparing
                            String titlePart = parts[0].trim(); // Extract the title before the comma
                            if (titlePart.toLowerCase().equals(desiredBookText.toLowerCase())) {
                                found = true;
                                break;
                            }
                        }
                    }

                    if (found) {
                        System.out.println("Book found: " + desiredBookText);

                        collection.add(desiredBookText);

                        user.setBookCollection(collection);

                        System.out.println(collection);



                    } else {
                        System.out.println("Book not found: " + desiredBookText);
                        // Add the book to the library file

                    }
                } catch (IOException r) {
                    r.printStackTrace();
                }

            });


        });
    }


}

