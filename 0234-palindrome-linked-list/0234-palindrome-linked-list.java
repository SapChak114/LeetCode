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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = rev(slow);

        ListNode temp = head;
        ListNode temp2 = newHead;

        while (temp2 != null) {
            System.out.println(temp.val + "  "+ temp2.val);
            if (temp.val != temp2.val) {
                return false;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }

        return true;
    }

    ListNode rev(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        return prev;
    }
}