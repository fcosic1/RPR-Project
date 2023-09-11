package ba.unsa.etf.rpr.exceptions;

import java.sql.SQLException;

public class ProjectException extends RuntimeException {
    public ProjectException(String message, SQLException reason) {
        super(message);
    }
    public ProjectException(String message) {
        super(message);
    }

}
