/**
 * 
 * Problem: Given a linked list and a value x, partition it such that all nodes
 * less than x come before nodes greater than or equal to x. You should preserve
 * the original relative order of the nodes in each of the two partitions.
 * 
 * For example, Given 3->5->8->5->10->2->1 and x = 5, return 1->2->3->5->8->5->10.
 *
 */

public class Partition_LinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node partitionLL(Node node, int x) {
        Node head = node;
        Node tail = node;

        while(node != null) {
            Node next = node.next;
            if(node.data >= x) {
                tail.next = node;
                tail = node;
            } else {
                node.next = head;
                head = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        //Creating nodes
       Node node1 = new Node(3);
       Node node2 = new Node(5);
       Node node3 = new Node(8);
       Node node4 = new Node(5);
       Node node5 = new Node(10);
       Node node6 = new Node(2);
       Node node7 = new Node(1);

        //Linking nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Partition_LinkedList pLL = new Partition_LinkedList();
        Node node = pLL.partitionLL(node1, 5);

        //Print res
        while(node !=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
    }
}
