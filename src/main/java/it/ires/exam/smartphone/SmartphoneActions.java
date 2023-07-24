package it.ires.exam.smartphone;

import it.ires.exam.Sim.PhoneCall;
import it.ires.exam.Sim.SimCard;
import it.ires.exam.exceptions.PhoneIsAlreadyInCallException;

import java.time.LocalDateTime;

public class SmartphoneActions implements SmartPhone {
    PhoneCall handledPhoneCall;
    static int startCallTime;
    static int startCallHour;
    boolean isCallActive = false;

    @Override
    public PhoneCall startPhoneCall(SimCard simCard, String toWhom) throws PhoneIsAlreadyInCallException {
        if (!isCallActive()) {
            PhoneCall currentPhoneCall = new PhoneCall(toWhom);
            this.handledPhoneCall = currentPhoneCall;
            simCard.addPhoneCall(currentPhoneCall);
            startCallTime = LocalDateTime.now().getMinute();
            startCallHour = LocalDateTime.now().getHour();
            isCallActive = true;
            return currentPhoneCall;
        } else {
            throw new PhoneIsAlreadyInCallException();
        }
    }

    @Override
    public void stopPhoneCall() {
        handledPhoneCall.setCallLenght((int) phoneCallDuration());
        isCallActive = false;
    }

    @Override
    public boolean isCallActive() {
        return isCallActive;
    }

    @Override
    public long phoneCallDuration() {
        int stopCallTime = LocalDateTime.now().getMinute();
        if (startCallTime < stopCallTime) {
            return (stopCallTime - startCallTime);
        } else {
            int elapsedHoursInMinutes = (LocalDateTime.now().getHour() - startCallHour) * 60;
            return (stopCallTime + elapsedHoursInMinutes - startCallTime);
        }
    }

    @Override
    public int howManyTimesHaveIcalledThisNumber(SimCard simCard, String phoneNumber) {
        return (int) simCard.getPhoneCalls().stream()
                .map(PhoneCall::getToWhom)
                .filter(number -> number.equals(phoneNumber))
                .count();
    }
}
