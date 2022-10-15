package week04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Example showing two ways of copying Arrays (with the same size or not)
 * The code also demonstrates how to print arrays using a for loop or Arrays.toString()
 *
 * @author Juliano Franz
 */
public class ArrayCopy {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        final int NUM_OF_ENTRIES = 4;
        int[] nums = new int[NUM_OF_ENTRIES];

        for (int i = 0; i < NUM_OF_ENTRIES; i++) {
            nums[i] = kb.nextInt();
        }

        //Create a new array with the same size to copy to
        int[] copyOfNums = new int[nums.length];
        //Copy one element after the other
        for (int i = 0; i < copyOfNums.length; i++) {
            copyOfNums[i] = nums[i];
        }

        //Another way to Copy
        int[] anotherCopyOfNums = Arrays.copyOf(nums,nums.length);

        //Now lets print
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        System.out.println(Arrays.toString(nums));

        System.out.println(nums);

    }
}
