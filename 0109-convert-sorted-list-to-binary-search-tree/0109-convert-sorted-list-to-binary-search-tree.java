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
        if (head == null) {
            return null;
        }

        int size = getSize(head);
        this.curr = head;

        return convertToBst(0, size-1);
    }

    int getSize(ListNode head) {
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }

        return size;
    }

    TreeNode convertToBst(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start+end) >> 1;
        TreeNode left = convertToBst(start, mid-1);

        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;

        TreeNode right = convertToBst(mid+1, end);

        root.left = left;
        root.right = right;

        return root;

    }
}