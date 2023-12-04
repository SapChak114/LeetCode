class Solution {
    public String largestGoodInteger(String num) {
        char[] charArr = num.toCharArray();
        String ans = "";
        int count = 1;
        for(int i = 1; i<charArr.length; i++){
            if(charArr[i-1]==charArr[i]){
                count++;
            } else{
                count = 1;
            }
            if(count==3 && (ans.isEmpty() || Integer.valueOf(""+charArr[i])>Integer.valueOf(ans))){
                ans =""+charArr[i];
            }
        }
        
        ans += ans+""+ans;
        
        return ans;
    }
}