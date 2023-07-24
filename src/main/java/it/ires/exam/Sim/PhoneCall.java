package it.ires.exam.Sim;

public class PhoneCall {
    private final String toWhom;
    private int callLenght;
    public PhoneCall(String toWhom) {
        int callLenght;
        this.toWhom = toWhom;
    }

    public String getToWhom() {
        return toWhom;
    }

    public int getCallLenght() {
        return callLenght;
    }

    public void setCallLenght(int callLenght) {
        this.callLenght = callLenght;
    }

    @Override
    public String toString() {
        return "PhoneCall to " + toWhom + " which lasted " + + callLenght + '\n';
    }

}
