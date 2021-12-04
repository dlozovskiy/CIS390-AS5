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

		MinHeap heap = new MinHeap();
		// Find Start and Sink Points
		char[][] map = startSink(maze);
		System.out.println(printPath(map));

		int vIndex = 0;
		int tIndex = -1;

		for (int i = 0; i < V.size(); i++) {
			Vertex vert = findNeighs(i);
			if (vert == s)
				vIndex = i;
			if (vert == t)
				tIndex = i;
		}

		heap.push(s, 0);

		while (vIndex != tIndex) {
			for (int i = 0; i < V.get(vIndex).neighs.size(); i++) {

				Vertex vert = V.get(vIndex).neighs.get(i).getnode();

				if (vert == V.get(vIndex).pre)
					continue;
				if (heap.I.containsKey(vert)) {
					if (V.get(vIndex).dist + V.get(vIndex).neighs.get(i).getvalue() < heap.I.get(vert)) {
						heap.decrease_key(vert, V.get(vIndex).dist + V.get(vIndex).neighs.get(i).getvalue());
						vert.pre = V.get(vIndex);
						vert.dist = V.get(vIndex).dist + V.get(vIndex).neighs.get(i).getvalue();
					} else
						continue;

				}

				vert.pre = V.get(vIndex);
				vert.dist = V.get(vIndex).dist + V.get(vIndex).neighs.get(i).getvalue();

				heap.push(vert, vert.dist);

				for (int n = 0; n < V.size(); n++) {
					if (V.get(n) == vert)
						vIndex = n;
				}
			}

		}

		// System.out.println(s.neighs.size());

		// Add S
		// Add neighbor vertices
		// If neighbor vertex exist, update key and pre if shorter
		// reach T

		// heap.push(s, 0);

		Deconstructor();

		return printPath(map);

	}

	void push(Vertex vertice, char[][] map) {

		if (vertice == s) {
			vertice.dist = 0;
			vertice = findNeighs(vertice, map);

		}
		vertice = findNeighs(vertice, map);
		for (int i = 0; i < vertice.neighs.size(); i++) {
			Vertex vert = vertice.neighs.get(i).getnode();
			vert = findNeighs(vert, map);
			vert.dist = vertice.dist + vertice.neighs.get(i).getvalue();

			vert.pre = vertice;

		}
	}

	Vertex findNeighs(int k) {
		Vertex vert = V.get(k);
		int vRow = vert.row;
		int vCol = vert.col;
		int nRow, nCol;
		for (int i = 0; i < V.size(); i++) {
			Vertex n = V.get(i);
			nRow = n.row;
			nCol = n.col;

			// CHECK IF ADJACENT
			// CASES
			// 1: nRow+1==vRow&&nCol==vCol
			// 2: nRow-1==vRow&&nCol==vCol
			// 3: nRow==vRow&&nCol+1==vCol
			// 4: nRow==vRow&&nCol-1==vCol

			if (nRow + 1 == vRow && nCol == vCol) {
				vert.neighs.add(new Pair(n, 1));
			}
			if (nRow - 1 == vRow && nCol == vCol) {
				vert.neighs.add(new Pair(n, 1));
			}
			if (nRow == vRow && nCol + 1 == vCol) {
				vert.neighs.add(new Pair(n, 1));
			}
			if (nRow == vRow && nCol - 1 == vCol) {
				vert.neighs.add(new Pair(n, 1));
			}

		}
		return vert;
	}

	Vertex findNeighs(Vertex vert, char[][] map) {

		int vRow = vert.row;
		int vCol = vert.col;
		int preCol, preRow;
		try {
			preCol = vert.pre.col;
			preRow = vert.pre.row;
		} catch (Exception e) {
			preCol = -1;
			preRow = -1;
		}
		// vert.dist = Math.abs(vRow - s.row) + Math.abs(vCol - s.col);
		Vertex neigh;

		// UP
		try {
			if (map[vRow - 1][vCol] == 32) {
				// System.out.println("UP!");
				neigh = new Vertex(vRow - 1, vCol);
				neigh.pre = vert;
				if (neigh.col != preCol || neigh.row != preRow)
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
				if (neigh.col != preCol || neigh.row != preRow)
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
				if (neigh.col != preCol || neigh.row != preRow)
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
				if (neigh.col != preCol || neigh.row != preRow)
					vert.neighs.add(new Pair(neigh, 1));
			}
		} catch (Exception e) {
			// System.out.println("OH NO!");
		}

		return vert;

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
					Vertex vert = new Vertex(r, c);
					V.add(vert);
					// START AND END POINTS
					int r_perimeter = row.length - 1;
					int c_perimeter = col.length - 1;

					if (r == 0 || r == r_perimeter) {
						if (c == 0 || c < c_perimeter) {
							if (s == null) {
								s = vert;
								s.dist = 0;
							}
							t = vert;
						}
					}

					if (r == 0 || r < r_perimeter) {
						if (c == 0 || c == c_perimeter) {
							if (s == null) {
								s = vert;
								s.dist = 0;
							}
							t = vert;
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