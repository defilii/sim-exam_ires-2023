package it.ires.exam.smartphone;

import it.ires.exam.Sim.SimCard;
import it.ires.exam.exceptions.PhoneIsAlreadyInCallException;
import it.ires.exam.Sim.PhoneCall;

public interface SmartPhone {

    PhoneCall startPhoneCall(SimCard simCard, SimCard simThatsGettingCalled);
    void stopPhoneCall(SimCard simCardThatsCalling, SimCard simCardThatsGettingCalled);
    boolean isCallActive(SimCard simCardThatsCalling, SimCard simCardThatsGettingCalled);
    long phoneCallDuration();
    int howManyTimesHaveIcalledThisNumber(SimCard simCard, String phoneNumber);

}
