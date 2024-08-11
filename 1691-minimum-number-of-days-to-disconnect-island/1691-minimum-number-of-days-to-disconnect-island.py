class Solution:
    def minDays(self, A: List[List[int]]) -> int:
        R, C = len(A), len(A[0])

        def neighbors(x, y):
            for r, c in ((x+1, y), (x,y+1), (x-1, y), (x,y-1)):
                if 0 <= r < R and 0 <= c < C and A[r][c] == 1:
                    yield r, c

        def islands():
            isl = 0
            seen = set()
            
            def dfs(r, c):
                for nr, nc in neighbors(r, c):
                    if (nr, nc) not in seen:
                        seen.add((nr, nc))
                        dfs(nr, nc)
                
            for r, c in product(range(R), range(C)):
                if (r, c) not in seen and A[r][c] == 1:
                    isl += 1
                    seen.add((r, c))
                    dfs(r, c)

            return isl != 1
        
        ones = sum(sum(row) for row in A)

        def find():
            ans = (-1, -1, -1)
            for r, c in product(range(R), range(C)):
                if A[r][c] == 0:
                    continue
                valid = len(list(neighbors(r, c)))
                ans = max(ans, (valid, r, c))
            
            _, r, c = ans
            A[r][c] = 0

        if islands():
            return 0

        for r, c in product(range(R), range(C)):
            if A[r][c] == 1:
                A[r][c] = 0
                if islands():
                    return 1
                A[r][c] = 1
        
        return 2