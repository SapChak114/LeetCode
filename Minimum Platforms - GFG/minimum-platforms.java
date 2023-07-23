//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int s){
        int A = 0, D = 1;
        int n = arr.length, m = dep.length;
        
        int[][] elem = new int[n+m][2];
        
        int x = 0;
        
        for(int i = 0; i<n; i++){
            elem[x][0] = arr[i];
            elem[x][1] = A;
            x++;
        }
        
        for(int i = 0; i<m; i++){
            elem[x][0] = dep[i];
            elem[x][1] = D;
            x++;
        }
        
        Arrays.sort(elem,(a,b)->Integer.compare(a[0],b[0]));
        
        int plat = 0, maxP = 0;
        for(int i = 0; i<elem.length; i++){
            if(elem[i][1]==A) plat++;
            else if(elem[i][1]==D) plat--;
            
            maxP = Math.max(maxP,plat);
        }
        
        return maxP;
    }
    
}

