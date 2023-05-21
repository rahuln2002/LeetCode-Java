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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        
        ListNode temp = new ListNode(0);
        temp.next = head;
        
        ListNode prev = temp;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        
        ListNode curr = prev.next;
        for (int i = left; i < right; i++) {
            ListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }
        
        return temp.next;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(1)
*/
