package it.ires.exam.Sim;

public class PhoneCall {
    private final String toWhom;
    private int callLenght;
    private final TypeCall typeCall;

    public PhoneCall(String toWhom, TypeCall typeCall) {
        this.typeCall = typeCall;
        this.callLenght = 0;
        this.toWhom = toWhom;
    }

    public String getToWhom() {
        return toWhom;
    }

    public void setCallLenght(int callLenght) {
        this.callLenght = callLenght;
    }

    @Override
    public String toString() {
        if (typeCall.equals(TypeCall.Calling)) {
            return "PhoneCall to " + toWhom + " which lasted " + callLenght + "minutes" + '\n';
        } else {
            return "PhoneCall from " + toWhom + " which lasted " + callLenght + "minutes" + '\n';
        }
    }

}
