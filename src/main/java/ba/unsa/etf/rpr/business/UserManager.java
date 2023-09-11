package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.ArrayList;
import java.util.List;
/**
 * Business Logic Layer for management of Users
 */
public class UserManager {

    public List<User> getAll() throws ProjectException {
        return DaoFactory.userDao().getAll();
    }
    public void delete(int id) throws ProjectException {
        DaoFactory.userDao().delete(id);
    }
    public User add(User item) throws ProjectException{
        return DaoFactory.userDao().add(item);
    }
    public User update(User item) throws ProjectException{
        return DaoFactory.userDao().update(item);
    }

    /**Provjeri koristeci username*/
    public User searchByUsername(String username) throws ProjectException {
        return DaoFactory.userDao().searchByUsername(username);
    }

    /**Provjera username, da li je prazno polje i da li je izmedju 5 i 15 karaktera*/
    public void checkUsername(String username){
        if(username.trim().isEmpty() )
            throw new ProjectException("Username field empty");
        else if(username.trim().length()<5 || username.trim().length()>15)
            throw new ProjectException("Username needs to be between 5 and 15 characters long!");
    }
    /**Provjera passworda da li je izmedju 8 i 20*/
    public void checkPassword(String password){
        if(password.trim().isEmpty()) throw new ProjectException("Password field empty");
        else if(password.trim().length()<8 || password.trim().length()>20) throw new ProjectException("Password needs to be between 8 and 20 characters long!");
    }
    /**provjera logina, da li ima user sa tim usernamom, i da li je password tacan*/
    public void checkLogIn(String username, String password){
        checkUsername(username);
        checkPassword(password);
        UserManager userManager=new UserManager();
        User user = userManager.searchByUsername(username);
        if(user == null) throw new ProjectException("No user is registered with given username!");
        if(!user.getPassword().equals(password)) throw new ProjectException("Password incorrect!");
    }
    public void checkFieldEmpty(ArrayList<String> fields){
        for(String s : fields)
            if(s.trim().isEmpty()) throw new ProjectException("Text field cannot be blank!");
    }
    public void checkUsernameForRegistration(String username){
        if(username.trim().isEmpty() )
            throw new ProjectException("Username field empty");
        else if(username.trim().length()<5 || username.trim().length()>15)
            throw new ProjectException("Username needs to be between 5 and 15 characters long!");
        else if (searchByUsername(username.trim()) != null)
            throw new ProjectException("Account with given username already exists!");
    }
}
