package it.ires.exam.smartphone;

import it.ires.exam.Sim.PhoneCall;
import it.ires.exam.Sim.SimCard;
import it.ires.exam.Sim.TypeCall;
import it.ires.exam.exceptions.SimCardNotInsertedException;

import java.time.LocalDateTime;
import java.util.Optional;

public class Smartphone implements SmartphoneInterface {
    PhoneCall handledPhoneCallThatsCalling;
    PhoneCall handledPhoneCallThatsGettingCalled;
    static int startCallTime;
    static int startCallHour;
    int phoneCallDuration;
    SimCard simCard;

    public Smartphone(SimCard simCard) {
        this.simCard = simCard;
    }

    public Smartphone(){}

    public PhoneCall startPhoneCall(SimCard simCardThasGettingCalled) throws SimCardNotInsertedException {
        Optional<SimCard> simCardOptional = Optional.ofNullable(simCard);
        if (simCardOptional.isPresent()){
            return startPhoneCall(simCardOptional.get(), simCardThasGettingCalled);
        }else{
            throw new SimCardNotInsertedException();
        }
    }

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
