package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        Iterator iter = framePointer.iterator();
        int c = (Integer) iter.next();
        if (iter.hasNext()) {
            c = (Integer) iter.next();
        }

        System.out.printf("[");
        if (!runTimeStack.isEmpty()) {
            System.out.print(runTimeStack.get(0));
        }

        for (int i = 1; i < runTimeStack.size(); i++) {
            if (i == c) {
                System.out.print("][" + runTimeStack.get(i));

                if (iter.hasNext()) {
                    c = (Integer) iter.next();
                }
            }

            else {
                System.out.print("," + runTimeStack.get(i));
            }
        }
        System.out.println("]");
    }

    public int peek() {
        return runTimeStack.get( runTimeStack.size() - 1);
    }

    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public int pop() {
        int value = 0;
        if (runTimeStack.size() > 0 ) {
            value = runTimeStack.get(runTimeStack.size()-1);
            runTimeStack.remove(runTimeStack.size() - 1);
        }

        return value;
    }

    /**
     * Takes a value from the run time stack that is at offset
    * from the current frame marker and pushes it onto the top of * the stack.
     * @param offset number of slots above current frame marker
    * @return item just loaded into the offset
    */
    public int load(int offset) {
        int value = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(value);
        return value;
    }

    public int store(int offset) {
        int value = runTimeStack.get(runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        runTimeStack.set(framePointer.peek() + offset, value);
        return value;
    }


    /**
     * create a new frame pointer at the index offset slots down * from the top of the runtime stack.
     * @param offset slots down from the top of the runtime stack */
    public void newFrameAt (int offset) {
        framePointer.push(runTimeStack.size() - offset);
    }

    public void popFrame() {
        int subtract;

        if (runTimeStack.size() - 1 == -1) { subtract = 0; }
        else { subtract = 1; }

        //System.out.println(runTimeStack.size());
        int value = runTimeStack.get(runTimeStack.size() - subtract);


        while(true) {
            if (runTimeStack.size() == framePointer.peek()) { break; }
            runTimeStack.remove(runTimeStack.size() - subtract);
        }

        framePointer.pop();
        runTimeStack.add(value);

    }




}
