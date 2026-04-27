package actividades;

public class GestorDeTareas<T extends Comparable<T>> {

    private ListLinked<T> lista;

    public GestorDeTareas(){
        lista=
          new ListLinked<T>();
    }

    public void agregarTarea(T t){
        lista.insertLast(t);
    }

    public boolean eliminarTarea(T t){
        return lista.removeNode(t);
    }

    public boolean contieneTarea(T t){
        return lista.search(t);
    }

    public void imprimirTareas(){
        lista.print();
    }

    public int contarTareas(){
        return lista.length();
    }

    public void invertirTareas(){
        lista.reverse();
    }

}