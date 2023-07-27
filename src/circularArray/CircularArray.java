package circularArray;

import java.util.Arrays;

/**
 * lastPos = (start + size - 1) % arr.length;
 * nextAvailPos = (start + size) % arr.length;
 * k = (k + arr.length- 1) % arr.length; for going backward
 */
public class CircularArray {
    static Integer arr[];
    static int start;
    static int size;
    public static void main(String[] args) {
        arr = new Integer[8]; // nullable and non-resizeable
        start = 5 ;
        add(13);add(7);add(9);add(15);add(-4);add(17);
        print();
        System.out.println(Arrays.toString(arr));
        add(31,2);
        System.out.println(Arrays.toString(arr));
        add(43,5);
       // add(55,3); // will throw an exception
        System.out.println(Arrays.toString(arr));
        remove();
        System.out.println(Arrays.toString(arr));
        remove(1);
        System.out.println(Arrays.toString(arr));
        remove(size-2);
        System.out.println(Arrays.toString(arr));
    }
    //by default adding in the end of Array
    static void add(int n){
        if(size == arr.length){
            throw new RuntimeException("Array is Full") ; //unchecked exception
        }
        int lastAvailableIndex = (start+size) % arr.length ;
        arr[lastAvailableIndex] = n ;
        size++ ;
    }

    static void print(){
        int i = start;
        for(int c = 1;  c <=size ; c++){
            System.out.print(arr[i]+"  ");
            i = (i+1) % arr.length;
        }
        System.out.println();
    }

    /**
     * Insert the specified data in the calculated index.
     * We must calculate the number of elements to right shift by following formula:
     * int elementsToRightShift = size - offset ;
     * @param data the element to insert
     * @param offSet it is the index in the sense of Linear Array
     *               in circular array index = (start+offset)% arr.length
     */
    static void add(int data, int offSet){
        if(size == arr.length){
            throw new RuntimeException("Array is Full") ; //unchecked exception
        }
        int index = (start + offSet) % arr.length;
        int lastIndex = (start+size-1) % arr.length;
        int elementsToShift = size - offSet; //------> Important
        for(int c=1; c<=elementsToShift; c++){
            arr[(lastIndex+1) % arr.length] = arr[lastIndex];
            lastIndex = ( lastIndex - 1 + arr.length )% arr.length;
        }
        arr[index] = data;
        ++size;
    }
    // by default removing from end
    static void remove(){
        if(size==0){
            throw new RuntimeException("Array is Empty");
        }
        // In Array Remove operation always delete the last index's value
        int lastAvailableIndex = (start+size-1) % arr.length;
        arr[lastAvailableIndex] = null;
        --size;
    }

    /**
     * Removes the element from the specified Offset.
     * int elementToLeftShift = (start+size-1)%arr.length -------> For removing
     *@param offset it is the index in the sense of Linear Array
     *       in circular array index = (start+offset)% arr.length
     */
    static void remove(int offset){
        if(size==0){
            throw new RuntimeException("Array is Empty");
        }
        int index = (start + offset) % arr.length ;
        int elementsToShift = size - offset - 1 ; //----> Important
        for(int c = 1; c<=elementsToShift; c++){
            arr[index] = arr[(index+1)%arr.length];
            index = (index+1)%arr.length;
        }
        // In Array Remove operation always delete the last index's value
        int lastIndex = (start + size - 1 ) % arr.length ;
        arr[lastIndex] = null;
        --size;
    }
}
