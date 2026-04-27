package actividades;

public class Main {

    public static void main(String[] args) {

        GestorDeTareas<Tarea> g=
             new GestorDeTareas<>();

        Tarea t1=
        new Tarea("Diseñar BD",2,"pendiente");

        Tarea t2=
        new Tarea("Deploy",1,"pendiente");

        Tarea t3=
        new Tarea("Documentar",3,"completada");

        Tarea t4=
        new Tarea("Code review",2,"pendiente");

        Tarea t5=
        new Tarea("Corregir bug",1,"completada");


        g.agregarTarea(t1);
        g.agregarTarea(t2);
        g.agregarTarea(t3);
        g.agregarTarea(t4);
        g.agregarTarea(t5);

        g.imprimirTareas();

        System.out.println(
         "Total tareas: "+
          g.contarTareas()
        );

        g.eliminarTarea(t3);

        System.out.println("Invertida");

        g.invertirTareas();

        g.imprimirTareas();

    }

}