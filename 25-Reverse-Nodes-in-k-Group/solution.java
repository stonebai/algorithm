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
        while (tail != null) {
            list = reverseK(tail, k);
            tail.next = list[0];
            tail = list[1];
        }
        return res;
    }
    
    private ListNode[] reverseK(ListNode node, int k) {
        ListNode[] res = new ListNode[2];
        if (!lenK(node, k)) {
            res[0] = node;
            return res;
        }
        ListNode dummy = new ListNode(0);
        while (k > 0) {
            ListNode tmp = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = tmp;
            k--;
        }
        res[0] = dummy.next;
        res[1] = node;
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
    }
}