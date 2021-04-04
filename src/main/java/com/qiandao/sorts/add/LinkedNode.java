package com.qiandao.sorts.add;

import java.util.ArrayList;
import java.util.Stack;

public class LinkedNode {

    /**
     * 翻转链表
     */
    public class Solution {
        public ListNode ReverseList(ListNode head) {
            ListNode pre = null;
            ListNode next;
            ListNode curr = head;
            while (curr != null) {
                next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }

    /**
     * 按链表从尾到头的顺序返回一个ArrayList
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode temp = listNode;
        if (temp == null) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack();
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        ArrayList <Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    /**
     * 输出该链表中倒数第k个结点
     * @param pHead
     * @param k
     * @return
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        ListNode first = pHead;
        for (int i = 0; i < k; i++) {
            if (first == null) {
                return first;
            }
            first = first.next;
        }
        ListNode last = pHead;
        while (first != null) {
            first = first.next;
            last = last.next;
        }
        return last;
    }

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，
     * 合成后的链表满足单调不减规则。
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode heard = new ListNode(-1);
        ListNode curr = heard;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        if (list1 != null) {
            curr.next = list1;
        }
        return heard.next;
    }

    /**
     * 找出两个链表的第一个公共结点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead2 == null || pHead1 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
