package it.ires.exam.exceptions;

public class PhoneIsAlreadyInCallException extends Exception {
    public PhoneIsAlreadyInCallException(){
        super("Phone is already in call, stop current call before making a new one");
    }
}
