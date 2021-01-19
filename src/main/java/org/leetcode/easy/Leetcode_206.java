package org.leetcode.easy;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
    Reverse a singly linked list.

    Example:
    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL

    Follow up:
    A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Leetcode_206 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode copyNd = null;
        ListNode previous = null;
        while (head != null){
            copyNd = new ListNode(head.val, previous);
            previous = copyNd;
            head = head.next;
        }
        return copyNd;
    }

    private static void printListNode(ListNode nd){
        while(nd != null){
            System.out.printf("%s ", nd.val);
            nd = nd.next;
        }
    }

    public static void main(String[] args) {
        ListNode nd1 = new ListNode(1);
        ListNode nd2 = new ListNode(2);
        ListNode nd3 = new ListNode(3);
        ListNode nd4 = new ListNode(4);
        ListNode nd5 = new ListNode(5);

        nd1.next = nd2;
        nd2.next = nd3;
        nd3.next = nd4;
        nd4.next = nd5;
        nd5.next = null;

        printListNode(nd1);
        System.out.println("------------------------");
        ListNode reverseNd = reverseList(nd1);
        System.out.println("------------------------");
        printListNode(reverseNd);
    }
}
