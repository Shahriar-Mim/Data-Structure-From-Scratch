package heap;

/**
 * In HEAP insert and remove operations, comparison happens between parent and child
 * swapping of accurate parent and child results in the heap
 *
 * for MAX-HEAP:
 * Insert method will insert the data in the array on the last available size-th position i.e. index
 * Then the swim() method will compare each nodes with its parents.
 *
 * Remove method will remove the data from the 0th index of array
 * Then the sink() method will be called.
 * sink() method will compare the max child between left and right child
 * after the calculation of max child, parent node will be compared with the max child
 * the largest node will sit as parent
 * We should decrement the size in remove method after getting the result from sink().
 */
public class Heap {
    // Heap Array and Heap Size is Global Variable
    static int size = 0 ;
    static int[] heapArray ;
    public static void main(String[] args) {
        // this is my initial heap.
        heapArray = new int[10];
        insert(10);
        insert(5);
        insert(3);
        insert(2);
        insert(4);
        insert(15);
        print();
        remove();
        print();
        remove();
        print();
        remove();
        print();

//        remove();
//        print();
//
//        remove();
//        print();
//
//        remove();
//        print();
//        remove();
//        print();
    }

    /**
     * insert data in the Heap.
     * @param data the data to insert
     */
     static void insert(int data){
        if(heapArray.length <= size){ // if array is smaller, then it has to be resized
            System.out.println("I am going to resize !!");
            resizeArray();
        }
        // Adding in the last available position
         // Note: we have already data in size-1 :) New insert will be on size-th.
        heapArray[size] = data; // size will work as the index, where to add.
        // we will now compare with parents if the newly added nodes satisfy the heap properties.
        swim(size);
        //incrementing after swim();
        size++;

    }

    static void swim(int currentIndex){ // this compares the nodes with the parents
        int parentIndex = (currentIndex-1) / 2; // when index is 0 parent is 0 too. (0-1) / 2 = 0
        // if the parent's (root) value is smaller than the child value
        if(heapArray[parentIndex]<heapArray[currentIndex]){
            //swap
            int temp = heapArray[currentIndex];
            heapArray[currentIndex] = heapArray[parentIndex];
            heapArray[parentIndex] = temp;
            // Recursively again check with other parents.
            swim(parentIndex);
        }
    }

    static void remove(){
        if(size<=0){
            throw new RuntimeException("The heap is empty");
        }
        System.out.println("Removed Node "+heapArray[0]);
        heapArray[0] = heapArray[size-1] ; // inserting the last element in the 0th index
        heapArray[size-1] = Integer.MIN_VALUE ; // means there's no need to compare;
        sink(0); //0 = root index of the heap
        //decrementing after sink();
        --size;

    }
     static void sink(int parentIndex){
         int leftIndex = 2*parentIndex+1; // left subtree.
         int rightIndex = 2*parentIndex+2; // right subtree.
         // in case we have only two nodes. Root and Left Node
         int largestIndex = leftIndex; // assuming left index is the largest.
         // if leftIndex and rightIndex is less than size
         // it means we have both left and right child
         if(leftIndex<size && rightIndex <size){
             // calculating the maxNode between left and right subtree
             if(heapArray[leftIndex] < heapArray[rightIndex]){
                 largestIndex = rightIndex;
             }
             else{
                 largestIndex = leftIndex;
             }
         }
         if(heapArray[parentIndex]<heapArray[largestIndex]){
             //swap
             int swap = heapArray[largestIndex];
             heapArray[largestIndex] = heapArray[parentIndex];
             heapArray[parentIndex] = swap;
             sink(largestIndex); // recursive call with new parentIndex
         }

     }

     static void resizeArray(){
        int[] newArr = new int[heapArray.length*2];
        for(int i = 0 ;  i<heapArray.length; i++){
            newArr[i] = heapArray[i];
        }
        heapArray = newArr;
    }

    static void print(){
        for(int i=0; i<size; i++ ){
            System.out.println(heapArray[i]);
        }
    }
}
