class Solution:
    def isCovered(self, ranges: list[list[int]], left: int, right: int) -> bool:
        diff = [0] * 52

        for start, end in ranges:
            diff[start] += 1
            diff[end + 1] -= 1

        active = 0
        for i in range(1, 51):
            active += diff[i]
            if left <= i <= right and active == 0:
                return False

        return True