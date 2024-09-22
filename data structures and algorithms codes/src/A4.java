import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class A4 {
  private static class BST {
    Node root;

    /**
     * to insert the key value pair in the tree
     * @param key added to tree
     * @param value of the key that will be added
     * @return true if key is added successfully and false if
     */
    public boolean insert(int key, String value) {
      // if key is already there in tree return false
      if (contains(key)) { return false; }
      else {
        Node node = new Node(key, value); // create node with key-value pair
        if (root == null) {
          root = node;
          return true;
        }
        Node previous = null;
        Node temporary = root;
        //loop through tree to enter new node at right position
        while (temporary != null) {
          if (temporary.key > key) {
            previous = temporary;
            temporary = temporary.left;
          } else if (temporary.key < key) {
            previous = temporary;
            temporary = temporary.right;
          }
        }
        if (previous.key > key) { previous.left = node; }
        else { previous.right = node; }
        return true;
      }
    }

    /**
     * to search through the tree to find key
     * @param key that is to be found
     * @return true if key is present iin tree otherwise false
     */
    public boolean contains(int key) {
      //when root not equals null, call getKey
      if (root != null) {
        String found = root.getKey(key);
        if (found != null) {
          return true;
        }
      }
      return false;
    }

    /**
     * get the data present at particular key in tree
     * @param key for which you have to find value
     * @return the data at the key
     */
    public String get(int key) {
      if(root != null){
        return root.getKey(key);
      }
      return null;
    }

    /**
     * delete the key given in parameter and return string at that key
     * @param key to be deleted
     * @return data value of that string
     */
    private String delete(int key) {
      Node current = root;
      Node parent = root;
      boolean decider = false; // variable to decided if node has child
      // if tree doesn't exist
      if (root == null) {
        return null;
      }
      // loop to search for the key to be deleted in the tree
      while (true) {
        if (key < current.key) {
          parent = current;
          current = current.left;
          decider = true;
        } else if (key > current.key) {
          parent = current;
          current = current.right;
          decider = false;
        } else {
          break;
        }
      }
      String value = current.data;
      //leaf node (No child)
      if (current.left == null && current.right == null) {
        if (current.key == root.key) { // if current key is equal to root
          root = null;
          return value; // return value from root.
        }
        if (decider) { // if current key has child
          parent.left = null; // set left of parent node to null
        } else {
          parent.right = null; // set right of parent node to null
        }
        return value;
      }
      // node with only one child or no child
      else if (current.right == null) { // if node has only left child
        if (current.key == root.key) { // keys are equal
          String result = current.data; // data value of the key deleted
          root = current.left;
          return result;
        } else if(decider) { // if node has child
          Node result = current;
          parent.left = current.left;
          return  result.data;
        } else {
          Node result = current;
          parent.right = current.left;
          return result.data;
        }
      } else if(current.left == null) { // if node has only right child
        if(current.key == root.key){
          String result = current.data;
          root = current.right;
          return result;
        }else if(decider){
          Node result = current;
          parent.left = current.right;
          return result.data;

        }else{
          Node result = current;
          parent.right = current.right;
          return result.data;
        }
      }
      // when 2 or more child
      else {
        Node child = getChild(current); // get child of node to be deleted
        if(current == root) {
          value = current.data;
          root = child;
          child.left = current.left;
          return value;
        } else if(decider) {
          Node result = current;
          parent.left = child;
          child.left = current.left;
          return result.data;
        } else {
          Node result = current;
          parent.right = child;
          child.left = current.left;
          return result.data;
        }
      }
    }

    /**
     * Get successor of the root that needs to be deleted
     * @param root that has to be deleted
     * @return right most child
     */
     private static Node getChild(Node root) {
      Node parent = root;
      Node successor = root;
      Node current = root.right;
      while(current != null) {
        parent = successor;
        successor = current;
        current = current.left;
      }
      if(successor != root.right) {
        parent.left = successor.right;
        successor.right = root.right;
      }
      return successor;
    }

    /**
     * prints the tree in preorder
     * @param node
     */
    private void preorder(Node node) {
      if (node != null) {
        System.out.print(node.data + "\t");
        preorder(node.left);
        preorder(node.right);
      }
    }

    /**
     * prints the tree in levelorder
     * @param root
     */
    private void levelOrder(Node root) {
      if (root == null) {
        return;
      } // if the tree doesn't exist
      Queue<Node> q = new LinkedList<Node>(); // queue contains tree nodes
      q.add(root); // add to queue
      while (!q.isEmpty()) { // check is queue is not empty
        Node current = q.peek(); // value at front in queue
        System.out.print(current.data + "\t"); // print the data
        q.poll(); // remove the node from queue
        if (current.left != null) {
          q.add(current.left);
        } // if the current node has left child
        if (current.right != null) {
          q.add(current.right);
        } // if the current node has right child
      }
    }

    /**
     * prints in inorder
     * @param node
     */
    public static void inorder(Node node) {
      if (node != null) {
        inorder(node.left); // gets node from left
        System.out.print(node.data + "\t"); // print the data at node
        inorder(node.right); //get node from right
      }
    }

    /**
     * prints tree values in postorder
     * @param node
     */
    public static void postorder(Node node) {
      if (node != null) {
        postorder(node.left); // get nodes from left
        postorder(node.right); // get nodes from right
        System.out.print(node.data + "\t");
      }
    }

    /**
     * search through tree using DFS to find the
     * value of the key
     * @param key
     * @return value of key if it found else return null
     */
    private String getDFS(int key) {
      if (root == null) {
        return null;
      } // if tree doesn't exist
      Stack<Node> s = new Stack<>();
      s.push(root); // push root to stack
      while (!s.isEmpty()) { // loop until stack is empty
        Node current = s.pop(); // pop node which is at the top of stack
        if (current.key == key) {
          return current.data;
        } // check if the value is found
        if (current.right != null) {
          s.push(current.right);
        } // if current node has right child
        if (current.left != null) {
          s.push(current.left);
        } // if current node has left child
      }
      return null;
    }

    /**
     * Node class that create node object and
     * has reference to right and left child nodes
     * and key value pairs
     */
    public class Node {
      Node left, right;
      int key;
      String data;

      // constructor creating object of key and value pair
      public Node(int key, String data) {
        this.data = data;
        this.key = key;
      }

      /**
       * get value of the key that is entered in parameter
       * @param key
       * @return value of the key that is found
       */
      public String getKey(int key) {
        if (root != null) {
          if (key == this.key) {
            return this.data;
          } else if (key < this.key && this.left != null) {
            return left.getKey(key);
          } else if (this.right != null) {
            return right.getKey(key);
          }
        }
        return null;
      }
    }
  }

  /*
   * The main method will read line by line and execute commands based on input.
   * The following is the input style: (key as an integer and value as a string)
   * insert key value
   * contains key
   * get key
   * delete key
   * dfs key
   * pre
   * post
   * in
   * level
   * exit (terminates input)
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    BST tree = new BST();

    String currLine = in.nextLine();

    // Using starts with for ease of use for lines with additional input
    while (!currLine.equals("exit")) {
      if (currLine.startsWith("insert")) {
        Scanner inputLine = new Scanner(currLine);
        inputLine.next(); // throw away function name
        System.out.println(tree.insert(inputLine.nextInt(), inputLine.next()));
      } else if (currLine.startsWith("contains")) {
        Scanner inputLine = new Scanner(currLine);
        inputLine.next(); // throw away function name
        System.out.println(tree.contains(inputLine.nextInt()));
      } else if (currLine.startsWith("get")) {
        Scanner inputLine = new Scanner(currLine);
        inputLine.next(); // throw away function name
        System.out.println(tree.get(inputLine.nextInt()));
      } else if (currLine.startsWith("delete")) {
        Scanner inputLine = new Scanner(currLine);
        inputLine.next(); // throw away function name
        System.out.println(tree.delete(inputLine.nextInt()));
      } else if (currLine.startsWith("dfs")) {
        Scanner inputLine = new Scanner(currLine);
        inputLine.next(); // throw away function name
        System.out.println(tree.getDFS(inputLine.nextInt()));
      } else if (currLine.startsWith("pre")) {
        System.out.print("pre: ");
        tree.preorder(tree.root);
        System.out.println();
      } else if (currLine.startsWith("in")) {
        System.out.print("in: ");
        tree.inorder(tree.root);
        System.out.println();
      } else if (currLine.startsWith("post")) {
        System.out.print("post: ");
        tree.postorder(tree.root);
        System.out.println();
      } else if (currLine.startsWith("level")) {
        System.out.print("level: ");
        tree.levelOrder(tree.root);
        System.out.println();
      } else {
        System.out.println("Invalid input");
        break;
      }

      currLine = in.nextLine();
    }
  }
}

