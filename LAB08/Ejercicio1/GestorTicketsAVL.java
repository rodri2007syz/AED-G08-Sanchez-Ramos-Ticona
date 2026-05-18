package Ejercicio1;
public class GestorTicketsAVL {
    // Reutilizamos la estructura interna de Nodo y AVL descrita en la guía
    static class Nodo {
        int idTicket;
        int altura;
        Nodo izq, der;

        Nodo(int id) {
            this.idTicket = id;
            this.altura = 1;
        }
    }

    private Nodo raiz;

    private int obtenerAltura(Nodo n) {
        return n == null ? 0 : n.altura;
    }

    private int obtenerBalance(Nodo n) {
        return n == null ? 0 : obtenerAltura(n.der) - obtenerAltura(n.izq);
    }

    private void actualizarAltura(Nodo n) {
        if (n != null) {
            n.altura = 1 + Math.max(obtenerAltura(n.izq), obtenerAltura(n.der));
        }
    }

    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izq;
        Nodo temp = x.der;
        x.der = y;
        y.izq = temp;
        actualizarAltura(y);
        actualizarAltura(x);
        return x;
    }

    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.der;
        Nodo temp = y.izq;
        y.izq = x;
        x.der = temp;
        actualizarAltura(x);
        actualizarAltura(y);
        return y;
    }

    public void insertar(int id) {
        System.out.println("-> Insertando Ticket: " + id);
        raiz = insertarRec(raiz, id);
    }

    private Nodo insertarRec(Nodo nodo, int id) {
        if (nodo == null) return new Nodo(id);

        if (id < nodo.idTicket) {
            nodo.izq = insertarRec(nodo.izq, id);
        } else if (id > nodo.idTicket) {
            nodo.der = insertarRec(nodo.der, id);
        } else {
            return nodo; // No duplicados
        }

        actualizarAltura(nodo);
        int bf = obtenerBalance(nodo);

        // Caso Izquierda-Izquierda
        if (bf < -1 && id < nodo.izq.idTicket) {
            return rotarDerecha(nodo);
        }
        // Caso Derecha-Derecha
        if (bf > 1 && id > nodo.der.idTicket) {
            return rotarIzquierda(nodo);
        }
        // Caso Izquierda-Derecha
        if (bf < -1 && id > nodo.izq.idTicket) {
            nodo.izq = rotarIzquierda(nodo.izq);
            return rotarDerecha(nodo);
        }
        // Caso Derecha-Izquierda
        if (bf > 1 && id < nodo.der.idTicket) {
            nodo.der = rotarDerecha(nodo.der);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    public boolean buscar(int id) {
        Nodo aux = raiz;
        while (aux != null) {
            if (id == aux.idTicket) return true;
            aux = (id < aux.idTicket) ? aux.izq : aux.der;
        }
        return false;
    }

    public void mostrarInorden(Nodo n) {
        if (n != null) {
            mostrarInorden(n.izq);
            System.out.print(n.idTicket + " (bf=" + obtenerBalance(n) + ") | ");
            mostrarInorden(n.der);
        }
    }

    public void imprimirEstructura() {
        mostrarInorden(raiz);
        System.out.println();
    }

    public static void main(String[] args) {
        GestorTicketsAVL gestor = new GestorTicketsAVL();
        int[] tickets = {30, 10, 20, 40, 50, 25};

        for (int t : tickets) {
            gestor.insertar(t);
            gestor.imprimirEstructura();
        }

        System.out.println("\n--- BÚSQUEDAS ---");
        System.out.println("¿Existe Ticket 20?: " + gestor.buscar(20));
        System.out.println("¿Existe Ticket 60?: " + gestor.buscar(60));
    }
}