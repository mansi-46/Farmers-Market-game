/**
 * This programs takes the list of strings
 * and checks if it is palindrome on or not
 * with the help of stack
 * @author Mansi Patel
 */
import java.util.*;
public class A3Q1 {
    //this class implements the stack ADT using linked list
    public static class Stack<String> {
        private LinkedList<String> list; // list of stack

        // constructor to initialise list
        public Stack() {
            list = new LinkedList<String>();
        }

        // Inserts item at the top of stack
        private void push(String item) {
            list.addFirst(item);
        }

        //remove from the first element of the list
        private String pop() { return list.removeFirst(); }

        // returns item to look at but not remove from the stack
        private String peek() { return list.getFirst(); }

        // calculate the size of the stack
        private int size(){ return list.size(); }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfElements = in.nextInt(); // number of elements to be added to the stack
        boolean palindrome = true; // check if the stack is palindrome
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        int count = 0; // keep the count of input items
        while(count < numberOfElements){
            String item = in.next();
            stack1.push(item); // adds item to stack
            count++;
        }
        int halfLength = stack1.size()/2; // divide the stack in 2
        int check = stack1.size()%2; // to if length of list is odd or even
        for (int i = 0; i < halfLength; i++) {
            stack2.push(stack1.pop()); // added half of items to 2nd stack
        }
        // is length list is not even remove the middle element of the list
        if(check!=0){
            stack1.pop();
        }
        // check if 2 stacks are equal
        for(int i = 0; i<halfLength; i++) {
            if(!stack1.pop().equals(stack2.pop())){
                System.out.println("No");
                palindrome = false;
                break;
            }
        }
        if(palindrome) {
            System.out.println("Yes");
        }
    }
}


