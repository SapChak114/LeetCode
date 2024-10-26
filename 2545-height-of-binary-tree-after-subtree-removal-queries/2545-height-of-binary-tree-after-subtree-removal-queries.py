# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def treeQueries(self, root: Optional[TreeNode], queries: List[int]) -> List[int]:
        prefix = Counter()
        suffix = Counter()

        def pre_order(node, height = 0):
            if not node:
                return
            
            prefix[node.val] = self.max_height
            self.max_height = max(self.max_height, height)

            pre_order(node.left, height+1)
            pre_order(node.right, height+1)
        
        def suf_order(node, height = 0):
            if not node:
                return
            
            suffix[node.val] = self.max_height
            self.max_height = max(self.max_height, height)

            suf_order(node.right, height+1)
            suf_order(node.left, height+1)
        
        self.max_height = 0
        pre_order(root)
        self.max_height = 0
        suf_order(root)

        return [max(prefix[val], suffix[val]) for val in queries]