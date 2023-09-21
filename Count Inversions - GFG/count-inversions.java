//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static long count;

    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], long N) {
        count = 0l;

        mergeSort(arr, N, 0, N - 1);

        return count;
    }

    static void mergeSort(long[] arr, long n, long l, long r) {
        if (l < r) {
            long mid = (l + r) / 2;
            mergeSort(arr, n, l, mid);
            mergeSort(arr, n, mid + 1, r);
            merge(arr, l, r, mid);
        }
    }

    static void merge(long[] arr, long l, long r, long mid) {
        int n = (int) (r - l + 1);
        long[] temp = new long[n];
        int i = (int) l, j = (int) (mid + 1), k = 0;

        List<Long> li = new ArrayList<>();

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                count += (mid - i + 1); // Increment count for inversions
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        k = 0;
        for (i = (int) l; i <= r; i++) {
            arr[i] = temp[k++];
        }
    }
}
