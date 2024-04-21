package com.example.bookhaven0;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

public class BookHavenFX extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage)  { // main page mostly front end with some actionHandling

        ImageView bookHavenIMG = new ImageView(new Image("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/cd847377-ad39-45cd-b315-efe75712f3f4/dfjsxml-bd9d95c5-4261-461e-aa7b-1bf8007b8249.jpg/v1/fill/w_894,h_894,q_70,strp/fantasy_library_background__by_enchantedhawke_dfjsxml-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTAyNCIsInBhdGgiOiJcL2ZcL2NkODQ3Mzc3LWFkMzktNDVjZC1iMzE1LWVmZTc1NzEyZjNmNFwvZGZqc3htbC1iZDlkOTVjNS00MjYxLTQ2MWUtYWE3Yi0xYmY4MDA3YjgyNDkuanBnIiwid2lkdGgiOiI8PTEwMjQifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.gbfPwY0npz0jWLuF7xaVUCNIFm9-sncKoRVrtWX89xo"));
        bookHavenIMG.setFitHeight(700);
        bookHavenIMG.setFitWidth(600);




        VBox startPage = new VBox();
        startPage.setStyle("-fx-background-color: BLACK;");
        startPage.setAlignment(Pos.CENTER);
        Label welcomeLabel = new Label("Welcome or welcome back to BookHaven.\n\nWe are glad to have you!\n",
                bookHavenIMG);
        welcomeLabel.setContentDisplay(ContentDisplay.CENTER);
        welcomeLabel.setFont(new Font("Tahoma",32));
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

        adminHandler adminHandle = new adminHandler();
        adminButton.setOnAction(adminHandle);

        startPage.getChildren().addAll(welcomeLabel, loginButton, createButton, adminButton);

        Scene scene0 = new Scene(startPage, 600,1000);
        stage.setScene(scene0);
        stage.show();

    }
}
class loginHandlerClass implements EventHandler<ActionEvent> { // front end for login
    @Override
    public void handle(ActionEvent e) {

        ImageView loginImage = new ImageView(new Image("https://i.pinimg.com/originals/ae/21/6b/ae216b6c9166bb91c297beba088d0a1e.jpg"));
        loginImage.setFitHeight(600);
        loginImage.setFitWidth(600);

        Stage loginStage = new Stage();
        VBox loginPage = new VBox();
        loginPage.setStyle("-fx-background-color: DARKSLATEBLUE;");
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


        loginPage.getChildren().addAll(welcomeBackLabel, loginImage, loginUserNameLabel, loginUserNameText,
                loginPassWordLabel, loginPassWordText, enterLogin);

        loginPage.setSpacing(5);

        Scene loginScene = new Scene(loginPage, 600, 1000);
        loginStage.setScene(loginScene);
        loginStage.show();

        enterLogin.setOnAction(d -> {

            final String name = loginUserNameText.getText(); // retrieving text from userName field
            final String passWord = loginPassWordText.getText(); // and passwordField


            boolean found = false;

            try (BufferedReader reader = new BufferedReader(new FileReader("username.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().equals(name.trim())) {
                        // Name already exists in the file
                        found = true;
                        break;
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
                alert.setHeaderText("Username does not exist");
                alert.setContentText("Please choose a different username or create account.");
                alert.showAndWait();
            }

            if(passWord.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("No password found");
                alert.setContentText("Please enter a password");
                alert.showAndWait();
            } else {
                enteredUserHandler loginEntered = new enteredUserHandler();
                enterLogin.setOnAction(loginEntered);
            }

            //*************************************************






//***************************************************


        });

    }
}

class createAccountHandlerClass implements EventHandler<ActionEvent> { // mostly front end stuff
    @Override
    public void handle(ActionEvent e) {

        //List<String> names = new ArrayList<>();
        //List<String> passwords = new ArrayList<>();



        ImageView createAccountImage = new ImageView(new Image("https://storage.googleapis.com/pai-images/0ba9ddb6d4e54fff8ca94362f2445994.jpeg"));
        createAccountImage.setFitHeight(600);
        createAccountImage.setFitWidth(600);

        Stage createAccountStage = new Stage();
        VBox createAccountPage = new VBox();
        createAccountPage.setStyle("-fx-background-color: #800000 ;");
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


            // writing usernames to userName file


            try (BufferedWriter writer = new BufferedWriter(new FileWriter("username.txt", true))) {

                boolean found = false;

                // reading them and making sure that userName does not already exist in file

                try (BufferedReader reader = new BufferedReader(new FileReader("username.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.trim().equals(name.trim())) {
                            // Name already exists in the file
                            found = true;
                            break;
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
                    writer.write(name + "\n");




                    enteredUserHandler enteredHandle = new enteredUserHandler(); // creating instance of
                    enterCreateAccount.setOnAction(enteredHandle); // otherwise enter shop




                }


            } catch (IOException a) {
                a.printStackTrace();
                throw new RuntimeException(a); // exception handling
            }

            try(BufferedWriter writer1 = new BufferedWriter(new FileWriter("password.txt",true))){


                writer1.write(passWord + "\n"); // writing the password. Two or more people can have the same
                // so there is no reason to check data base for duplicates

            } catch(IOException q){
                q.printStackTrace();

            }

            User user = new User(name, passWord,null);
            String userToString = user.toString();

            System.out.println(userToString);






        });
    }
}

class backButtonHandlerClass implements EventHandler<ActionEvent> { // replica of main page
    @Override
    public void handle(ActionEvent e) {
        ImageView bookHavenIMG = new ImageView(new Image("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/cd847377-ad39-45cd-b315-efe75712f3f4/dfjsxml-bd9d95c5-4261-461e-aa7b-1bf8007b8249.jpg/v1/fill/w_894,h_894,q_70,strp/fantasy_library_background__by_enchantedhawke_dfjsxml-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9MTAyNCIsInBhdGgiOiJcL2ZcL2NkODQ3Mzc3LWFkMzktNDVjZC1iMzE1LWVmZTc1NzEyZjNmNFwvZGZqc3htbC1iZDlkOTVjNS00MjYxLTQ2MWUtYWE3Yi0xYmY4MDA3YjgyNDkuanBnIiwid2lkdGgiOiI8PTEwMjQifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6aW1hZ2Uub3BlcmF0aW9ucyJdfQ.gbfPwY0npz0jWLuF7xaVUCNIFm9-sncKoRVrtWX89xo"));
        bookHavenIMG.setFitHeight(700);
        bookHavenIMG.setFitWidth(600);

        Stage backStage = new Stage();


        VBox startPage = new VBox();
        startPage.setStyle("-fx-background-color: BLACK;");
        startPage.setAlignment(Pos.CENTER);
        Label welcomeLabel = new Label("Welcome or welcome back to BookHaven.\n\nWe are glad to have you!\n",
                bookHavenIMG);
        welcomeLabel.setContentDisplay(ContentDisplay.CENTER);
        welcomeLabel.setFont(new Font("Tahoma", 32));
        welcomeLabel.setTextFill(Color.OLIVE);
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

// for after user enter their name successfully through login or createAccount

class enteredUserHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {
        ImageView interfaceImage = new ImageView("https://i.pinimg.com/originals/f6/a9/58/f6a958cc0bb5ea53db40b9cab1a7a0a7.jpg");
        interfaceImage.setFitHeight(600);
        interfaceImage.setFitWidth(500);

        Stage interfaceStage = new Stage();
        VBox interfacePage = new VBox();
        interfacePage.setStyle("-fx-background-color: #DEB887;");
        interfacePage.setAlignment(Pos.CENTER);
        Label optionsLabel = new Label("Pick from one of the following options");
        optionsLabel.setFont(new Font("Tahoma", 30));
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


        interfacePage.getChildren().addAll(optionsLabel, interfaceImage,seeCollectionButton,
                bookRecommendationButton, searchBook);

        Scene scene0 = new Scene(interfacePage, 600, 1000);
        interfaceStage.setScene(scene0);
        interfaceStage.show();



    }
}

class bookCollectionHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e) {

    }
}

class searchBookHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e) {




    }
}

class adminHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e) {

        Stage adminStage = new Stage();
        VBox adminPage = new VBox();

        Label adminLabel = new Label("Please enter your employee name and ID");
        TextField adminName = new TextField();
        TextField adminID = new TextField();
        Button enterAsAdmin = new Button("Enter");

        adminPage.setSpacing(3.0);

        adminPage.getChildren().addAll(adminLabel,adminName,adminID,enterAsAdmin);

        HashMap<String,Integer> adminHashMap = new HashMap<String,Integer>();



        enterAsAdmin.setOnAction(r -> {

            String employee = adminName.getText();
            int passCode = Integer.parseInt(adminID.getText());

            adminHashMap.put(employee,passCode);

            System.out.println(adminHashMap);

            addBookHandler addBookHandle = new addBookHandler();
            enterAsAdmin.setOnAction(addBookHandle);


        });



        Scene scene0 = new Scene(adminPage, 600, 1000);
        adminStage.setScene(scene0);
        adminStage.show();
    }
}

class addBookHandler extends Book implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {

        ImageView addBookImage = new ImageView("https://storage.googleapis.com/pai-images/0dad3fd431974d88b24e6ef5ed9b3f89.jpeg");
        addBookImage.setFitHeight(500);
        addBookImage.setFitWidth(500);

        Stage addBookStage = new Stage();
        VBox addBookPage = new VBox();
        addBookPage.setAlignment(Pos.CENTER);
        addBookPage.setStyle("-fx-background-color: TAN;");


        Label adminLabel = new Label("Enter the book information required below");
        adminLabel.setAlignment(Pos.TOP_CENTER);
        Label nameLabel = new Label("Title");
        TextField bookName = new TextField();
        Label idLabel = new Label("Book ID(ex. 11111)");
        TextField bookID = new TextField();
        Label authorLabel = new Label("Author");
        TextField author = new TextField();
        Label priceLabel = new Label("Price");
        TextField bookPrice = new TextField();
        Button enterBook= new Button("Enter");

        addBookPage.setSpacing(3.0);

        addBookPage.getChildren().addAll(adminLabel, addBookImage ,nameLabel,bookName,idLabel,bookID,authorLabel,author, priceLabel
        ,bookPrice, enterBook);

        Scene scene = new Scene(addBookPage, 600, 1200);
        addBookStage.setScene(scene);
        addBookStage.show();


        enterBook.setOnAction(book -> {

            Book userBook = new Book();

            String title = bookName.getText();
            userBook.setTitle(title);

            int bookCode = Integer.parseInt(bookID.getText());
            userBook.setCode(bookCode);

            String writer = author.getText();
            userBook.setAuthor(writer);

            double value = Double.parseDouble(bookPrice.getText());
            userBook.setPrice(value);

            Stack<Book> bookStack = new Stack<>(); // creating stack

            bookStack.push(userBook);
            System.out.println(bookStack); // prints the stack




        });

    }
}
