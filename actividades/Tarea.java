package actividades;

public class Tarea implements Comparable<Tarea>{

    private String titulo;
    private int prioridad;
    private String estado;

    public Tarea(String titulo,int prioridad,String estado){
        this.titulo=titulo;
        this.prioridad=prioridad;
        this.estado=estado;
    }

    public String getTitulo(){
        return titulo;
    }

    public int getPrioridad(){
        return prioridad;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado=estado;
    }

    public int compareTo(Tarea otra){
        return prioridad-otra.prioridad;
    }

    public String toString(){
        return "["+titulo+
                " | Prioridad: "+prioridad+
                " | Estado: "+estado+"]";
    }

}