package EJERCICIO02;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class RedCiudades {

    private Graph<String, DefaultWeightedEdge> grafo;

    public RedCiudades() {
        grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
    }

    // Agrego una ciudad
    public void agregarCiudad(String ciudad) {
        grafo.addVertex(ciudad);
    }

    // Agrego una carretera con distancia
    public void agregarCarretera(String origen,
                                 String destino,
                                 double distancia) {

        DefaultWeightedEdge edge =
                grafo.addEdge(origen, destino);

        if (edge != null) {
            grafo.setEdgeWeight(edge, distancia);
        }
    }

    // Muestro ciudades
    public void mostrarCiudades() {

        System.out.println("CIUDADES:");

        for (String ciudad : grafo.vertexSet()) {
            System.out.println(ciudad);
        }
    }

    // Muestro carreteras
    public void mostrarCarreteras() {

        System.out.println("\nCARRETERAS:");

        for (DefaultWeightedEdge edge : grafo.edgeSet()) {

            String origen =
                    grafo.getEdgeSource(edge);

            String destino =
                    grafo.getEdgeTarget(edge);

            double distancia =
                    grafo.getEdgeWeight(edge);

            System.out.println(
                    origen + " <-> "
                    + destino + " = "
                    + distancia + " km");
        }
    }

    // Camino mas corto
    public void caminoMasCorto(
            String origen,
            String destino) {

        GraphPath<String,
                DefaultWeightedEdge> ruta =
                DijkstraShortestPath.findPathBetween(
                        grafo,
                        origen,
                        destino);

        if (ruta == null) {
            System.out.println(
                    "No existe ruta.");
            return;
        }

        System.out.println(
                "\nCAMINO MAS CORTO:");

        System.out.println(
                ruta.getVertexList());

        System.out.println(
                "Costo total: "
                + ruta.getWeight()
                + " km");
    }
}
