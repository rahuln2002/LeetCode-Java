/*
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode ln = new ListNode(0);
        ln.next = head;
        ListNode temp = ln;
        while(temp.next != null) {
            if(temp.next.val == val) {
                ListNode next = temp.next;
                temp.next = next.next; 
            }
            else {
                temp = temp.next;
            }
        }
        return ln.next;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(1)
*/
