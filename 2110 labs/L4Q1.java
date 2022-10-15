import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class L4Q1 {

  private static class HashMapPractice {

    // Pair class to store our values
    private class Pair {
      Integer key;
      Integer value;

      private Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
      }

      private Integer getKey() { return key; }
      private Integer getValue() { return value; }
    }

    private ArrayList<LinkedList<Pair>> hashTable;
    private Integer size; // You need to update this as you put and remove

    // Our hash map will be of size 10 for this lab for simplicity
    private HashMapPractice() {
      size = 0;

      /*
       * Create our Arraylist containing the bucket arraylists
       * for external chaining
       */
      hashTable = new ArrayList<>();
      for (int i = 0; i < 10; i++) {
        hashTable.add(new LinkedList<>());
      }
    }

    /*
     * Determine if a key is in the map already. This is needed for the put
     * method as all keys in a map must be unique and we need to check if
     * a key is already present
     */
    private boolean containsKey(Integer key) {
      int hashValue = hashCode(key);

      LinkedList<Pair> bucketList = hashTable.get(hashValue);
      for (Pair i : bucketList) {
        if (i.getKey().equals(key)) {
          return true;
        }
      }

      return false;
    }

    /*
     * Add a pair to the hash table if the key is not already present. Return
     * true if added and false if not added
     */
    private Boolean put(Integer key, Integer value) {
      if(!containsKey(key)) { //check if key is present
        Pair p = new Pair(key, value);//generate a new pair
        LinkedList<Pair> list = hashTable.get(hashCode(key)); // getting Linked list of that index
        if(list.contains(p)) { // check if list contains that pair
          return false;
        }
        else {
          list.add(p); // adding pair to list
        }
        size++;
        return true;
      }
      return false;
    }

    // Return value for a given key if present or null otherwise
    private Integer get(int key) {
      LinkedList<Pair> l = hashTable.get(hashCode(key));
      if(containsKey(key)) { //if key already present
        for(Pair p : l){ // loop over list to find matching keys
          if(p.key == key) {
            return p.value; // return value at that key
          }
        }
      }
      return null;
    }

    /*
     * Remove a pair based on the key, do nothing if there is no such pair.
     * Return the value of the pair if present else return null
     */

    private Integer remove(int key) {
      LinkedList<Pair> l = hashTable.get(hashCode(key));
      if(containsKey(key)){ //check if key present in list
        for (Pair p: l) {//loop over list
          if(p.key == key) {
            Integer v = p.value;
            l.remove(p);// remove key from list
            size--;
            return v;
          }
        }
      }
      return null;
    }

    // Return if 0 elements in map
    private Boolean isEmpty() {
      return size == 0;
    }

    // Return number of pairs in map
    private Integer size() {
      return size;
    }

    // Our simple hashcode to make bug testing easier (modulo 10 the key)
    private Integer hashCode(Integer key) {
      return key % hashTable.size();
    }
  }

  /*
   * The main method will read line by line and execute commands based on input.
   * The following is the input style: (Key and Value are both integers)
   * put Key Value
   * get Key
   * remove Key
   * containsKey Key
   * isEmpty
   * size
   * exit (terminates input)
   */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    HashMapPractice map = new HashMapPractice();

    String currLine = in.nextLine();

    // Using starts with for ease of use for lines with additional input
    while(!currLine.equals("exit")) {
      if (currLine.startsWith("put")) {
        // Scan for the int
        Scanner inputString = new Scanner(currLine);
        inputString.next(); // Throwing away first word
        System.out.println(map.put(inputString.nextInt(), inputString.nextInt()));
      } else if (currLine.startsWith("get")) {
        Scanner inputString = new Scanner(currLine);
        inputString.next(); // Throwing away first word
        System.out.println(map.get(inputString.nextInt()));
      } else if (currLine.startsWith("remove")) {
        Scanner inputString = new Scanner(currLine);
        inputString.next(); // Throwing away first word
        System.out.println(map.remove(inputString.nextInt()));
      } else if (currLine.startsWith("containsKey")) {
        Scanner inputString = new Scanner(currLine);
        inputString.next(); // Throwing away first word
        System.out.println(map.containsKey(inputString.nextInt()));
      } else if (currLine.startsWith("isEmpty")) {
        System.out.println(map.isEmpty());
      } else if (currLine.startsWith("size")) {
        System.out.println(map.size());
      } else {
        System.out.println("Invalid input");
        break;
      }

      currLine = in.nextLine();
    }
  }
}
