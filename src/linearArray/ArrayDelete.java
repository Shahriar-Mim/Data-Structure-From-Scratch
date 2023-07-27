package linearArray;

import java.util.Arrays;
/**
 Array Delete = Left Shifting
 After removing the element at a given index, we need to plug the hole
 by shifting all the elements to its left.
 */
public class ArrayDelete {

public static void main(String[] args) {
    Object[] arr = {1,2,3,4,5,null,null,null}; //nullable and non-resizeable array
    int size = 5; // assumed the array of 5 :)
    //deleting the 0th index value
    arr = delete(arr,0,size);
    System.out.println(Arrays.toString(arr));

}

    private static Object[] delete(Object[] arr, int index, int size) {
        // left shifting and we should fill-up the hole
        for(int i = index; i+1< size; i++ ){
            arr[i] = arr[i+1];
        }
        // In Array Remove operation always delete the last index's value
        arr[size-1] = null;
        --size;
        return arr;
    }
}
