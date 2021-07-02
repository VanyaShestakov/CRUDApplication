package Application.REST.ExceptionHandlers;

import Application.REST.Exceptions.IncorrectSexValueException;
import Application.REST.Exceptions.IncorrectPatientException;
import Application.REST.Exceptions.NoSuchPatientException;
import Application.REST.ResponseEntities.ExceptionInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("Application.REST.Controller")
public class RESTControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionInfo> handleNoSuchPatientException(NoSuchPatientException exception) {
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setInfo(exception.getMessage());
        return new ResponseEntity<>(exceptionInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionInfo> handleNumberFormatException(NumberFormatException exception) {
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setInfo("Incorrect " + exception.getMessage());
        return new ResponseEntity<>(exceptionInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionInfo> handleIncorrectPatientException(IncorrectPatientException exception) {
        ExceptionInfo exceptionInfo = new ExceptionInfo();
        exceptionInfo.setInfo(exception.getMessage());
        return new ResponseEntity<>(exceptionInfo, HttpStatus.BAD_REQUEST);
    }


}
