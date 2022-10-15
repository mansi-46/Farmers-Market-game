/**
 * this program performs merge sort using arrayList
 * @author Mansi Patel
 */
import java.util.ArrayList;
import java.util.Scanner;

public class L2Q2 {
  public static ArrayList<Integer> mergeSort(ArrayList<Integer> list) {
    // base case to stop recursion when only 1 element in list
    if (list.size() < 2) {
      return list;
    }
    int middleIndex = list.size() / 2;
    ArrayList<Integer> leftList = new ArrayList<>();
    ArrayList<Integer> rightList = new ArrayList<>();
    // store first half of the list
    for(int i = 0; i < middleIndex; i++) {
      leftList.add(list.get(i));
    }
    // store 2nd half of the list
    for(int i = middleIndex; i < list.size(); i++){
      rightList.add(list.get(i));
    }
    leftList = mergeSort(leftList);
    rightList = mergeSort(rightList);
    return merge(leftList, rightList); // to merge sort 2 lists
  }

  /**
   * This method merge sorts both halves of lists and
   * merge then together
   * @param leftList first half of list
   * @param rightList second half of the list
   * @return returns the merged sorted list
   */
  private static ArrayList<Integer> merge(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
    ArrayList<Integer> list = new ArrayList<>(); // store merged list
    int size1 = leftList.size(); // size of first half
    int size2 = rightList.size(); // size of second half
    int i = 0, j = 0;
    while(i < size1 && j < size2) { // to check both lists are not empty
      if(leftList.get(i) <= rightList.get(j)) {
        list.add(leftList.get(i)); // add smaller element in front
        i++;
      }
      else {
        list.add(rightList.get(j)); // add smaller element
        j++;
      }
    }
    // if only 1 list has element
    while(i < size1){
      list.add(leftList.get(i));
      i++;
    }
    while(j < size2){
      list.add(rightList.get(j));
      j++;
    }
    return list; // sorted list returned
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

    list = mergeSort(list);

    for (int i = 0; i < n; i++) {
      System.out.print(list.get(i) + " ");
    }
  }
}
