/*
Name: Lawond Zangana 
PID: A17708568
Email: lazangana@ucsd.edu
Class: 9:30AM
 */ 

import java.util.Collection;

public class MyPriorityQueue<E extends Comparable<E>> {
    
    //create instance variables
    protected MyMinHeap<E> heap; 


    //Constructors
    public MyPriorityQueue(){
        heap = new MyMinHeap<>(); 
    }
    public MyPriorityQueue(Collection<? extends E> collection){
       //Throw if true;
        if(collection == null || collection.contains(null)){
            throw new NullPointerException();
        }
        

         //Initialze data
         heap = new MyMinHeap<>(collection);

         }

    //Methods

         //push method
         public void push(E element){
            //throw if true
            if(element == null){
                throw new NullPointerException();
            }
            //add element to priority queue
            heap.insert(element);
         }

         //peek method
         public E peek(){
            //if empty return null
            if(heap.size() <= 0){
                return null;
            }
            //return the root, or the smallest value
            return heap.getMin();
         }

         //pop method
         public E pop(){
             //if empty return null
             if(heap.size() <= 0){
                return null;
            }
            return heap.remove();
         }

         //getLength method 
         public int getLength(){
            return heap.size(); 
         }

         //clear method
         public void clear(){
            heap.clear();
         }


}
