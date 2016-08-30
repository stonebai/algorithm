/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private ListNode head;
    private Random random;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int len = getLen(this.head);
        int rdm = this.random.nextInt(len);
        ListNode node = goNSteps(this.head, rdm);
        return node.val;
    }
    
    private static ListNode goNSteps(ListNode node, int n) {
        for (int i = 0;i < n;i++) {
            node = node.next;
        }
        return node;
    }
    
    private static int getLen(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */