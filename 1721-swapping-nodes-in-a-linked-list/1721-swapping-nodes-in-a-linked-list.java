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
    public ListNode swapNodes(ListNode head, int k) {
        int count = 0;
        ListNode temp = head;
        ListNode t1 = head;
        ListNode t2 = head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        int n=k;
        k--;
        while(k--!=0) t2 = t2.next;
        while((count-n)!=0){
            t1 = t1.next;
            count--;
        }
        
        int t = t2.val;
        t2.val = t1.val;
        t1.val = t;
        
        return head;
    }
}