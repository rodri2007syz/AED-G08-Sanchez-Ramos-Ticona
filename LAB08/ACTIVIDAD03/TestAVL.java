package ACTIVIDAD03;

public class TestAVL {

    public static void main(String[] args) {

        // PRUEBA 1 SIN ROTACIÓN

        AVLTree avl1 = new AVLTree();

        avl1.insert(15);
        avl1.insert(10);
        avl1.insert(20);

        System.out.println("PRUEBA 1 SIN ROTACIÓN");
        System.out.println(avl1);

        // PRUEBA 2 RSR

        AVLTree avl2 = new AVLTree();

        avl2.insert(30);
        avl2.insert(20);
        avl2.insert(10);

        System.out.println("PRUEBA 2 RSR");
        System.out.println(avl2);

        // PRUEBA 3 RSR

        AVLTree avl3 = new AVLTree();

        avl3.insert(50);
        avl3.insert(40);
        avl3.insert(30);

        System.out.println("PRUEBA 3 RSR");
        System.out.println(avl3);

        // PRUEBA 4 RSL

        AVLTree avl4 = new AVLTree();

        avl4.insert(10);
        avl4.insert(20);
        avl4.insert(30);

        System.out.println("PRUEBA 4 RSL");
        System.out.println(avl4);

        // PRUEBA 5 RSL

        AVLTree avl5 = new AVLTree();

        avl5.insert(5);
        avl5.insert(15);
        avl5.insert(25);

        System.out.println("PRUEBA 5 RSL");
        System.out.println(avl5);
	
	// PRUEBA 6 RDR

        AVLTree avl6 = new AVLTree();

        avl6.insert(30);
        avl6.insert(10);
        avl6.insert(20);

        System.out.println("PRUEBA 6 RDR");
        System.out.println(avl6);

        // PRUEBA 7 RDR

        AVLTree avl7 = new AVLTree();

        avl7.insert(50);
        avl7.insert(30);
        avl7.insert(40);

        System.out.println("PRUEBA 7 RDR");
        System.out.println(avl7);

        // PRUEBA 8 RDL

        AVLTree avl8 = new AVLTree();

        avl8.insert(10);
        avl8.insert(30);
        avl8.insert(20);

        System.out.println("PRUEBA 8 RDL");
        System.out.println(avl8);

        // PRUEBA 9 RDL

        AVLTree avl9 = new AVLTree();

        avl9.insert(40);
        avl9.insert(60);
        avl9.insert(50);

        System.out.println("PRUEBA 9 RDL");
        System.out.println(avl9);
    }
}