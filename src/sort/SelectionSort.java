package sort;

import java.util.Arrays;
// best case O(n^2), worst case O(n^2)
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,50,1};

        // selection sort
        for(int i = 0; i<arr.length; i++){
            int min = arr[i];
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<min){
                    min = arr[j];
                    arr[j] = arr[i] ;
                    arr[i] = min;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
