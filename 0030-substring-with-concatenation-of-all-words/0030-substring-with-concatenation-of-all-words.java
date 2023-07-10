class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map = new HashMap<>();
        int bigWord = 0;
        
        for(int i = 0; i<words.length; i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
            bigWord += words[i].length();
        }
        
        int n = s.length();
        int len = words[0].length();
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            if(i + bigWord > n) break;
            
            String word = s.substring(i,i+bigWord);
            if(isPresent(word,map,len)){
                list.add(i);
            }
        }
        
        return list;
    }
    
    boolean isPresent(String bigWord, Map<String,Integer> map, int len){
        
        int n = bigWord.length();
        
        Map<String,Integer> newMap = new HashMap<>();
        
        for(int i = 0; i<n; i += len){
            String word = bigWord.substring(i,i+len);
            newMap.put(word,newMap.getOrDefault(word,0)+1);
        }
        
        return map.equals(newMap);
    }
}