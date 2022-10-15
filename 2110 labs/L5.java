
/**
 * Uses Srini's Binary Tree code as a base
 * to assess understanding of basic tree methods
 */

import java.util.*;

public class L5{
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

    // this method returns the number of nodes/trees in a BinaryTree 
    public static<T> int nodes(BinaryTree<T> t){
      if(t == null){ // if tree is not there
        return 0;
      }
      int leftsideNodes = nodes(t.getLeft()); //height of left side
      int rightsideNodes = nodes(t.getRight()); //height of right side
      //max node from any side plus the root node
      return leftsideNodes + rightsideNodes + 1;
    }

    // this method returns the height of a BinaryTree
    // (the number of edges separating a root node/tree from its most distant,
    // descendant leaf) height of a null tree is -1
    public static<T> int height(BinaryTree<T> t){
      if(t == null){ // if tree is not there
        return -1;
      }
      int leftSideNodes = height(t.getLeft()); //height of left side
      int rightSideNodes = height(t.getRight()); //height of right side
      //max node from any side plus the root node
      int result = Math.max(leftSideNodes,rightSideNodes) + 1;
      return result;
    }

    // this method tests whether a tree is height balanced
    public static<T> boolean isBalanced(BinaryTree<T> t){
        // base case (accounts for trees of one node or nulls)
        if(height(t)<1)
            return true;
        // recursive case (t must be balanced, subtrees too)
        else
            return ((height(t.getLeft())-height(t.getRight())<2 &&
                     height(t.getRight())-height(t.getLeft())<2)
                    &&
                    (isBalanced(t.getLeft()) &&
                     isBalanced(t.getRight())));
    }

    // Prints tree in preorder (use tab characters \t instead of space characters for separation)
    public static <T> void preorder(BinaryTree<T> t){
      if (t!=null){
        System.out.print(t.getData()+"\t");
        preorder(t.getLeft());
        preorder(t.getRight());
      }
    }

    // Prints tree in inorder (use tab characters \t instead of space characters for separation)
    public static <T> void inorder(BinaryTree<T> t){
      if(t !=null) {
        inorder(t.getLeft()); // gets node from left
        System.out.print(t.getData()+"\t"); // print the data at node
        inorder(t.getRight()); //get node from right
      }
    }

    // Prints tree in postorder (use tab characters \t instead of space characters for separation)
    public static <T> void postorder(BinaryTree<T> t){
      if(t!=null) {
        postorder(t.getLeft()); // get nodes from left
        postorder(t.getRight()); // get nodes from right
        System.out.print(t.getData() + "\t");
      }
    }
  }


  // Enter a series of strings and then done to create tree, then follow prompts
	public static void main(String[] args) {
    // DO NOT CHANGE MAIN METHOD

    // initialize Scanner to capture user input
    Scanner sc = new Scanner(System.in);

    // initialize Queue to store references to BinaryTrees
    Queue<BinaryTree<String>> trees = new LinkedList<BinaryTree<String>>();

    // declare sentinel
    String s;
    
    String prompt = "Enter name or done: ";
    System.out.print(prompt);
            
    while(!((s = sc.nextLine()).equals("done"))){
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
    
    // Tree Creation
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

    System.out.println("\n\nDo you want height: true/false");
    if (sc.next().equals("true")) {
      System.out.printf("Height of the tree is: %d\n\n",
          BinaryTree.height(trueRoot));
    }

    System.out.println("Do you want number of nodes: true/false");
    if (sc.next().equals("true")) {
      System.out.printf("Number of nodes in the tree is: %d\n\n",
          BinaryTree.nodes(trueRoot));
    }

    System.out.println("Print in preorder: true/false");
    if (sc.next().equals("true")) {
      System.out.print("Preorder:\t");
      BinaryTree.preorder(trueRoot);
      System.out.println("\n");
    }

    System.out.println("Print in inorder: true/false");
    if (sc.next().equals("true")) {
      System.out.print("Inorder:\t");
      BinaryTree.inorder(trueRoot);
      System.out.println("\n");
    }

    System.out.println("Print in postorder: true/false");
    if (sc.next().equals("true")) {
      System.out.print("Postorder:\t");
      BinaryTree.postorder(trueRoot);
      System.out.println("\n");
    }
	}
}
