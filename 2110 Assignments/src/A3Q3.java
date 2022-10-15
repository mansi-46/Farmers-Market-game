/**
 * This program takes in 2 sorted lists and merge then to create
 * another sorted list using queue ADT which implemented using
 * doubly linked list
 * @author Mansi Patel B00871094
 */
import java.util.Scanner;
import java.util.LinkedList;
public class
A3Q3 {

    // this class implements Queue ADT using the linked list
    private static class Queue<T> {
        private LinkedList<T> queue; // instance variable Queue
        // constructor to initialise linkedList
        private Queue() {
            queue = new LinkedList<>();
        }
        /**
         * adds item to the queue
         * @param item to be added
         */
        private void enqueue(T item) {
            queue.addLast(item);
        }
        /**
         * removes the items from queue
         * @return the value of item removed
         */
        private T dequeue() {
            return queue.removeFirst();
        }
        /**
         * returns first item in queue without removing it
         */
        private T peek() {
            return queue.getFirst();
        }
        /**
         * gives number of items in queue
         * @return size of queue
         */
        private int size() {
            return queue.size();
        }
        /**
         * checks if queue is empty and returns true or false
         * @return
         */
        private Boolean isEmpty() {
            if (queue.isEmpty()) {
                return true;
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> queue1 = new Queue<>();
        Queue<Integer> queue2 = new Queue<>();
        Queue<Integer> sortedQueue = new Queue<>();
        int numberOfElement1 = in.nextInt(); // number of items in queue1
        int count1 = 0; // count for number of items entered in queue1
        while(count1<numberOfElement1) {
            int item = in.nextInt();
            queue1.enqueue(item);
            count1++;
        }
        int numberOfElement2 = in.nextInt(); // number of items in queue2
        int count2 = 0; // count for number of items entered in queue2
        while(count2<numberOfElement2) {
            int item = in.nextInt();
            queue2.enqueue(item);
            count2++;
        }
        int sortedListSize = queue1.size() + queue2.size(); // size of new merged list
        for (int i = 0; i < sortedListSize; i++) {
            if(queue1.isEmpty()) {
                sortedQueue.enqueue(queue2.dequeue());// add queue2 only if queue1 is empty
                if(queue2.isEmpty()) { break; }
            }
            else if(queue2.isEmpty()) {
                sortedQueue.enqueue(queue1.dequeue());// add queue1 only if queue2 is empty
                if(queue1.isEmpty()) { break; }
            }
            else if(queue1.peek() <= queue2.peek()) { // check which element is smaller
                sortedQueue.enqueue(queue1.dequeue());
            }
            else {
                sortedQueue.enqueue(queue2.dequeue());
            }
        }
        for(int i = 0; i<sortedListSize; i++) {
            System.out.print(sortedQueue.dequeue() + " ");// display sorted list
        }
    }
}
