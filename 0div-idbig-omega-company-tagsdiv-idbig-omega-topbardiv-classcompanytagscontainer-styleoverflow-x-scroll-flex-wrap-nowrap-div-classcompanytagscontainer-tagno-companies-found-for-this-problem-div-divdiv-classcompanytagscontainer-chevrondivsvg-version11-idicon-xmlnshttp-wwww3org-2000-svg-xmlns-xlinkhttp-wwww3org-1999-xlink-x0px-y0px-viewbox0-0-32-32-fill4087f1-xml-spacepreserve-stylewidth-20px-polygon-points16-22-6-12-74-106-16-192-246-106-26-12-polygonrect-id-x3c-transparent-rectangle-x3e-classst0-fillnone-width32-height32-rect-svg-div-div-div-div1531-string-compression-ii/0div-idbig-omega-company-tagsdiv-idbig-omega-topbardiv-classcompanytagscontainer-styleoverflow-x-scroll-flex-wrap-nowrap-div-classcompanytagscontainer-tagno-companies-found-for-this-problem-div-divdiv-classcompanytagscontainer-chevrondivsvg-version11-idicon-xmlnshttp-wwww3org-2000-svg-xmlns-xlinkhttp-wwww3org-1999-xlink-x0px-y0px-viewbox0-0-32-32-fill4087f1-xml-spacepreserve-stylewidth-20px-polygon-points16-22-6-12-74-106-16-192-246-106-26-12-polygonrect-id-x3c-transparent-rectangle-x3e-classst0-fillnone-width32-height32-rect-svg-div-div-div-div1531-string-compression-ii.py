class Solution:
    def getLengthOfOptimalCompression(self, s: str, k: int) -> int:
        
        def cost(streak):
            if streak == 0:
                return 0
            if streak == 1:
                return 1
            if streak <= 9:
                return 2
            if streak <= 99:
                return 3
            return 4
        
        @cache
        def dfs(index, pchar, delete, streak):
            if index >= len(s):
                return cost(streak)
            
            mincost = inf
            char = s[index]
            
            # Take
            if char == pchar:
                mincost = min(mincost, dfs(index+1, char, delete, streak + 1))
            else:
                mincost = min(mincost, cost(streak) + dfs(index+1, char, delete, 1))
            
            # Dont take
            if delete > 0:
                mincost = min(mincost, dfs(index+1, pchar, delete - 1, streak))
                
            return mincost
        
        return dfs(0, '#', k, 0)
