package EJERCICIO01.graph;

import ACTIVIDAD03.listlinked.ListLinked;
import java.util.ArrayList;
import java.util.Stack;

public class GraphLink<E> {

    // Vertices del grafo
    private ListLinked<AdjList<E>> graph;

    public GraphLink() {
        graph = new ListLinked<>();
    }

    // Agrega un vertice
    public void insertVertex(E data) {

        Vertex<E> vertex = new Vertex<>(data);
        graph.addLast(new AdjList<>(vertex));
    }

    // Busca un vertice
    private AdjList<E> findVertex(E data) {

        for (int i = 0; i < graph.size(); i++) {

            AdjList<E> adj = graph.get(i);

            if (adj.getVertex().getData().equals(data)) {
                return adj;
            }
        }

        return null;
    }

    // Une dos vertices
    public void insertEdge(E origin, E destination) {

        AdjList<E> v1 = findVertex(origin);
        AdjList<E> v2 = findVertex(destination);

        if (v1 == null || v2 == null) {
            return;
        }

        v1.getEdges().addLast(
                new Edge<>(v2.getVertex()));

        v2.getEdges().addLast(
                new Edge<>(v1.getVertex()));
    }

    // Une dos vertices con peso
    public void insertEdgeWeight(E origin, E destination, int weight) {

        AdjList<E> v1 = findVertex(origin);
        AdjList<E> v2 = findVertex(destination);

        if (v1 == null || v2 == null) {
            return;
        }

        v1.getEdges().addLast(
                new Edge<>(v2.getVertex(), weight));

        v2.getEdges().addLast(
                new Edge<>(v1.getVertex(), weight));
    }

    // Verifica si el grafo es conexo
    public boolean isConexo() {

        if (graph.isEmpty()) {
            return true;
        }

        ArrayList<E> visitados = new ArrayList<>();

        dfs(graph.get(0).getVertex().getData(), visitados);

        return visitados.size() == graph.size();
    }

    private void dfs(E dato, ArrayList<E> visitados) {

        if (visitados.contains(dato)) {
            return;
        }

        visitados.add(dato);

        AdjList<E> vertice = findVertex(dato);

        for (int i = 0; i < vertice.getEdges().size(); i++) {

            E vecino = vertice.getEdges()
                    .get(i)
                    .getDestination()
                    .getData();

            dfs(vecino, visitados);
        }
    }

    // Retorna un camino entre dos vertices
    public ArrayList<E> shortPath(E origin, E destination) {

        ArrayList<E> camino = new ArrayList<>();

        buscarCamino(origin, destination, camino);

        return camino;
    }

    private boolean buscarCamino(
            E actual,
            E destino,
            ArrayList<E> camino) {

        camino.add(actual);

        if (actual.equals(destino)) {
            return true;
        }

        AdjList<E> vertice = findVertex(actual);

        for (int i = 0; i < vertice.getEdges().size(); i++) {

            E vecino = vertice.getEdges()
                    .get(i)
                    .getDestination()
                    .getData();

            if (!camino.contains(vecino)) {

                if (buscarCamino(vecino, destino, camino)) {
                    return true;
                }
            }
        }

        camino.remove(camino.size() - 1);

        return false;
    }

    // Retorna la ruta en una pila
    public Stack<E> Dijkstra(E origin, E destination) {

        ArrayList<E> camino =
                shortPath(origin, destination);

        Stack<E> pila = new Stack<>();

        for (int i = camino.size() - 1; i >= 0; i--) {
            pila.push(camino.get(i));
        }

        return pila;
    }

    // Muestra el grafo
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < graph.size(); i++) {

            AdjList<E> adj = graph.get(i);

            sb.append(adj.getVertex())
              .append(" -> ");

            for (int j = 0; j < adj.getEdges().size(); j++) {

                sb.append(adj.getEdges().get(j))
                  .append(" ");
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}