package br.com.fabio.igreja.exceptions;

public class ServiceException extends Exception {

//    private static final long serialVersionUID = -3285686331008549906L;

    public ServiceException() {
    }
   
    public ServiceException(String message) {
        super(message);
    }

}