package L5.E1;

//lista enlazada ordenada
public class SortedListLinked<T extends Comparable<T>>
     extends ListLinked<T> {

 public void insertOrden(T x) {

     // crear nuevo nodo
     Node<T> nuevo = new Node<T>(x);

     // si la lista esta vacia
     // o va al inicio
     if (first == null ||
         x.compareTo(first.value) < 0) {

         nuevo.next = first;
         first = nuevo;

         return;
     }

     // recorrer lista
     Node<T> aux = first;

     // buscar posicion correcta
     while (aux.next != null &&
            x.compareTo(
            aux.next.value) >= 0) {

         aux = aux.next;
     }

     // insertar ordenado
     nuevo.next = aux.next;
     aux.next = nuevo;

 }

}