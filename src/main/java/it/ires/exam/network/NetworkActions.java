package it.ires.exam.network;

import it.ires.exam.Sim.OperatorPlan;
import it.ires.exam.Sim.Plan;
import it.ires.exam.Sim.SimCard;
import it.ires.exam.exceptions.NotInCallException;
import it.ires.exam.exceptions.PhoneIsAlreadyInCallException;
import it.ires.exam.smartphone.Smartphone;

import java.util.Optional;

public class NetworkActions implements NetworkDistribution {
    Smartphone smartphone = new Smartphone();
    SimCard simThatsCalling;
    SimCard simThatsGettingCalled;

    @Override
    public void call(SimCard simThatsCalling, SimCard simThatsGettingCalled) throws PhoneIsAlreadyInCallException {
        if (!simThatsCalling.getCallStatus() &&
                !simThatsGettingCalled.getCallStatus()) {
            smartphone.startPhoneCall(simThatsCalling, simThatsGettingCalled);
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
            smartphone.stopPhoneCall(simThatsCalling, simThatsGettingCalled);
        } else {
            throw new NotInCallException();
        }
    }

    @Override
    public void changePlan(SimCard simCard, OperatorPlan operatorPlan) {
        simCard.setPlan(operatorPlan);
    }
}
