/*
Name: Lawond Zangana 
PID: A17708568
Email: lazangana@ucsd.edu
Class: 9:30AM
*/ 

import java.util.ArrayList;

public class MyAlgorithm {
    public static Integer lastAtom (ArrayList<Integer> atoms){

        //throw if true
        if(atoms == null){
            throw new NullPointerException();
        }
        
        MyPriorityQueue<Integer> atomList = new MyPriorityQueue<>(atoms); 
        while(atomList.getLength() > 1){
            int firstAtom = atomList.pop(); 
            int secondAtom = atomList.pop();
            if(firstAtom == secondAtom) {
                atomList.push(firstAtom + secondAtom);
            }
            else {
                atomList.push(Math.abs(firstAtom - secondAtom));
            }
        }
        return atomList.peek();
    }
}


