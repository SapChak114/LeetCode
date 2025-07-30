class Solution {
    private int cameraCount = 0;

    // State encoding:
    // 0: needs camera
    // 1: covered
    // 2: has camera
    public int dfs(TreeNode node) {
        if (node == null) return 1;  // Null nodes are covered

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == 0 || right == 0) {
            cameraCount++;
            return 2; // Place a camera here
        }
        if (left == 2 || right == 2) {
            return 1; // This node is covered (children have camera)
        }
        return 0; // This node needs a camera
    }

    public int minCameraCover(TreeNode root) {
        cameraCount = 0; // reset before each call
        if (dfs(root) == 0) {
            cameraCount++; // root itself needs a camera
        }
        return cameraCount;
    }
}