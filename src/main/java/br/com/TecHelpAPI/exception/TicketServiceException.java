package br.com.TecHelpAPI.exception;

public class TicketServiceException extends RuntimeException {
    public TicketServiceException(String message) {
        super(message);
    }

    public TicketServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
