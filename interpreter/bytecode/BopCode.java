package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    String operator;
    int v1;
    int v2;
    int result;

    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }

    public void exec(VirtualMachine virtualMachine) {

        v2 = virtualMachine.pop();
        v1 = virtualMachine.pop();

        if (operator.equals("+")) {result = v1 + v2;}

        else if (operator.equals("-")) {result = v1 - v2;}

        else if (operator.equals("/")) {result = v1 / v2;}

        else if (operator.equals("*")) {result = v1 * v2;}

        //return 0 = false return 1 = true
        else if (operator.equals("==")) {
            if (v1 == v2) { result = 1; }

            else { result = 0; }
        }

        else if (operator.equals("!=")) {
            if (v1 != v2) { result = 1; }

            else { result = 0; }
        }

        else if (operator.equals("<=")) {
            if (v1 <= v2) { result = 1; }

            else { result = 0; }
        }

        else if (operator.equals(">")) {
            if (v1 > v2) { result = 1; }

            else {result = 0; }
        }

        else if (operator.equals(">=")) {
            if (v1 >= v2) { result = 1; }

            else { result = 0; }
        }

        else if (operator.equals("<")) {
            if (v1 < v2) { result = 1; }

            else { result = 0; }
        }

        virtualMachine.push(result);
    }



    public String toString() {
        return "BOP " +
                String.valueOf(v1) +
                operator + " " +
                String.valueOf(v2) + " = " +
                String.valueOf(result);
    }

}
