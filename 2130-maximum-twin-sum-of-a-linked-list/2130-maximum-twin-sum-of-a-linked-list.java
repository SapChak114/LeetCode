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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        
        while(fast!=null){
            fast = fast.next.next;
            
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
            //System.out.println(slow.val+" "+prev.val);
        }
        //System.out.println();
        int res = Integer.MIN_VALUE;
        
        while(slow!=null){
            //System.out.println(slow.val+" "+prev.val);
            res = Math.max(res,(slow.val+prev.val));
            slow = slow.next;
            prev = prev.next;
        }
        
        return res;
    }
}