package Bellman_Ford_1;

public class Main {
	public static void main(String[] args) {

		Graph<String> g = new Graph<String>();
		
		Node<String> A = g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		
		g.addUndirectedEdge("A", 1, "B");
		g.addUndirectedEdge("A", 3, "F");
		g.addUndirectedEdge("B", 1, "F");
		g.addUndirectedEdge("B", 3, "C");
		g.addUndirectedEdge("B", 5, "E");
		g.addUndirectedEdge("C", 2, "D");
		g.addUndirectedEdge("F", 6, "D");
		g.addUndirectedEdge("F", 2, "E");
		g.addUndirectedEdge("E", 1, "D");
		
		
		System.out.println("Comienzo");
		
//		for (Node<String> i : g.listNodes) {
//			System.out.println(i.value);
//		}
		
		String[][] bf = g.Bellman_Ford(A);;
		
		String[] distancias=bf[0];
		
		
		for (int i = 0; i < distancias.length; i++) {
			System.out.println(g.listNodes.get(i).value+" ->  "+bf[1][i]+" , "+distancias[i]);
		}
		
		
		System.out.println("Fin");
		
		Graph<String> g2 = new Graph<String>();
		
		Node<String> A2 = g2.addVertex("A");
		g2.addVertex("B");
		g2.addVertex("C");
		g2.addVertex("D");
		g2.addVertex("E");
		g2.addVertex("F");
		
		g2.addDirectedEdge("A", 6, "B");
		g2.addDirectedEdge("A", 4, "C");
		g2.addDirectedEdge("A", 5, "D");
		g2.addDirectedEdge("B", -1, "E");
		g2.addDirectedEdge("C", -2, "B");
		g2.addDirectedEdge("C", 3, "E");
		g2.addDirectedEdge("D", -2, "C");
		g2.addDirectedEdge("D", -1, "F");
		g2.addDirectedEdge("E", 3, "F");
		
		
		System.out.println("Comienzo");
		
//		for (Node<String> i : g.listNodes) {
//			System.out.println(i.value);
//		}
		
		String[][] bf2 = g2.Bellman_Ford(A2);;
		
		String[] distancias2=bf2[0];
		
		
		for (int i = 0; i < distancias.length; i++) {
			System.out.println(g2.listNodes.get(i).value+" ->  "+bf2[1][i]+" , "+distancias2[i]);
		}
		
		
		System.out.println("Fin");
		
	}
}