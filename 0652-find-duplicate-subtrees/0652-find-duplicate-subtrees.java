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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
class Solution {
    List<TreeNode> ans;
    Map<String, Integer> counter;
    MessageDigest digest; // SHA-256 instance

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.ans = new ArrayList<>();
        this.counter = new HashMap<>();

        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e); // Handle exception
        }

        dfs(root);
        return ans;
    }

    String dfs(TreeNode node) {
        if (node == null) {
            return "#";  // Unique identifier for null nodes
        }

        // Generate unique hash based on structure and value
        String subtree = dfs(node.left) + "," + node.val + "," + dfs(node.right);
        String hash = sha256(subtree);

        counter.put(hash, counter.getOrDefault(hash, 0) + 1);

        if (counter.get(hash) == 2) { // Add only the first time it becomes duplicate
            ans.add(node);
        }

        return hash;
    }

    // Generate SHA-256 hash for a given string
    private String sha256(String str) {
        byte[] hashBytes = digest.digest(str.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }
}