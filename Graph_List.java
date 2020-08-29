import java.util.*;

// class for represent a graph and containing the dikjstra method

public class Graph_List {
// set for represent a graph
    HashSet<Node> graph;
// priority queue for storing Unvisited nodes and retreiving the minimum nodes cost
    private PriorityQueue<Node> queue;

    public Graph_List() {
        this.graph = new HashSet<>();
        queue = new PriorityQueue<>();

    }
// add nodes to graph
    public void add_node(Node node) {
        graph.add(node);
    }
// add edges between nodes 
    public void add_edges(Node from, Node to, int dist) {
        from.add_edge(to, dist);
    }

// the modified Dijkstra Algorithm  
    public void dikjstra(Node node_name) {

        node_name.cost = 0;
        if (!graph.contains(node_name)) return;
        System.out.println("********************");
        queue.add(node_name);
        while (!queue.isEmpty()) {
            Node parent = queue.poll();
            parent.visited = true;
            for (Node child : parent.edges.keySet()) {
                if (!child.visited) {
                    queue.add(child);
                }
                if (child.cost > parent.cost + parent.edges.get(child)) {
                    child.cost = parent.cost + parent.edges.get(child);
                    // this is the new line which inserted to the Algorithm
                    // which indicate that if we modified cost for a visited node we adding it again to the queue to modify each node_cost that depend on it  
                    if (child.visited) queue.add(child);
                }
            }
        }

    }
}
