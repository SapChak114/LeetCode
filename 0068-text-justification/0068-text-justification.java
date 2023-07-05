class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0;
        int n = words.length;
        
        List<String> res = new ArrayList<>();
        while(index < n){
            List<String> str = new ArrayList<>();
            int i = 0;
            int charCount=0;
            while(index<n && i+words[index].length() <= maxWidth){
                charCount += words[index].length();
                i += words[index].length()+1;
                str.add(words[index++]);
            }
            int spaces = maxWidth - charCount;
            int idx = 0;
            while(index!=n && spaces-- >0){
                str.set(idx,str.get(idx)+" ");
                idx = str.size()==1?0:(idx+1)%(str.size()-1);
            }
            if(index==n){
                for(int j = 0; j<str.size()-1; j++){
                    str.set(j,str.get(j)+" ");
                }
                spaces = spaces-str.size() + 1;
                //System.out.println(spaces+" "+charCount);
                while(spaces-- >0){
                    str.set(str.size()-1,str.get(str.size()-1)+" ");
                }
            }
            String st = "";
            for(int j = 0; j<str.size(); j++){
                st += str.get(j);
            }
            
            res.add(st);
        }
        
        return res;
    }
}