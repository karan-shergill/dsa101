// https://leetcode.com/problems/invert-binary-tree/description/

// Recursive
class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

// Iterative
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        
        while (que.size() > 0) {
            TreeNode curr = que.remove();
            
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            
            if (curr.left != null) {
                que.add(curr.left);
            }
            
            if (curr.right != null) {
                que.add(curr.right);
            }
        }
        
        return root;
    }
}
