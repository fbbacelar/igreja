package br.com.fabio.igreja.exceptions;

public class ServiceException extends Exception {

    public ServiceException() {
    }
   
    public ServiceException(String message) {
        super(message);
    }

}