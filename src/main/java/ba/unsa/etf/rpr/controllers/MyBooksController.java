package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.PurchaseTableView;
import ba.unsa.etf.rpr.business.PurchaseTableViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MyBooksController implements Initializable {
    @FXML
    public TableView myBooksTable;
    @FXML
    public TableColumn column_title;
    @FXML
    public TableColumn column_author;
    @FXML
    public TableColumn column_bookType;
    @FXML
    public TableColumn column_price;
    @FXML
    public TableColumn column_date;
    @FXML
    private ObservableList<PurchaseTableView> bookList = FXCollections.observableArrayList();
    private final PurchaseTableViewManager purchaseTableViewManager=new PurchaseTableViewManager();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
