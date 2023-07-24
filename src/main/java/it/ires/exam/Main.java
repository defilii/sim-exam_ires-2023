package it.ires.exam;

import it.ires.exam.Sim.OperatorPlan;
import it.ires.exam.Sim.Plan;
import it.ires.exam.Sim.SimCard;
import it.ires.exam.exceptions.InvalidPhoneNumberException;
import it.ires.exam.exceptions.NotInCallException;
import it.ires.exam.exceptions.PhoneIsAlreadyInCallException;
import it.ires.exam.exceptions.PhoneNumberIsAlreadyTakenException;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws PhoneNumberIsAlreadyTakenException, InvalidPhoneNumberException, PhoneIsAlreadyInCallException, NotInCallException, InterruptedException {
        PhoneApp phoneApp = new PhoneApp();
        SimCard simCard1 = phoneApp.createNewSim( 0, new OperatorPlan(Plan.CHEAP));
        SimCard simCard = phoneApp.createNewSim( 0, new OperatorPlan(Plan.CHEAP));
        phoneApp.networkActions.call(simCard, simCard1);
        TimeUnit.SECONDS.sleep(1);
        phoneApp.networkActions.stopCall();
        System.out.println(simCard1.toString());
        System.out.println(simCard.toString());

    }
}
