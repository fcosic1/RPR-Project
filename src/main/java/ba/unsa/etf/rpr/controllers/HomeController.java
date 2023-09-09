package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class HomeController {
    public MenuItem buttonBooks;
    public MenuItem buttonMyBooks;
    public MenuButton menu;

    public Label labelWelcome;


   public void showBooks(ActionEvent actionEvent) throws IOException {
        Stage stage1=(Stage) menu.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/books.fxml"));
        Parent root = fxmlloader.load();
        stage1.setTitle("Books");
        stage1.setScene(new Scene(root,600,390));
    }


    public void showMyBooks(ActionEvent actionEvent) throws IOException {
        Stage stage1=(Stage) menu.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/mybooks.fxml"));
        Parent root = fxmlloader.load();
        stage1.setTitle("My Books");
        stage1.setScene(new Scene(root,600,390));
    }


    public void showLogin(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) menu.getScene().getWindow();
        Stage stage1 = new Stage();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("Book");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();
    }

}
