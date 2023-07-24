package it.ires.exam.Sim;

public class OperatorPlan {
    private final Plan plan;
    private int rate;
    public OperatorPlan(Plan plan) {
        this.plan = plan;
        switch (plan)
        {
            case CHEAP:
                this.rate = 1;
                break;
            case PREMIUM:
                this.rate = 3;
                break;
            case STANDARD:
                this.rate = 2;
                break;
        }
    }
}
