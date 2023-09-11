package ba.unsa.etf.rpr.controllers;

import javafx.scene.control.Alert;

/**class that display an alert on screen*/
public class ShowAlert {
    /**method which displays an alert on screen*/
    public static void showAlert(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }
}
