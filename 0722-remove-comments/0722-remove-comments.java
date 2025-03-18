class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean isBlock = false;

        for (String line : source) {

            if (!isBlock) {
                sb.setLength(0);
            }

            int n = line.length(), i = 0;
            while (i < n) {
                if (!isBlock && i+1 < n && line.charAt(i) == '/' && line.charAt(i+1) == '*') {
                    isBlock = true;
                    i++;
                } else if (isBlock && i+1 < n && line.charAt(i) == '*' && line.charAt(i+1) == '/') {
                    isBlock = false;
                    i++;
                } else if(!isBlock && i+1 < n && line.charAt(i) == '/' && line.charAt(i+1) == '/') {
                    i++;
                    break;
                } else if (!isBlock && i < n) {
                    sb.append(line.charAt(i));
                }
                i++;
            }
            
            if (!isBlock && !sb.isEmpty()) {
                ans.add(sb.toString());
            }
        }

        return ans;
    }
}