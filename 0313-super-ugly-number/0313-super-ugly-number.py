class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        heap = [1]
        ith = 0
        seen = {1}

        while heap:
            ugly = heapq.heappop(heap)
            ith += 1
            if ith == n:
                return ugly

            for p in primes:
                nugly = ugly * p
                if nugly in seen: continue
                seen.add(nugly)
                heapq.heappush(heap, nugly)
        
        return -1