package Ejercicio2extra;

public class ControlClinica {
    public class NodoTurno{
        int idturno;
        int altura;
        NodoTurno izq, der;

        public NodoTurno(int idturno) {
            this.idturno=idturno;
            this.altura=1;
        }
    }
    private NodoTurno raiz;
    private int obtenerAltura(NodoTurno x){
        return x==null ? 0 : x.altura;
    }
    private int ObetenerFE(NodoTurno x){
        return x==null ? 0:obtenerAltura(x.izq)-obtenerAltura(x.der);
    }
    private void actualizarAltura(NodoTurno x){
        if(x!=null){
            x.altura=Math.max(obtenerAltura(x.izq),obtenerAltura(x.der));
        }
    }
    private NodoTurno rotarDerecha(NodoTurno y) {
        NodoTurno x = y.izq;
        NodoTurno temp = x.der;

        x.der = y;
        y.izq = temp;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    // Rotación simple a la izquierda (RSL)
    private NodoTurno rotarIzquierda(NodoTurno x) {
        NodoTurno y = x.der;
        NodoTurno temp = y.izq;

        y.izq = x;
        x.der = temp;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    // --- INSERCIÓN ---
    public void registrarTurno(int turno) {
        System.out.println("-> Registrando nuevo turno: " + turno);
        raiz = insertar(raiz, turno);
    }

    private NodoTurno insertar(NodoTurno nodo, int turno) {
        // 1. Inserción normal de un BST
        if (nodo == null) {
            return new NodoTurno(turno);
        }

        if (turno < nodo.idturno) {
            nodo.izq = insertar(nodo.izq, turno);
        } else if (turno > nodo.idturno) {
            nodo.der = insertar(nodo.der, turno);
        } else {
            System.out.println("El turno " + turno + " ya existe.");
            return nodo; // No se permiten turnos duplicados
        }

        // 2. Actualizar altura del nodo antecesor
        actualizarAltura(nodo);

        // 3. Calcular el factor de equilibrio para verificar desbalances
        int fe = ObetenerFE(nodo);

        // Caso Izquierda-Izquierda (Requiere RSR)
        if (fe < -1 && turno < nodo.izq.idturno) {
            return rotarDerecha(nodo);
        }

        // Caso Derecha-Derecha (Requiere RSL)
        if (fe > 1 && turno > nodo.der.idturno) {
            return rotarIzquierda(nodo);
        }

        // Caso Izquierda-Derecha (Requiere RDR: RSL + RSR)
        if (fe < -1 && turno > nodo.izq.idturno) {
            nodo.izq = rotarIzquierda(nodo.izq);
            return rotarDerecha(nodo);
        }

        // Caso Derecha-Izquierda (Requiere RDL: RSR + RSL)
        if (fe > 1 && turno < nodo.der.idturno) {
            nodo.der = rotarDerecha(nodo.der);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // --- ELIMINACIÓN (Atención de un Turno) ---
    public void atenderTurno(int turno) {
        System.out.println("-> Atendiendo/Eliminando turno: " + turno);
        raiz = eliminar(raiz, turno);
    }

    private NodoTurno eliminar(NodoTurno nodo, int turno) {
        if (nodo == null) {
            System.out.println("El turno " + turno + " no se encuentra en la cola.");
            return nodo;
        }

        // Búsqueda del nodo a eliminar
        if (turno < nodo.idturno) {
            nodo.izq = eliminar(nodo.izq, turno);
        } else if (turno > nodo.idturno) {
            nodo.der = eliminar(nodo.der, turno);
        } else {
            // ¡Nodo encontrado! Aplicamos casos de eliminación BST
            if ((nodo.izq == null) || (nodo.der == null)) {
                // Caso 1 (Hoja) o Caso 2 (Un solo hijo)
                NodoTurno temp = (nodo.izq != null) ? nodo.izq : nodo.der;

                if (temp == null) { // Caso Hoja
                    temp = nodo;
                    nodo = null;
                } else { // Caso un solo hijo
                    nodo = temp; // Se reemplaza por el hijo
                }
            } else {
                // Caso 3: Nodo con dos hijos (Usamos sucesor inorden)
                NodoTurno temp = obtenerMinimo(nodo.der);
                nodo.idturno = temp.idturno;
                nodo.der = eliminar(nodo.der, temp.idturno);
            }
        }

        if (nodo == null) return nodo;

        // Actualizar altura
        actualizarAltura(nodo);

        // Rebalanceo tras la eliminación
        int fe = ObetenerFE(nodo);

        if (fe < -1 && ObetenerFE(nodo.izq) <= 0) {
            return rotarDerecha(nodo);
        }
        if (fe < -1 && ObetenerFE(nodo.izq) > 0) {
            nodo.izq = rotarIzquierda(nodo.izq);
            return rotarDerecha(nodo);
        }
        if (fe > 1 && ObetenerFE(nodo.der) >= 0) {
            return rotarIzquierda(nodo);
        }
        if (fe > 1 && ObetenerFE(nodo.der) < 0) {
            nodo.der = rotarDerecha(nodo.der);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private NodoTurno obtenerMinimo(NodoTurno nodo) {
        NodoTurno actual = nodo;
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual;
    }

    // --- BÚSQUEDA ---
    public boolean buscarTurno(int turno) {
        NodoTurno aux = raiz;
        while (aux != null) {
            if (turno == aux.idturno) return true;
            aux = (turno < aux.idturno) ? aux.izq : aux.der;
        }
        return false;
    }

    // --- RECORRIDO E IMPRESIÓN ---
    public void mostrarColaTurnos() {
        System.out.print("Cola de Turnos (Inorden): [ ");
        inorden(raiz);
        System.out.println("]");
        if (raiz != null) {
            System.out.println("Turno en la Raíz actual: " + raiz.idturno);
        }
        System.out.println("----------------------------------------");
    }

    private void inorden(NodoTurno n) {
        if (n != null) {
            inorden(n.izq);
            System.out.print(n.idturno + " (fe=" + ObetenerFE(n) + ") ");
            inorden(n.der);
        }
    }

    // --- MÉTODO MAIN PARA PRUEBAS ---
    public static void main(String[] args) {
        ControlClinica clinica = new ControlClinica();

        System.out.println("=== SIMULACIÓN: COLA DE ATENCIÓN EN CLÍNICA ===");
        
        // Insertamos turnos de forma que fuercen balanceos automáticos
        clinica.registrarTurno(10);
        clinica.mostrarColaTurnos();

        clinica.registrarTurno(20);
        clinica.mostrarColaTurnos();

        // Al meter el 30, el 10 queda con fe=2, provocando una Rotación Simple Izquierda
        clinica.registrarTurno(30); 
        clinica.mostrarColaTurnos();

        clinica.registrarTurno(40);
        clinica.registrarTurno(25);
        clinica.mostrarColaTurnos();

        // Probando la búsqueda
        System.out.println("¿Está el paciente con el turno 25 en espera?: " + clinica.buscarTurno(25));
        System.out.println("¿Está el paciente con el turno 50 en espera?: " + clinica.buscarTurno(50));
        System.out.println("----------------------------------------");

        // Probando la eliminación (Atención de pacientes)
        clinica.atenderTurno(10); // El turno 10 es un nodo hoja en este punto
        clinica.mostrarColaTurnos();
    }   
}
