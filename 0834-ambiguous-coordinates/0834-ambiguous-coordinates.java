class Solution {
    List<String> result = new ArrayList<>();
    public List<String> ambiguousCoordinates(String s) {
        s=s.substring(1,s.length()-1);
        //Breaking String in x,y form (0123) -> (0,123)
        for(int i = 1; i < s.length(); i++) {
            helper(s.substring(0,i), s.substring(i));
        }
        return result;
    }
    
    public void helper(String x, String y){
        List<String> dotx = putDot(x);
        List<String> doty = putDot(y);
        
        for(String dx : dotx){
            if(isValid(dx)) {
                for(String dy : doty){
                    if(isValid(dy)) {
                        result.add("("+dx+", "+dy+")"); //(1, 23)
                    }
                }
            }
        }
    }
    
    public List<String> putDot(String s){
        List<String> res = new ArrayList<>();
        res.add(s);
        for(int i = 1; i < s.length(); i++) {
            res.add(s.substring(0,i)+"."+s.substring(i));
        }
        return res;
    }
    
    public boolean isValid(String s) {
        if(s.contains(".")) {
            String[] part = s.split("\\.");
            if(!part[0].equals("0") && part[0].startsWith("0")) return false;
            else return !part[1].endsWith("0");
        }
        else {
            if(s.equals("0")) return true;
            else return !s.startsWith("0");
        }
    }
}