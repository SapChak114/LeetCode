class Solution:
    def smallestSufficientTeam(self, req_skills: List[str], people: List[List[str]]) -> List[int]:

        n = len(people)
        m = len(req_skills)

        skills_to_index = {}
        for i, skill in enumerate(req_skills):
            skills_to_index[skill] = i
        
        target_mask = 0
        for i in range(m):
            target_mask = (target_mask << 1) + 1

        @cache
        def dp(i, mask):
            print(mask)
            if mask == target_mask:
                return []
            if i == n:
                return [-inf for _ in range(n)]

            dont_take = dp(i+1, mask)

            for skill in people[i]:
                s_i = skills_to_index[skill]
                mask = mask | (1 << s_i)
            take = [i] + dp(i+1, mask)
            

            if len(dont_take) < len(take):
                return dont_take
            else:
                return take

        res = dp(0, 0)
        return res