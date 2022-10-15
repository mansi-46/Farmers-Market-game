package week04;

import java.util.Scanner;

/**
 * For each loop example code
 *
 * @author Juliano Franz
 */
public class ForEach {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        final int NUM_OF_ENTRIES = 4;
        int[] nums = new int[NUM_OF_ENTRIES];

        for (int i = 0; i < NUM_OF_ENTRIES; i++) {
            nums[i] = kb.nextInt();
        }

        for(int value : nums){
            System.out.println(value);
        }
    }
}
