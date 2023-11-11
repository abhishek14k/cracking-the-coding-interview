/*
Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the begining of the loop.
DEFINITION
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
EXAMPLE
Input: A->B->C->D->E->C [the same C as earlier]
Output: C
*/

public class Loop_Detection {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node detectLoop(Node head) {

//      Floyd's Tortoise and Hare algorithm
        Node slow_ptr = head; //Tortoise 1x
        Node fast_ptr = head; //Hare 2x

        while(fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;

            if(fast_ptr == slow_ptr) {
                break;
            }
        }

        //Continue if cycle is found
        slow_ptr = head;
        while (slow_ptr != fast_ptr) {
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next;
        }
        return slow_ptr;
    }

    public static void main(String[] args) {
        //Creating nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        //Linking nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node3; //Loop back to node 3

        Loop_Detection lD = new Loop_Detection();
        Node node = lD.detectLoop(node1);
        System.out.println(node.data);
    }
}
