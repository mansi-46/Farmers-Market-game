import java.util.LinkedList;
import java.util.Scanner;

public class L1Q1 {
  public static class Stack<T> {
    private LinkedList<T> list; // list of stacks
    // constructor to initialise list
    private Stack(){
        list = new LinkedList<T>();
    }
    // Inserts item at the top of stack
    private void push(T item){ list.addFirst(item); }
    // returns item to look at but not remove from the stack
    private T peek(){
         return list.getFirst();
    }
    // Removes the first item on the top of stack
    private T pop(){
     return list.removeFirst();
    }
    // check if a stack is empty and returns true or false
    private Boolean isEmpty(){
        if(list.isEmpty()){
            return true;
        }
        return false;
    }
    }


  /*
   * The main method will read line by line and execute commands based on input.
   * The following is the input style:
   * push X (X can be any string without spaces)
   * peek
   * pop
   * isEmpty
   * exit (terminates input)
   */
  public static void main(String[] args) {
    /*
     * DO NOT CHANGE THIS METHOD
     */

    Scanner in = new Scanner(System.in);

    Stack<String> stack = new Stack<>();

    String currLine = in.nextLine();

    // Using starts with for ease of use for lines with additional input
    while(!currLine.equals("exit")) {
      if (currLine.startsWith("push")) {
        // Scan for the int
        Scanner inputString = new Scanner(currLine);
        inputString.next(); // Throwing away first word
        stack.push(inputString.next());
      } else if (currLine.startsWith("peek")) {
        System.out.println(stack.peek());
      } else if (currLine.startsWith("pop")) {
        System.out.println(stack.pop());
      } else if (currLine.startsWith("isEmpty")) {
        System.out.println(stack.isEmpty());
      } else {
        System.out.println("Invalid input");
        break;
      }

      currLine = in.nextLine();
    }
  }
}
