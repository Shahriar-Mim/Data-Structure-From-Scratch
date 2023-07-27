package linearArray;

import java.util.Arrays;

/**
 Array Insert = Right Shifting
Inserting an element into any slot in an array requires that
we first make room for it by shifting some of the elements to the right,
and then insert the new element in the newly formed gap.
*/
public class ArrayInsert {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5}; //non nullable and non-resizeable array
        int size = arr.length;
        // inserting elements at 0th index
        arr = insert(arr,0,99,size);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param index = the specified index where we want to insert
     */
    private static int[] insert(int[] arr, int index, int val, int size) {
        //checking if the array is full
        if(index==arr.length){
            throw new RuntimeException("Array is full");
        }
        //right shifting, always start from the last available index
        int j = size-1;
        while(j>index){
            arr[j] = arr[j-1];
            --j;
        }
        // now fill the hole/gap with the new element.
        arr[index] = val ;
        ++size;
        return arr;
    }
}
