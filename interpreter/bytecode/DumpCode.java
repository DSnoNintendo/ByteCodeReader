package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    boolean dump;
    public void init(ArrayList<String> args) {
        if (args.get(0).equals("ON")) {
            dump = true;
        }
        else if (args.get(0).equals("OFF")) {
            dump = false;
        }
    }

    public void exec(VirtualMachine virtualMachine) { virtualMachine.setDump(dump);}

    public String toString() {
        return "DUMP " +
                dump;
    }
}
