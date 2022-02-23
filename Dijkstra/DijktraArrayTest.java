package Dijkstra;
public class DijktraArrayTest {

	public static void main(String[] args) {

		Node2 A = new Node2(	"A");
		Node2 B = new Node2(	"B");
		Node2 C = new Node2(	"C");
		Node2 D = new Node2(	"D");
		Node2 E = new Node2(	"E");
		Node2 F = new Node2(	"F");

		// initialize the edges
		A.adjacencies = new Edge2[] { new Edge2(B, 1), new Edge2(F, 3)
				};

		B.adjacencies = new Edge2[] { new Edge2(F, 1), new Edge2(C, 3), new Edge2(E, 5) 
				, new Edge2(A, 1)};

		C.adjacencies = new Edge2[] { new Edge2(D, 2) 
				, new Edge2(B, 3)};

		D.adjacencies = new Edge2[] { 
				 new Edge2(C, 2), new Edge2(F, 6), new Edge2(E, 1)
		};

		E.adjacencies = new Edge2[] { new Edge2(D, 1) 
				, new Edge2(B, 5), new Edge2(F, 2)};

		F.adjacencies = new Edge2[] { new Edge2(D, 6), new Edge2(E, 2)
				, new Edge2(A, 3), new Edge2(B, 1)};
		
		Node2[] nodes = {A,B,C,D,E,F};

		GrafoArray grafoArray = new GrafoArray(nodes);

		double[] dijkstraArray = grafoArray.Dijkstra(A);

		System.out.println("Dijkstra con Arrays");
		System.out.println("Distancias desde " + A.value + " ...");
		for (int i = 0; i < grafoArray.listNodes.size(); i++) {
			Node2 n = grafoArray.listNodes.get(i);
			System.out.println("... hasta " + n.value + " \t= " + grafoArray.distancias[i]);
		}

	}

}
