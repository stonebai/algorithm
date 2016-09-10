/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode node : lists) {
            q.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            cur.next = node;
            cur = node;
            if (node.next != null) {
                q.offer(node.next);
            }
        }
        return dummy.next;
    }
}