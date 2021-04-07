package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode {
    public void init(ArrayList<String> args) {

    }

    public void exec(VirtualMachine virtualMachine) {
        System.out.println(virtualMachine.peek());;
    }

    public String toString() {
        return "WRITE ";

    }
}
