// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/

// Recursive
class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> allLevels = new ArrayList<>();
        if (root == null) {
            return allLevels;
        }

        zigzagLevelOrder(root, 1, allLevels);
        for (int i = 0; i < allLevels.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(allLevels.get(i));
            }
        }
        return allLevels;
    }

    private void zigzagLevelOrder(TreeNode root, int currLevel, List<List<Integer>> allLevels) {
        if (root == null) return;
        if (allLevels.size() < currLevel) {
            allLevels.add(new ArrayList<>());
        }
        allLevels.get(currLevel - 1).add(root.val);
        zigzagLevelOrder(root.left, currLevel + 1, allLevels);
        zigzagLevelOrder(root.right, currLevel + 1, allLevels);
    }
}

// Iterative - 1
class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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

        boolean reverse = false;
        for (List curr : ans) {
            if (reverse) {
                Collections.reverse(curr);
            }
            reverse = !reverse;
        }

        return ans;
    }
}

// Iterative - 2
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> allLevels = new LinkedList<>();
        if (root == null) {
            return allLevels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Boolean temp = false;

        while(!queue.isEmpty()) {
            int currSize = queue.size();
            List<Integer> currLevel = new LinkedList<>();

            while(currSize > 0) {
                TreeNode currNode = queue.poll();
                currLevel.add(currNode.val);

                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
                currSize--;
            }

            if (temp) {
                Collections.reverse(currLevel);
            }
            temp = !temp;
            allLevels.add(currLevel);
        }

        return allLevels;
    }
}
