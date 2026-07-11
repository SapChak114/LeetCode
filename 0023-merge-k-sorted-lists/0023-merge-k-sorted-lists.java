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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for (ListNode node : lists) {
            ListNode temp = node;
            while (temp != null) {
                ListNode temp2 = temp.next;
                temp.next = null;
                pq.add(temp);
                temp = temp2;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();

            prev.next = temp;
            prev = temp;
        }

        return dummy.next;
    }
}