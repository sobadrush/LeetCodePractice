package org.leetcode.easy;

/*
    21. Merge Two Sorted Lists
 */
/*
    Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
public class Leetcode_21 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static List<Integer> collectToList(ListNode nd){
        List<Integer> rList = new ArrayList<>();
        while (nd != null){
            rList.add(nd.val);
            nd = nd.next;
        }
        return rList;
    }

    private static ListNode getListNode(List<Integer> list){
        ListNode nd1 = null;
        ListNode tmp = null;

        Integer[] arr = list.toArray(new Integer[]{});

        for (int i = 0; i < arr.length; i++) {
            if (i == 0){
                nd1 = new ListNode(arr[i]);
                continue;
            }
            if (tmp != null){
                tmp.next = new ListNode(arr[i]);
                tmp = tmp.next;
                continue;
            }
            nd1.next = new ListNode(arr[i]);
            tmp = nd1.next;
        }

        return nd1;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        if (l1 == null || l2 == null){
            return l1 == null ? l2 : l1;
        }

        List<Integer> listA = collectToList(l1);
        List<Integer> listB = collectToList(l2);

        listA.addAll(listB);
        Collections.sort(listA);

//      listA.forEach(System.out::println);

        return getListNode(listA);
    }

    public static void main(String[] args) {
        // Input: l1 = [1,2,4], l2 = [1,3,4]
        // Output: [1,1,2,3,4,4]

        ListNode ndA_1 = new ListNode(1);
        ListNode ndA_2 = new ListNode(2);
        ListNode ndA_3 = new ListNode(4);
        ndA_1.next = ndA_2;
        ndA_2.next = ndA_3;

        ListNode ndB_1 = new ListNode(1);
        ListNode ndB_2 = new ListNode(3);
        ListNode ndB_3 = new ListNode(4);
        ndB_1.next = ndB_2;
        ndB_2.next = ndB_3;

        ListNode ld = mergeTwoLists(ndA_1, ndB_1);
        while(ld != null){
            System.out.println(ld.val);
            ld = ld.next;
        }


        // ListNode nd1 = null;
        // ListNode tmp = null;
        // int[] arr1 = new int[] {1, 2, 4};
        // for (int i = 0; i < arr1.length; i++) {
        //     if (i == 0){
        //         nd1 = new ListNode(arr1[i]);
        //         continue;
        //     }
        //     if (tmp != null){
        //         tmp.next = new ListNode(arr1[i]);
        //         tmp = tmp.next;
        //         continue;
        //     }
        //     nd1.next = new ListNode(arr1[i]);
        //     tmp = nd1.next;
        // }
        //
        // while(nd1 != null){
        //     System.out.println(nd1.val);
        //     nd1 = nd1.next;
        // }

    }
}
