package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class LoginController {
    public TextField fieldUsername;
    public PasswordField fieldPassword;

    public static String username ;
    private final UserManager customerManager=new UserManager();


    public void buttonLogIn(ActionEvent actionevent) throws IOException {
        try{
            usermanager.checkLogIn(fieldUsername.getText(),fieldPassword.getText());
        } catch (Exception e) {
            AlertDisplay.showAlert("Error","Invalid input!",e.getMessage());
            return;
        }
        Stage stage=(Stage) fieldUsername.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        //FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        //Parent root = fxmlloader.load();
        //stage1.setScene(new Scene(root,600,430));
        //HomeController homecontroller = fxmlloader.getController();
        //homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+fieldUsername.getText() + "!");
        stage1.show();
        username=fieldUsername.getText();
    }


    public static String getUsername(){
        return username;
    }
    public void registerButton(ActionEvent actionevent) throws IOException {
        Stage stage1=(Stage) fieldUsername.getScene().getWindow();
        stage1.close();
        Stage stage = new Stage();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("Book");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();
    }
}
