class Solution {
    public String minWindow(String A, String B) {
//         int left = 0, right = 0, count = 0, len = 0, start = -1, end = 100007;
//         int n = t.length(), m = s.length();
        
//         if(n>m) return "";
        
//         Map<Character,Integer> map = new HashMap<>();
        
//         for(int i = 0; i<n; i++){
//             char c = t.charAt(i);
//             map.put(c, map.getOrDefault(c,0)+1);
//         }
        
//         while(right<m){
//             char c = s.charAt(right);
//             if(map.containsKey(c)){
//                 if(map.get(c)>0){
//                     count++;
//                 }
//                 map.put(c,map.getOrDefault(c,0)-1);
//             }
            
//             while(count==n){
//                 if(right-left+1 < end-start+1){
//                     start = left;
//                     end = right;
//                 }
                
//                 char lc = s.charAt(left);
//                 if(map.containsKey(lc)){
//                     map.put(lc,map.getOrDefault(lc,0)+1);
//                     if(map.get(lc)>0){
//                         count--;
//                     }
//                 }
//                 left++;
//             }
            
//             right++;
//         }
//         if(start==-1) return "";
//         return s.substring(start,end+1);
        
         if(A==null || B==null || A.isEmpty() || B.isEmpty()) return "";
        int i = 0, j = 0, size=A.length(), minI=0, minJ=0;
        boolean def=false;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int x = 0 ; x<B.length(); x++) {
            char c = B.charAt(x);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }
        int need = map.size();
        while(j<A.length()){
            char endChar = A.charAt(j++);
            if(map.containsKey(endChar)){
                map.put(endChar,map.get(endChar)-1);
                if(map.get(endChar)==0) need--; 
            }
            if(need>0) continue;
            while(need==0){
                char startChar = A.charAt(i++);
                if(map.containsKey(startChar)){
                    map.put(startChar,map.get(startChar)+1);
                    if(map.get(startChar)>0) need++;
                }
            }
            if(size>j-i){
                size=j-i;
                minI=i;
                minJ=j;
                def=true;
            }
        }
        return (!def)?(""):(A.substring(minI-1,minJ));
    }
    
    
}