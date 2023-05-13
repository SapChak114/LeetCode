class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        map.put(stones[0]+1,set);
        
        for(int i = 1; i<stones.length; i++){
            int pos = stones[i];
            if(map.containsKey(pos)){
                for(int it : new HashSet<>(map.get(pos))){
                    Set<Integer> set1 = map.get(pos+it);
                    if(set1!=null){
                        set1.add(it);
                    } else{
                        set1 = new HashSet<>();
                        set1.add(it);
                    }
                    map.put(pos+it,set1);
                    Set<Integer> set2 = map.get(pos+it+1);
                    if(set2!=null){
                        set2.add(it+1);
                    } else{
                        set2 = new HashSet<>();
                        set2.add(it+1);
                    }
                    map.put(pos+it+1,set2);
                    Set<Integer> set3 = map.get(pos+it-1);
                    if(set3!=null){
                        set3.add(it-1);
                    } else{
                        set3 = new HashSet<>();
                        set3.add(it-1);
                    }
                    map.put(pos+it-1,set3);
                }
            }
        }
        return map.containsKey(stones[stones.length-1]);
    }
}