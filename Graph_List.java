import java.util.*;

public class Graph_List {
    HashSet<Node> graph;
    private PriorityQueue<Node> queue;

    public Graph_List() {
        this.graph = new HashSet<>();
        queue = new PriorityQueue<>();

    }


    public void add_node(Node node) {
        graph.add(node);
    }

    public void add_edges(Node from, Node to, int dist) {
        from.add_edge(to, dist);
    }

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
                    if (child.visited) queue.add(child);
                }
            }
        }

    }
}
