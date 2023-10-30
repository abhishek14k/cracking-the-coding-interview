/*
Problem Statement:
Implement an algorithm to find the kth to last element of a singly linked list.
*/

public class KthElementFromLast {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node kFromLast(Node head, int k) {
        Node p1 = head;
        Node p2 = head;

        //Moving the 1st pointer k positions ahead of 2nd pointer
        for(int i=0; i < k; i++) {
            if(p1 == null){
                return null;
            }
            p1=p1.next;
        }

        //Moving both the pointers together until first pointer reaches null
        while(p1!=null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
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

        KthElementFromLast kFromL = new KthElementFromLast();
        Node node = kFromL.kFromLast(node1, 2);
        System.out.println("The value of the kth last node is: "+node.data);
    }
}
