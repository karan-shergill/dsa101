// https://leetcode.com/problems/binary-tree-postorder-traversal/description/

// Recursive
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

// Iterative
class Tree
{
    ArrayList<Integer> postOrder(Node root)
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)
            return arrayList;
            
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        
        stack1.push(root);
        
        while (stack1.size() > 0) {
            Node curr = stack1.pop();
            stack2.push(curr);
            
            if (curr.left != null)
                stack1.push(curr.left);
            if (curr.right != null)
                stack1.push(curr.right);
        }
        
        while (stack2.size() > 0) {
            Node curr = stack2.pop();
            arrayList.add(curr.data);
        }
        return arrayList;
    }
}
