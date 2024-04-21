public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true; 

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int adj : graph.getOrDefault(node, Collections.emptyList())) {
                if (adj == destination) return true; 
                if (visited.add(adj)) { 
                    queue.offer(adj);
                }
            }
        }

        return false;
    }
}
