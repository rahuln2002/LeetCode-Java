class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        for (int course = 0; course < numCourses; course++) {
            if (visited[course] == 0 && hasCycle(course, adjList, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int course, List<List<Integer>> adjList, int[] visited) {
        visited[course] = 1;

        for (int neighbor : adjList.get(course)) {
            if (visited[neighbor] == 1) {
                return true;
            }
            if (visited[neighbor] == 0 && hasCycle(neighbor, adjList, visited)) {
                return true;
            }
        }

        visited[course] = 2;
        return false;
    }
}
/* Time Complexity: O(N+E)
* Space Complexity: O(N+E)
*/
