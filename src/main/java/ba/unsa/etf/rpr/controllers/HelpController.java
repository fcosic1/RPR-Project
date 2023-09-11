package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class HelpController {

        public Button btnZatvori, btnONama;

        public void actionOtvaranjeONama(ActionEvent actionEvent) throws IOException {
            try {
                Stage stage =(Stage)btnONama.getScene().getWindow();
                stage.close();
                Stage stage1 = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/obrendu.fxml"));
                OBrenduController brend = new OBrenduController();
                fxmlLoader.setController(brend);
                Scene scene = new Scene(fxmlLoader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE);
                stage1.setTitle("eBook");
                stage1.setScene(scene);
                stage1.setResizable(false);
                stage1.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        /**
         * Događaj za zatvaranje prozora
         *
         * @param actionEvent
         */
        public void actionZatvori(ActionEvent actionEvent)
        {
            Stage stage =(Stage)btnZatvori.getScene().getWindow();
            stage.close();
        }
}
