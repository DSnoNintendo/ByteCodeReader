package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode {

    public void init(ArrayList<String> args) {
    }

    public void exec(VirtualMachine virtualMachine) { virtualMachine.halt();}

    public String toString() {
        return "HALT";
    }
}
