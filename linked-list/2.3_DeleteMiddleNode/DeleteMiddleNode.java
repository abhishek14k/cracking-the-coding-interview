/*
Problem Statement:
Implement an algorithm to delete a node in the middle(i.e., any node but the first and last node, not necessarily the exact middle)
of a singly linked list, given only access to tha node.
Example
Input: the node c from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a->b->d->e->f
*/

public class DeleteMiddleNode {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean deleteMiddleNode(Node node) {
        //Not middle node or last node if null
        if(node == null || node.next == null) {
            return false;
        }
        node.data = node.next.data;
        node.next = node.next.next;
        return true;
    }


    public static void main(String[] args) {
        //Creating nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        //Linking nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        DeleteMiddleNode dM = new DeleteMiddleNode();
        dM.deleteMiddleNode(node3);

        //Print res
        while(node1!=null){
            System.out.println(node1.data+" ");
            node1 = node1.next;
        }
    }
}
