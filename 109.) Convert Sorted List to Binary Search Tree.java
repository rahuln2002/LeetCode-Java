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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int length = findLength(head);
        current = head;

        return convertToBST(0, length - 1);
    }

    private int findLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    private TreeNode convertToBST(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode left = convertToBST(start, mid - 1);

        TreeNode root = new TreeNode(current.val);
        root.left = left;

        current = current.next;

        root.right = convertToBST(mid + 1, end);

        return root;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(log n)
*/
