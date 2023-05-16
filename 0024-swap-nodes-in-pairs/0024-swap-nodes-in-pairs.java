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
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode curr = head;
        ListNode prev = temp;
        
        while(curr!=null && curr.next!=null){
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = curr;
            
            prev = prev.next.next;
            curr = curr.next;
            
        }
        
        return temp.next;
    }
}