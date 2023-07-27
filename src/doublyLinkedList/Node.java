package doublyLinkedList;

class Node {
    public Integer elem;
    public Node next; // reference to the next Node
    public Node prev;// reference to the previous Node

    public Node(Integer elem, Node next, Node prev) {
        this.elem = elem;
        this.next = next;
        this.prev = prev;
    }
}
