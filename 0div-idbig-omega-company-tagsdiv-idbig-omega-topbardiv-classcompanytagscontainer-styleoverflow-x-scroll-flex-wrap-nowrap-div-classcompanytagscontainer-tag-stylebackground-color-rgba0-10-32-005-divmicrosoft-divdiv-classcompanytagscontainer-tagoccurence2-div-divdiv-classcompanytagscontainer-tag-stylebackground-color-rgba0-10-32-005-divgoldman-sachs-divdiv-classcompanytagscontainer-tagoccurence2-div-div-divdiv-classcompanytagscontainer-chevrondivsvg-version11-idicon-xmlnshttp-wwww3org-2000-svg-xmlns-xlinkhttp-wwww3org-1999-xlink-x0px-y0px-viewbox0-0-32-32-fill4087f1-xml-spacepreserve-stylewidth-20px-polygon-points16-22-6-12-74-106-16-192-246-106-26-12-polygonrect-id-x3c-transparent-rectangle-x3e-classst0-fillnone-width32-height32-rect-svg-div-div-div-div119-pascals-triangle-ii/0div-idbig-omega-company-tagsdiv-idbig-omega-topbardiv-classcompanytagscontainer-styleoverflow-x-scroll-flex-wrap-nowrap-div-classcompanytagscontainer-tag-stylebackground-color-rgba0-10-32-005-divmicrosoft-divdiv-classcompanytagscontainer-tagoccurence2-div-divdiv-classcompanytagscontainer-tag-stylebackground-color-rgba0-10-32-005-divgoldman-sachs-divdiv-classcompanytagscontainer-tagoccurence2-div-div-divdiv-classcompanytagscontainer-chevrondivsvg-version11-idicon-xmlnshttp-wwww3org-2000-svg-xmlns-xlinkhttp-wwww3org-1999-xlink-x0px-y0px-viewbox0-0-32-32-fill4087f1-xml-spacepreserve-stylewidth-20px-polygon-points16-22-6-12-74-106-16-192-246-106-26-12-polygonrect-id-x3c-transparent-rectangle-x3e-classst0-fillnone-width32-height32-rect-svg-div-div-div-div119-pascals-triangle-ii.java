class Solution {
    List<List<Integer>> list;
    public List<Integer> getRow(int rowIndex) {
        list = new ArrayList<>();
        pascal(rowIndex);
        return list.get(rowIndex);
    }
    
    void pascal(int n){
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(1,1));
        
        for(int i = 2; i<=n; i++){
            List<Integer> l = list.get(i-1);
            List<Integer> l2 = new ArrayList<>();
            l2.add(1);
            for(int j = 0; j<l.size()-1; j++){
                int a = l.get(j);
                int b = l.get(j+1);
                l2.add((a+b));
            }
            l2.add(1);
            list.add(l2);
        }
    }
}