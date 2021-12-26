package uz.agromon.config.exception;

import io.swagger.models.auth.In;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.agromon.config.exception.klass.*;
import uz.agromon.helper.APIResponse;
import uz.agromon.helper.FailureMessage;
import uz.agromon.helper.ResponseBuilder;
import uz.agromon.mobile.dto.response.LoginResponse;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class AgroMonExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<APIResponse> handleExceptions(Exception exception) {
        FailureMessage failureMessage = new FailureMessage();

        failureMessage.setExceptionMessage(UnexpectedException.class.toString());
        failureMessage.setExceptionMessage(exception.getMessage());

        return ResponseBuilder.buildError(failureMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccessRefusedException.class)
    protected ResponseEntity<APIResponse> handleAccessRefusedException(AccessRefusedException e) {
        FailureMessage message = new FailureMessage();
        message.setExceptionName(AccessRefusedException.class.toString());
        message.setExceptionMessage(e.getMessage());
        return ResponseBuilder.buildError(message, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    protected ResponseEntity<APIResponse> handleAlreadyExistsException(AlreadyExistsException e) {
        FailureMessage failureMessage = new FailureMessage();

        failureMessage.setExceptionName(AlreadyExistsException.class.toString());
        failureMessage.setExceptionMessage(e.getMessage());

        return ResponseBuilder.buildError(failureMessage, HttpStatus.OK);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ResponseEntity<APIResponse> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        FailureMessage failureMessage = new FailureMessage();

        failureMessage.setExceptionName(DataIntegrityViolationException.class.toString());
        failureMessage.setExceptionMessage(e.getMessage());

        return ResponseBuilder.buildError(failureMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidParameterException.class)
    protected ResponseEntity<APIResponse> handleInvalidParameterException(InvalidParameterException e) {
        FailureMessage failureMessage = new FailureMessage();

        failureMessage.setExceptionMessage(InvalidParameterException.class.toString());
        failureMessage.setExceptionMessage(e.getMessage());

        return ResponseBuilder.buildError(failureMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<APIResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        FailureMessage failureMessage = new FailureMessage();

        failureMessage.setExceptionMessage(ResourceNotFoundException.class.toString());
        failureMessage.setExceptionMessage(e.getMessage());

        return ResponseBuilder.buildError(failureMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnexpectedException.class)
    protected ResponseEntity<APIResponse> handleUnexpectedException(UnexpectedException e) {
        FailureMessage failureMessage = new FailureMessage();

        failureMessage.setExceptionMessage(UnexpectedException.class.toString());
        failureMessage.setExceptionMessage(e.getMessage());

        return ResponseBuilder.buildError(failureMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidUserParameterException.class)
    protected ResponseEntity<LoginResponse> handleInvalidUserParam(InvalidUserParameterException exception) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setResult(false);
        loginResponse.setMessage(exception.getMessage());
        return ResponseEntity.ok(loginResponse);
    }
}
