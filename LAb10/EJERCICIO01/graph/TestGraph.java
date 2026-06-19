package EJERCICIO01.graph;

public class TestGraph {

    public static void main(String[] args) {

        GraphLink<String> g = new GraphLink<>();

        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");

        g.insertEdgeWeight("A", "B", 5);
        g.insertEdgeWeight("A", "C", 3);
        g.insertEdgeWeight("B", "D", 2);

        System.out.println(g);

        System.out.println("Conexo: " + g.isConexo());

        System.out.println("Camino A-D: "
                + g.shortPath("A", "D"));

        System.out.println("Dijkstra A-D: "
                + g.Dijkstra("A", "D"));
    }
}