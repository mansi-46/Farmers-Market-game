import java.util.*;

public class L7 {
  private static class GeneralTree {
    private class Node {
      Integer key;
      String value;
      ArrayList<Node> children;

      private Node(Integer key, String value) {
        this.key = key;
        this.value = value;
        children = new ArrayList<>();
      }
    }

    private Node root;

    private GeneralTree() {
      root = null;
    }

    /*
     * I have created this method to insert the pairs into specific locations
     * in a tree. If you use a general tree in a solution eventually you will
     * have to decide how to insert yourself. I am also just going to use
     * non-duplicate keys
     */
    private void insert(Integer key, String value, ArrayList<Integer> directions) {
      Node insertionNode = new Node(key, value);

      if (root == null) {
        root = insertionNode;
        return;
      }

      Node posn = root;

      // Navigate tree to insert (root is the base level assumed)
      for (Integer direction : directions) {
        if (direction.equals(-1)) {
          posn.children.add(insertionNode);
          break; // This is to handle accidentally having extra input
        }

        posn = posn.children.get(direction);
      }
    }

    // get the value of the node containing the key and search using DFS (with a stack)
    private String getDFS(Integer key) {
      // TODO
     Stack<Node> s = new Stack<Node>();
     s.add(root);
     while(!s.isEmpty()) {
       Node temp = s.pop();
       if(temp.right)
     }
    }

    // Using a queue (using a LinkedList) we will count the nodes using modified BFS
    private Integer countBFS() {
      // TODO
    }

    // Simple wrapper to call method with root node
    private Integer height() {
      // TODO
    }

    /*
     * Prints tree values in preorder (use tab characters \t instead of space
     * characters for separation)
     */
    private void preorder(){
      // TODO 
    }

    /*
     * Prints tree in postorder (use tab characters \t instead of space
     * characters for separation)
     */
    private void postorder() {
      // TODO
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    GeneralTree tree = new GeneralTree();

    String currLine = in.nextLine();

    // Using starts with for ease of use for lines with additional input
    while (!currLine.equals("exit")) {
      if (currLine.startsWith("insert")) {
        Scanner inputLine = new Scanner(currLine);
        inputLine.next(); // throw away function name

        // Pull pair info
        Integer key = inputLine.nextInt();
        String value = inputLine.next();

        // Pull directions
        ArrayList<Integer> directions = new ArrayList<>();
        while (inputLine.hasNextInt()) {
          directions.add(inputLine.nextInt());
        }

        // Insert into tree at specified location
        tree.insert(key, value, directions);
      } else if (currLine.startsWith("get")) {
        Scanner inputLine = new Scanner(currLine);
        inputLine.next(); // throw away function name
        System.out.println(tree.getDFS(inputLine.nextInt()));
      } else if (currLine.startsWith("count")) {
        Scanner inputLine = new Scanner(currLine);
        inputLine.next(); // throw away function name
        System.out.println("Count: " + tree.countBFS());
      } else if (currLine.startsWith("height")) {
        Scanner inputLine = new Scanner(currLine);
        inputLine.next(); // throw away function name
        System.out.println("Height: " + tree.height());
      } else if (currLine.startsWith("pre")) {
        System.out.print("pre: ");
        tree.preorder();
        System.out.println();
      } else if (currLine.startsWith("post")) {
        System.out.print("post: ");
        tree.postorder();
        System.out.println();
      } else {
        System.out.println("Invalid input");
        break;
      }

      currLine = in.nextLine();
    }
  }
}

