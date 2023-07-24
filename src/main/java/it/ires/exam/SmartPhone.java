package it.ires.exam;

import it.ires.exam.exceptions.PhoneIsAlreadyInCallException;

import java.time.LocalTime;

public interface SmartPhone {

    PhoneCall startPhoneCall() throws PhoneIsAlreadyInCallException;
    void stopPhoneCall();
    boolean isCallActive();
    long phoneCallDuration();

}
