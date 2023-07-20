class Solution {
    public int[] asteroidCollision(int[] as) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<as.length; i++){
            list.add(as[i]);
            
            while(list.size()>1 && list.get(list.size()-1)<0 && list.get(list.size()-2)>0){
                int last = list.remove(list.size()-1);
                int slast = list.remove(list.size()-1);
                
                if(Math.abs(last)>Math.abs(slast)){
                    list.add(last);
                }
                else if(Math.abs(last)<Math.abs(slast)){
                    list.add(slast);
                }
            }
        }
        
        return list.stream().mapToInt(i->i).toArray();
        
    }
}