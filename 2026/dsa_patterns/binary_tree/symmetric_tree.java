// https://leetcode.com/problems/symmetric-tree/description/

// Recursive
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        boolean left = isSameTree(p.left, q.right);
        boolean right = isSameTree(p.right, q.left);

        return left && right;
    }
}

//Iterative
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root, root);
    }
    
    public boolean isSymmetricHelper(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root1);
        queue2.add(root2);

        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode curr1 = queue1.remove();
            TreeNode curr2 = queue2.remove();

            if (curr1.val != curr2.val)
                return false;

            if (curr1.left != null && curr2.right != null) {
                queue1.add(curr1.left);
                queue2.add(curr2.right);
            } else if (curr1.left != null || curr2.right != null) {
                return false;
            }

            if (curr1.right != null && curr2.left != null) {
                queue1.add(curr1.right);
                queue2.add(curr2.left);
            } else if (curr1.right != null || curr2.left != null) {
                return false;
            }
        }
        return true;
    }
}
