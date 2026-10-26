class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[] prefix = new int[13];
        for (int i = 0; i<12; i++) {
            prefix[i+1] = prefix[i] + dayOfMonth[i];
        }

        int arriveAliceDay = calculateDayOfTheYear(arriveAlice, prefix);
        int leaveAliceDay = calculateDayOfTheYear(leaveAlice, prefix);
        int arriveBobDay = calculateDayOfTheYear(arriveBob, prefix);
        int leaveBobDay = calculateDayOfTheYear(leaveBob, prefix);

        return Math.max(0, Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1);
    }

    int calculateDayOfTheYear(String day, int[] prefixSum) {
        int month = Integer.parseInt(day.substring(0, 2));
        int date = Integer.parseInt(day.substring(3));

        return prefixSum[month - 1] + date;
    }
}