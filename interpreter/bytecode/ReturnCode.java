package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturnCode extends ByteCode{
    String method;

    public void init(ArrayList<String> args) {
        if (!args.isEmpty()) {
            method = args.get(0);
        }

    }

    public void exec(VirtualMachine virtualMachine) {
        virtualMachine.popFrame();
        virtualMachine.setProgramCounter(virtualMachine.popReturnAddress());
    }

    public String toString() {
        return "RETURN " + method;
    }
}
