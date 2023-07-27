package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * null nodes, null root nodes play a significant role in Binary Trees
 * Remember: Every operations on Binary Tree require the ROOT node.
 *           ROOT node is the identity of the tree.
 */
public class BST {
    public static void main(String[] args) {
        Node root = null; // this means there is no Nodes in BST
        // We give the root node, and the data to insert in the function parameter.
        root = insert(root,15);
        root = insert(root,10);
        root = insert(root,20);
        root = insert(root,25);
        root = insert(root,8);
        root = insert(root,12);
        System.out.println(root);
        System.out.println("The result of the search operation "+search(root,8));
        System.out.println("Minimum is: "+findMin(root)+"   Maximum is: "+findMax(root));
        System.out.println("Height of the tree: "+findHeight(root));
        // Queue Interface
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root); // adding the root node in the queue first
        breadthTraverse(queue,root);
        System.out.println("\nPreorder Traversal");
        preorder(root);
        System.out.println("\nInorder Traversal");
        inorder(root);
        System.out.println("\npostorder Traversal");
        postorder(root);
        System.out.println();
        System.out.println("This is a BST or not?: "+
                isBST(root,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY));
        System.out.println("Delete  "+delete(root,25));

    }

    /**
     * Insert element in the BST
     * @param parent root node of 'each' tree or subtree is given through parent variable
     * @param data element of the node
     * @return the root of the whole tree.
     */
    static Node insert(Node parent, int data){
        if(parent==null)
        {
            Node n = new Node(data,null,null); // creating a new node
            return n;
        }
        else if(data <= parent.data){
            parent.left = insert(parent.left,data);
        }
        else{
            parent.right = insert(parent.right,data);
        }
        return parent;  // it will return the parent variable of the method which were first
                        // called from the main method.

    }

    /**
     *Search the given element in the bst and returns true if the element is found
     * @param parent root nodes of 'each' tree or sub-tree.
     * @param data element to search
     * @return true or false
     */
    static boolean search(Node parent, int data){
        if(parent==null){
            return false;
        }
        if(parent.data == data){
            return true;
        }
        if (data <= parent.data){
            return search(parent.left,data);
        }
        else {
            return search(parent.right, data);
        }
    }

    /**
     * Finds the minimum which the left-most node's data
     * @param parent root nodes of 'each' tree or sub-tree.
     * @return the element/data
     */
    static int findMin(Node parent){
        if(parent==null){ // corner case
            throw new RuntimeException("The Tree is empty");
        }
        else if (parent.left==null){ // it means we are on the left-most node available
            return parent.data;
        }
        return findMin(parent.left);
    }

    static int findMax(Node parent){
        if(parent==null){ // corner case
            throw new RuntimeException("The Tree is empty");
        }
        else if (parent.right==null){ // it means we are on the right-most node available
            return parent.data;
        }
        return findMax(parent.right);
    }

    /**
     * Finds the height of the tree. Works in self-similar (recursive) manner.
     * Take each node as a parent aka root and finds its height
     * Formula: max(LeftSubTree+RightSubTree)+1; +1 because the outgoing edge from the parent node
     * @param parent take each node as a root of the sub-tree.
     * @return the height.
     */
    static int findHeight(Node parent){
        if(parent==null){ // means empty node
            return -1; // height of 1 node = 0 and height of 0 node = -1
        }
        int leftSubTreeH = findHeight(parent.left);
        int rightSubtreeH = findHeight(parent.right);
        return Math.max(leftSubTreeH,rightSubtreeH)+1;
    }

    /**
     * Level Order Tree Traversal. Prints the nodes level by level.
     * @param queue FIFO structure maintain to preserve level by level insertion.
     * @param parent adding the parent first then its children.
     */
    static void breadthTraverse(Queue<Node> queue, Node parent){
        System.out.println("Level Order Tree Traversal");

        while( !queue.isEmpty() ) {

            Node current = queue.poll();
            System.out.print(current.data+"  ");

            //adding the children of the popped node(parent) from the queue
            if(current.left != null){ // check to avoid nullPointerException
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
    }

    /**
     * Root.data, Left Subtree, Right Subtree
     * @param parent root of each subtree.
     */
    static void preorder(Node parent){
        if(parent==null){ // empty tree. Remember: each subtree is also a tree.
            // this means in a bigger tree, we have reached to an empty node.
            return;
        }
        System.out.print(parent.data+"   "); // root.data
        preorder(parent.left); // left subtree
        preorder(parent.right); // right subtree

    }

    /**
     *  Left Subtree, Root.data, Right Subtree
     * @param parent root of each subtree.
     */
    static void inorder(Node parent){
        if(parent==null){ // empty tree. Remember: each subtree is also a tree.
            // this means in a bigger tree, we have reached to an empty node.
            return;
        }
        inorder(parent.left); // left subtree
        System.out.print(parent.data+"   "); // root.data
        inorder(parent.right); // right subtree

    }

    /**
     *  Left Subtree, Right Subtree, Root.data.
     * @param parent root of each subtree.
     */
    static void postorder(Node parent){
        if(parent==null){ // empty tree. Remember: each subtree is also a tree.
            // this means in a bigger tree, we have reached to an empty node.
            return;
        }
        postorder(parent.left); // left subtree
        postorder(parent.right); // right subtree
        System.out.print(parent.data+"   "); // root.data
    }

    /**
     * Finds if a tree is BST or not.
     * @param parent the main root node from the callee method
     * @param minRange negative infinity: to check on the left subtree.
     *                 if all the subtree is lesser or equal than the parent.
     * @param maxRange positive infinity: to check on the right subtree.
     *                 if all the subtree is greater than the parent.
     * @return true or false
     * Note: basically changing of the maxRange and minRange will give us result.
     * Left Subtree must be lesser than the root value (-infinity <= rootValue)
     * Right Subtree must be greater than the root value (rootValue < +infinity)
     */
    static boolean isBST(Node parent, double minRange, double maxRange){
        if(parent==null){ // we hit the last node or the tree is empty.
            return true;
        }
            // this minRange and maxRange will change
            // parent.data is always remain same as it was provided by the callee method
       if(parent.data >= minRange && parent.data < maxRange
          && isBST(parent.left,minRange,parent.data)   // checking each of the subtree recursively.
          && isBST(parent.right, parent.data, maxRange) ) {
           return true;
       }
       return false;
    }
    /**
     * There are 3 cases in BST delete operation.
     * Case I: Deleting a leaf node i.e. a node which has no (0) children
     *         Just setting the reference to the null will complete the operation
     * Case II: Deleting a node which have one (1) child only.
     *          Current node's direct parent now should refer the direct one child of Current Node
     * Case III: Deleting a node which have two children
     *           i) Find the minimum value from right sub-tree.
     *           ii) Setting the value of target node to the minimum value from right subtree
     *           iii) Through recursive calls try to reduce to CASE-I or CASE-II
     *                to delete the duplicate child node.
     * @param parent : identity root of each sub-tree
     * @param data : the node's element/ data to delete
     * @return root node reference of the whole tree.
     */

    static Node delete(Node parent, int data){
        if(parent==null){ // empty node or tree
            return parent;
        }
        if(data< parent.data){
           parent.left = delete(parent.left,data); // going into the left-subtree
           return parent;
        }
        if(data>parent.data){
            parent.right = delete(parent.right,data); // going into the right-subtree
            return parent;
        }
        else{ // data == parent.data
            //CASE I: No Children
            if(parent.right==null && parent.left == null){
                parent=null;
                return parent;
            }
            //CASE II : 1 Child
            if(parent.left==null){ // means there is no left subtree or left child
                Node temp = parent;
                parent = parent.right;
                temp = null;
                return parent;
            }
            if(parent.right == null){ // means there is no right subtree or right child
                Node temp = parent;
                parent = parent.right;
                temp = null;
                return parent;
            }
            //CASE III: 2 child
            else {
                int minData = findMin(parent.right); // Find the minimum value from right sub-tree.
                parent.data = minData; //Setting the value of target node to the minimum value from right subtree
                parent.right = delete(parent.right,minData); // recursive call to delete the duplicate value in children
                return parent;
            }
        }
    }

}
