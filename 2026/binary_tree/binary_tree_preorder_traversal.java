// https://leetcode.com/problems/binary-tree-preorder-traversal/description/

// Recursive
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

// Iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) return preOrder;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            preOrder.add(currNode.val);

            if (currNode.right != null) stack.push(currNode.right);
            if (currNode.left != null) stack.push(currNode.left);
        }
        return preOrder;
    }
}
