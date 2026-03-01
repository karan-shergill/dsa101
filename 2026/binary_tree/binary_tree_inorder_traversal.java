// https://leetcode.com/problems/binary-tree-inorder-traversal/description/
// DFS

// Recursive
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
}

// Iterative
class Tree {
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)
            return arrayList;
            
        Stack<Node> stack = new Stack<>();
        Node currNode = root;
        
        while(stack.size() > 0 || currNode != null) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            if(stack.size() > 0) {
                currNode = stack.pop();
                arrayList.add(currNode.data);
                currNode = currNode.right;
            }
        }
        
        return arrayList;
    }
}
