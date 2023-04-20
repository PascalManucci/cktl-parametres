package fr.assococktail.cktlParametres.exceptions;

public class ServiceParametreException extends Exception{

    /**
     *
     */
    private static final long serialVersionUID = 61470748587891L;

    private String errorCode;
    private String errorMessage;

    public ServiceParametreException(String message, Throwable throwable) {
        super(message, throwable);
        this.errorMessage = message;
    }

    public ServiceParametreException(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }



}
