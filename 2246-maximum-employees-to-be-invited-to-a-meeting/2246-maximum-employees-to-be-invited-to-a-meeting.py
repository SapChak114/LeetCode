class Solution:
    def maximumInvitations(self, favorite: List[int]) -> int:
        n = len(favorite)
        followers = [[] for _ in range(n)]
        pairs = []
        for u, p in enumerate(favorite):
            followers[p].append(u)
            if u < p and favorite[p] == u:
                pairs.append((u, p))

        def go(u, time, run):
            if visited[u] != -1:
                if run == runs[u]:
                    return time - visited[u]
                return 0
            runs[u] = run
            visited[u] = time
            best = 0
            for v in followers[u]:
                root[v] = root[u]
                best = max(best, go(v, time + 1, run))
            return best

        def go2(u):
            best = 1
            for v in followers[u]:
                if v == favorite[u]:
                    continue
                best = max(best, 1 + go2(v))
            return best

        best = 0
        run = 0
        visited = [-1] * n
        root = [-1] * n
        runs = [-1] * n
        for u in range(n):
            if visited[u] == -1:
                root[u] = u
                best = max(best, go(u, 0, run))
            run += 1
        total = 0
        for u, v in pairs:
            total += go2(u) + go2(v)
        return max(best, total)