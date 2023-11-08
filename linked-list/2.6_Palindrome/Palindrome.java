
public class Palindrome {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isPalindrome(Node head) {


        return false;
    }

    public static void main(String[] args) {

        //Creating nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(0);
        Node node5 = new Node(3);
        Node node6 = new Node(2);
        Node node7 = new Node(1);

        //Linking nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(node1));

    }
}
