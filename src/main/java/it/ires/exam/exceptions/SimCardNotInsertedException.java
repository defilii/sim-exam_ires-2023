package it.ires.exam.exceptions;

public class SimCardNotInsertedException extends Throwable {
    public SimCardNotInsertedException(){
        super("Smartphone has no simcard");
    }
}
