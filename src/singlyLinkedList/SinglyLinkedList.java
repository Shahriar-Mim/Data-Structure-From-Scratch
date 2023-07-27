package singlyLinkedList;

/**
 * In singly linkedList in both insert and remove operation
 * we have to keep track the predecessor node.
 *
 * In singly LinkedList in reverse operation
 * we have to keep track of the successor node.
 */
public class SinglyLinkedList {
    static Node head = null;
    static Node tail = null;
    static int size = 0;

    public static void main (String[] args){
        System.out.println("Inserting sequentially");
        insert(0,55);
        insert(1,66);
        insert(2,99);
        insert(3,49);
        print();

        System.out.println("Inserting in middle");
        insert(2,67);
        insert(0,10);
        print();

        System.out.println("Remove");
        remove(3);
        print();
        System.out.println("Remove");
        remove(0);
        print();

        System.out.println("Copy");
        print(copy()); // overloaded print() method
        head = reverse();
        System.out.println("Reverse");
        print();
        System.out.println(" Recursive Reverse");
        print(head);

    }

    /**
     * 3 cases to insert. I) Head, II) Tail, III) Between Head and Tail
     * @param index
     * @param elem
     */
    static void insert(int index,int elem){
        if(index<0 || index>size){ // we are allowing index==size, so that we can insert at last(tail).
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(elem,null);
        // inserting at head
        // special case: the first node
        if(index==0){
            newNode.next = head;
            head = newNode;
            if(size==0){
                tail = head;
            }
        }
        // inserting at tail
        else if(index==size){
            tail.next = newNode;
            tail = newNode;
        }
        // else find the predecessor node
        else {
            Node pred = nodeAt(index - 1);
            newNode.next = pred.next;
            pred.next = newNode;
        }
        ++size;
    }

     static Node nodeAt(int index){
         // we are not allowing index==size, since element containing index != size.
         if(index<0 || index >= size){
             throw new IndexOutOfBoundsException();
         }
        Node n = head;
         // while index is 0, we are in the 1st indexed Node(n)
         // that's why going less one than index
        for(int i = 0; i<index; i++){
            n = n.next;  // while index is 1, we are in the 2nd indexed Node(n)
        }
        return n;
    }

     static void print(){
        Node n = head;
        while(n!=null){
            System.out.println(n.elem);
            n = n.next;
        }
    }
    // overloaded print() method.
     static void print(Node head){
        Node n = head;
        while(n!=null){
            System.out.println(n.elem);
            n = n.next;
        }
    }

    /**
     *  3 cases to remove. I) Head, II) Tail, III) Between Head and Tail
     */
     static void remove(int index){
        //bound check
        // we are not allowing index==size, since element containing index != size.
        if(index<0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node removedNode = null;
        //special case: the first node
        if(index==0){
            removedNode = head;
            head = head.next;
        }
        // else find the predecessor node
        else{
            Node pred = nodeAt(index - 1);
            removedNode = pred.next;
            pred.next = removedNode.next;
            // if it's last index, then we need to change the tail
            if(index == size-1){
                tail = pred;
            }
        }
        System.out.println("The node is removed and its value =  "+removedNode.elem);
        removedNode.next = null;
        removedNode = null ; // GC will delete it.
        --size;
    }
    // copy of the linkedlist
     static Node copy(){
        Node copyHead=null;
        Node copyTail=null;
        Node source = head;
        while(source != null){
            Node n = new Node(source.elem, null);
            if(copyHead == null){ // it means there's no nodes yet.
                copyHead = n;
                copyTail = n;
            }
            else{ // adding in the last each time and updating the new Tail
                copyTail.next = n;
                copyTail = n ;
            }
            source = source.next;
        }
        return copyHead;
    }

    //iterative reverse:
     static Node reverse(){
        Node newHead = null;//-----> Remember
        tail = head;
        Node current = head;
        while(current != null){
            // we have to hook the successor node first in case of iterative inversing
            Node nextNode = current.next;
            current.next = newHead;
            newHead = current; // referring the head as the current
            current = nextNode;
        }
        return newHead;
    }
    //recursive reverse
    static void recursiveReverse(Node current){
        // stopping at the last node that's why current.next != null
        if(current.next==null){
            head = current;
            return ;
        }
        recursiveReverse(current.next); // recursion call
        Node successor = current.next;
        successor.next = current;
        current.next = null;
        tail = current;
    }
}
