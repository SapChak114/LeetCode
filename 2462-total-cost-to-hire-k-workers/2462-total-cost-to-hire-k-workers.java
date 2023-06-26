class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> firstHalf = new PriorityQueue<>();
        PriorityQueue<Integer> secondHalf = new PriorityQueue<>();
        
        int i = 0, j = costs.length-1;
        
        while(i<candidates && j>=i){
            firstHalf.add(costs[i++]);
            if(j>=i) secondHalf.add(costs[j--]);
        }
        long res = 0;
        while(k-- >0){
            int first = firstHalf.size()==0?Integer.MAX_VALUE:firstHalf.peek();
            int second = secondHalf.size()==0?Integer.MAX_VALUE:secondHalf.peek();
            if(first<=second){
                res += firstHalf.poll();
                if(i<=j) firstHalf.add(costs[i++]);
            } else{
                res += secondHalf.poll();
                if(i<=j) secondHalf.add(costs[j--]);
            }
        }
        return res;
    }
}