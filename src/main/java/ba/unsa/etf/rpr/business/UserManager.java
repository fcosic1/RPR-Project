package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.exceptions.ProjectException;

public class UserManager {
    public void checkUsername(String username){
        if(username.trim().isEmpty() )
            throw new ProjectException("Username field empty");
        else if(username.trim().length()<5 || username.trim().length()>15)
            throw new ProjectException("Username needs to be between 5 and 15 characters long!");
    }
}
