package application;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ComparadorDeTareas implements Comparator<Tarea>{

	@Override
	public int compare(Tarea o1, Tarea o2) {
		return Integer.compare(o1.getPrioridad(), o2.getPrioridad());
	}		
}


