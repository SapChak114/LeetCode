class Solution:
    def strangePrinter(self, S):
        
        @cache
        def dp(i, j):
            if i > j: return 0
            ans = dp(i+1, j) + 1
            for k in range(i+1, j+1):
                if S[k] == S[i]:
                    ans = min(ans, dp(i, k-1) + dp(k+1, j))
            return ans

        return dp(0, len(S) - 1)