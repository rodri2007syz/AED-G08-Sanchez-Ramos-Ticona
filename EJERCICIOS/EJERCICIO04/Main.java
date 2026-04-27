package EJERCICIO04;

public class Main {
    public static void main(String[] args) {
        Nodo<Integer> n1 = new Nodo<>(14);
        Nodo<Integer> n2 = new Nodo<>(23);
        Nodo<Integer> n3 = new Nodo<>(50);

        n1.next = n2;
        n2.next = n3;

        int total = Nodo.contarNodos(n1); 
        
        System.out.println("Total nodos: " + total);
    }
}
