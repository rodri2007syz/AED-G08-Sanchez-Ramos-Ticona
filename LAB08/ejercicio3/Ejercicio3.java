package ejercicio3;

public class Ejercicio3 {

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();

        avl.insertar(30);
        avl.insertar(20);
        avl.insertar(40);
        avl.insertar(10);
        avl.insertar(25);

        System.out.println("AVL:");

        avl.mostrar();

        System.out.println("Eliminar 20");

        avl.eliminar(20);

        avl.mostrar();
    }
}