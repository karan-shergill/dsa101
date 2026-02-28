// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

// Recursive
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        
        if (root.left != null)
            root.left.next = root.right;
        
        if (root.right != null && root.next != null)
            root.right.next = root.next.left;
        
        connect(root.left);
        connect(root.right);
        return root;
    }
}

// Iterative
class Solution {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currSize = queue.size();

            while (currSize != 0) {
                currSize--;
                Node currNode = queue.poll();

                if (currSize != 0) {
                    currNode.next = queue.peek();
                }

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
        }

        return root;
    }
}
