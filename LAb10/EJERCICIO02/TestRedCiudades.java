package EJERCICIO02;

public class TestRedCiudades {

    public static void main(String[] args) {

        RedCiudades red =
                new RedCiudades();

        // Ciudades
        red.agregarCiudad("Arequipa");
        red.agregarCiudad("Cusco");
        red.agregarCiudad("Puno");
        red.agregarCiudad("Tacna");
        red.agregarCiudad("Moquegua");

        // Carreteras
        red.agregarCarretera(
                "Arequipa",
                "Cusco",
                510);

        red.agregarCarretera(
                "Arequipa",
                "Moquegua",
                230);

        red.agregarCarretera(
                "Moquegua",
                "Tacna",
                160);

        red.agregarCarretera(
                "Cusco",
                "Puno",
                390);

        red.agregarCarretera(
                "Puno",
                "Tacna",
                420);

        red.mostrarCiudades();

        red.mostrarCarreteras();

        red.caminoMasCorto(
                "Arequipa",
                "Tacna");
    }
}