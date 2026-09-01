class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;

        int l = 0, r = n-1, boat = 0;

        while (l <= r) {
            int weight = people[l] + people[r];

            if (weight <= limit) {
                l++;
                r--;
            } else {
                r--;
            }
            boat++;
        }

        return boat;
    }
}