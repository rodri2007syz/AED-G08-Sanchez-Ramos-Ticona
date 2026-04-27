package EJERCICIO05;

public class Main {
    public static void main(String[] args) {
        ListLinked<Integer> lista1 = new ListLinked<>();
        ListLinked<Integer> lista2 = new ListLinked<>();

        lista1.insertLast(10);
        lista1.insertLast(20);
        lista1.insertLast(30);

        lista2.insertLast(10);
        lista2.insertLast(20);
        lista2.insertLast(30);

        boolean resultado = Ejercicio05.sonIguales(lista1, lista2); 
        
        System.out.println("¿Son iguales?: " + resultado);
    }
}
