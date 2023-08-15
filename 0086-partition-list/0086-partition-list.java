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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode prev1 = dummy1;
        ListNode prev2 = dummy2;
        
        while(head!=null){
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            if(temp.val<x){
                prev1.next = temp;
                prev1 = prev1.next;
            }else {
                prev2.next = temp;
                prev2 = prev2.next;
            }
        }
        
        prev1.next = dummy2.next;
        
        return dummy1.next;
    }
}