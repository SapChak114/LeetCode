class Pair implements Comparable<Pair>{
    int elem1;
    int elem2;
    
    public Pair(int elem1, int elem2){
        this.elem1=elem1;
        this.elem2=elem2;
    }
    
    public int compareTo(Pair p2){
        int set1 = this.elem1 + this.elem2;
        int set2 = p2.elem1 + p2.elem2;
        
        return Integer.compare(set1,set2);
    }
    
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        
        List<List<Integer>> res = new ArrayList<>();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int sum = nums1[i] + nums2[j];
                if(pq.size()<k) pq.add(new Pair(nums1[i],nums2[j]));
                else if((pq.peek().elem1+pq.peek().elem2)>sum){
                    pq.poll();
                    pq.add(new Pair(nums1[i],nums2[j]));
                } else{
                    break;
                }
            }
        }
        PriorityQueue<Pair> qp = new PriorityQueue<>(pq);
        while(k-- > 0 && !qp.isEmpty()){
            Pair p = qp.poll();
            List<Integer> li = new ArrayList<>();
            li.add(p.elem1);
            li.add(p.elem2);
            res.add(li);
        }
        // Collections.sort(res, (o1, o2) -> ((o1.get(0)+o1.get(1)) > (o2.get(0)+o2.get(1))) ? -1 :
        //                                ((o1.get(0)+o1.get(1)) < (o2.get(0)+o2.get(1))) ? 1 : 0);
        return res;
    }
}