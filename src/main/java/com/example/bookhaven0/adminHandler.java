package com.example.bookhaven0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

class adminHandler extends Employee implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent e) {





        Stage adminStage = new Stage();
        VBox adminPage = new VBox();

        Label adminLabel = new Label("Please enter your admin name and ID");
        TextField adminName = new TextField();
        TextField adminID = new TextField();
        Button enterAsAdmin = new Button("Enter");

        adminPage.setSpacing(3.0);

        adminPage.getChildren().addAll(adminLabel,adminName,adminID,enterAsAdmin);





        enterAsAdmin.setOnAction(r -> {

            String adminNameText = adminName.getText();
            String adminIDText = adminID.getText();  // may cause a problem since this is an int







            if(!(adminNameText.equals("HavenBoss")) || !(adminIDText.equals("FCC")) || adminNameText.isEmpty() || adminIDText.isEmpty()){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Wrong admin UserName or Password ");
                alert.setContentText("Please enter the correct information or press Back");
                alert.showAndWait();

            } else {




                enteredAdminHandler adminEntered = new enteredAdminHandler();
                enterAsAdmin.setOnAction(adminEntered);

                System.out.println("Entered");



            }






        });



        Scene scene0 = new Scene(adminPage, 600, 1000);
        adminStage.setScene(scene0);
        adminStage.show();
    }
}

class enteredAdminHandler extends adminHandler implements EventHandler<ActionEvent>{


    @Override
    public void handle(ActionEvent e) {
        Stage adminStage = new Stage();
        VBox adminBox = new VBox();
        Label optionsLabel = new Label("Please select from one of the following options");

        Button addBookButton = new Button("Add New Book To System");
        addBookHandler addBook = new addBookHandler();
        addBookButton.setOnAction(addBook);

        Button deleteBookButton = new Button("Delete Book From System");
        deleteBookHandler deleteBook = new deleteBookHandler();
        deleteBookButton.setOnAction(deleteBook);

        Button changeBookPrice = new Button("Change Price of Book");
        Button viewSales = new Button("View Sales");



        adminBox.setSpacing(3.0);

        adminBox.getChildren().addAll(optionsLabel, addBookButton,deleteBookButton,changeBookPrice,viewSales);

        Scene scene = new Scene(adminBox,600,1000);
        adminStage.setScene(scene);
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
        Button enterBook = new Button("Enter");

        addBookPage.setSpacing(3.0);

        addBookPage.getChildren().addAll(adminLabel, addBookImage, nameLabel, bookName, idLabel, bookID, authorLabel, author, priceLabel
                , bookPrice, enterBook);

        Scene scene = new Scene(addBookPage, 600, 1200);
        addBookStage.setScene(scene);
        addBookStage.show();


        enterBook.setOnAction(book -> {

            Book userBook = new Book();
            userBook.setTitle(bookName.getText());
            userBook.setCode(Integer.parseInt(bookID.getText()));
            userBook.setAuthor(author.getText());
            userBook.setPrice(Double.parseDouble(bookPrice.getText()));

            try (BufferedReader bookReader = new BufferedReader(new FileReader("library.txt"))) {
                Deque<String> bookStack = new ArrayDeque<>();
                String line;

                // Reading existing book titles into a deque
                while ((line = bookReader.readLine()) != null) {
                    String[] parts = line.split(",", 2);
                    if (parts.length > 0) {
                        String titlePart = parts[0].trim();
                        bookStack.push(titlePart);
                        if (titlePart.equals(userBook.getTitle())) {
                            // Book already exists, show an alert and return
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setHeaderText("Book already exists");
                            alert.setContentText("Please choose a different Book.");
                            alert.showAndWait();
                            return;
                        }
                    }

                }

                // Book doesn't exist, print deque to console and add book to library.txt
                System.out.println(bookStack);
                try (BufferedWriter bookWriter = new BufferedWriter(new FileWriter("library.txt", true))) {
                    bookWriter.write(userBook.toString());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

}
class deleteBookHandler extends Book implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){

        ImageView deleteBookImage = new ImageView("https://cdn.pixabay.com/photo/2024/01/04/23/48/ai-generated-8488616_1280.jpg");
        deleteBookImage.setFitHeight(500);
        deleteBookImage.setFitWidth(500);

        Stage deleteBookStage = new Stage();
        VBox deleteBookPage = new VBox();
        deleteBookPage.setAlignment(Pos.CENTER);
        deleteBookPage.setStyle("-fx-background-color: TAN;");

        Label adminLabel = new Label("Enter the book you wish to delete below");
        adminLabel.setContentDisplay(ContentDisplay.CENTER);
        adminLabel.setFont(new Font("Tahoma",20));
        adminLabel.setTextAlignment(TextAlignment.CENTER);
        TextField deleteBook = new TextField();
        Button deleteBookEnter = new Button("Enter");

        deleteBookPage.getChildren().addAll(adminLabel,deleteBookImage, deleteBook, deleteBookEnter);

        deleteBookPage.setSpacing(8.0);

        Scene scene = new Scene(deleteBookPage, 600, 1200);
        deleteBookStage.setScene(scene);
        deleteBookStage.show();

        deleteBookEnter.setOnAction(book -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Are you sure you want to delete this book?");
            Optional<ButtonType> result = alert.showAndWait();

            String bookToDelete = deleteBook.getText();

            // Check if the user clicked OK
            if (result.isPresent() && result.get() == ButtonType.OK) {
                // Perform your action when OK is pressed


                deleteBook(bookToDelete);


                // Call your deleteBook method or perform any other action here
            } else {
                // Handle the case when user cancels the operation
                deleteBook.clear();
            }
        });



    }

    public static void deleteBook(String titleToDelete) {

        Deque<String> updatedBooks = new ArrayDeque<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("library.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2); // Split at the first comma
                if (parts.length > 0) {
                    String title = parts[0].trim(); // Extract the title before the comma
                    if (!title.equals(titleToDelete)) {
                        // Add the book to the updated deque if it's not the one to be deleted
                        updatedBooks.add(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write the updated book list back to the library.txt file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("library.txt"))) {
            while (!updatedBooks.isEmpty()) {
                writer.write(updatedBooks.poll() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
