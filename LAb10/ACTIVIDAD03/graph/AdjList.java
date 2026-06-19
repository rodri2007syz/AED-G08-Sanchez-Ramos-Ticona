package ACTIVIDAD03.graph;

import ACTIVIDAD03.listlinked.ListLinked;

public class AdjList<E> {

    // Vertice
    private Vertex<E> vertex;

    // Conexiones del vertice
    private ListLinked<Edge<E>> edges;

    public AdjList(Vertex<E> vertex) {
        this.vertex = vertex;
        this.edges = new ListLinked<>();
    }

    public Vertex<E> getVertex() {
        return vertex;
    }

    public ListLinked<Edge<E>> getEdges() {
        return edges;
    }
}