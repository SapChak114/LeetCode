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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head, tem = head;
        int t = 1;
        int count = 0;
        while(tem!=null){
            tem = tem.next;
            count++;
        }
        if(count==1) return null;
        if(n==count) return head.next;
        System.out.println(count+" "+n);
        ListNode prev = null;
        while(temp!=null){
            prev = temp;
            temp = temp.next;
            t++;
            if(t==(count-n+1)){
                System.out.println(prev.val+" "+temp.val);
                prev.next = temp.next;
                break;
            }
        }
        
        return head;
    }
}