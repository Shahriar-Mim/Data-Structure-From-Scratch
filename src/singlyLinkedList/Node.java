package singlyLinkedList;
//default class so that it doesn't work outside the package.
class Node {
    public int elem; // element/data of the node
    public Node next; // reference to the next node

    public Node(int elem, Node n){
        this.elem = elem;
        next = n ;
    }
}
