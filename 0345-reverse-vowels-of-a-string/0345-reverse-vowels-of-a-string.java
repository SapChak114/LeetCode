class Solution {
    public String reverseVowels(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int left = 0, right = n-1;
        String vowels = "aeiouAEIOU";
        
        while (left < right) {
            while (left < n && vowels.indexOf(ch[left])== -1) {
                left++;
            }

            while (right >=0 && vowels.indexOf(ch[right])== -1) {
                right--;
            }

            if (left < right) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }

        return new String(ch);
    }
}