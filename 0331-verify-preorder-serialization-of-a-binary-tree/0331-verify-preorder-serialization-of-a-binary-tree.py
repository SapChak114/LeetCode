class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None
    
class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        queue = collections.deque(preorder.split(","))
        self.ans = True

        def build():
            if not queue:
                self.ans = False
                return None
            
            ch = queue.popleft()
            if ch == "#":
                return None

            node = TreeNode(ch)
            node.left = build()
            node.right = build()
            return node
        
        build()
        return self.ans and not queue