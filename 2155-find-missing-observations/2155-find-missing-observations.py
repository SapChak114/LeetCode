class Solution:
    def missingRolls(self, rolls: List[int], mean: int, n: int) -> List[int]:
        m = len(rolls)
        total = mean * (m + n)
        make = total - sum(rolls)

        ans = []
        size = n

        for _ in range(n):
            avg = make//size
            ans.append(avg)
            size -= 1
            make -= avg
        
        for val in ans:
            if not 1 <= val <= 6:
                return []

        return ans
