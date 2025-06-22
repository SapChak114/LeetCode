class Solution:
    def isValidSerialization(self, preorder: str) -> bool:
        degree = 1 # to handle the root
        # diff b/w indegree and outdegree
        # outdegree - indegree

        if preorder.startswith("#") and len(preorder) != 1:
            return False

        for node in preorder.split(","):
            degree -= 1
            if degree < 0:
                return False

            if node != "#":
                degree += 2
        
        return degree == 0