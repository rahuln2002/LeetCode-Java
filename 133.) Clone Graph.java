/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node clonedNode = new Node(node.val);

        visited.put(node, clonedNode);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    Node cloneNeighbor = new Node(neighbor.val);
                    visited.put(neighbor, cloneNeighbor);
                    queue.offer(neighbor);
                }

                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }

        return clonedNode;
    }
}
/* Time Complexity: O(N+M)
* Space Complexity: O(N)
*/
