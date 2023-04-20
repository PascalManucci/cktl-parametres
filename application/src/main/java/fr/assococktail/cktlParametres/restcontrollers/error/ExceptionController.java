package fr.assococktail.cktlParametres.restcontrollers.error;

import fr.assococktail.cktlParametres.exceptions.ParametreErreurReponse;
import fr.assococktail.cktlParametres.exceptions.ServiceParametreException;
import fr.assococktail.cktlParametres.exceptions.TechnicalParametreException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceParametreException.class)
    public ResponseEntity<ParametreErreurReponse> handleLdapConnectServiceException(
            ServiceParametreException ex, WebRequest request) {
        ParametreErreurReponse parametreErreurReponse = new ParametreErreurReponse();
        parametreErreurReponse.setStatus(HttpStatus.BAD_REQUEST.value());
        parametreErreurReponse.setReasonPhrase(HttpStatus.BAD_REQUEST.getReasonPhrase());
        parametreErreurReponse.setErrorCode(ex.getErrorCode());
        parametreErreurReponse.setErrorMessage(ex.getErrorMessage());
        return new ResponseEntity<>(parametreErreurReponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TechnicalParametreException.class)
    public ResponseEntity<ParametreErreurReponse> handleLdapConnectTechnicalException(
            TechnicalParametreException ex, WebRequest request) {
        ParametreErreurReponse parametreErreurReponse = new ParametreErreurReponse();
        parametreErreurReponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        parametreErreurReponse.setReasonPhrase(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        parametreErreurReponse.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(parametreErreurReponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
