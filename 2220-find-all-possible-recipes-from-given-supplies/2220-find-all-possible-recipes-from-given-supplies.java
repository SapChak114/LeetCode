class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Map<String, Integer> indegree = new HashMap<>();
        Map<String, List<String>> adjList = new HashMap<>();
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));
        
        for (String recipe : recipes) {
            indegree.put(recipe, 0);
            adjList.put(recipe, new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            String recipe = recipes[i];
            for (String ingredient : ingredients.get(i)) {
                if (!supplySet.contains(ingredient)) {
                    adjList.computeIfAbsent(ingredient, k -> new ArrayList<>()).add(recipe);
                    indegree.put(recipe, indegree.get(recipe) + 1);
                }
            }
        }
        
        Queue<String> queue = new LinkedList<>();
        for (String recipe : recipes) {
            if (indegree.get(recipe) == 0) {
                queue.offer(recipe);
            }
        }
        
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String currRecipe = queue.poll();
            result.add(currRecipe);
            
            for (String nextRecipe : adjList.getOrDefault(currRecipe, new ArrayList<>())) {
                indegree.put(nextRecipe, indegree.get(nextRecipe) - 1);
                if (indegree.get(nextRecipe) == 0) {
                    queue.offer(nextRecipe);
                }
            }
        }
        
        return result;
    }
}