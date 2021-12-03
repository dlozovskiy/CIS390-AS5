import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;

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
		char[][] map = startSink(maze);

		MinHeap heap = new MinHeap();
		for (int i = 0; i < V.size() - 1; i++) {
			heap.push(V.get(i), 0);
		}
		System.out.println(heap.size);

		findNeighs(map);
		// System.out.println(s.neighs.size());

		Deconstructor();
		System.out.println(printPath(map));
		return printPath(map);

	}

	void findNeighs(char[][] map) {

		for (int i = 0; i < V.size(); i++) {
			Vertex vert = V.get(i);
			int vRow = vert.row;
			int vCol = vert.col;
			vert.dist = Math.abs(vRow - s.row) + Math.abs(vCol - s.col);
			Vertex neigh;

			// UP
			try {
				if (map[vRow - 1][vCol] == 32) {
					// System.out.println("UP!");
					neigh = new Vertex(vRow - 1, vCol);
					neigh.pre = vert;
					vert.neighs.add(new Pair(neigh, 1));

				}
			} catch (Exception e) {
				// System.out.println("OH NO!");
			}
			// DOWN
			try {
				if (map[vRow + 1][vCol] == 32) {
					// System.out.println("DOWN!");
					neigh = new Vertex(vRow + 1, vCol);
					neigh.pre = vert;
					vert.neighs.add(new Pair(neigh, 1));

				}
			} catch (Exception e) {
				// System.out.println("OH NO!");
			}
			// LEFT
			try {
				if (map[vRow][vCol - 1] == 32) {
					// System.out.println("LEFT!");
					neigh = new Vertex(vRow, vCol - 1);
					neigh.pre = vert;
					vert.neighs.add(new Pair(neigh, 1));

				}
			} catch (Exception e) {
				// System.out.println("OH NO!");
			}
			// RIGHT
			try {
				if (map[vRow][vCol + 1] == 32) {
					// System.out.println("RIGHT!");
					neigh = new Vertex(vRow, vCol + 1);
					neigh.pre = vert;
					vert.neighs.add(new Pair(neigh, 1));
				}
			} catch (Exception e) {
				// System.out.println("OH NO!");
			}

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
					V.add(new Vertex(r, c));
					// START AND END POINTS
					int r_perimeter = row.length - 1;
					int c_perimeter = col.length - 1;

					if (r == 0 || r == r_perimeter) {
						if (c == 0 || c < c_perimeter) {
							if (s == null) {
								s = new Vertex(r, c);
								s.dist = 0;
							}
							t = new Vertex(r, c);
						}
					}

					if (r == 0 || r < r_perimeter) {
						if (c == 0 || c == c_perimeter) {
							if (s == null) {
								s = new Vertex(r, c);
								s.dist = 0;
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