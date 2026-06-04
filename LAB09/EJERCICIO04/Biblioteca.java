package EJERCICIO04;

import EJERCICIO01.BTree;

public class Biblioteca {

    private BTree<Libro> libros;

    public Biblioteca() {

        libros = new BTree<>(4);
    }

    public void agregarLibro(Libro libro) {

        // agrego libro
        libros.insert(libro);
    }

    public BTree<Libro> getLibros() {

        return libros;
    }

    public void mostrarLibros() {

        // muestro árbol
        System.out.println(libros);
    }
}