package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.PurchaseTableView;
import ba.unsa.etf.rpr.business.PurchaseTableViewManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
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
        List<PurchaseTableView> list;
        if(LoginController.getUsername() != null)
            list = purchaseTableViewManager.getMyBooks(LoginController.getUsername());
        else list = purchaseTableViewManager.getMyBooks(SignupController.username);
        for(int i=0;i<list.size();i++){
            bookList.add(new PurchaseTableView(list.get(i).getBookTitle(),list.get(i).getAuthor(),list.get(i).getBookType(),list.get(i).getPrice(),list.get(i).getPurchase_date()));
        }
        column_title.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        column_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        column_bookType.setCellValueFactory(new PropertyValueFactory<>("bookType"));
        column_date.setCellValueFactory(new PropertyValueFactory<>("purchase_date"));
        column_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        myBooksTable.setItems(bookList);
    }

}

