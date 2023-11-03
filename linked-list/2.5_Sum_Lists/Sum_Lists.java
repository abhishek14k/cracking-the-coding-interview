/**
 *
 * Problem: You are given two non-empty linked lists representing two
 * non-negative integers. The digits are stored in reverse order and each of
 * their nodes contain a single digit. Add the two numbers and return it as a
 * linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2 -> 1) Output: 2 -> 1 -> 9 -> 1              617 + 1295 = 1912
 *
 */

public class Sum_Lists {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node sumLists(Node list1, Node list2) {
        int res = 0;
        int carry = 0;
        Node output_H = null;
        Node output_P = null;

        while(list1 != null || list2 != null || carry != 0) {
            if(list1 != null) {
                res += list1.data;
                list1 = list1.next;
            }
            if(list2 != null) {
                res += list2.data;
                list2 = list2.next;
            }
            res += carry;
            carry = res/10;

            Node new_Node = new Node(res % 10);
            if(output_H == null) {
                output_H = new_Node;
                output_P = output_H;
            } else {
                output_P.next = new_Node;
                output_P = new_Node;
            }
            res = 0;
        }
        return output_H;
    }

    public static void main(String[] args) {

        Node list1_1 = new Node(7);
        Node list1_2 = new Node(1);
        Node list1_3 = new Node(6);

        list1_1.next = list1_2;
        list1_2.next = list1_3;

        Node list2_1 = new Node(5);
        Node list2_2 = new Node(9);
        Node list2_3 = new Node(2);
        Node list2_4 = new Node(1);

        list2_1.next = list2_2;
        list2_2.next = list2_3;
        list2_3.next = list2_4;

        Sum_Lists sl = new Sum_Lists();
        Node node = sl.sumLists(list1_1, list2_1);

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
