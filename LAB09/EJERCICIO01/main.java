package EJERCICIO01;

public class main {
	public static void main(String[] args) {

	    // creo árbol B
	    BTree<Integer> tree = new BTree<>(4);

	    // inserto datos
	    tree.insert(45);
	    tree.insert(25);
	    tree.insert(65);
	    tree.insert(15);
	    tree.insert(35);
	    tree.insert(55);
	    tree.insert(75);
	    tree.insert(5);
	    tree.insert(20);
	    tree.insert(50);
	    tree.insert(85);
	    
	    // árbol
	    System.out.println("ÁRBOL B");
	    System.out.println(tree);

	    System.out.println();

	    // hoja izquierda
	    System.out.println("BUSCAR 5");
	    System.out.println(tree.search(5));

	    System.out.println();

	    // hoja derecha
	    System.out.println("BUSCAR 85");
	    System.out.println(tree.search(85));

	    System.out.println();

	    // raíz
	    System.out.println("BUSCAR 45");
	    System.out.println(tree.search(45));

	    System.out.println();

	    // dato inexistente
	    System.out.println("BUSCAR 99");
	    System.out.println(tree.search(99));
	}

}
