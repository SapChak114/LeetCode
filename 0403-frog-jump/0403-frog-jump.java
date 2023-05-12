class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        map.put(stones[0]+1,set);
        
        for(int i = 1; i<stones.length; i++){
            int pos = stones[i];
            System.out.println(pos);
            if(map.containsKey(pos)){
                Set<Integer> s0 = map.get(pos);
                System.out.println(s0);
                System.out.println();
                for(int it : new HashSet<>(s0)){
                    Set<Integer> s1 = map.get(pos + it);
                    if(s1!=null) s1.add(it);
                    else{
                        s1 = new HashSet<>();
                        s1.add(it);
                    }
                    map.put(pos + it,s1);
                    Set<Integer> s2 = map.get(pos + it+1);
                    if(s2!=null) s2.add(it+1);
                    else{
                        s2 = new HashSet<>();
                        s2.add(it+1);
                    }
                    map.put(pos + it+1,s2);
                    Set<Integer> s3 = map.get(pos + it-1);
                    if(s3!=null) s3.add(it-1);
                    else{
                        s3 = new HashSet<>();
                        s3.add(it-1);
                    }
                    map.put(pos + it-1,s3);
                }
            }
        }
        return map.containsKey(stones[stones.length-1]);
    }
}