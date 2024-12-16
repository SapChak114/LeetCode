from fractions import Fraction

class Solution:
    def maxAverageRatio(self, classes: List[List[int]], extra: int) -> float:
        import heapq
        heap = []

        def get_delta(p, t):
            pf = p/t
            pn = (p+1)/(t+1)
            delta = pn - pf
            return delta


        for p, t in classes:
            delta = get_delta(p, t)
            heapq.heappush(heap, [-delta, p, t])

        for _ in range(extra):
            _, p, t = heapq.heappop(heap)
            delta = get_delta(p+1, t+1)
            heapq.heappush(heap, [-delta, p+1, t+1])
        
        ans = 0

        for _, p, t in heap:
            ans += p/t
        
        return ans/len(classes)