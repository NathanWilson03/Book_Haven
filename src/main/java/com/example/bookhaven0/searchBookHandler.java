package com.example.bookhaven0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class searchBookHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e){

        ImageView searchImage = new ImageView("https://imagedelivery.net/9sCnq8t6WEGNay0RAQNdvQ/UUID-cl90fi4xx33976vmqy1fptg6tx/public");
        searchImage.setFitHeight(600);
        searchImage.setFitWidth(500);

        VBox searchBox = new VBox();
        Stage searchStage = new Stage();
        searchBox.setStyle("-fx-background-color: #DEB887;");
        searchBox.setAlignment(Pos.CENTER);

        Label searchLabel = new Label("Please enter the book you are looking for");
        searchLabel.setFont(new Font("Tahoma", 18));
        TextField searchField = new TextField();
        Button enter = new Button("Enter");
        enter.setStyle("-fx-background-color: #FFE4C4; -fx-text-fill: #808000;" +
                " -fx-font-weight: bold;" + " -fx-border-color: black; -fx-border-width: 2px;");

        searchBox.setSpacing(5.0);


        searchBox.getChildren().addAll( searchLabel, searchImage, searchField, enter);

        Scene scene0 = new Scene(searchBox, 600, 1000);
        searchStage.setScene(scene0);
        searchStage.show();





    }
}
