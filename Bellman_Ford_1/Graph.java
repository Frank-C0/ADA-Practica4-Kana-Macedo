package Bellman_Ford_1;

import java.util.ArrayList;
import java.util.Stack;

public class Graph<E> {
	ArrayList<Node<E>> listNodes = new ArrayList<Node<E>>();

	public Graph() {
	}

	public Node<E> addVertex(E e) {
		Node<E> node = new Node<E>(e);
		listNodes.add(node);
		return node;
	}
	public void addUndirectedEdge(E nodo1, int distancia, E nodo2) {
		Node<E> node1 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo1)) {
				node1 = node;
			}
		}
		Node<E> node2 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo2)) {
				node2 = node;
			}
		}
		node1.addVecino(node2, distancia);
		node2.addVecino(node1, distancia);
		
	}
	
	public void addDirectedEdge(E nodo1, int distancia, E nodo2) {
		Node<E> node1 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo1)) {
				node1 = node;
			}
		}
		Node<E> node2 = null;
		for (Node<E> node : listNodes) {
			if (node.value.equals(nodo2)) {
				node2 = node;
			}
		}
		node1.addVecino(node2, distancia);
		
		
	}
	
	
	
	public String[][] Bellman_Ford(Node<E> nodoInicial) {
		Stack<Node<E>> nodosCapaN = new Stack<Node<E>>();
		int[] distancias = new int[listNodes.size()];
		Object[] nodeAnterior = new Object[listNodes.size()];
		nodeAnterior[0] = nodoInicial;
		nodosCapaN.add(nodoInicial);
		
		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = Integer.MAX_VALUE;
		}
		distancias[0]=0;
		
		for(int N_Iteraciones = 1;N_Iteraciones<listNodes.size();N_Iteraciones++) {
			System.out.println("\nPaso "+(N_Iteraciones));
			Stack<Node<E>> nodosCapaSiguiente = new Stack<Node<E>>();
			ArrayList<Node<E>> temp = new ArrayList<Node<E>>();
			while(!nodosCapaN.isEmpty()) {
				Node<E> nodoActual = nodosCapaN.pop();
				
				for (int i = 0; i < nodoActual.getNumeroDeVecinos(); i++) {
					if(!temp.contains(nodoActual.getVecino(i))) {
						temp.add(nodoActual.getVecino(i));
					
						int indexVecino = indexOf(nodoActual.getVecino(i));
						int indexNodoActual = indexOf(nodoActual);
						if(distancias[indexVecino] > distancias[indexNodoActual]+nodoActual.getDistanciaDelVecinoI(i)) {
							System.out.println("anterior distancia hasta "+nodoActual.getVecino(i).value+": "+distancias[indexVecino] +",  nueva: "+ (distancias[indexNodoActual]+nodoActual.getDistanciaDelVecinoI(i)));
							distancias[indexVecino] = distancias[indexNodoActual]+nodoActual.getDistanciaDelVecinoI(i);
							nodeAnterior[indexVecino] = nodoActual;
						}
						nodoActual.getVecino(i);
//						System.out.println(".");
						if(!nodosCapaSiguiente.contains(nodoActual.getVecino(i))) {
							nodosCapaSiguiente.push(nodoActual.getVecino(i));
						}
					}
				}
			}
			
			nodosCapaN = nodosCapaSiguiente;
		}
		
		String[][] array = new String[2][nodeAnterior.length];
		
		for (int i = 0; i < nodeAnterior.length; i++) {
			array[0][i]=Integer.toString(distancias[i]);
			array[1][i]= ((Node<E>)nodeAnterior[i]).value.toString();
			
		}
		return array;
	}
	
	private int indexOf(Node<E> n) {
		int index=0;
		for (; index < listNodes.size(); index++) {
			if(listNodes.get(index).value.equals(n.value)) {
				break;
			}
		}
		return index;
	}

}















