import java.util.Scanner;

public class L1Q3 {

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

  /*
   * The main method will read line by line and execute commands based on input.
   * The following is the input style:
   * getFirst
   * getLast
   * addFirst X (X can be any string without spaces)
   * addLast X (X can be any string without spaces)
   * removeFirst
   * removeLast
   * isEmpty
   * count
   * exit (terminates input)
   */
  public static void main(String[] args) {
    /*
     * DO NOT CHANGE THIS METHOD
     */

    Scanner in = new Scanner(System.in);

    DoublyLinkedList<String> list = new DoublyLinkedList<>();

    String currLine = in.nextLine();

    // Using starts with for ease of use for lines with additional input
    while(!currLine.equals("exit")) {
      if (currLine.startsWith("getFirst")) {
        System.out.println(list.getFirst());
      } else if (currLine.startsWith("getLast")) {
        System.out.println(list.getLast());
      } else if (currLine.startsWith("addFirst")) {
        // Scan for the int
        Scanner inputString = new Scanner(currLine);
        inputString.next(); // Throwing away first word
        list.addFirst(inputString.next());
      } else if (currLine.startsWith("addLast")) {
        // Scan for the int
        Scanner inputString = new Scanner(currLine);
        inputString.next(); // Throwing away first word
        list.addLast(inputString.next());
      } else if (currLine.startsWith("removeFirst")) {
        System.out.println(list.removeFirst());
      } else if (currLine.startsWith("removeLast")) {
        System.out.println(list.removeLast());
      } else if (currLine.startsWith("isEmpty")) {
        System.out.println(list.isEmpty());
      } else if (currLine.startsWith("count")) {
        System.out.println(list.count());
      } else {
        System.out.println("Invalid input");
        break;
      }

      currLine = in.nextLine();
    }
  }
}
