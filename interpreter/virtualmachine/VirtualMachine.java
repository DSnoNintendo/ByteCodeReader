package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;
import interpreter.bytecode.HaltCode;

import javax.sound.midi.Track;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning = true;
    private boolean        dump;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<>();


        while (isRunning) {
            ByteCode line = program.getCode(programCounter);
            //System.out.println("running " + line.toString());
            line.exec(this);

            //dumpCodes cant be dumped
            if (dump && !(line instanceof DumpCode)
                        && !(line instanceof HaltCode)) {
                System.out.println(line.toString());
                runTimeStack.dump();
            }
            programCounter++;

        }

        System.exit(0);
    }

    public void  setProgramCounter(int pc) { this.programCounter = pc; }

    public int getProgramCounter() { return programCounter; }

    public void setDump(boolean b) { dump = b; }

    public void halt() { isRunning = false; }

    public void push(int i) { runTimeStack.push(i); }

    public int pop() { return runTimeStack.pop(); }

    public int peek() { return runTimeStack.peek(); }

    public int load(int offset) { return runTimeStack.load(offset); }

    public int  store(int offset) { return runTimeStack.store(offset); }

    public int popReturnAddress() {
        return returnAddress.pop();
    }

    public void pushReturnAddress(int address) {
        returnAddress.push(address);
    }

    public void newFrameAt(int offset) {
        runTimeStack.newFrameAt(offset);
    }

    public void popFrame() {
        runTimeStack.popFrame();
    }


}
