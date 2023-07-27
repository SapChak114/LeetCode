class Solution:
    def maxRunTime(self, n: int, batteries: List[int]) -> int:
        batteries.sort()
        
        def check(mins):
            total = 0
            computers = 0
            for time in batteries:
                total += time
                if total >= mins:
                    computers += 1
                    total -= mins
            
            return computers >= n
        
        left = 0
        right = 10**18
        
        while left < right:
            mid = left + right >> 1
            
            if check(mid):
                left = mid + 1
            else:
                right = mid
                
        return left - 1
            