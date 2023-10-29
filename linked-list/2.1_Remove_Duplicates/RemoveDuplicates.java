/*
Problem Statement: Write code to remove duplicates from an unsorted linked list.
*/
import java.util.HashSet;

public class RemoveDuplicates {


    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void removeDuplicates(Node node) {
        HashSet<Integer> hs = new HashSet<>();
        Node previous = null;

        while(node != null) {
            if(!hs.contains(node.data)) {
                hs.add(node.data);
                previous = node;
            } else {
                previous.next = node.next;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        //Creating nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(3);
        Node node6 = new Node(3);

        //Linking nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        RemoveDuplicates rD = new RemoveDuplicates();
        rD.removeDuplicates(node1);

        //Print res
        while(node1!=null){
            System.out.println(node1.data+" ");
            node1 = node1.next;
        }
    }
}
