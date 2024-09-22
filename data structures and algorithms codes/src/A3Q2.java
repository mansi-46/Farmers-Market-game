/**
 * this programs takes input as single characters store it in
 * a queue and then checks if the queue is palindrome or not
 * @author Mansi Patel
 */
import java.util.Scanner;
public class A3Q2 {
    // this class implement Queue ADT using linked list
    private static class Queue<String> {
        private DoublyLinkedList<String> queue; // instance variable Queue

        // constructor to initialise linkedList
        private Queue() {
            queue = new DoublyLinkedList<>();
        }

        /**
         * insert item to first position in list.
         * @param item to be added
         */
        private void addFirst(String item) {
            queue.addFirst(item);
        }

        /**
         * insert item to last position in list.
         * @param item to be added
         */
        private void addLast(String item) {
            queue.addLast(item);
        }

        /**
         * removes item from first position in list
         * @return the value of item remove
         */
        private String removeFirst() {
            return queue.removeFirst();
        }

        /**
         * removes item from last of the queue
         * @return value to item removed
         */
        private String removeLast() {
            return queue.removeLast();
        }

        /**
         * get item on first position in list.
         * @return value of first item of list
         */
        private String getFirst() {
            return queue.getFirst();
        }

        /**
         * get item on last position in list.
         * @return value of last item of list
         */
        private String getLast() {
            return queue.getLast();
        }

        /**
         * gets the size of the list
         * @return the size of list
         */
        private int size() {
            return queue.count();
        }
    }
    private static class DoublyLinkedList<T> {
        private int count; // count items of list
        private Node<T> head; // head of the list
        private Node<T> tail; // tail of the list
        // node class shows the connection between items in list
        private static class Node<T> {
            private T item; // item to be inserted
            Node<T> prev; // denotes link to previous node
            Node<T> next; // denotes link to next node
            private Node(T item, Node<T> prev, Node<T> next) {
                this.item = item;
                this.prev = prev;
                this.next = next;
            }
            public void setPrev(Node<T> prev) { this.prev = prev; }
            public void setNext(Node<T> next) { this.next = next; }
            public Node<T> getPrev() { return prev; }
            public Node<T> getNext() { return next; }
            public T getItem() { return item; }
        }
        // constructor initialising instance variables
        private DoublyLinkedList() {
            this.head = null;
            this.tail = null;
            this.count = 0;
        }
        // gets the First element in the list
        private T getFirst() {
            if(isEmpty()) { // if the list is empty
                return null;
            }
            return head.getItem();  // when list is not empty
        }
        // gets the Last item in the list
        private T getLast() {
            if (isEmpty()) { // when list is empty
                return null;
            }
            return tail.getItem(); // when list is not empty
        }
        // add the item to the beginning of the list
        private void addFirst(T item) {
            Node<T> newNode = new Node<>(item, null, head);
            if(!isEmpty()) {  // when the list is not empty
                head.setPrev(newNode);
                newNode.setNext(head);
                head = newNode;
            }
            else { //when list is empty
                head = newNode;
                tail = newNode;
            }
            count++;// increasing list item count
        }
        // add the item to the end of the list
        private void addLast(T item) {
            Node<T> node = new Node<>(item,tail,null);
            if(!isEmpty()){ //when list is not empty
                tail.setNext(node);
                node.setPrev(tail);
                tail = node;
            }
            else{ // when list is empty
                head = node;
                tail = node;
            }
            count++; // increasing list item count
        }
        // remove first element from list
        private T removeFirst() {
            if (isEmpty()) {  // if list empty
                return null;
            }
            else if(head.getNext() == null){ // when only 1 element in the list
                T item = head.getItem();
                tail = null;
                head = null;
                count--;
                return item;
            }
            else{ // when more than 2 items in list
                T item = head.getItem();
                head = head.getNext();
                head.setPrev(null);
                count--;
                return item;
            }
        }
        // removes last item from the list
        private T removeLast() {
            //if list is empty
            if (isEmpty()) {
                return null;
            } else if (head.getNext() == null) { // when only 1 element in the list
                T item = tail.getItem();
                head = null;
                tail = null;
                count--;
                return item;
            } else { // when more than 2 element in the list
                T item = tail.getItem();
                tail = tail.getPrev();
                tail.setNext(null);
                count--;
                return item;
            }
        }
        // to check if list is empty
        private Boolean isEmpty() {
            if (count()==0) { return true; }
            return false;
        }
        // to count the items in the list
        private int count() {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Character> queue= new Queue<>();
        String item = in.nextLine(); // item to be added
        Boolean palindrome = true;
        // runs until a string with more than 1 element is entered
        while(item.length()==1) {
            queue.addFirst(item.charAt(0));
            item = in.nextLine();
        }
        int halfLength = queue.size()/2; // gets half-length of queue
        for(int i = 0; i < halfLength; i++) {
            Character first = queue.removeFirst(); // gets element from front of list
            Character last = queue.removeLast(); // gets element from end of list
            // if first and last element not equal it's not palindrome
            if(!first.equals(last)) {
                System.out.println("No");
                palindrome = false;
                break;
            }
        }
        if(palindrome)
        System.out.println("Yes");
    }
}
