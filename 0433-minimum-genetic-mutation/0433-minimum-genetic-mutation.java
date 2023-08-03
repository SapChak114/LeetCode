class Solution {
    Set<String> genes;
    public int minMutation(String startGene, String endGene, String[] bank) {
        genes = new HashSet<>();
        for(String b : bank) genes.add(b);
        
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        
        queue.add(startGene);
        levels.add(0);
        
        Set<String> vis = new HashSet<>();
        
        while(!queue.isEmpty()){
            String word = queue.poll();
            int level = levels.poll();
            if(word.equals(endGene)) return level;
            
            for(String w : getGenes(word)){
                if(!vis.contains(w)){
                    queue.add(w);
                    levels.add(level+1);
                    vis.add(w);
                }
            }
        }
        
        return -1;
        
    }
    
    List<String> getGenes(String gene){
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i<gene.length(); i++){
            for(char c = 'A'; c<='Z'; c++){
                if(gene.charAt(i)==c) continue;
                String nword = gene.substring(0,i)+""+c+""+gene.substring(i+1);
                //System.out.println(nword);
                if(genes.contains(nword)){
                   res.add(nword); 
                }
            }
        }
        
        return res;
    }
}