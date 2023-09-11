package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.business.PurchaseManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ProjectException;
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
    public TableColumn column_date;
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
            bookList.add(new Book(list.get(i).getId(),list.get(i).getBookTitle(), list.get(i).getPrice(), list.get(i).getAuthor(),list.get(i).getAgeOfBook(), list.get(i).getBookType()));
        }
        column_title.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        column_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        column_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        column_date.setCellValueFactory(new PropertyValueFactory<>("ageOfBook"));
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

    public void showHome(ActionEvent actionEvent) throws Exception{
        Stage stage=(Stage) user_table.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent root = fxmlloader.load();
        HomeController homecontroller = fxmlloader.getController();
        if(LoginController.getUsername() != null)
            homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+LoginController.getUsername() + "!");
        else homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+SignupController.username + "!");
        stage.setScene(new Scene(root,600,430));
    }

    public void actionBuy(ActionEvent actionEvent) {
        Book book = (Book) user_table.getSelectionModel().getSelectedItem();
        if(book==null){
            ShowAlert.showAlert("Warning","No books selected","Please select book that you want to purchase");
            return;
        }

        User user;
        if(LoginController.getUsername() != null)
            user = userManager.searchByUsername(LoginController.getUsername());
        else
            user = userManager.searchByUsername(SignupController.username);
       try{
            PurchaseManager purchaseManager=new PurchaseManager();
            purchaseManager.isPurchaseAlreadyMade(user,book);
        } catch (ProjectException e) {
            ShowAlert.showAlert("Warning", "Book purchase error", "You already purchased this book");
        }
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        purchaseManager.add(new Purchase(book,user,date));
    }
    public void showMyBooks(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) user_table.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/mybooks.fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("My Books");
        stage.setScene(new Scene(root,600,430));
    }
}
