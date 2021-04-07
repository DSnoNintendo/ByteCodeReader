package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {

    int value;
    String id = "";
    public void init(ArrayList<String> args) {
        value = Integer.parseInt( args.get(0).replaceAll("[^0-9]", "") );
        if (args.size() > 1) {
            id = args.get(1);
        }
    }

    public void exec(VirtualMachine virtualMachine) {
        virtualMachine.push(value);
    }

    public String toString() {
        if (id.length() == 0) {
            return "LIT " +
                    value;
        }
        return "LIT " +
                value +
                "  " +
                id +
                " int " +
                id;
    }
}
