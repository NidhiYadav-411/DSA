/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public TreeNode canMerge(List<TreeNode> trees) {

        // Map root value -> root node
        Map<Integer, TreeNode> map = new HashMap<>();

        // Store all leaf values
        Set<Integer> leaves = new HashSet<>();

        for (TreeNode root : trees) {
            map.put(root.val, root);

            if (root.left != null) {
                leaves.add(root.left.val);
            }

            if (root.right != null) {
                leaves.add(root.right.val);
            }
        }

        // Find the root which is not a leaf of any tree
        TreeNode root = null;

        for (TreeNode tree : trees) {
            if (!leaves.contains(tree.val)) {
                if (root != null) {
                    return null; // More than one possible root
                }
                root = tree;
            }
        }

        if (root == null) {
            return null;
        }

        // Remove final root from map
        map.remove(root.val);

        // Merge and validate
        if (!dfs(root, Long.MIN_VALUE, Long.MAX_VALUE, map)) {
            return null;
        }

        // All trees must have been merged
        if (!map.isEmpty()) {
            return null;
        }

        return root;
    }

    private boolean dfs(TreeNode node,
                        long min,
                        long max,
                        Map<Integer, TreeNode> map) {

        if (node == null) {
            return true;
        }

        // Check BST property
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // If this node is a leaf and its value is another tree's root,
        // merge that tree here.
        if (node.left == null && node.right == null) {

            TreeNode tree = map.remove(node.val);

            if (tree != null) {
                node.left = tree.left;
                node.right = tree.right;
            }
        }

        return dfs(node.left, min, node.val, map)
            && dfs(node.right, node.val, max, map);
    }
}