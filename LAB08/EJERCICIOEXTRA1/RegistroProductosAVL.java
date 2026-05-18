package EJERCICIOEXTRA1;

import EJERCICIO06.AVLTree;
import EJERCICIO06.Node;

public class RegistroProductosAVL {

    public static void main(String[] args) {

        AVLTree productos = new AVLTree();

        // insertar productos
        productos.insert(30);
        productos.insert(20);
        productos.insert(10);
        productos.insert(40);
        productos.insert(50);

        System.out.println("ÁRBOL AVL DE PRODUCTOS");
        System.out.println(productos);

        // recorrido inorder
        System.out.println("RECORRIDO INORDER");
        productos.inOrder(productos.getRoot());

        System.out.println("\n");

        // búsqueda de productos
        System.out.println("BUSCAR PRODUCTO 20");
        buscarProducto(productos.getRoot(), 20);

        System.out.println("\nBUSCAR PRODUCTO 99");
        buscarProducto(productos.getRoot(), 99);
    }

    public static void buscarProducto(Node actual, int valor) {

        while (actual != null) {

            if (valor == actual.data) {

                System.out.println("Producto encontrado");

                return;
            }

            if (valor < actual.data) {
                actual = actual.left;
            }

            else {
                actual = actual.right;
            }
        }

        System.out.println("Producto no encontrado");
    }