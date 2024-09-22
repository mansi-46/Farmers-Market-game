import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class main {
    private static class BST {
        Node root;

        public boolean insert(int key, String value) {
            if (contains(key)) {
                return false;
            } else {
                Node node = new Node(key, value);
                if (root == null) {
                    root = node;
                    return true;
                }
                Node previous = null;
                Node temp = root;
                while (temp != null) {
                    if (temp.key > key) {
                        previous = temp;
                        temp = temp.left;
                    } else if (temp.key < key) {
                        previous = temp;
                        temp = temp.right;
                    }
                }
                if (previous.key > key) previous.left = node;
                else previous.right = node;
                return true;
            }
        }

        public boolean contains(int key) {
            if (root != null) {
                String temp = root.getKey(key);
                if (temp != null) {
                    return true;
                }
            }
            return false;
        }

        public String get(int key) {
            if(root != null){
                return root.getKey(key);
            }
            return null;
        }

        private String deleteNode(int key) {
            Node current = root;
            Node parent = root;
            boolean decider = false;
            if (root == null) {
                return null;
            }
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

//      if (current == parent.left) {
//        decider = true;
//      }
            String value = current.data;
            //leaf node (No child)
            if (current.left == null && current.right == null) {
                if (current.key == root.key) {
                    root = null;
                    return value;
                }
                if (decider) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return value;
            }
            // node with only one child or no child
            else if(current.left == null){
                if(current.key == root.key){
                    String res = current.data;
                    root = current.right;
                    return res;
                }else if(decider){
                    Node res = current;
                    parent.left = current.right;
                    return res.data;

                }else{
                    Node res = current;
                    parent.right = current.right;
                    return res.data;
                }
            }
            else if (current.right == null) {
                if (current.key == root.key) {
                    String res = current.data;
                    root = current.left;
                    return res;
                } else if (decider) {
                    String res = current.data;
                    parent.left = current.left;
                    return res;
                } else {
                    Node res = current;
                    parent.right = current.left;
                    return res.data;
                }

            } else {
                Node succ = minValue(current);
                if(current == root) {
                    value = current.data;
                    root = succ;
                    succ.left = current.left;
                    return value;
                } else if(decider) {
                    Node result = current;
                    parent.left =succ;
                    succ.left = current.left;
                    return result.data;
                } else {
                    Node result = current;
                    parent.right = succ;
                    succ.left = current.left;
                    return result.data;
                }
            }
        }
        static Node minValue(Node root) {
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

        private static <T> void preorder(Node t) {
            if (t != null) {
                System.out.print(t.data + "\t");
                preorder(t.left);
                preorder(t.right);
            }
        }

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

        public static void inorder(Node t) {
            if (t != null) {
                inorder(t.left); // gets node from left
                System.out.print(t.data + "\t"); // print the data at node
                inorder(t.right); //get node from right
            }
        }

        // Prints tree in postorder (use tab characters \t instead of space characters for separation)
        public static void postorder(Node t) {
            if (t != null) {
                postorder(t.left); // get nodes from left
                postorder(t.right); // get nodes from right
                System.out.print(t.data + "\t");
            }
        }

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

        public class Node {
            Node left, right;
            int key;
            String data;

            public Node(int key, String data) {
                this.data = data;
                this.key = key;
            }

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

//      private Node deleteRoot(Node root, int key) {
//        if(root == null) {
//          return null;
//        }
//        /* Otherwise, recur down the tree */
//        if (key < root.key)
//          root.left = deleteRoot(root.left, key);
//        else if (key > root.key)
//          root.right = deleteRoot(root.right, key);
//
//          // if key is same as root's
//          // key, then This is the
//          // node to be deleted
//        else {
//          // node with only one child or no child
//          if (root.left == null)
//            return root.right;
//          else if (root.right == null)
//            return root.left;
//
//          // node with two children: Get the inorder
//          // successor (smallest in the right subtree)
//          root.key = minValue(root.right);
//
//          // Delete the inorder successor
//          root.right = deleteRec(root.right, root.key);
//    }

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
                System.out.println(tree.deleteNode(inputLine.nextInt()));
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

