package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode{
    int pops = 0;

    public void init(ArrayList<String> args) {
        pops = Integer.parseInt(args.get(0));
    }

    public void exec(VirtualMachine virtualMachine) {
        for (int i = 0; i < pops; i++) { virtualMachine.pop(); }
    }

    public String toString() {
        return "POP " +
                pops;
    }

}
