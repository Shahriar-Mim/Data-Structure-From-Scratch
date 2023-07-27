package linearArray;

import java.util.Arrays;

// Reversing an Array using In-place Algorithm
/**
Main goal is to think the array as two halves.
then forwarding an Index from left half and backwarding
another index from the right half, until the
forwarding index surpassed the backwarding index
and then swapping the values of two index
 */
public class ArrayReverse {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int i = 0;  // Forward index from left half
        int j = arr.length-1; // Backward index from right half

        //important condition ( i<j )
        while(i<j){ // condition to check if the forwarding index surpass the backwarding index
        // basic swap operation
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; //forward
            j--; //backward
        }
        // printing the array
        System.out.println(Arrays.toString(arr));
    }
}

