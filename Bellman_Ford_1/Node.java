package Bellman_Ford_1;
import java.util.ArrayList;

public class Node<E> {
	E value;
	private ArrayList<Node<E>> vecinos = new ArrayList<Node<E>>();
	
	private ArrayList<Integer> aristas = new ArrayList<Integer>();
	
	public Node(E e){
		this.value = e;
	}
	public boolean equals(Object o) {
		return value.equals(((Node<E>)o).value);
	}
	public int getNumeroDeVecinos() {
		return vecinos.size();
	}
	
	public Node<E> getVecino(int i){
		return vecinos.get(i);
	}
	public int getDistanciaDelVecinoI(int i){
		return aristas.get(i);
	}
	public void addVecino(Node<E> a, int distancia) {
		vecinos.add(a);
		aristas.add(distancia);
	}
	
}