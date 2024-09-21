/*
Name: Lawond Zangana 
PID: A17708568
Email: lazangana@ucsd.edu
Class: 9:30AM
 */ 

import java.util.ArrayList;
import java.util.Collection;


public class MyMinHeap<E extends Comparable<E>> implements
MinHeapInterface<E>{

    //Create instance variable for data
    protected ArrayList<E> data; 


    //Constructor 
    public MyMinHeap(){

        //Initialize data to an empty ArrayList
        data = new ArrayList<>(); 

        }  

    //Constructor
    public MyMinHeap(Collection<? extends E> collection){

        //Throw if true;
        if(collection == null || collection.contains(null)){
          throw new NullPointerException();
        }

        //Initialze data
        data = new ArrayList<>(collection);

        for (int i=data.size()-1; i>=0; i--) {
            percolateDown(i);
        }

    }

    //Helper Methods

        //swap method
        protected void swap(int from, int to){
            E fromElement = data.get(from); 
            E toElement = data.get(to);
            data.remove(from);
            data.add(from, toElement);
            data.remove(to);
            data.add(to, fromElement); 
        }

        //getParentIdx method 
        protected static int getParentIdx(int index){
            return (index-1)/2; 
        }

        //getLeftChildIdx method
        protected static int getLeftChildIdx(int index){
            return 2 * index + 1;
        }

        //getRightChildIdx method
        protected static int getRightChildIdx(int index){
            return 2 * index + 2;
        }

        //getMinChildIdx method
        protected int getMinChildIdx(int index){
            //Create values for left and right children
            int leftChild =  2 * index + 1;
            int rightChild = 2 * index + 2;

            //first check if children are within bounds
            if (leftChild >= data.size()){
                return -1;
            } else {
                if(rightChild >= data.size()){
                    return leftChild;
                }
            }

            //Check if they are the same, if left is greater, and finally if left is less
            if(data.get(leftChild).compareTo(data.get(rightChild)) == 0){
                return leftChild;
            } else {
                if(data.get(leftChild).compareTo(data.get(rightChild)) > 0){
                    return rightChild; 
                }
            }
            return leftChild; 
            

        }

        //percolateUp method 
        protected void percolateUp(int index){
            //Create for parent/current Node
            int curr = getParentIdx(index);

            if(data.get(getParentIdx(index)).compareTo(data.get(index)) < 0){
                return;
            }
            swap(index, getParentIdx(index));
            percolateDown(curr);
        }

        //percolateDown method
        protected void percolateDown(int index){
            //Create for current Node
            int curr = getMinChildIdx(index); 
            
            //If node is a leaf (has no children), return
            if(getMinChildIdx(index) == -1){
                return;
            }
            //if node is greater than smallest child node, swap places 
            if(data.get(index).compareTo(data.get(getMinChildIdx(index))) > 0){
                swap(index, getMinChildIdx(index));
                percolateDown(curr);
            }
           
        }

        //deleteIndex method 
        protected E deleteIndex(int index){

            E curr = data.get(index); 
            swap(index, data.size()-1);
            if(curr.compareTo(data.get(index)) == 0){
                data.remove(curr);
                return curr;
            } else {
                if(curr.compareTo(data.get(index)) > 0){
                    data.remove(curr);
                    percolateDown(index);
                    return curr; 
                }
            } 
            data.remove(curr);
            percolateUp(index);
            return curr; 
        
        }

    //Core Methods
        
        //insert Method 
        public void insert(E element){
            //Throw if true 
            if(element == null){
                throw new NullPointerException();
            }

            //vairable for end of the heap
            int lastElement = data.size();
            //add element and percolate up
            data.add(lastElement, element);
            percolateUp(lastElement);
        }

        //getMin Method 
        public E getMin(){
            //return if heap is empty
            if (data.isEmpty() == true){
                return null;
            } 
            //return the root
            return data.get(0);
        }

        //remove Method
        public E remove(){
          //return if heap is empty
          if (data.isEmpty() == true){
            return null;
          } 
          E root = data.get(0);
          //remove and return the root
          deleteIndex(0);
          return root;
        }

        //size Method
        public int size(){
            return data.size(); 
        }

        //clear Method 
        public void clear(){
            data.clear();
        }

}
