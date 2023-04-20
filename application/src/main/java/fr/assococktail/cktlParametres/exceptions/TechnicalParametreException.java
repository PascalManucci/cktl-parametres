package fr.assococktail.cktlParametres.exceptions;

public class TechnicalParametreException extends Exception{
    
    private static final long serialVersionUID = 5455874741741L;

    private String developerMessage;

    public TechnicalParametreException(Throwable cause) {
        super(cause);
    }

    public TechnicalParametreException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }


}
