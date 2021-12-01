import java.util.ArrayList;

public class Maze {

	Vertex s; // origin
	Vertex t; // sink
	ArrayList<Vertex> V; // the list of adjacency lists of vertices in the graph

	Maze() {
		s = null;
		t = null;
		V = new ArrayList<Vertex>();
	}

	// remember to call this at the end of solve()
	void Deconstructor() {
		s = null;
		t = null;
		V.clear();
	}

	// Implement the Dijkstra Algorithm to Compute the Shortest Path
	String solve(String maze) {
		// Map each vertex to ArrayList

		String row[] = maze.split("\n");

		for (int r = 0; r < row.length; r++) {
			char[] col = row[r].toCharArray();

			for (int c = 0; c < col.length; c++) {
				if (col[c] == 32 || (col[c] <= 57 && col[c] >= 48)) {
					V.add(new Vertex(r, c));

					int r_perimeter = row.length - 1;
					int c_perimeter = col.length - 1;

					if (r == 0 || r == r_perimeter) {
						if (c == 0 || c < c_perimeter) {
							if (s == null) {
								s = new Vertex(r, c);
							}
							t = new Vertex(r, c);
						}
					}

					if (r == 0 || r < r_perimeter) {
						if (c == 0 || c == c_perimeter) {
							if (s == null) {
								s = new Vertex(r, c);
							}
							t = new Vertex(r, c);
						}
					}

				}
			}
		}

		// for (int i = 0; i < V.size(); i++) {
		// System.out.println(V.get(i).row + " , " + V.get(i).col);
		// }

		System.out.println("Start = " + s.row + " , " + s.col);
		System.out.println("End = " + t.row + " , " + t.col);
		Deconstructor();
		return "null";

	}

}