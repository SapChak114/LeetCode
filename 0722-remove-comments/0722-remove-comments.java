class Solution {
    public List<String> removeComments(String[] source) {
            List<String> ans = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            boolean inBlock = false;  // Tracks if inside a block comment

            for (String line : source) {
                int i = 0;
                if (!inBlock) sb.setLength(0);  // Reset for new line if not in a block comment
                
                while (i < line.length()) {
                    if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++;  // Skip '*' as well
                    } else if (inBlock && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++;  // Skip '/'
                    } else if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break;  // Ignore everything after //
                    } else if (!inBlock) {
                        sb.append(line.charAt(i));  // Append valid code
                    }
                    i++;
                }

                // If this line had valid code and is not inside a block, add it
                if (!inBlock && sb.length() > 0) {
                    ans.add(sb.toString());
                }
            }

            return ans;
        }
}