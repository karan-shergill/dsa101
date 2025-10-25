// https://leetcode.com/problems/binary-tree-inorder-traversal/description/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorderTraversal(root, list);
        return list;
    }

    public void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
    // Recursive Solution
    // TC: O(n)
    // SC: O(n)
}

// future todo: Iterative & Morris Traversal
