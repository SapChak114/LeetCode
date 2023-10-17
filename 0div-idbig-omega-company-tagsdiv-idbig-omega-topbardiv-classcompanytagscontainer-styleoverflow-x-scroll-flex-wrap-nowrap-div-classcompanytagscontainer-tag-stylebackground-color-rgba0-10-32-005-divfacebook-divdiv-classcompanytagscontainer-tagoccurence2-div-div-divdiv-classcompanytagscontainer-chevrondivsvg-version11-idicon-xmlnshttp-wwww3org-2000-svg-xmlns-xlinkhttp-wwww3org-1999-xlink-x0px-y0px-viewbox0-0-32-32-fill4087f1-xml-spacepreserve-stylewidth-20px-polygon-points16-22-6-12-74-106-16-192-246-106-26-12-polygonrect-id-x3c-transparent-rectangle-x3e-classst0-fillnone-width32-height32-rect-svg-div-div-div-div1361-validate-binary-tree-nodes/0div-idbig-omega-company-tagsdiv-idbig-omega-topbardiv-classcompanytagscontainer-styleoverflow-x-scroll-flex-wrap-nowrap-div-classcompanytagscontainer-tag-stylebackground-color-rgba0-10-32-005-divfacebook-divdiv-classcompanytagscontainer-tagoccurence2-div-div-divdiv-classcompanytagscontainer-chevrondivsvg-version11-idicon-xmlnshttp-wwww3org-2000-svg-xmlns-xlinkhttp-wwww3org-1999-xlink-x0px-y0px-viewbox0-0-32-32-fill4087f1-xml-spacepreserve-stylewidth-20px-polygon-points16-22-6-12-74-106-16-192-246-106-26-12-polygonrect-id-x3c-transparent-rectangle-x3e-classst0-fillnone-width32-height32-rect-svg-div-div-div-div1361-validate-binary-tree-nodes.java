import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int WHITE = 0, GRAY = 1, BLACK = 2;
        Map<Integer, Integer> color = new HashMap<>();

        Map<Integer, List<Integer>> graph = new HashMap<>();

        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        int edges = 0;

        for (int parent = 0; parent < n; parent++) {
            int lc = leftChild[parent];
            int rc = rightChild[parent];

            for (int child : new int[]{lc, rc}) {
                if (child != -1) {
                    if (!graph.containsKey(parent)) {
                        graph.put(parent, new ArrayList<>());
                    }
                    graph.get(parent).add(child);

                    edges++;
                    outDegree[parent]++;
                    inDegree[child]++;
                }
            }
        }

        for (int node = 0; node < n; node++) {
            if (!dfs(node, color, graph)) {
                return false;
            }
        }

        for (int node = 0; node < n; node++) {
            if (inDegree[node] > 1) {
                return false;
            }
        }

        for (int node = 0; node < n; node++) {
            if (outDegree[node] > 2) {
                return false;
            }
        }

        if (edges != n - 1) {
            return false;
        }

        return true;
    }

    private boolean dfs(int node, Map<Integer, Integer> color, Map<Integer, List<Integer>> graph) {
        int WHITE = 0, GRAY = 1, BLACK = 2;

        if (color.containsKey(node)) {
            return color.get(node) == BLACK;
        }

        color.put(node, GRAY);

        if (graph.containsKey(node)) {
            for (int neiNode : graph.get(node)) {
                if (color.containsKey(neiNode) && color.get(neiNode) == GRAY) {
                    return false;
                } else if (!dfs(neiNode, color, graph)) {
                    return false;
                }
            }
        }

        color.put(node, BLACK);
        return true;
    }
}
