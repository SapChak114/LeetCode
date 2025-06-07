class Solution {
    public String clearStars(String s) {
        int n = s.length();
        Stack<Integer>[] q = new Stack[26];
        
        char[] arr = s.toCharArray();
        for (int i = 0; i<26; i++) {
            q[i] = new Stack<>();
        }

        for (int i = 0; i<n; i++) {
            char c = s.charAt(i);

            if (c != '*') {
                q[arr[i] - 'a'].push(i);
            } else {
                for (int j = 0; j<26; j++) {
                    if (!q[j].isEmpty()) {
                        arr[q[j].pop()] = '*';
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] != '*') {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}