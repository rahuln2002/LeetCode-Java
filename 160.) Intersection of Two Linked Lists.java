/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int m=0, n=0;
        ListNode currA = headA, currB = headB;
        while(currA != null){
            currA = currA.next;
            m++;
        }
        while(currB != null) {
            currB = currB.next;
            n++;
        }
        int k = Math.abs(n-m);
        if ( n > m ) {
            while(k>0) {
                headB = headB.next;
                k--;
            }
        }
        else {
            while(k>0) {
                headA = headA.next;
                k--;
            }
        }
        
        while(headA != headB && headA.next != null && headB.next != null) {
            headA = headA.next;
            headB = headB.next;
        }
        
        if(headA != headB) {
            return null;
        }
        return headA;
    }
}
/* Time Complexity: O(m+n)
* Space Complexity: O(1)
*/
