package it.ires.exam;

import it.ires.exam.Sim.OperatorPlan;
import it.ires.exam.Sim.Plan;
import it.ires.exam.Sim.SimCard;
import it.ires.exam.exceptions.InvalidPhoneNumberException;
import it.ires.exam.exceptions.PhoneNumberIsAlreadyTakenException;
import it.ires.exam.network.NetworkActions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneApp {

    NetworkActions networkActions = new NetworkActions();

    static Map<String, SimCard> simCards = new HashMap<>();
    static Set<String> takenPhoneNumbers = new HashSet<>();

    public PhoneApp() {
        Map<String, SimCard> simCards ;
        Set<String> takenPhoneNumbers ;
    }

    public String availableOperatorPlans() {
        List<OperatorPlan> availablePlans = Arrays.asList(OperatorPlan.class.getEnumConstants());
        return availablePlans.toString();
    }

    public SimCard createNewSim(float credit, OperatorPlan operatorPlan) {
        String phoneNumber = generatePhoneNumber();
        do {
            phoneNumber = generatePhoneNumber();
        }
        while (takenPhoneNumbers.contains(phoneNumber));
        SimCard simCard = new SimCard(phoneNumber, credit, operatorPlan);
        simCards.put(phoneNumber, simCard);
        takenPhoneNumbers.add(phoneNumber);
        return simCard;
    }

    private String generatePhoneNumber() {
        Random random = new Random();
        int part1 = random.nextInt(999);
        int part2 = random.nextInt(9999);
        int part3 = random.nextInt(999);
        return String.valueOf(part1) + String.valueOf(part2) + String.valueOf(part3);
    }

    public SimCard createNewSim(String phoneNumber, float credit, OperatorPlan operatorPlan) throws PhoneNumberIsAlreadyTakenException, InvalidPhoneNumberException {
        if (takenPhoneNumbers.contains(phoneNumber)) {
            throw new PhoneNumberIsAlreadyTakenException(phoneNumber);
        }
        if (!checkIfNumberIsValid(phoneNumber)) {
            throw new InvalidPhoneNumberException(phoneNumber);
        }
        SimCard simCard = new SimCard(phoneNumber, credit, operatorPlan);
        simCards.put(phoneNumber, simCard);
        takenPhoneNumbers.add(phoneNumber);
        return simCard;
    }

    private boolean checkIfNumberIsValid(String phoneNumber) {
        Pattern pattern = Pattern.compile("\"((\\+?[0-9]{2})?([0-9]{10}))\"gm");
        Matcher matcher = pattern.matcher(phoneNumber.trim());
        return matcher.find();
    }
}
