/**
 * this class finds the kth largest value from given list of integers
 * @author Mansi Patel
 * */
import java.util.*;
public class A3Q4 {
    public class Heap{
        ArrayList<Integer> elements;
        public Heap() { elements = new ArrayList<>(); }
    }
    /**
     * this class implements a priority using heap data structure.
     * it checks each element of the array list and sorts them in
     * decreasing order.
     */
    public static class priorityQueue {
        ArrayList<Integer> items; //list of items
        public priorityQueue(){
            items = new ArrayList<>();
        }

        /**
         * adds the integer to the list
         * @param value number to be added.
         */
        public void add(int value) {
            items.add(value);
            upHeap(items.size() - 1); //sends element to top
        }

        /**
         * this method checks if the new element add has
         * a parent whose value is lesser. If yes then new
         * element is shifted to parent position.
         * @param index
         */
        private void upHeap(int index) {
            if(index == 0) {
                return;
            }
            int parent = (index - 1)/2; //get index of parent
            if(items.get(index) > items.get(parent)){ // checks if new value larger than parent value
                swap(index,parent);
                upHeap(parent); // recalls until head is arranged in descending order
            }
        }

        /**
         * swaps the position of items in array list
         * @param index1 index of 1st item to be swapped
         * @param index2 index of 2nd item to be swapped
         */
        private void swap(int index1, int index2) {
            int value1 = items.get(index1); // value of 1st index
            int value2 = items.get(index2); // value of 2nd index
            items.set(index1,value2); //swapping the values
            items.set(index2,value1);
        }

        /**
         * this method returns and removes the largest element which
         * is on the top of the list. Then it re-arranges the heap
         * in descending order.
         * @return largest value of heap
         */
        public int remove() {
            if(this.size() == 0) { return -1; }
            swap(0,items.size() - 1); // swap first element with last element
            int value = items.remove(items.size() - 1);
            downHeap(0);
            return value;
        }

        /**
         * takes the index of parent and checks if it has child
         * whose value is greater than parent. if yes then
         * parent swap position with the child
         * @param parent
         */
        private void downHeap(int parent) {
            int max = parent; // largest number index
            int leftChild = 2*parent+1; //gets left child of parent
            // checks if child value greater
            if(leftChild < items.size() && items.get(leftChild) > items.get(max)) {
                max = leftChild;
            }
            int rightChild = 2*parent+2; //gets right child
            // checks if child value greater
            if(rightChild < items.size() && items.get(rightChild) > items.get(max)) {
             max = rightChild;
            }
            if(max != parent) {
                swap(parent, max); // swap value if any child has larger values
                downHeap(max);
            }
        }

        /**
         * calculate size of array list
         * @return returns size of array list
         */
        public int size() {
            return items.size();
        }
    }

    /**
     * main method accepts input of queue and displays
     * the sorted queue.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        priorityQueue queue = new priorityQueue();
        int n = in.nextInt();
        int k = in.nextInt();
        // if k value is less than n add items to queue
        if(k<=n && k!=0) {
            for(int i = 0; i<n ;i++) {
                queue.add(in.nextInt());
            }
        }
        else { // terminate program if no items are to be added to queue
            System.exit(0);
        }
        // loop removes the largest elements from heap and display them.
        for (int i = 0; i < k ;i++)
        System.out.print(queue.remove() + " ");
    }
}
