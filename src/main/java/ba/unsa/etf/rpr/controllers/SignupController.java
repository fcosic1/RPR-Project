package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
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
    public TextField fieldLastName;
    public TextField fieldEmail;
    public TextField fieldUsername;
    public PasswordField fieldPassword;
    private final UserManager userManager = new UserManager();

}
