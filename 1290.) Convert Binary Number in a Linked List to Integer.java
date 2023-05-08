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
    public int getDecimalValue(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int n = list.size() - 1;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += list.get(i) * Math.pow(2, n - i);
        }
        return sum;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(n)
*/
