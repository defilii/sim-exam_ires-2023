package it.ires.exam.smartphone;

import it.ires.exam.Sim.SimCard;
import it.ires.exam.exceptions.PhoneIsAlreadyInCallException;
import it.ires.exam.Sim.PhoneCall;

public interface SmartPhone {

    PhoneCall startPhoneCall(SimCard simCard, String toWhom) throws PhoneIsAlreadyInCallException;
    void stopPhoneCall();
    boolean isCallActive();
    long phoneCallDuration();
    int howManyTimesHaveIcalledThisNumber(SimCard simCard, String phoneNumber);

}
