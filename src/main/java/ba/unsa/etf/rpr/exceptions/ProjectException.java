package ba.unsa.etf.rpr.exceptions;

public class ProjectException extends Exception {
    public ProjectException(String message, Exception reason) {
        super(message, reason);
    }
    public ProjectException(String message) {
        super(message);
    }

}
