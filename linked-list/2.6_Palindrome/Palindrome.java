/**
 *
 * Problem: Given a singly linked list, determine if it is a palindrome.
 * **/

import java.util.Stack;

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

        if(head == null) {
            return false;
        }

        Node slow_ptr = head;
        Node fast_ptr = head;
        Stack<Integer> stack = new Stack<>();

        //slow_ptr moves by 1 position & fast_ptr moves by 2 positions
        while(fast_ptr != null && fast_ptr.next != null) {
            stack.push(slow_ptr.data);
            slow_ptr = slow_ptr.next;
            fast_ptr = fast_ptr.next.next;
        }

        //skip the middle element if odd length
        if(fast_ptr.next == null){
            slow_ptr = slow_ptr.next;
        }

        //comparing the data of next half of the list with popping the stack from the first half
        while (slow_ptr != null) {
            if(stack.peek() != slow_ptr.data) {
                return false;
            }
            slow_ptr = slow_ptr.next;
            stack.pop();
        }
        return true;
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
