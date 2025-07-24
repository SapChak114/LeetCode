class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Pair<Double, Integer>[] workers = new Pair[n];
        for(int i=0;i<n;i++){
            workers[i] = new Pair<>(1.0 * wage[i]/quality[i], quality[i]);
        }
        
        Arrays.sort(workers, (a,b) -> Double.compare((double)a.getKey(), (double)b.getKey()));
        
        PriorityQueue<Integer> pq =  new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        
        Double cost = Double.MAX_VALUE;
        int total = 0;
        for(var worker : workers){
            Double rate = worker.getKey();
            int _quality = worker.getValue();
            
            pq.offer(_quality);
            total += _quality;
            
            while(pq.size()>k){
                total -= pq.poll();
            }
            if(pq.size() == k){
                cost = Math.min(cost, total * rate);
            }
        }
        return cost;
    }
}
/**
quality = [10,20,5], wage = [70,50,30], k = 2

Pair {30 - 5, 50 - 20, 70 - 10}

1 -> 30, a = 30,
5 * 4 = 20 -> 30 * 4 = 120


10 - 70 -> 70/10 ->7
20 - rate * quality
cost = rate * quakity


     = 7 * 15
     = 105
 
 - [7, 2.5. 6]
 
 - [2.5,20  ,  6,5  , 7,10]
 - 
rate  =2.5     [20]
rate   6       [20,5] = 6 * 25 =  cost = 150.00
rate   7       [,5,10] = 7 * 15 = 105.00
*/