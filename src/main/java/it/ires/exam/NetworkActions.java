package it.ires.exam;

import it.ires.exam.Sim.PhoneCall;
import it.ires.exam.Sim.SimCard;
import it.ires.exam.Sim.TypeCall;
import it.ires.exam.exceptions.NotInCallException;
import it.ires.exam.exceptions.PhoneIsAlreadyInCallException;
import it.ires.exam.smartphone.SmartphoneActions;

import java.util.Optional;

public class NetworkActions implements NetworkDistribution {
    SmartphoneActions smartphoneActions = new SmartphoneActions();

    SimCard simThatsCalling;
    SimCard simThatsGettingCalled;

    @Override
    public void call(SimCard simThatsCalling, SimCard simThatsGettingCalled) throws PhoneIsAlreadyInCallException {
        if (!simThatsCalling.getCallStatus() &&
                !simThatsGettingCalled.getCallStatus()) {
            smartphoneActions.startPhoneCall(simThatsCalling, simThatsGettingCalled);
            this.simThatsCalling = simThatsCalling;
            this.simThatsGettingCalled = simThatsGettingCalled;
        } else {
            throw new PhoneIsAlreadyInCallException();
        }

    }

    @Override
    public void stopCall() throws NotInCallException {
        Optional<SimCard> sim1 = Optional.ofNullable(simThatsCalling);
        Optional<SimCard> sim2 = Optional.ofNullable(simThatsGettingCalled);
        if (sim1.isPresent() && sim2.isPresent()) {
            smartphoneActions.stopPhoneCall(simThatsCalling, simThatsGettingCalled);
        } else {
            throw new NotInCallException();
        }


    }
}
