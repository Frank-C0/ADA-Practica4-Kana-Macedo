package Bellman_Ford_2;

public class Arista implements Comparable<Object>{
	private char start;
	private char target;
	private int weight;

	public Arista(char start, char target, int weight) {
		this.start = start;
		this.target = target;
		this.weight = weight;
	}

	public int getStartPoint() {
		return start-65;
	}

	public int getEndPoint() {
		return target-65;
	}

	public int getWeight() {
		return weight;
	}

	public boolean equals(Arista edge) {
		if (this.start == edge.start) {
			if (this.target == edge.target) {
				return true;
			}
		}
		return false;
	}
	
	public int compareTo(Object o) {
		Arista temp = (Arista) o;
		return Double.compare(this.weight, temp.weight);
	}

	public String toString() {
		return start + ":" + target + " (" + weight + ")";
	}

}