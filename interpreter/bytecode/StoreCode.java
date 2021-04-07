package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    int offset;
    String id = "";

    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            id = args.get(1);
        }
    }

    public void exec(VirtualMachine virtualMachine) {
        virtualMachine.store(offset);
    }

    public String toString() {
        return "Store " +
                offset +
                " " +
                id;
    }
}
