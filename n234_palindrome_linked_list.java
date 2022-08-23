package leetcode.dailychallenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class n234_palindrome_linked_list {
}

class Solution1 {
    public boolean isPalindrome(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (head.val != node.val)
                return false;
            head = head.next;
        }
        return true;
    }
}

class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    //反转链表
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //先获取当前节点的下一个节点
            ListNode nextTemp = curr.next;
            //再把当前节点的指针指向上一个节点
            curr.next = prev;
            //更新上一个节点为当前节点
            prev = curr;
            //更新当前节点为下一个节点
            curr = nextTemp;
        }
        //最后返回的就是翻转之前链表的尾巴，现在也就是头节点
        return prev;
    }

    //使用快慢指针找到链表的中心节点
    private ListNode endOfFirstHalf(ListNode head) {
        //快指针的速度是满指针的两倍
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}