package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode {
    String destination;
    int finalAddress;
    public void init(ArrayList<String> args) {
        destination = args.get(0);
    }

    public String getDestination() {
        return destination;
    }

    public void setFinalAddress(int n) {
        this.finalAddress = n;
    }



    public void exec(VirtualMachine virtualMachine) {
        virtualMachine.setProgramCounter(this.finalAddress);
    }

    public String toString() {
        return "GOTOCODE " +
                destination;
    }

}
