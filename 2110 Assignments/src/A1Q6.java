/**
 * This program finds the k largest integer from the list
 * and sorts it using priority queue which is implemented using array.
 * @author Mansi Patel B00871094
 */
import java.util.*;
public class A1Q6 {
    // this class creates a heap data structure
    public static class Heap{
        int size = 0;
        int limit = 20;
        int[] items = new int[limit];

        private int getLeftNode(int parent) { return 2*parent+1; }
        private int getRightNode(int parent) { return 2*parent+2; }
        private int getSuperNode(int child) { return (child - 1)/2; }

        private boolean hasLeftNode(int index){ return getLeftNode(index) < size; }
        private boolean hasRightNode(int index){ return getRightNode(index) < size; }
        private boolean hasSuperNode(int index){ return getSuperNode(index) >= 0; }

        private int leftNode(int index){ return items[getLeftNode(index)]; }
        private int rightNode(int index){ return items[getRightNode(index)]; }
        private int parentNode(int index){ return items[getLeftNode(index)]; }

        private void swap (int index1, int index2){
            int temporary = items[index1];
            items[index1] = items[index2];
            items[index2] = temporary;
        }

        private void checkLimit(){
            if(size == limit) {
                items = Arrays.copyOf(items, limit*2);
                limit = limit*2;
            }
        }
        public int peek() {
            if(size == 0) return 0;
            return items[0];
        }
        public int poll() {
            if(size == 0) return 0;
            int item = items[0];
            items[0] = items[size - 1];
            size--;
            heapDown();
            return item;
        }
        public void insert(int value){
            checkLimit();
            items[size] = value;
            size++;
            heapUp();
        }
        public void heapUp(){
            int index = size - 1;
            while(hasSuperNode(index) && parentNode(index) < items[index]) {
                swap(getSuperNode(index), index);
                index = getSuperNode(index);
            }
        }
        public void heapDown() {
            int index = 0;
            while(hasLeftNode(index)) {
                int newNode = getLeftNode(index);
                if(hasRightNode(index) && rightNode(index) > leftNode(index)) {
                    newNode = getRightNode(index);
                }
                if (items[index] > items[newNode]) { break; }
                else { swap(index,newNode); }
                index = newNode;
            }
        }
        public String toString() { return Arrays.toString(items); }
    }
    public static class priorityQueue {
        Heap heap;
        int size;
        public priorityQueue() { this.heap = new Heap(); }

        public void add(int value) {
            heap.insert(value);
            size++;
        }
        public int remove() {
            size--;
            return heap.poll();
        }
        public int getSize() { return size; }
    }
    public static void main(String [] args){
        priorityQueue queue = new priorityQueue();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if(n>=k) {
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                queue.add(a);
            }
        }
        for(int i = 0; i<n ; i++){
            System.out.print(queue.remove() + " ");
        }
    }
}
