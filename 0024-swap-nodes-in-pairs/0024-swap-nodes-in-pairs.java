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
        if(head==null || head.next==null) return head;
        ListNode child = null;
        ListNode parent = null;
        ListNode temp = new ListNode(-1);
        ListNode t1 = temp;
        while(head!=null && head.next!=null){
            parent = head;
            child = head.next;
            
            t1.next = new ListNode(child.val);
            t1.next.next = new ListNode(parent.val);
            
            t1 = t1.next.next;
            head = head.next.next;
        }
        if(head!=null){
            t1.next = new ListNode(head.val);
        }
        
        return temp.next;
    }
}