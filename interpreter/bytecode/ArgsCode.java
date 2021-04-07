package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode{
    int numArgs;

    public void init(ArrayList<String> args) { numArgs = Integer.parseInt(args.get(0)); }

    public void exec(VirtualMachine vm) { vm.newFrameAt(numArgs); }

    public String toString() {
        return "ARGS " +
                numArgs;
    }
}
