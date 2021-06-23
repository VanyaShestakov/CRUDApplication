package Application.REST.Exceptions;

public class NoSuchPatientException extends RuntimeException{

    public NoSuchPatientException(String message) {
        super(message);
    }
}
