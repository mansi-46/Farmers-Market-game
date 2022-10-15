package week04;

import java.util.Arrays;

/**
 * Example code showing how to work with 2D Arrays. Lecture 06
 *
 * @author Juliano
 */
public class RowColTotal {
    public static void main(String[] args) {
        int[][] my2DArr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printArray(my2DArr);
        //printSumRow(my2DArr);
        //printSumCol(my2DArr);
    }

    /**
     * Computes and prints the sum of all elements in each column of a 2D array
     *
     * @param my2DArr the 2D array to sum the elements from
     */
    public static void printSumCol(int[][] my2DArr) {
        for (int i = 0; i < my2DArr[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < my2DArr.length; j++) {
                sum += my2DArr[j][i];
            }
            System.out.println(sum);
        }
    }

    /**
     * Computes and prints the sum of all elements on each row of a 2D array
     * @param array the 2D array to sum the elements from
     */
    public static void printSumRow(int[][] array) {

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[0].length; j++) {
                sum+= array[i][j];
            }
            System.out.println(sum);
        }
    }

    /**
     * Prints a 2D array to the console. This example shows how to print using for loops and for each loops
     * @param array the 2D array we want to print
     */
    public static void printArray(int[][] array){
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[0].length; j++){
//                System.out.print(array[i][j]);
//            }
//            System.out.println();
        //}
     for (int[]  row : array) {
         System.out.println(Arrays.toString(row));
     }
    }

}

