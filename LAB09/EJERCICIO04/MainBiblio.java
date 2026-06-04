package EJERCICIO04;

public class MainBiblio {

    public static void main(String[] args) {

        Biblioteca biblioteca =
                new Biblioteca();

        // agrego libros
        biblioteca.agregarLibro(
                new Libro(
                        "978001",
                        "Algortimos",
                        "Jose Rodriguez",
                        2020));

        biblioteca.agregarLibro(
                new Libro(
                        "978002",
                        "Matematica",
                        "Vanesa Lopez",
                        2021));

        biblioteca.agregarLibro(
                new Libro(
                        "978003",
                        "Arquitectura",
                        "Sandro Pamo",
                        2019));

        biblioteca.agregarLibro(
                new Libro(
                        "978004",
                        "Comunicacion",
                        "Felipe Mollo",
                        2022));

        biblioteca.agregarLibro(
                new Libro(
                        "978005",
                        "Programacion",
                        "Luis Rojas",
                        2018));

        System.out.println(
                "BIBLIOTECA DIGITAL");

        biblioteca.mostrarLibros();
    }
}
