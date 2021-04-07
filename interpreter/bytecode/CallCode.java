package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode{
    String destinationLabel;
    int finalAddress;
    public void init(ArrayList<String> args) {
        destinationLabel = args.get(0);
    }

    public String getDestination() {
        return destinationLabel;
    }

    public void setFinalAddress(int n) {
        this.finalAddress = n;
    }

    public void exec(VirtualMachine virtualMachine) {
        virtualMachine.pushReturnAddress(virtualMachine.getProgramCounter());
        virtualMachine.setProgramCounter(finalAddress);
    }

    public String toString() {
        return "CALL " +
                destinationLabel;
    }
}
