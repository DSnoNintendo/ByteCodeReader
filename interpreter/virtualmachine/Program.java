package interpreter.virtualmachine;

import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    static HashMap<String,Integer> labelMap = new HashMap<>();
    private ArrayList<ByteCode> program;


    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    public void add(ByteCode bc) {
        program.add(bc);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */

    public void resolveAddress() {
        //1 pass through arraylist to keep track of label codes and their labels
        for (int i=0;i<this.program.size();i++) {

            //
            if (program.get(i) instanceof LabelCode) {
                LabelCode line = (LabelCode) program.get(i);
                labelMap.put( line.getLabel(),i);
                //System.out.println(line.getLabel() + " " + (i));
            }
        }


        for (int i=0;i<this.program.size();i++) {

            if (program.get(i) instanceof FalseBranchCode) {
                FalseBranchCode line = (FalseBranchCode) program.get(i);
                //change final address to address where label being branched to is present
                line.setFinalAddress(labelMap.get(line.getDestinationLabel()));
            }

            else if (program.get(i) instanceof GotoCode) {
                GotoCode line = (GotoCode) program.get(i);
                //System.out.println("Getting line for " + line.getDestination());
                line.setFinalAddress(labelMap.get(line.getDestination()));
                //System.out.println("GOTO address set to " +
                     //   labelMap.get(line.getDestination()) );
            }

            else if (program.get(i) instanceof CallCode) {
                CallCode line = (CallCode) program.get(i);
                //System.out.println("Getting line for " + line.getDestination());
                line.setFinalAddress(labelMap.get(line.getDestination()));
                //System.out.println("CALL address set to " +
                   //     labelMap.get(line.getDestination()) );
            }



        }

        //2nd pass through the arraylist to look for call, goto and falsebranch codes
        //and look at sored label codes and find the 1 that has matching label

    }




}
