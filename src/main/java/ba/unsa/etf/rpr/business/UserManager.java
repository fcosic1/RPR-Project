package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.ProjectException;

import java.util.List;

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
    public User searchByUsername(String username) throws ProjectException {
        return DaoFactory.userDao().searchByUsername(username);
    }
    public void checkUsername(String username){
        if(username.trim().isEmpty() )
            throw new ProjectException("Username field empty");
        else if(username.trim().length()<5 || username.trim().length()>15)
            throw new ProjectException("Username needs to be between 5 and 15 characters long!");
    }
    public void checkPassword(String password){
        if(password.trim().isEmpty()) throw new ProjectException("Password field empty");
        else if(password.trim().length()<8 || password.trim().length()>20) throw new ProjectException("Password needs to be between 8 and 20 characters long!");
    }
    public void checkLogIn(String username, String password){
        checkUsername(username);
        checkPassword(password);
        UserManager userManager=new UserManager();
        User user = userManager.searchByUsername(username);
        if(user == null) throw new ProjectException("No user is registered with given username!");
        if(!user.getPassword().equals(password)) throw new ProjectException("Password incorrect!");
    }
}