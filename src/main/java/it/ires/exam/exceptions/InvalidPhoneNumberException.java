package it.ires.exam.exceptions;

public class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String phoneNumber){
        super(String.format("%s is not a valid phone number", phoneNumber));
    }
}
