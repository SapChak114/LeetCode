class Solution:
    def poorPigs(self, buckets: int, minutesToDie: int, minutesToTest: int) -> int:
        pigs=0
        trails = minutesToTest//minutesToDie
        while(pow((trails+1),pigs)<buckets):
            pigs+=1
        return pigs 