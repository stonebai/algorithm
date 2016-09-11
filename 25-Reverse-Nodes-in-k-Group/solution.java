/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode[] list = reverseK(head, k);
        ListNode res = list[0];
        ListNode tail = list[1];
        ListNode next = list[2];
        while (tail != null) {
            list = reverseK(next, k);
            tail.next = list[0];
            tail = list[1];
            next = list[2];
        }
        return res;
    }
    
    private ListNode[] reverseK(ListNode node, int k) {
        ListNode[] res = new ListNode[3];
        if (!lenK(node, k)) {
            res[0] = node;
            return res;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = node;
        ListNode next = null;
        while (k > 0) {
            next = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = next;
            k--;
        }
        res[0] = dummy.next;
        res[1] = tail;
        res[2] = next;
        return res;
    }
    
    private boolean lenK(ListNode node, int k) {
        while (node != null) {
            k--;
            if (k == 0) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}