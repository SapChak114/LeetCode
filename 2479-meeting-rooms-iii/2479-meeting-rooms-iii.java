class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        for(int i = 0; i<n; i++){
            availableRooms.add(i);
        }

        Arrays.sort(meetings,(a,b)->a[0]-b[0]);

        int[] count = new int[n];
        for(int i = 0; i<meetings.length; i++){
            int start = meetings[i][0];
            int end = meetings[i][1];
            while(!busyRooms.isEmpty() && busyRooms.peek()[0]<=start){
                int[] pair = busyRooms.poll();
                availableRooms.add(pair[1]);
            }

            int room = -1;
            if(!availableRooms.isEmpty()){
                room = availableRooms.poll();
                busyRooms.add(new int[]{end,room});
            } else{
                int[] pair = busyRooms.poll();
                room = pair[1];
                busyRooms.add(new int[]{(pair[0]+(end-start)),room});
            }
            count[room]++;
        }

        int max = Arrays.stream(count).max().getAsInt();
        for(int i = 0; i<n; i++){
            if(count[i]==max){
                return i;
            }
        }

        return 0;
    }
}