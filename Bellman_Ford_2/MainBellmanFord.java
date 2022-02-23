package Bellman_Ford_2;

import java.util.Iterator;

public class MainBellmanFord {

	public static void main(String[] args) {				
		System.out.println("Práctica 3 - Bellman-Ford y programación dinámica");			
		
		Grafo grafoTest = new Grafo(6);
		grafoTest.addEdge('A', 'B', 1);
		grafoTest.addEdge('A', 'F', 3);
		grafoTest.addEdge('B', 'C', 3);
		grafoTest.addEdge('B', 'E', 5);
		grafoTest.addEdge('B', 'F', 1);
		grafoTest.addEdge('C', 'D', 2);
		grafoTest.addEdge('D', 'E', 1);
		grafoTest.addEdge('D', 'F', 6);
		grafoTest.addEdge('E', 'F', 2);	
		
		grafoTest.addEdge('B', 'A', 1);
		grafoTest.addEdge('F', 'A', 3);
		grafoTest.addEdge('C', 'B', 3);
		grafoTest.addEdge('E', 'B', 5);
		grafoTest.addEdge('F', 'B', 1);
		grafoTest.addEdge('D', 'C', 2);
		grafoTest.addEdge('E', 'D', 1);
		grafoTest.addEdge('F', 'D', 6);
		grafoTest.addEdge('F', 'E', 2);
		
		System.out.println("Grafo:");
		grafoTest.imprimir();
		System.out.println("Camino más corto usando Bellman Ford:");
		BellmanFord(grafoTest, 'A');	
		
	}

	public static void BellmanFord(Grafo grafo, char cInicio) {
		int inicio= cInicio-65;	
		int[] distancias = new int[grafo.cantNodos];		
		int[] anteriores = new int[grafo.cantNodos];
		
		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = Integer.MAX_VALUE;
			anteriores[i] = -1;
		}
		distancias[inicio] = 0;
		
		for (int i = 1; i < grafo.cantNodos; i++) {
			for (int j = 0; j < grafo.cantNodos; j++) {
				Iterator<Arista> it = grafo.vecinos(j).iterator();
				while (it.hasNext()) {
					Arista e = it.next(); 
					if (distancias[e.getStartPoint()] + e.getWeight() < distancias[e.getEndPoint()]) {
						distancias[e.getEndPoint()] = distancias[e.getStartPoint()] + e.getWeight();
						anteriores[e.getEndPoint()] = e.getStartPoint();
					}
				}
			}
		}
		
		for (int i = 0; i < grafo.cantNodos - 1; i++) {
			Iterator<Arista> it = grafo.vecinos(i).iterator();
			while (it.hasNext()) {
				Arista e = it.next();				
				if (distancias[e.getStartPoint()] + e.getWeight() < distancias[e.getEndPoint()]) {
					System.out.println("El grafo contiene un ciclo negativo");
					return;
				}
			}
		}

		System.out.println("Nodo\tDistancia\tPredecesor");
		for (int i = 0; i < grafo.cantNodos; i++) {
			int pred= anteriores[i];
			System.out.println((char)(i+65) + "\t" + distancias[i] + "\t\t" + (char)(pred+65));
		}

	}
}