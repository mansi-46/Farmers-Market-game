package week04;

import java.util.Arrays;

/**
 * Lecture 06 example showing arrays as parameters to methods.
 *
 * @author Juliano Franz
 */
public class ArrayReference {
    public static void main(String[] args) {
        int[] mainArray = {3,1,4,5};

        System.out.println(Arrays.toString(mainArray));
    }

    public static void foo(int[] x){
        //Why the code behaves differently when you uncomment the nexr line?
        //x = new int[5];
        x[1] = 10;
    }
}
