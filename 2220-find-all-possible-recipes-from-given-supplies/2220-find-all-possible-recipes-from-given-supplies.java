class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        int n = recipes.length;

        for (int i = 0; i<n; i++) {
            String recipe = recipes[i];
            indegree.put(recipe, ingredients.get(i).size());
            for (String ingedient : ingredients.get(i)) {
                graph.computeIfAbsent(ingedient, k -> new ArrayList<>()).add(recipe);
            }
        }

        Queue<String> queue = new LinkedList<>();

        for (String supply : supplies) {
            queue.add(supply);
        }
        
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (indegree.containsKey(current)) {
                result.add(current);
            }

            if (graph.containsKey(current)) {
                for (String next : graph.get(current)) {
                    indegree.put(next, indegree.get(next) - 1);

                    if (indegree.get(next) == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        return result;

    }
}