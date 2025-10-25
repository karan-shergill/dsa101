// https://leetcode.com/problems/binary-tree-preorder-traversal/description/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preorderTraversal(root, list);
        return list;
    }

    public void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }
    // Recursive Solution
    // TC: O(n)
    // SC: O(n)
}

// future todo: Iterative & Morris Traversal
