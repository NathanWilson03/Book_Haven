package com.example.bookhaven0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

class backButtonHandlerClass implements EventHandler<ActionEvent> { // replica of main page
    @Override
    public void handle(ActionEvent e) {
        ImageView bookHavenIMG = new ImageView(new Image("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/cd847377-ad39-45cd-b315-efe75712f3f4/dfjsxml-bd9d95c5-4261-461e-aa7b-1bf8007b8249.jpg/v1/fill/w_894,h_894,q_70,strp/fantasy_library_background__by_enchantedhawke_dfjsxml-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTAyNCIsInBhdGgiOiJcL2ZcL2NkODQ3Mzc3LWFkMzktNDVjZC1iMzE1LWVmZTc1NzEyZjNmNFwvZGZqc3htbC1iZDlkOTVjNS00MjYxLTQ2MWUtYWE3Yi0xYmY4MDA3YjgyNDkuanBnIiwid2lkdGgiOiI8PTEwMjQifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.gbfPwY0npz0jWLuF7xaVUCNIFm9-sncKoRVrtWX89xo"));
        bookHavenIMG.setFitHeight(700);
        bookHavenIMG.setFitWidth(600);

        Stage backStage = new Stage();


        VBox startPage = new VBox();
        startPage.setStyle("-fx-background-color: #DEB887;");
        startPage.setAlignment(Pos.CENTER);
        Label welcomeLabel = new Label("Welcome or welcome back to BookHaven.\n\nWe are glad to have you!\n",
                bookHavenIMG);
        welcomeLabel.setContentDisplay(ContentDisplay.CENTER);
        welcomeLabel.setFont(new Font("Tahoma", 32));
        welcomeLabel.setTextFill(Color.GHOSTWHITE);
        welcomeLabel.setTextAlignment(TextAlignment.CENTER);

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #FFE4C4; -fx-text-fill: #808000; -fx-font-weight: bold;" +
                " -fx-border-color: black; -fx-border-width: 2px;");
        loginHandlerClass loginHandle = new loginHandlerClass();
        loginButton.setOnAction(loginHandle); // uses loginHandlerClass to open new VBox();

        Button createButton = new Button("Create Account");
        createButton.setStyle("-fx-background-color: #FFE4C4; -fx-text-fill: #808000; -fx-font-weight: bold;" +
                " -fx-border-color: black; -fx-border-width: 2px;");
        createAccountHandlerClass createAccountHandle = new createAccountHandlerClass();
        createButton.setOnAction(createAccountHandle); // uses createAccountHandlerClass to open new VBox();

        Button adminButton = new Button("Admin");
        adminButton.setStyle("-fx-background-color: #FFE4C4; -fx-text-fill: #808000; -fx-font-weight: bold;" +
                " -fx-border-color: black; -fx-border-width: 2px;");

        startPage.getChildren().addAll(welcomeLabel, loginButton, createButton, adminButton);

        Scene scene0 = new Scene(startPage, 600, 1000);
        backStage.setScene(scene0);
        backStage.show();


        // Close the current stage (the create account stage)
        ((Stage) (((Button) e.getSource()).getScene().getWindow())).close();
    }
}

