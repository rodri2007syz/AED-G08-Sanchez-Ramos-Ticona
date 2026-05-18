package ejercicio4;

public class Ejercicio4 {

    public static void main(String[] args) {

        AVL a = new AVL();

        a.insertar(50);
        a.insertar(30);
        a.insertar(70);
        a.insertar(20);
        a.insertar(40);
        a.insertar(60);
        a.insertar(80);

        System.out.println("Recorrido amplitud:");

        a.amplitud();
    }
}