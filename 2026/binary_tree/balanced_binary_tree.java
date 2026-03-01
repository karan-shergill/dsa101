// https://leetcode.com/problems/balanced-binary-tree/description/

// DFS
// Recursive
class Solution {

    public boolean isBalanced(TreeNode root) {
        boolean[] ans = new boolean[1];
        ans[0] = true;

        isBalanced(root, ans);
        return ans[0];
    }

    public int isBalanced(TreeNode root, boolean[] ans) {
        if (root == null) {
            return 0;
        }

        int left = 1 + isBalanced(root.left, ans);
        int right = 1 + isBalanced(root.right, ans);

        if (ans[0]) {
            ans[0] = Math.abs(left - right) <= 1;
        }

        return Math.max(left, right);
    }
}
