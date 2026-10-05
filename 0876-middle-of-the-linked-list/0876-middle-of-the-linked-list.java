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
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        while (fast.next != null && fast.next.next != null) {
            //System.out.println("print");
            slow = slow.next;
            fast = fast.next.next;
        }

        return count % 2 == 1 ? slow : slow.next;
    }
}