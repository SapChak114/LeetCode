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
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        ListNode t1 = dummy;
        while (temp != null) {
            t1.next = new ListNode(temp.val);
            temp = temp.next;
            t1 = t1.next;
        }
        
        ListNode rev = reverse(head);
        ListNode t2 = dummy.next;
    
        while (rev != null && t2 != null) {
            if (rev.val == t2.val) {
                rev = rev.next;
                t2 = t2.next;
            } else {
                return false;
            }
        }

        if ((rev == null && t2 != null) || (rev != null && t2 == null)) {
            return false;
        }

        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }

        return prev;
    }
}