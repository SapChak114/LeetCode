class Solution {
   //List<List<Integer>> list;
    public List<Integer> getRow(int n) {
         List<Integer> list2 = new ArrayList<>();
        // pascal(n);
        // return list.get(n);
        list2.add(1);
        long curr = 1;
        for(int i = 1; i<=n; i++){
            long val = curr*(n-i+1);
            val /=i;
            curr = val;
            list2.add((int)curr);
        }
        
        return list2;
    }
    
//     void pascal(int n){
//         list.add(Arrays.asList(1));
        
//         for(int i = 1; i<=n; i++){
//             List<Integer> l = list.get(i-1);
//             List<Integer> l2 = new ArrayList<>();
//             l2.add(1);
//             for(int j = 0; j<l.size()-1; j++){
//                 int a = l.get(j);
//                 int b = l.get(j+1);
//                 l2.add((a+b));
//             }
//             l2.add(1);
//             list.add(l2);
//         }
//     }
}