package binarySearch;
import java.util.Arrays;
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 50, 1};
        Arrays.sort(arr);
      //  binarySearchIterative(arr,1);
        System.out.println(binarySearchRecursive(arr,3,0,arr.length-1));

    }
    static void binarySearchIterative(int[] arr, int val){
        int start =0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            //case 1: value found in the mid index
            if(val == arr[mid]){
                System.out.println("Found "+arr[mid]);
                return;
            }
            //case 2 : value is greater than the mid
            else if(val > mid){
                start = mid + 1 ;
            }
            // case 3: by default value is lower than the mid
            else{
                end = mid - 1 ;
            }
        }
        System.out.println("Sorry the value has not been found");
    }

    static boolean binarySearchRecursive(int[] arr,int val,int start, int end){
        if(start<=end){
            int mid = (start+end)/2;
            //case 1: value found in the mid index
            if(val == arr[mid]){
                return true ;
            }
            //case 2 : value is greater than the mid
            else if(val > mid){
                start = mid + 1 ;
            }
            // case 3: by default value is lower than the mid
            else{
                end = mid - 1 ;
            }
            return binarySearchRecursive(arr, val, start, end);
        }
        return false;
    }
}