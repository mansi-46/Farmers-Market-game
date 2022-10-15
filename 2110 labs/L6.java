import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class L6 {
  public static class BinaryTree<T> {
    private T data;
    private BinaryTree<T> parent;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree() {
      parent = left = right = null;
      data = null;
    }

    public void makeRoot(T data) {
      if (!isEmpty()) {
        System.out.println("Can't make root. Already exists");
      } else
        this.data = data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public void setLeft(BinaryTree<T> tree) {
      left = tree;
    }

    public void setRight(BinaryTree<T> tree) {
      right = tree;
    }

    public void setParent(BinaryTree<T> tree) {
      parent = tree;
    }

    public T getData() {
      return data;
    }

    public BinaryTree<T> getParent() {
      return parent;
    }

    public BinaryTree<T> getLeft() {
      return left;
    }

    public BinaryTree<T> getRight() {
      return right;
    }

    public void attachLeft(BinaryTree<T> tree) {
      if (tree == null)
        return;
      else if (left != null || tree.getParent() != null) {
        System.out.println("Can't attach");
        return;
      } else {
        tree.setParent(this);
        this.setLeft(tree);
      }
    }

    public void attachRight(BinaryTree<T> tree) {
      if (tree == null)
        return;
      else if (right != null || tree.getParent() != null) {
        System.out.println("Can't attach");
        return;
      } else {
        tree.setParent(this);
        this.setRight(tree);
      }
    }

    public BinaryTree<T> detachLeft() {
      if (this.isEmpty())
        return null;
      BinaryTree<T> retLeft = left;
      left = null;
      if (retLeft != null)
        retLeft.setParent(null);
      return retLeft;
    }

    public BinaryTree<T> detachRight() {
      if (this.isEmpty())
        return null;
      BinaryTree<T> retRight = right;
      right = null;
      if (retRight != null)
        retRight.setParent(null);
      return retRight;
    }

    public boolean isEmpty() {
      if (data == null)
        return true;
      else
        return false;
    }

    public void clear() {
      left = right = parent = null;
      data = null;
    }

    public BinaryTree<T> root() {
      if (parent == null)
        return this;
      else {
        BinaryTree<T> next = parent;
        while (next.getParent() != null)
          next = next.getParent();
        return next;
      }
    }


    // Prints tree in preorder (use tab characters \t instead of space characters for separation)
    private static <T> void preorder(BinaryTree<T> t) {
      if (t != null) {
        System.out.print(t.getData() + "\t");
        preorder(t.getLeft());
        preorder(t.getRight());
      }
    }

    // this method uses a modified BFS to iteratively print the data associated 
    // with all nodes/trees in level order, must be given the root
    private static <T> void levelorder(BinaryTree<T> root) {
      if (root == null) { return; } // if the tree doesn't exist
      Queue<BinaryTree<T>> q = new LinkedList<BinaryTree<T>>(); // queue contains tree nodes
      q.add(root); // add to queue
      while (!q.isEmpty()) { // check is queue is not empty
        BinaryTree<T> current = q.peek(); // value at front in queue
        System.out.print(current.getData()+"\t"); // print the data
        q.poll(); // remove the node from queue
        if (current.left != null) { q.add(current.left); } // if the current node has left child
        if (current.right != null) { q.add(current.right); } // if the current node has right child
      }
    }

  /*
   * Search for a value using DFS with a stack iteratively, must be called
   * with the root node. Returns true if found or false if not found.
   */
  private static <T> boolean dfs(T value, BinaryTree<T> root) {
    if (root == null) { return false; } // if tree doesn't exist
    Stack<BinaryTree<T>> s = new Stack<BinaryTree<T>>();
    boolean found = false; // to check if the value is found in tree
    s.push(root); // push root to stack
    while (!s.isEmpty()) { // loop until stack is empty
      BinaryTree<T> current = s.pop(); // pop node which is at the top of stack
      if (current.data.equals(value)) { found = true; } // check if the value is found
      if (current.right != null) { s.push(current.right); } // if current node has right child
      if (current.left != null) { s.push(current.left); } // if current node has left child
    }
    return found;
  }
}

  public static void main(String[] args) {
    // initialize Scanner to capture user input
    Scanner in = new Scanner(System.in);
    // initialize Queue to store references to BinaryTrees
    Queue<BinaryTree<String>> trees = new LinkedList<BinaryTree<String>>();
    // declare sentinel
    String s;

    String prompt = "Enter string or done: ";
    System.out.println(prompt);

    while(!((s = in.nextLine()).equals("done"))){
      BinaryTree<String> t = new BinaryTree<String>();
      t.setData(s);
      trees.add(t);
      System.out.print(prompt);
    }

    // initialize Queue to store references to BinaryTrees
    Queue<BinaryTree<String>> nodeQueue = new LinkedList<BinaryTree<String>>();

    // initialize reference variable for final BinaryTree and preload nodeQueue
    BinaryTree<String> trueRoot;
    if (!trees.isEmpty()) {
      trueRoot = trees.remove();
      nodeQueue.add(trueRoot);
    } else {
      trueRoot = null;
    }

    // Generate tree
    while(!trees.isEmpty()){
      BinaryTree<String> root = nodeQueue.remove();
      BinaryTree<String> lc = trees.remove();

      root.attachLeft(lc);
      nodeQueue.add(lc);

      if(!trees.isEmpty()){
        BinaryTree<String> rc = trees.remove();

        root.attachRight(rc);
        nodeQueue.add(rc);
      }
    }


    System.out.println("Do you want level order: true/false");
    if (in.nextLine().startsWith("true")) {
      System.out.print("level order: \t");
      BinaryTree.levelorder(trueRoot);
      System.out.println();
    }

    System.out.println("Do you want to dfs: true/false");
    if (in.nextLine().startsWith("true")) {
      String currLine = in.nextLine();

      // dfs until exit is inputted
      while(!currLine.startsWith("exit")) {
        // Parse first word only and search
        Scanner line = new Scanner(currLine);
        System.out.println(BinaryTree.dfs(line.next(), trueRoot));

        currLine = in.nextLine();
      }
    }
  }
}
