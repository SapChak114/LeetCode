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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pnodeLeft = dummy;
        ListNode lnode = head;
        
        while(left>1){
            pnodeLeft = lnode;
            lnode = lnode.next;
            left--;
            right--;
        }
        
        ListNode pnodeRight = lnode;
        ListNode rnode = lnode.next;
        
        while(right>1){
            pnodeRight = rnode;
            rnode = rnode.next;
            right--;
        }
        
        pnodeLeft.next = null;
        pnodeRight.next = null;
        
        lnode = reverse(lnode);
        
        pnodeLeft.next = lnode;
        
        while(lnode!=null && lnode.next!=null){
            lnode = lnode.next;
        }
        
        lnode.next = rnode;
        
        return dummy.next;
    }
    
    ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            
            prev = head;
            head = temp;
        }
        return prev;
    }
}