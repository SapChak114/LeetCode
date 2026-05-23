class Solution {
    public String simplifyPath(String path) {
        String[] p = path.split("/");
        int n = p.length;
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();

        for (int i = 0; i<n; i++) {
            if (!st.isEmpty() && p[i].equals("..")) {
                st.pop();
            }
            if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")) {
                st.add(p[i]);
            }
        }

        if (st.isEmpty()) {
            return "/";
        }

        while (!st.isEmpty()) {
            sb.insert(0, st.pop()).insert(0, "/");
        }

        return sb.toString();
    }
}