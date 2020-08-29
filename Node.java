import java.util.HashMap;
import java.util.Map;

// class that represent nodes in the graph 
public class Node implements Comparable<Node> {
    String node_value;
    int cost;
// map for storing edges between nodes
    Map<Node,Integer> edges;
    boolean visited;

    public Node(String node_value) {
        this.node_value = node_value;
        this.cost = Integer.MAX_VALUE;
        this.edges =new HashMap<>();
        visited = false;
    }


    public void add_edge(Node to,int dist) {
        edges.put(to,dist);
    }



    @Override
    public int hashCode() {
        return node_value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Node n = (Node) obj;
        return n.node_value.equalsIgnoreCase(this.node_value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "node='" + node_value + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.cost-o.cost;
    }
}
