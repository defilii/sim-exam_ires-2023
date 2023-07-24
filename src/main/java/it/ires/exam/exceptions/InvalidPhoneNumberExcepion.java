package it.ires.exam.exceptions;

public class InvalidPhoneNumberExcepion extends Exception {
    public InvalidPhoneNumberExcepion(String phoneNumber){
        super(String.format("%s is not a valid phone number", phoneNumber));
    }
}
