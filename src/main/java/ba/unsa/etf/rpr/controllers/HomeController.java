package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PopupControl;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**Controller class which controls everything behind the home display of the app*/
public class HomeController {
    public MenuItem buttonBooks;
    public MenuItem buttonMyBooks;
    public MenuButton menu;

    public Label labelWelcome;

    /**to display book display */
   public void showBooks(ActionEvent actionEvent) throws IOException {
        Stage stage1=(Stage) menu.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/books.fxml"));
        Parent root = fxmlloader.load();
        stage1.setTitle("Books");
        stage1.setScene(new Scene(root,600,390));
    }

    /**to display mybooks*/
    public void showMyBooks(ActionEvent actionEvent) throws IOException {
        Stage stage1=(Stage) menu.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/mybooks.fxml"));
        Parent root = fxmlloader.load();
        stage1.setTitle("My Books");
        stage1.setScene(new Scene(root,600,390));
    }

    /**method to show login screen*/
    public void showLogin(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) menu.getScene().getWindow();
        Stage stage1 = new Stage();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("Book");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();
    }

    /**method to open help screen*/
    public void actionOtvaranjeHelp(ActionEvent actionEvent) throws IOException {
        try {
            Stage stage1 = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/help.fxml"));
            HelpController help = new HelpController();
            fxmlLoader.setController(help);
            Scene scene = new Scene(fxmlLoader.load(), PopupControl.USE_COMPUTED_SIZE, PopupControl.USE_COMPUTED_SIZE);
            stage1.setTitle("Pomoć eBook");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    /** method to open aboutus screen*/
    public void actionOtvaranjeONama(ActionEvent actionEvent) throws IOException {
        try {

            Stage stage1 = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/obrendu.fxml"));
            OBrenduController brend = new OBrenduController();
            fxmlLoader.setController(brend);
            Scene scene = new Scene(fxmlLoader.load(), PopupControl.USE_COMPUTED_SIZE, PopupControl.USE_COMPUTED_SIZE);
            stage1.setTitle("eBook");
            stage1.setScene(scene);
            stage1.setResizable(false);
            stage1.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
