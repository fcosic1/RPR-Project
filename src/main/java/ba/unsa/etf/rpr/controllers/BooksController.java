package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.business.PurchaseManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Purchase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BooksController implements Initializable {
    @FXML
    public TableColumn column_title;
    @FXML
    public TableColumn column_author;
    @FXML
    public TableColumn column_bookType;
    @FXML
    public TableColumn column_ageOfBook;
    @FXML
    public TableColumn column_price;
    public TextField searchTextField;
    public Button buttonBuy;
    @FXML
    private TableView user_table;
    @FXML
    private ObservableList<Book> bookList = FXCollections.observableArrayList();
    private final BookManager bookManager = new BookManager();
    private final PurchaseManager purchaseManager = new PurchaseManager();
    private final UserManager userManager = new UserManager();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Book> list = bookManager.getAll();
        for(int i=0;i<list.size();i++){
            bookList.add(new Book(list.get(i).getId(),list.get(i).getBookTitle(), list.get(i).getAgeOfBook(), list.get(i).getAuthor(), list.get(i).getPrice(),list.get(i).getBookType()));
        }
        column_title.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        column_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        column_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        column_ageOfBook.setCellValueFactory(new PropertyValueFactory<>("ageOfBook"));
        column_bookType.setCellValueFactory(new PropertyValueFactory<>("bookType"));

        user_table.setItems(bookList);
        FilteredList<Book> filteredData = new FilteredList<>(bookList);
        searchTextField.textProperty().addListener((observable,oldValue,newValue) ->{
            filteredData.setPredicate(Book -> {
                if(newValue==null || newValue.isEmpty()) return true;
                String lowerCaseFilter=newValue.toLowerCase();
                if(Book.getBookTitle().toLowerCase().indexOf(lowerCaseFilter)!=-1) return true;
                else return false;
            });
        });
        SortedList<Book> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(user_table.comparatorProperty());
        user_table.setItems(sortedData);
    }
}
