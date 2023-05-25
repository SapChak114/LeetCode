class Pair{
    double first;
    int second;
    
    public Pair(double first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public double mincostToHireWorkers(int[] q, int[] w, int k) {
        
        List<Pair> workers = new ArrayList<>();
        for(int i = 0; i<q.length; i++){
            double first = (double)w[i]/q[i];
            workers.add(new Pair(first,q[i]));
        }
        
        Collections.sort(workers,new Comparator<Pair>(){
           public int compare(Pair a, Pair b){
               return Double.compare(a.first,b.first);
           } 
        });
        
        int sum=0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int a = 0; a<k; a++){
            sum += workers.get(a).second;
            maxHeap.add(workers.get(a).second);
        }
        
        double captainRatio = workers.get(k-1).first;
        double minCost = captainRatio * sum;
        
        for(int i = k; i<w.length; i++){
            captainRatio = workers.get(i).first;
            
            if(workers.get(i).second<maxHeap.peek()){
                sum -= maxHeap.poll();
                sum += workers.get(i).second;
                maxHeap.add(workers.get(i).second);
            }
            
            double cost = sum * captainRatio;
            minCost = Math.min(minCost,cost);
        }
        return minCost;
    }
}