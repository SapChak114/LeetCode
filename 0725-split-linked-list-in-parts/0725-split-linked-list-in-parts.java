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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        
        ListNode temp = head;
        
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        
        ListNode[] node = new ListNode[k];
        
        int part = size/k;
        int rem = size%k;
        temp = head;
        
        for(int i = 0; i<k; i++){
            node[i] = temp;
            ListNode prev = temp;
            int j = 0;
            while(temp!=null && j++ <part+(rem>0?1:0)){
                prev = temp;
                temp = temp.next;
            }
            if(prev!=null) prev.next = null;
            rem--;
        }
        
        return node;
    }
}