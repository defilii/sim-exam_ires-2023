package it.ires.exam.exceptions;

public class NotInCallException extends Exception {

    public NotInCallException(){
        super("Cant stop call while not being in one");
    }
}

