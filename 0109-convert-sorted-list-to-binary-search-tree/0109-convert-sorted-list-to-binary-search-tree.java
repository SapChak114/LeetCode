/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode curr;
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        this.curr = head;
        return getTree(0, size - 1);
    }

    TreeNode getTree(int start, int end) {
        if (start > end) {
            return null;
        }

        if (curr == null) {
            return null;
        }

        int mid = (start + end) >> 1;

        TreeNode left = getTree(start, mid - 1);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = getTree(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }

    int getSize(ListNode head) {
        if (head == null) {
            return 0;
        }

        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }

        return size;
    }
}