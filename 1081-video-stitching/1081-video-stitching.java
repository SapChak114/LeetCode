class Solution {
    public int videoStitching(int[][] clips, int time) {

        Arrays.sort(clips, (a,b) -> a[0] - b[0]);

        int finalEvent = 0, n = clips.length, idx = 0, stich = 0;

        while (idx < n && finalEvent < time) {
            int currEvent = 0;

            while (idx < n && clips[idx][0] <= finalEvent) {
                currEvent = Math.max(currEvent, clips[idx][1]);
                idx++;
            }

            if (currEvent == 0) {
                return -1;
            }

            stich++;

            finalEvent = currEvent;
        }
        
        if (finalEvent < time) {
            return -1;
        }

        return stich;
    }
}
/**



 **/