package ACTIVIDAD03.graph;

public class TestGraph {

    public static void main(String[] args) {

        // Crear grafo
        GraphLink<String> g = new GraphLink<>();

        // Agregar vertices
        g.insertVertex("A");
        g.insertVertex("B");
        g.insertVertex("C");
        g.insertVertex("D");

        // Agregar conexiones
        g.insertEdge("A", "B");
        g.insertEdge("A", "C");
        g.insertEdge("B", "D");

        // Mostrar resultado
        System.out.println(g);
    }
}
