package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.business.PurchaseManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ProjectException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    BookManager bookManager = new BookManager();
    UserManager userManager = new UserManager();
    PurchaseManager purchaseManager = new PurchaseManager();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    /**
     * Test of username to be between 5 and 15 characters
     */
    @Test
    public void usernameLogInTest()
    {
        assertThrows(ProjectException.class,()->{
            userManager.checkUsername("aaaa");
        });
    }
    /** Test password to be between 8 and 20 characters */
    @Test
    public void passwordLogInTest(){
        assertThrows(ProjectException.class,()->{
            userManager.checkPassword("abcdefghkhkhkdldlslkksd");
        });
    }


    /** Test for user that is already registered */

    @Test
    public void LogInTest(){
        assertDoesNotThrow(()->{
            userManager.checkLogIn("hamohamic","hamohamic");
        });
    }
    /** test to search by name
    @Test
    public void searchByUsername(){
        User u = userManager.searchByUsername("fcosic");
        assertEquals(u.getFirstName(),"faris");
    }*/

    /**test to search by lastName*/
    @Test
    public void searchByLastName(){
        User u = userManager.searchByUsername("fcosic");
        assertEquals(u.getLastName(),"");
    }

    /**test for adding book in database*/
    @Test
    public void addBook(){
        Book book = new Book();
        book.setBookTitle("Na drini cuprija");
        book.setAuthor("Autor");
        book.setAgeOfBook(Date.valueOf(LocalDate.now()));
        book.setBookType("drama");
        book.setPrice(50);
        bookManager.add(book);
        boolean found = false;
        List<Book> books=bookManager.getAll();
        Book book1 = books.get(books.size()-1);
        assertEquals(book.getId(),book1.getId());
        bookManager.delete(book1.getId());
    }
    /** Test for search book by title */
    @Test
    public void searchByTitle(){
        List<Book> list = bookManager.getAll();
        Book book = list.get(1);
        Book book2=bookManager.searchByBookTitle(book.getBookTitle()).get(0);
        assertEquals(book.getBookType(),book2.getBookType());
    }

    @Test
    public void checkPassworddTest() {
        UserManager umm=new UserManager();
        UserManager um = Mockito.mock(UserManager.class);
        User u = new User("fatima","cosic","fatcos","fatimaa","12345678");
        List<User> users=new ArrayList<>();
        users.add(u);
        Mockito.when(um.getAll()).thenReturn(users);
        assertDoesNotThrow(()->{
            umm.checkPassword(u.getPassword());
        });
    }





}
