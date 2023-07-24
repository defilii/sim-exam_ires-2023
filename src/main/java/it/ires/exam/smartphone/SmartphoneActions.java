package it.ires.exam.smartphone;

import it.ires.exam.Sim.PhoneCall;
import it.ires.exam.Sim.SimCard;
import it.ires.exam.Sim.TypeCall;
import java.time.LocalDateTime;

public class SmartphoneActions implements SmartPhone {
    PhoneCall handledPhoneCallThatsCalling;
    PhoneCall handledPhoneCallThatsGettingCalled;
    static int startCallTime;
    static int startCallHour;
    int phoneCallDuration;

    @Override
    public PhoneCall startPhoneCall(SimCard simCardThatsCalling, SimCard simCardThatsGettingCalled){
            PhoneCall currentPhoneCall = new PhoneCall(simCardThatsGettingCalled.getPhoneNumber(), TypeCall.Calling);
            PhoneCall currentPhoneCallReceiving = new PhoneCall(simCardThatsCalling.getPhoneNumber(), TypeCall.Receiving);
            this.handledPhoneCallThatsCalling = currentPhoneCall;
            this.handledPhoneCallThatsGettingCalled = currentPhoneCallReceiving;
            simCardThatsCalling.addPhoneCall(currentPhoneCall);
            simCardThatsGettingCalled.addPhoneCall(currentPhoneCallReceiving);
            startCallTime = LocalDateTime.now().getMinute();
            startCallHour = LocalDateTime.now().getHour();
            simCardThatsGettingCalled.setCallStatus(true);
            simCardThatsCalling.setCallStatus(true);
            return currentPhoneCall;
        }


    @Override
    public void stopPhoneCall(SimCard simCardThatsCalling, SimCard simCardThatsGettingCalled) {
        handledPhoneCallThatsCalling.setCallLenght((int) phoneCallDuration());
        handledPhoneCallThatsGettingCalled.setCallLenght((int) phoneCallDuration());
        simCardThatsGettingCalled.setCallStatus(false);
        simCardThatsCalling.setCallStatus(false);
    }

    @Override
    public boolean isCallActive(SimCard simCardThatsCalling, SimCard simCardThatsGettingCalled) {
        return (simCardThatsGettingCalled.getCallStatus() && simCardThatsCalling.getCallStatus());
    }

    @Override
    public long phoneCallDuration() {
        int stopCallTime = LocalDateTime.now().getMinute();
        if (startCallTime < stopCallTime) {
            return (stopCallTime - startCallTime);
        } else {
            int elapsedHoursInMinutes = (LocalDateTime.now().getHour() - startCallHour) * 60;
            phoneCallDuration = (stopCallTime + elapsedHoursInMinutes - startCallTime);
            return phoneCallDuration();
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
