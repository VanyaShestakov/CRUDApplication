package Application.REST.Exceptions;

public class IncorrectPatientException extends  RuntimeException{
    public IncorrectPatientException(String message) {
        super(message);
    }
}
