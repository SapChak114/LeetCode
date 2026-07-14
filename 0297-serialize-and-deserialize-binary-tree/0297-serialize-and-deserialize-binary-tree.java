/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    List<String> li;
    int i, n;
    String[] data;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        this.li = new ArrayList<>();
        dfs(root);
        return String.join(",", li);
    }

    void dfs(TreeNode root) {
        if (root == null) {
            li.add("N");
            return;
        }

        li.add(String.valueOf(root.val));
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.i = 0;
        this.n = data.length();
        this.data = data.split(",");
        return build();
    }

    TreeNode build() {
        if (data[i].equals("N")) {
            i++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(data[i]));
        i++;
        node.left = build();
        node.right = build();

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));