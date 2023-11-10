/*
Problem Statement:
Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node. Note that the intersection is
defined based on reference, not value. That is, if the kth node of the first linked list is the exact same node (by reference) as the
jth node of the secondlinked list, then they are intersecting.
*/

/*
*   1 -> 2 -> 3 -> 4\
*                     7 -> 8 -> 9 -> 10
*             5 -> 6/
*/

public class Intersection {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node intersection(Node head1, Node head2) {

        Node ptr1 = head1;
        Node ptr2 = head2;

        while(ptr1 != ptr2) {
            if(ptr1 == null) {
                ptr1 = head2;
            }

            if(ptr2 == null) {
                ptr2 = head1;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }

    public static void main(String[] args) {
        //Creating nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        //Linking nodes for List 1
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node7; //intersecting node

        //Linking nodes for List 2
        node5.next = node6;
        node6.next = node7; //intersecting node

        node7.next = node8;
        node8.next = node9;
        node9.next = node10;

        Intersection i = new Intersection();
        Node node = i.intersection(node1, node5);
        System.out.println("The intersecting node: "+node.data);
    }
}
