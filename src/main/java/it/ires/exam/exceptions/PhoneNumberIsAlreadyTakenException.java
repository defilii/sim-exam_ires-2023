package it.ires.exam.exceptions;

public class PhoneNumberIsAlreadyTakenException extends Throwable {
    public PhoneNumberIsAlreadyTakenException(String phoneNumber){
        super(String.format("%s is already taken", phoneNumber));
    }
}
