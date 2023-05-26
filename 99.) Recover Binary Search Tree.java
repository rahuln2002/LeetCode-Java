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
    TreeNode firstElement;
    TreeNode secondElement;
    TreeNode prevElement;

    public void recoverTree(TreeNode root) {
        firstElement = null;
        secondElement = null;
        prevElement = null;

        inorderTraversal(root);

        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);

        if (prevElement != null && node.val < prevElement.val) {
            if (firstElement == null) {
                firstElement = prevElement;
            }
            secondElement = node;
        }
        prevElement = node;

        inorderTraversal(node.right);
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(h) or O(n) or O(log n)
*/
