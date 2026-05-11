package EJERCICIO05;

public class Prueba {

    public static void main(String[] args) {

        // Crea arbol
        LinkedBST<Integer> bst =
                new LinkedBST<>();

        // Inserta datos
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Muestra rango
        System.out.println("Elementos entre 30 y 70");

        bst.searchRange(30, 70);

        // Cuenta hojas
        System.out.println("\nCantidad de hojas");

        System.out.println(bst.countLeaves());

        // Muestra descendente
        System.out.println("\nOrden descendente");

        bst.printDescending();
    }
}