package doublyLinkedList;
// Dummy Headed Doubly Linked Circular List
public class DoublyLinkedList {
    static Node head; //dummy head
    static int size;
    public static void main(String[] args) {
        // making a dummy head;
        head = new Node(null,null,null);
        // making it circular
        head.next = head.prev = head;
        // Operations
        System.out.println("Inserting sequentially");
        insert(0,55);
        insert(1,66);
        insert(2,99);
        insert(3,49);
        print();

        System.out.println("Inserting in middle");
        insert(1,33);
        print();
//        System.out.println("Reverse Print");
//        reversePrint();
        System.out.println("Removing 0th index element");
        remove(0);
        print();

        System.out.println("Removing 3rd index element");
        remove(3);
        print();

        System.out.println("Reverse Print");
        reversePrint();

    }

    /**
     * No Special Condition here. No 3 cases like SinglyLinkedList.
     * We have to find-out the predecessor node first for adding.
     * Insert an element in the linked list based on index.
     * @param index the specified index where to add
     * @param elem the specified element/data to add in the index
     */
    static void insert(int index, int elem){
        if(index<0 || index>size){ // we are allowing index==size, so that we can insert at last(tail).
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(elem,null,null);
        Node pred = nodeAt(index-1);
        Node successor = pred.next;
        newNode.next = successor;
        newNode.prev = pred;
        pred.next = newNode;
        successor.prev = newNode;
        ++size;
    }

    /**
     * we just need to find the node at specified index.
     * Removes the element of the specified index
     * @param index of the element which has to be removed
     */
    static void remove(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node removedNode = nodeAt(index);
        Node pred = removedNode.prev;
        Node successor = removedNode.next;

        pred.next = successor;
        successor.prev = pred;

        System.out.println("The node has been removed "+removedNode.elem);
        removedNode.next = removedNode.prev = null;
    }
    /**
     * Finding the node on the given index.
     * @param index of the node
     * @return the node on the specified index.
     */
    static Node nodeAt(int index){
        Node n = head.next; // this is a dummy headed. So the actual head is from head.next.
        for(int i=0; i<index ; i++){
            n = n.next;
        }
        return n;
    }

    static void print(){
        Node n = head.next;
        while(n!=head){
            System.out.println(n.elem);
            n = n.next;
        }
    }
    //reverse print
    static void reversePrint(){
        Node n = head.prev;
        while(n!=head){
            System.out.println(n.elem);
            n = n.prev;
        }
    }
}
