import java.util.ArrayList;
import java.util.Scanner;

public class L2Q3 {

    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        int n = list.size();
        if (n <= 1) {
            return list;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            list1.add(list.get(i));
        }
        insertionSort(list1);
        int last = list1.get(n - 1);
        int j = n - 2;
        while(j >= 0 && list1.get(j) > last) {
            list1.set(j+1, list1.get(j));
            j--;
        }
        list1.set(j+1, last);
        return list1;
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
