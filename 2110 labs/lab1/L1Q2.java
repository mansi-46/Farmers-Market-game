import java.util.LinkedList;
import java.util.Scanner;

public class L1Q2 {
  private static class Queue<T> {
      private LinkedList<T> queue; // instance variable Queue
      // constructor to initialise linkedList
      private Queue() {
          queue = new LinkedList<>();
      }
      // Inserts item at last position of queue
      private void enqueue(T item) {
          queue.addLast(item);
      }
      // Removes and returns the first item in the queue
      private T dequeue(){
          return queue.removeFirst();
      }
      // returns first item in queue without removing it
      private T peek(){
          return queue.getFirst();
      }
      // checks if stack is empty and returns true or false
      private Boolean isEmpty(){
          if(queue.isEmpty()){
              return true;
          }
          return false;
      }
  }

  /*
   * The main method will read line by line and execute commands based on input.
   * The following is the input style:
   * enqueue X (X can be any string without spaces)
   * peek
   * dequeue
   * isEmpty
   * exit (terminates input)
   */
  public static void main(String[] args) {
    /*
     * DO NOT CHANGE THIS METHOD
     */

    Scanner in = new Scanner(System.in);

    Queue<String> queue = new Queue<>();

    String currLine = in.nextLine();

    // Using starts with for ease of use for lines with additional input
    while(!currLine.equals("exit")) {
      if (currLine.startsWith("enqueue")) {
        // Scan for the int
        Scanner inputString = new Scanner(currLine);
        inputString.next(); // Throwing away first word
        queue.enqueue(inputString.next());
      } else if (currLine.startsWith("peek")) {
        System.out.println(queue.peek());
      } else if (currLine.startsWith("dequeue")) {
        System.out.println(queue.dequeue());
      } else if (currLine.startsWith("isEmpty")) {
        System.out.println(queue.isEmpty());
      } else {
        System.out.println("Invalid input");
        break;
      }

      currLine = in.nextLine();
    }
  }
}
