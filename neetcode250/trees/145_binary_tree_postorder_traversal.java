// https://leetcode.com/problems/binary-tree-postorder-traversal/description/

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        postorderTraversal(root, list);
        return list;
    }

    public void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }
    // Recursive Solution
    // TC: O(n)
    // SC: O(n)
}

// future todo: Iterative & Morris Traversal
