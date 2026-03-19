class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        if not points:
            return 0
    
        # Sort by end coordinate (sweep left to right)
        points.sort(key=lambda x: x[1])
        
        arrows = 1
        arrow_pos = points[0][1]  # Shoot at end of first balloon
        
        for start, end in points[1:]:
            # Current balloon not covered by last arrow
            if start > arrow_pos:
                arrows += 1
                arrow_pos = end  # Shoot at end of this balloon
        
        return arrows
        