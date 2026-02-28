// https://www.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1

// Recursive
class Tree {
    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();

            while(currNode != null) {
                ans.add(currNode.data);

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }

                currNode = currNode.right;
            }
        }

        return ans;
    }
}
