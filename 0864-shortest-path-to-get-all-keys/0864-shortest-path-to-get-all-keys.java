class Pair{
    int x;
    int y;
    String keys;
    int steps;
    
    public Pair(int x, int y, String keys, int steps){
        this.x = x;
        this.y = y;
        this.keys = keys;
        this.steps = steps;
    }
    
    public String toString(){
        return x+" "+y+" "+keys;
    }
}

class Solution {
    int[] dirX = {0,1,0,-1};
    int[] dirY = {1,0,-1,0};
    
    public int shortestPathAllKeys(String[] grid) {
        List<List<Character>> li = new ArrayList<>();
        
        for(String s : grid){
            char[] ch = s.toCharArray();
            List<Character> cList = new ArrayList<>();
            for(int i = 0; i<ch.length; i++){
                cList.add(ch[i]);
            }
            li.add(cList);
        }
        
        int[] posOfAt = findPosOfAt(li);
        String ke = "";
        
        for(int i = 0; i<posOfAt[2]; i++){
            ke += "0";
        }
        
        Queue<Pair> q = new LinkedList<>();
        
        Set<String> set = new HashSet<>();
        
        Pair p = new Pair(posOfAt[0],posOfAt[1],ke,0);
        
        set.add(p.toString());
        
        q.add(p);
        
        while(!q.isEmpty()){
            Pair pp = q.poll();
            System.out.println(pp);
            int x = pp.x;
            int y = pp.y;
            String keys = pp.keys;
            int steps = pp.steps;
            
            for(int i = 0; i<dirX.length; i++){
                int ii = x + dirX[i];
                int jj = y + dirY[i];
                
                if(check(li,ii,jj)){
                    //System.out.println(li.get(ii).get(jj)+" "+ii+" "+jj);
                    if(isLock(li,ii,jj)){
                      //  System.out.println(keys);
                        int index = li.get(ii).get(jj)-65;
                        if(keys.charAt(index)=='1'){
                            Pair qp = new Pair(ii,jj,keys,steps+1);
                            if(set.contains(qp.toString())) continue;
                            q.add(qp);
                            set.add(qp.toString());
                        }
                    }
                    else if(isKey(li,ii,jj)){
                        int index = li.get(ii).get(jj)-97;
                        char[] ch = keys.toCharArray();
                        ch[index]='1';
                        //System.out.println(keys);
                        boolean flag = true;
                        for(char c : ch) if(c=='0') flag=false;
                        if(flag) return (steps + 1);
                        String key = new String(ch);
                        Pair qp = new Pair(ii,jj,key,steps+1);
                        if(set.contains(qp.toString())) continue;
                        q.add(qp);
                        set.add(qp.toString());
                    } else{
                        Pair qp = new Pair(ii,jj,keys,steps+1);
                        if(set.contains(qp.toString())) continue;
                        q.add(qp);
                        set.add(qp.toString());
                    }
                }
            }
        }
        
        return -1;
        
    }
    
    boolean isLock(List<List<Character>> li,int i, int j){
        if(li.get(i).get(j)>=65 && li.get(i).get(j)<=90) return true;
        return false;
    }
    
    boolean isKey(List<List<Character>> li,int i, int j){
        if(li.get(i).get(j)>=97 && li.get(i).get(j)<=122) return true;
        return false;
    }
    
    boolean check(List<List<Character>> ch, int i, int j){
        int n = ch.size();
        int m = ch.get(0).size();
        if(i<0 || j<0 || i>=n || j>=m || ch.get(i).get(j)=='#') return false;
        return true;
    }
    
    int[] findPosOfAt(List<List<Character>> ch){
        int a = 0;
        int b = 0;
        int keysCount = 0;
        for(int i = 0 ; i<ch.size(); i++){
            for(int j = 0; j<ch.get(i).size(); j++){
                if(ch.get(i).get(j)=='@'){
                    a=i;
                    b=j;
                }
                if(ch.get(i).get(j)>=97 && ch.get(i).get(j)<=122){
                    keysCount++;
                }
            }
        }
        
        return new int[]{a,b,keysCount};
    }
}