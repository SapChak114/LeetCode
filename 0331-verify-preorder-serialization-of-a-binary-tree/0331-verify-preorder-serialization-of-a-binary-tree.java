class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    Queue<String> queue;
    boolean ans;
    public boolean isValidSerialization(String preorder) {
        this.queue = new LinkedList<>(new ArrayList<>(Arrays.asList(preorder.split(","))));
        this.ans = true;
        
        build();
        return ans && queue.isEmpty();
    }

    TreeNode build() {
        if (queue.isEmpty()) {
            ans = false;
            return null;
        }

        String val = queue.poll();
        if (val.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = build();
        node.right = build();
        return node;
    }
}