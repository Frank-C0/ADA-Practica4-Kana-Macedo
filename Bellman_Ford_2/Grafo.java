package Bellman_Ford_2;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Grafo {
	public int cantNodos;
	private PriorityQueue<Arista>[] adj;
	
	@SuppressWarnings("unchecked")
	public Grafo(int n) {
		this.cantNodos = n;
		// initialize adj
		adj = new PriorityQueue[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new PriorityQueue<Arista>();
		}
	}

	public void addEdge(char start, char target, int weight) {
		int i=start-65;
		adj[i].add(new Arista(start, target, weight));
	}

	public void addEdge(Arista e) {
		adj[e.getStartPoint()].add(e);
	}

	public void removeEdge(char start, char target) {
		int i=start-65;
		Iterator<Arista> it = adj[i].iterator();
		Arista other = new Arista(start, target, 0);
		while (it.hasNext()) {
			if (it.next().equals(other)) {
				it.remove();
				return;
			}
		}
	}

	public boolean hasEdge(Arista e) {
		return adj[e.getStartPoint()].contains(e);
	}

	public PriorityQueue<Arista> vecinos(int vertex) {
		return adj[vertex];
	}

	public void imprimir() {
		for (int i = 0; i < cantNodos; i++) {
			PriorityQueue<Arista> aristas = vecinos(i);
			Iterator<Arista> it = aristas.iterator();
			System.out.print((char)(i+65) + ": ");
			for (int j = 0; j < aristas.size(); j++) {
				System.out.print(it.next() + " ");
			}
			System.out.println();
		}
	}
}