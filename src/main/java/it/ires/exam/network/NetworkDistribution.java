package it.ires.exam.network;

import it.ires.exam.Sim.OperatorPlan;
import it.ires.exam.Sim.Plan;
import it.ires.exam.Sim.SimCard;
import it.ires.exam.exceptions.NotInCallException;
import it.ires.exam.exceptions.PhoneIsAlreadyInCallException;

public interface NetworkDistribution {
    void call(SimCard simThatsCalling, SimCard simThatsGettingCalled) throws PhoneIsAlreadyInCallException;

    void stopCall() throws NotInCallException;

    void changePlan(SimCard simCard, OperatorPlan operatorPlan);
}
