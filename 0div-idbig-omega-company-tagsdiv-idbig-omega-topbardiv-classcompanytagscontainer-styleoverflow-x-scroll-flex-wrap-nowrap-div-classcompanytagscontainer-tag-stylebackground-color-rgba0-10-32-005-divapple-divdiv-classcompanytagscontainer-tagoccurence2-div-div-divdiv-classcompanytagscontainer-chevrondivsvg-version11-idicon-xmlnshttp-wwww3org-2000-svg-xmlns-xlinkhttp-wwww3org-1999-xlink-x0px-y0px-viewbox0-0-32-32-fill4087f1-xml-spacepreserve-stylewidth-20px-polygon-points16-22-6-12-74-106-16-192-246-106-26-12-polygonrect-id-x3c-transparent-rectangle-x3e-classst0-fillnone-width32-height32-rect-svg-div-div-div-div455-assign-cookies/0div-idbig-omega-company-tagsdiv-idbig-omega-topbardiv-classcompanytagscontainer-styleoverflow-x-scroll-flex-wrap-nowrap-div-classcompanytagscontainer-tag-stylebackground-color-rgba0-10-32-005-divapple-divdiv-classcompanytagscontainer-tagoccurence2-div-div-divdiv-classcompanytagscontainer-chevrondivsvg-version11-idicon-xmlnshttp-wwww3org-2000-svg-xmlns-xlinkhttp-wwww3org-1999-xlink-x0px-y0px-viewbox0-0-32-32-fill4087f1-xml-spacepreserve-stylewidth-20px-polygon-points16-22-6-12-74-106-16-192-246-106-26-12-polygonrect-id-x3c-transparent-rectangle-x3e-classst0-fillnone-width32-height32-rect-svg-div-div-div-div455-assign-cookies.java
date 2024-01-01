class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int childrenIndex = 0, cokieIndex = 0, i = 0, j = 0;
        
        while(cokieIndex < s.length && childrenIndex < g.length){
            if(s[cokieIndex] >= g[childrenIndex]){
                childrenIndex++;
            }
            cokieIndex++;
        }
        
        return childrenIndex;
    }
}