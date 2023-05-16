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
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        
        if (count < k) {
            return head;
        }
        
        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;
        
        for (int i = 0; i < k; i++) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }
        
        return prev;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(1)
*/
