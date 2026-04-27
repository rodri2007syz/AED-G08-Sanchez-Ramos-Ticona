package L5.E1;

public class Ejercicio6 {

    // une dos listas y devuelve una nueva
    public static <T>
    ListLinked<T> concatenarListas(
    ListLinked<T> lista1,
    ListLinked<T> lista2){

        // nueva lista resultado
        ListLinked<T> nueva=
        new ListLinked<T>();


        // recorrer primera lista
        Node<T> aux=
        lista1.first;

        while(aux!=null){

            // insertar elementos
            nueva.insertLast(
             aux.value
            );

            aux=aux.next;
        }


        // recorrer segunda lista
        aux=lista2.first;

        while(aux!=null){

            // insertar elementos
            nueva.insertLast(
             aux.value
            );

            aux=aux.next;
        }


        // retornar lista concatenada
        return nueva;

    }

}