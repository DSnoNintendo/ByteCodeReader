package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode{

    public void init(ArrayList<String> args) { }

    public void exec(VirtualMachine virtualMachine) {
        Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Enter a number: ");

            try {
                input = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Input must be a number");
            }
        }

        virtualMachine.push(input);



    }

    public String toString() {
        return "READ ";
    }

}
