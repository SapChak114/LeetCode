# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head):
        prev = None
        while head:
            curr = head
            head = head.next
            curr.next = prev
            prev = curr
        return prev
    
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        pnodeleft = dummy = ListNode(-1, head)
        nodeleft = head
        
        for _ in range(left-1):
            pnodeleft = nodeleft
            nodeleft = nodeleft.next
            
        pnoderight = None
        noderight = head
        
        for _ in range(right):
            pnoderight = noderight
            noderight = noderight.next
        
        pnodeleft.next = None
        pnoderight.next = None
        
        nodeleft = self.reverseList(nodeleft)
        
        pnodeleft.next = nodeleft
        
        while nodeleft and nodeleft.next:
            nodeleft = nodeleft.next
            
        nodeleft.next = noderight

        return dummy.next
            
            