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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode i = head;
        ListNode j = head;
        for(int k = 0; k < n; k++) {
            if(j == null) {
                return head;
            }
            j = j.next;
        }
        if(j == null) {
            return head.next;
        }
        while(j.next != null) {
            i = i.next;
            j = j.next;
        }
        i.next = i.next.next;
        return head;
    }

}
/* Time Complexity: O(n)
* Space Complexity: O(1)
*/
