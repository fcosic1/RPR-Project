package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class SignupController {
    public Button buttonRegister;
    public TextField fieldName;
    public TextField fieldLastname;
    public TextField fieldEmail;
    public TextField fieldUsername;
    public PasswordField fieldPassword;
    private final UserManager userManager = new UserManager();

    public static String username ;

    public void buttonRegister(ActionEvent actionEvent) throws IOException {
        try{
            userManager.checkFieldEmpty(new ArrayList<String>(Arrays.asList(fieldName.getText(),fieldLastname.getText(),
                    fieldEmail.getText(),fieldUsername.getText(),fieldPassword.getText())));
            userManager.checkUsernameForRegistration(fieldUsername.getText());
            userManager.checkPassword(fieldPassword.getText());
        } catch (Exception e) {
            //AlertDisplay.showAlert("Error", "Registration failed", e.getMessage());
            return;
        }
        userManager.add(new User(fieldName.getText().trim(),fieldLastname.getText().trim(),fieldEmail.getText().trim(),fieldUsername.getText().trim(),fieldPassword.getText().trim()));
        Stage stage=(Stage) fieldUsername.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent root = fxmlloader.load();
        stage1.setScene(new Scene(root,600,430));
        HomeController homecontroller = fxmlloader.getController();
        homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+fieldUsername.getText() + "!");
        stage1.show();
        username=fieldUsername.getText().trim();
    }



    public void buttonLogIn(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) fieldPassword.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("Book");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();
    }
}
