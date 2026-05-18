package ejercicio5;

public class Ejercicio5 {

    public static void main(String[] args) {

        AVLTree avl = new AVLTree();

        avl.insertar(50);
        avl.insertar(30);
        avl.insertar(70);
        avl.insertar(20);
        avl.insertar(40);
        avl.insertar(60);
        avl.insertar(80);
        avl.insertar(10);
        avl.insertar(25);
        avl.insertar(65);

        System.out.println("BFS:");

        avl.bfs();
    }
}