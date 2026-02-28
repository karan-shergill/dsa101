// https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

// Recursive
class Solution {

    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;

        maxPathSum(root, ans);
        return ans[0];
    }

    private int maxPathSum(TreeNode root, int[] ans) {
        if (root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = maxPathSum(root.left, ans);
        }
        if (root.right != null) {
            right = maxPathSum(root.right, ans);
        }

        // at curr node sum can have 4 cases
        // we will pick max of all 4 cases
        int currPathSum = Math.max(Math.max(left + right + root.val, root.val), Math.max(left + root.val, right + root.val));
        if (ans[0] < currPathSum) {
            ans[0] = currPathSum;
        }

        // return max of all 3 usecase
        return Math.max(root.val, Math.max(left + root.val, right + root.val));
    }
}
