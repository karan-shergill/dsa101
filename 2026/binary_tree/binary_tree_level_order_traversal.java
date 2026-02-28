// https://leetcode.com/problems/binary-tree-level-order-traversal/description/

// Recursive
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> valueAtLevel = new ArrayList<>();

        levelOrder(root, valueAtLevel, 0);
        return valueAtLevel;
    }

    private void levelOrder(TreeNode root, List<List<Integer>> valueAtLevel, int currLevel) {
        if (root == null) {
            return;
        }

        if (valueAtLevel.size() == currLevel) {
            valueAtLevel.add(new ArrayList<>());
        }

        valueAtLevel.get(currLevel).add(root.val);

        levelOrder(root.left, valueAtLevel, currLevel + 1);
        levelOrder(root.right, valueAtLevel, currLevel + 1);
    }
}


// Iterative
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int currSize = queue.size();

            List<Integer> list = new ArrayList<>();
            while (currSize != 0) {
                TreeNode currNode = queue.poll();
                list.add(currNode.val);

                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
                currSize--;
            }

            ans.add(list);
        }

        return ans;
    }
}
