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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No need to reorder for empty or single-node lists
        }
        
        ListNode oddHead = head; // Head of odd-indexed list
        ListNode evenHead = head.next; // Head of even-indexed list
        ListNode oddTail = oddHead; // Tail of odd-indexed list
        ListNode evenTail = evenHead; // Tail of even-indexed list
        
        while (evenTail != null && evenTail.next != null) {
            oddTail.next = evenTail.next; // Link odd-indexed nodes
            oddTail = oddTail.next;
            evenTail.next = oddTail.next; // Link even-indexed nodes
            evenTail = evenTail.next;
        }
        
        oddTail.next = evenHead; // Attach even-indexed list at the end of odd-indexed list
        
        return oddHead;
        
        
    }
}