class Node{
    public String name;
    public String subtree;
    public Map<String,Node> children;
    public boolean isEnd;
    public Node(String name){
        this.name = name;
        this.subtree = "";
        isEnd = false;
        children = new TreeMap<>();
    }
}


class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node("/");
        for(var path : paths){
            insert(root, path);
        }
        Map<String, Integer> subtreeFreq = new HashMap<>();
        dfs(root,subtreeFreq);
        List<List<String>> res = new ArrayList<>();
        List<String> path =  new ArrayList<>();
        deletion(root, subtreeFreq, path, res);
        return res;
    }
    void deletion(Node node,Map<String, Integer> subtreeFreq, List<String> path, List<List<String>> res){
        if(node == null) return;
        if(subtreeFreq.getOrDefault(node.subtree,0) > 1) return;
        if(node.isEnd == true) res.add(new ArrayList<>(path));
        for(var entry : node.children.entrySet()){
            path.add(entry.getKey());
            deletion(entry.getValue(), subtreeFreq,path,res);
            path.remove(path.size()-1);
        }
    }
    void dfs(Node node, Map<String, Integer> subtreeFreq){
        if(node == null) {
            return;
        } //z()
        
        for(var entry : node.children.entrySet()){
            dfs(entry.getValue(),subtreeFreq);
            node.subtree += entry.getKey() + "(" + entry.getValue().subtree + ")";
        }
        if(!node.subtree.isEmpty()){
            subtreeFreq.put(node.subtree, subtreeFreq.getOrDefault(node.subtree,0)+1);
        }
    }
    public void insert(Node node, List<String> path){
        for(var folder : path){
            if(!node.children.containsKey(folder)){
                node.children.put(folder, new Node(folder));
            }
            node = node.children.get(folder);
        }
        node.isEnd = true;
    }
}