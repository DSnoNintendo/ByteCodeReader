package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode{
    int offset;
    String id = "";

    public void init(ArrayList<String> args) {
        System.out.println("offset " + args.get(0));
        offset = Integer.parseInt( args.get(0).replaceAll("[^0-9]", "") );
        if (args.size() > 1) { id = args.get(1); }
    }

    public void exec(VirtualMachine virtualMachine) {
        virtualMachine.load(offset);
    }

    public String toString() {
        return "LOAD " +
                offset +
                " " +
                id;
    }
}
