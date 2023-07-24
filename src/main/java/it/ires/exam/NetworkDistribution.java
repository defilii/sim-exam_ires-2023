package it.ires.exam;

import it.ires.exam.Sim.SimCard;
import it.ires.exam.exceptions.NotInCallException;
import it.ires.exam.exceptions.PhoneIsAlreadyInCallException;

public interface NetworkDistribution {
    void call(SimCard simThatsCalling, SimCard simThatsGettingCalled) throws PhoneIsAlreadyInCallException;

    void stopCall() throws NotInCallException;
}
