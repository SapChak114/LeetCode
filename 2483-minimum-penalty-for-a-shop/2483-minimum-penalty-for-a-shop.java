class Solution {
    public int bestClosingTime(String cust) {
        int n = cust.length();
        int[] suffixY = new int[n];
        int[] preN = new int[n];
        int yCount = 0;
        int nCount = 0;
        
        if(cust.charAt(n-1)=='Y') suffixY[n-1] = 1;
        if(cust.charAt(0)=='N') preN[0] = 1;
        
        for(int i = 0; i<n; i++){
            if(cust.charAt(i)=='Y') yCount++;
            if(cust.charAt(i)=='N') nCount++;
            
            if(i!=0){
                int isY = 0;
                int isN = 0;
                if(cust.charAt(n-i-1)=='Y') isY = 1;
                if(cust.charAt(i)=='N') isN = 1;
                suffixY[n-i-1] = suffixY[n-i] + isY;
                preN[i] = preN[i-1] + isN;
            }
        }
        
        // if(yCount==n) return n;
        // if(nCount==n) return 0;
        
        int minLoss = Integer.MAX_VALUE;
        int minIndex = n;
        
        for(int i = 0; i<=n; i++){
            int yGonnaMiss = i==n?0:suffixY[i];
            int nOccuredTillNow = i==0?0:preN[i-1];
            //System.out.println(" i: "+i+" y: "+yGonnaMiss+" n: "+nOccuredTillNow);
            int currLoss = yGonnaMiss + nOccuredTillNow;
            if(currLoss<minLoss){
                //System.out.println(" i: "+i+" currLoss: "+currLoss+" minLoss: "+minLoss);
                minLoss = currLoss;
                minIndex = i;
            }
        }
        
        return minIndex;
        
    }
}