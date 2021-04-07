package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode{
    String destinationLabel;
    int finalAddress;
    public void init(ArrayList<String> args) {
        destinationLabel = args.get(0);
    }

    public String getDestinationLabel() {
        return destinationLabel;
    }

    public void setFinalAddress(int n) {
        this.finalAddress = n;
    }


    public void exec(VirtualMachine virtualMachine) {
        int bool = virtualMachine.pop();
        if (bool == 0) {
            virtualMachine.setProgramCounter(finalAddress);
        }
    }

    public String toString() {
        return "FALSEBRANCH " +
                destinationLabel;
    }
}
