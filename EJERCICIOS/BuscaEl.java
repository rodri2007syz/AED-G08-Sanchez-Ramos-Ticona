import java.util.ListLinked;


class BuscaElemento{
    public static <T> boolean buscarElemento(ListLinked<T> lista, T valor) {
        // Recorremos cada elemento de la lista
        for (T elemento : lista) {
            // Usamos .equals() porque al ser genérico (T), comparamos objetos, no primitivos
            if (elemento != null && elemento.equals(valor)) {
                return true;
            }
        }
        return false;
    }
}

