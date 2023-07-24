package it.ires.exam;

import java.util.HashSet;
import java.util.Set;

public class SimCard {
    private final String phoneNumber;
    private float credit;
    private OperatorPlan plan;
    private Set<PhoneCall> phoneCalls;

    public SimCard(String phoneNumber, Float credit, OperatorPlan plan) {
        this.phoneNumber = phoneNumber;
        this.credit = credit;
        Set<PhoneCall> phoneCalls = new HashSet<>();
        this.plan = plan;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit) {
        this.credit = credit;
    }

    public OperatorPlan getPlan() {
        return plan;
    }

    public void setPlan(OperatorPlan plan) {
        this.plan = plan;
    }

    public Set<PhoneCall> getPhoneCalls() {
        return phoneCalls;
    }

    public void setPhoneCalls(Set<PhoneCall> phoneCalls) {
        this.phoneCalls = phoneCalls;
    }

}
