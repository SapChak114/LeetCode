class Solution:
    def longestObstacleCourseAtEachPosition(self, nums: List[int]) -> List[int]:
        
        LIS = [float("inf")] * len(nums)
        lengths = []
        
        for num in nums:
            idx = bisect.bisect_left(LIS, num + 1)
            LIS[idx] = num
            lengths.append(idx+1)
            
        return lengths