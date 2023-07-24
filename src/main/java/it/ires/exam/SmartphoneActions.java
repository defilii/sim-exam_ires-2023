package it.ires.exam;

import it.ires.exam.exceptions.PhoneIsAlreadyInCallException;

public class SmartphoneActions implements SmartPhone {
    @Override
    public PhoneCall startPhoneCall() throws PhoneIsAlreadyInCallException {
        return null;
    }

    @Override
    public void stopPhoneCall() {

    }

    @Override
    public boolean isCallActive() {
        return false;
    }

    @Override
    public long phoneCallDuration() {
        return 0;
    }
}
