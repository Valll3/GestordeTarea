package application;

public class Tarea {
	String descripcion;
	int prioridad;
	
	public Tarea(String descripcion,int prioridad) {
		this.descripcion=descripcion;
		this.prioridad=prioridad;
	}
    public String getDescripcion() {
        return descripcion;
    }

    public int getPrioridad() {
        return prioridad;
    }

	public void resolver() {
		System.out.println("resolviendo tarea"+descripcion);
		
	}

}
