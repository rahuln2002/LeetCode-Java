class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjList.get(prerequisiteCourse).add(course);
        }

        int[] visited = new int[numCourses];

        Stack<Integer> stack = new Stack<>();

        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0 && !dfs(course, adjList, visited, stack)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = stack.pop();
        }

        return result;
    }

    private boolean dfs(int course, List<List<Integer>> adjList, int[] visited, Stack<Integer> stack) {
        visited[course] = 1;

        for (int neighbor : adjList.get(course)) {
            if (visited[neighbor] == 1) {
                return false;
            }
            if (visited[neighbor] == 0 && !dfs(neighbor, adjList, visited, stack)) {
                return false;
            }
        }

        visited[course] = 2;
        stack.push(course);
        return true;
    }
}
/* Time Complexity: O(N+E)
* Space Complexity: O(N+E)
*/
