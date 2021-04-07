package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    String label = "";

    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    public void exec(VirtualMachine virtualMachine) { }


    public String getLabel() {
        return label;
    }

    public String toString() {
        return "Label " +
                label;
    }
}
