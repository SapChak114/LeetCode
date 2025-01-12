class Solution:
    def canBeValid(self, s: str, locked: str) -> bool:
        if len(s) % 2 == 1:  # If the length is odd, it cannot be valid
            return False

        def helper(s, locked, ptype):
            bal = 0

            for char, lock in zip(s, locked):
                if lock == '0' or char == ptype:
                    bal += 1
                else:
                    bal -= 1
                if bal < 0:
                    return False
            
            return True
        
        return helper(s, locked, "(") and helper(reversed(s), reversed(locked), ")")