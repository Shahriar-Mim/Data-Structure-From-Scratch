package binarySearchTree;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public String toString(){
        return "Node data : "+data;
    }
}
