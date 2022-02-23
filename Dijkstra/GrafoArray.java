package Dijkstra;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class GrafoArray {

	static ArrayList<Node2> listNodes = new ArrayList<Node2>();

	public GrafoArray(Node2[] nodos) {
		for (Node2 node2 : nodos) {
			listNodes.add(node2);
		}
	}

	static double[] distancias = null;

	public double[] Dijkstra(Node2 source) {
		distancias = new double[listNodes.size()];
		for (int i = 0; i < distancias.length; i++) {
			distancias[i] = Double.POSITIVE_INFINITY;
		}

		distancias[listNodes.indexOf(source)] = 0;

		PriorityQueue<Node2> queue = new PriorityQueue<Node2>();
		queue.add(source);

		while (!queue.isEmpty()) {
			Node2 u = queue.poll();
			for (Edge2 e : u.adjacencies) {

				Node2 v = e.target;
				double weight = e.weight;

				double distanceFromU = distancias[listNodes.indexOf(u)] + weight;
//				System.out.println(distanceFromU);
				if (distanceFromU < distancias[listNodes.indexOf(v)]) {
					
					System.out.println("Anterior distancia hasta "+v.value+": "+distancias[listNodes.indexOf(v)]+",  nueva: "+distanceFromU );
					
					queue.remove(v);
					distancias[listNodes.indexOf(v)] = distanceFromU;
					v.parent = u;
					queue.add(v);
//					System.out.println("e " + e.weight);
				}
			}
		}
		return distancias;
	}

}

class Edge2 {
	public final Node2 target;
	public final double weight;

	public Edge2(Node2 targetNode, double weightVal) {
		target = targetNode;
		weight = weightVal;
	}
}

class Node2 implements Comparable<Node2> {

	public final String value;
	public Edge2[] adjacencies;
	public Node2 parent;

	public Node2(String val) {
		value = val;
	}

	public String toString() {
		return value;
	}

	@Override
	public int compareTo(Node2 o) {
		return Double.compare(GrafoArray.distancias[GrafoArray.listNodes.indexOf(this)],
				GrafoArray.distancias[GrafoArray.listNodes.indexOf(o)]);

	}
}
