class Solution {
    public List<String> removeSubfolders(String[] folder) {
        int n = folder.length;
        Set<String> folderSet = new HashSet<>(Arrays.asList(folder));
        List<String> ans = new ArrayList<>();

        for (String f : folder) {
            boolean isSubFolder = false;
            String prefix = f;

            while (!prefix.isEmpty()) {
                int idx = prefix.lastIndexOf("/");
                if (idx == -1) {
                    break;
                }
                prefix = prefix.substring(0, idx);
                if (folderSet.contains(prefix)) {
                    isSubFolder = true;
                    break;
                }
            }

            if (!isSubFolder) {
                ans.add(f);
            }
        }

        return ans;
    }
}