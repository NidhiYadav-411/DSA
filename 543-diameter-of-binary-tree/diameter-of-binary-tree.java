class Solution {

    static class Info {
        int diam;
        int ht;

        Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    private Info solve(TreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info left = solve(root.left);
        Info right = solve(root.right);

        int height = Math.max(left.ht, right.ht) + 1;

        // Diameter in nodes
        int diameter = Math.max(
                Math.max(left.diam, right.diam),
                left.ht + right.ht + 1
        );

        return new Info(diameter, height);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // Convert nodes to edges
        return solve(root).diam - 1;
    }
}