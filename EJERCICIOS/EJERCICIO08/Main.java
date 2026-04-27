package EJERCICIO08;

public class Main {
    public static void main(String[] args) {

        ColaReproduccion<Cancion> cola = new ColaReproduccion<>();

        cola.agregarCancion(new Cancion("Bohemian Rhapsody", "Queen", 354));
        cola.agregarCancion(new Cancion("Blinding Lights", "The Weeknd", 200));
        cola.agregarCancion(new Cancion("Shape of You", "Ed Sheeran", 234));
        cola.agregarCancion(new Cancion("Cuéntame", "Pedro Suárez-Vértiz", 240));
        cola.agregarCancion(new Cancion("Nada Personal", "Soda Stereo", 260));
        cola.agregarCancion(new Cancion("Temblando", "Hombres G", 210));

        System.out.println("=== Cola Inicial ===");
        cola.mostrarCola();

        System.out.println("\nReproduciendo:");
        System.out.println(cola.reproducirSiguiente());
        System.out.println(cola.reproducirSiguiente());
        System.out.println(cola.reproducirSiguiente());

        System.out.println("\nAnterior:");
        System.out.println(cola.reproducirAnterior());

        System.out.println("\n=== Mezclando ===");
        cola.mezclar();
        cola.mostrarCola();

        int total = cola.duracionTotal();
        System.out.println("\nDuración total: " + total + " segundos");
    }
}
