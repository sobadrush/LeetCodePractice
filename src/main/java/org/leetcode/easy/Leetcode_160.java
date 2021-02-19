package org.leetcode.easy;

/*
    160. Intersection of Two Linked Lists
 */
public class Leetcode_160 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = getListNodeLength(headA);
        int lenB = getListNodeLength(headB);

        // 計算出兩條ListNode的長度, 在計算差值
        if (lenA > lenB){
            // 較長的往右邊移
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next;
            }

        }else if (lenA < lenB){
            // 較長的往右邊移
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }
        }

        while (headA != null && headB != null && headA != headB /*兩條ListNode不斷邁進時若節點不為共同節點→繼續跑下去*/){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int getListNodeLength(ListNode nd){
        int cc = 0;
        while (nd != null){
            cc++;
            nd = nd.next;
        }
        return cc;
    }

    public static void main(String[] args) {
        /*
            Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
            Output: Reference of the node with value = 8
        */

        ListNode commonNode = new ListNode(8);

        ListNode headA = new ListNode(4);
        ListNode ndA_2 = new ListNode(1);
        ListNode ndA_4 = new ListNode(4);
        ListNode ndA_5 = new ListNode(5);

        headA.next = ndA_2;
        ndA_2.next = commonNode;
        commonNode.next = ndA_4;
        ndA_4.next = ndA_5;

        System.out.println(getListNodeLength(headA));

        ListNode headB = new ListNode(5);
        ListNode ndB2 = new ListNode(6);
        ListNode ndB3 = new ListNode(1);
        ListNode ndB5 = new ListNode(4);
        ListNode ndB6 = new ListNode(5);

        headB.next = ndB2;
        ndB2.next = ndB3;
        ndB3.next = commonNode;
        commonNode.next = ndB5;
        ndB5.next = ndB6;

        System.out.println(getListNodeLength(headB));
        System.out.println("================================");

        System.out.println("ans = " + getIntersectionNode(headA, headB).val);
    }

}
