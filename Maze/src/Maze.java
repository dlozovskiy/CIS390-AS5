import java.util.ArrayList;
import java.util.Collections;

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

		// Find Start and Sink Points
		char map[][] = startSink(maze);

		MinHeap heap = new MinHeap();
		heap.push(s, 0);

		// findNeighs(s, map);

		Deconstructor();
		System.out.println(printPath(map));
		return printPath(map);

	}

	void findNeighs(Vertex vert, char[][] map) {
		if (vert.col == t.col && vert.row == t.row)
			return;

		int vRow = vert.row;
		int vCol = vert.col;
		Vertex neigh;
		// UP
		try {
			if (map[vRow - 1][vCol] == 32) {
				neigh = new Vertex(vRow - 1, vCol);
				findNeighs(neigh, map);
				vert.neighs.add(new Pair(neigh, 1));

			}
		} catch (Exception e) {

		}
		// DOWN
		try {
			if (map[vRow + 1][vCol] == 32) {
				neigh = new Vertex(vRow + 1, vCol);
				findNeighs(neigh, map);
				vert.neighs.add(new Pair(neigh, 1));

			}
		} catch (Exception e) {

		}
		// LEFT
		try {
			if (map[vRow][vCol - 1] == 32) {
				neigh = new Vertex(vRow, vCol - 1);
				findNeighs(neigh, map);
				vert.neighs.add(new Pair(neigh, 1));

			}
		} catch (Exception e) {

		}
		// RIGHT
		try {
			if (map[vRow][vCol + 1] == 32) {
				neigh = new Vertex(vRow, vCol + 1);
				findNeighs(neigh, map);
				vert.neighs.add(new Pair(neigh, 1));
			}
		} catch (Exception e) {

		}
	}

	char[][] startSink(String maze) {

		String row[] = maze.split("\n");
		char tomap[][] = new char[row.length][];

		for (int r = 0; r < row.length; r++) {
			char[] col = row[r].toCharArray();
			tomap[r] = new char[col.length];
			for (int c = 0; c < col.length; c++) {
				tomap[r][c] = col[c];
				if (col[c] == 32 || (col[c] <= 57 && col[c] >= 48)) {

					// START AND END POINTS
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

		return tomap;
	}

	String printPath(char[][] map) {
		String path = "";
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				path += map[r][c];
			}
			path += "\n";
		}
		return path;
	}
}