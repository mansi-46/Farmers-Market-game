import java.util.ArrayList;
import java.util.Scanner;

public class L2Q1 {

  public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
    // loop runs from 2nd to last element in the arrayList
    for(int i = 1; i < list.size(); i++){
      int temp = list.get(i); // stores a element at index i
      int index = i;
      while(index > 0 && temp < list.get(index-1)){ // to check if the previous element is larger
        list.set(index, list.get(index - 1)); // moves larger element in back
        index--;
      }
      list.set(index, temp); // set smaller to front
    }
    return list;
  }

  /*
   * The main method will read in the length n and then n integers.
   * Then it will call the sort method and then print the list.
   */
  public static void main(String[] args) {
    /*
     * DO NOT CHANGE THIS METHOD
     */

    Scanner in = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<>();

    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      list.add(in.nextInt());
    }

    list = insertionSort(list);

    for (int i = 0; i < n; i++) {
      System.out.print(list.get(i) + " ");
    }
  }
}
