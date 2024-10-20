package application;

import java.util.PriorityQueue;

public class Gestor {
	private PriorityQueue<Tarea> colaDeTareas;
	public Gestor() {
		colaDeTareas=new PriorityQueue<>(new ComparadorDeTareas());
	}
	public void agregarTarea(String descripcion,int prioridad) {
		Tarea nuevaTarea=new Tarea(descripcion,prioridad);
		colaDeTareas.offer(nuevaTarea);
		System.out.println("Tarea"+descripcion+"añadida");
		
	}
	public Tarea resolverTarea() {
	    Tarea tarea = colaDeTareas.poll(); 
	    if (tarea != null) {
	        tarea.resolver();  
	    }
	    return tarea;  
	}


	public boolean vacia() {
		return colaDeTareas.isEmpty();
	}

}
