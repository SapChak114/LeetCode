class Pair{
    int num1;
    int num2;
    
    public Pair(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
}
class Solution {
    public long maxScore(int[] num1, int[] num2, int k) {
        List<Pair> list = new ArrayList<>();
        
        for(int i = 0; i<num1.length; i++){
            list.add(new Pair(num1[i],num2[i]));
        }
        
        Collections.sort(list,new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return Integer.compare(b.num2,a.num2);
            }
        });
        
        long currentSum = 0;
        long ans = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i<k-1; i++){
            currentSum += list.get(i).num1;
            q.add(list.get(i).num1);
        }
        
        for(int i = k-1; i<num1.length; i++){
            currentSum += list.get(i).num1;
            q.add(list.get(i).num1);
            ans = Math.max(ans,currentSum*list.get(i).num2);
            currentSum -= q.poll();
        }
        
        return ans;
        
    }
    
}