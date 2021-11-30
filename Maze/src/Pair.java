
// A helper class implementing a pair (vertex, edgelength) in an adjacency list of a vertex

public class Pair {

	public Vertex v;
	int val;

	Pair(Vertex u, int x) {
		v = u;
		val = x;
	}

	int getvalue() {
		return val;
	}

	Vertex getnode() {
		return v;
	}
}