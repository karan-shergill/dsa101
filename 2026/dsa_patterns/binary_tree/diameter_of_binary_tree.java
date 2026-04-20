// https://leetcode.com/problems/diameter-of-binary-tree/description/

// Recursive
class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = 0;

        diameterOfBinaryTree(root, ans);
        return ans[0];
    }

    private int diameterOfBinaryTree(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = 1 + diameterOfBinaryTree(root.left, ans);
        }
        if (root.right != null) {
            right = 1 + diameterOfBinaryTree(root.right, ans);
        }

        int currDiameter = left + right;
        if (ans[0] < currDiameter) {
            ans[0] = currDiameter;
        }

        return Math.max(left, right);
    }
}

