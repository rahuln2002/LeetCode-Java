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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
        if (inStart > inEnd || postEnd < 0) {
            return null;
        }

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        int rootIndexInorder = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndexInorder = i;
                break;
            }
        }

        int rightSubtreeSize = inEnd - rootIndexInorder;

        root.right = buildTreeHelper(inorder, postorder, rootIndexInorder + 1, inEnd, postEnd - 1);
        root.left = buildTreeHelper(inorder, postorder, inStart, rootIndexInorder - 1, postEnd - rightSubtreeSize - 1);

        return root;
    }
}
/* Time Complexity: O(n)
* Space Complexity: O(n)
*/
