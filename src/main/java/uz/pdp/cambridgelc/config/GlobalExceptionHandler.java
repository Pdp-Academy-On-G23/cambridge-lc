package uz.pdp.cambridgelc.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.pdp.cambridgelc.entity.error.ErrorMessage;
import uz.pdp.cambridgelc.exception.DataNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({DataNotFoundException.class})
    public ResponseEntity<ErrorMessage> dataNotFoundException(RuntimeException e) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
