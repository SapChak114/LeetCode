//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int n = s.length();
        if(n<k) return -1;
        int[] freq = new int[126];
        Set<Character> set = new HashSet<>();
        
        
        
        int start = 0;
        int endVal = 0, startVal = 0, max = 0;
        for(int end = 0; end<n; end++){
            freq[s.charAt(end)]++;
            set.add(s.charAt(end));
            
            while(set.size()>k){
                if(--freq[(int)s.charAt(start)]==0) set.remove(s.charAt(start));
                start++;
            }
            
            if(endVal-startVal<end-start){
                endVal = end;
                startVal = start;
            }
        }
        
        return endVal-startVal+1;
        
    }
}