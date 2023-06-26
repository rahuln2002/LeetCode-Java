class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);
            Set<String> visited = new HashSet<>();
            results[i] = dfs(graph, dividend, divisor, 1.0, visited);
        }
        
        return results;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, double result, Set<String> visited) {
        if (!graph.containsKey(start) || !graph.containsKey(end))
            return -1.0;
        
        if (start.equals(end))
            return result;
        
        visited.add(start);
        
        Map<String, Double> neighbors = graph.get(start);
        for (String neighbor : neighbors.keySet()) {
            if (!visited.contains(neighbor)) {
                double neighborResult = dfs(graph, neighbor, end, result * neighbors.get(neighbor), visited);
                if (neighborResult != -1.0)
                    return neighborResult;
            }
        }
        
        visited.remove(start);
        
        return -1.0;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double value = values[i];
            
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());
            
            graph.get(dividend).put(divisor, value);
            graph.get(divisor).put(dividend, 1.0 / value);
        }
        
        return graph;
    }
}
/* Time Complexity: O((V + E) * Q)
* Space Complexity: O(V + E)
*/
