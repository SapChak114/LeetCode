class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(-1);
        ListNode greaterHead = new ListNode(-1);
        ListNode lessTail = lessHead;
        ListNode greaterTail = greaterHead;

        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = null;

            if (temp.val < x) {
                lessTail.next = temp;
                lessTail = lessTail.next;
            } else {
                greaterTail.next = temp;
                greaterTail = greaterTail.next;
            }
        }

        lessTail.next = greaterHead.next;

        return lessHead.next;
    }
}
