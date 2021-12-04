import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle.Control;
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
		ArrayList<Integer> traveled = new ArrayList<>();
		//System.out.println(printPath(map));

		int vIndex = 0;
		int tIndex = -1;

		for (int i = 0; i < V.size(); i++) {
			Vertex vert = findNeighs(i);
			if (vert == s)
				vIndex = i;
				traveled.add(vIndex);
			if (vert == t)
				tIndex = i;
		}

		heap.push(s, 0);
		//minheap arraylist becomes useful

		//while heap H is not empty
		//Add vertex v neighbors
		//Pop vertex v
		//Go to next vertex
		while (heap.H.size()>0) {
			for (int i = 0; i < heap.front().neighs.size(); i++) {

				//Select neighbor vertex
				Vertex vert = heap.front().neighs.get(i).getnode();

				//If vert is pre, continue to next neighbor vertex
				if (vert == heap.front().pre)
					continue;

				//If Vertex exists in minheap
				if (heap.I.containsKey(vert)) {

					//Check if distance to this same vertex is shorter
					if (heap.front().dist + heap.front().neighs.get(i).getvalue() < heap.I.get(vert)) {
						heap.decrease_key(vert, heap.front().dist + heap.front().neighs.get(i).getvalue());
						vert.pre = heap.front();
						vert.dist = heap.front().dist + heap.front().neighs.get(i).getvalue();

					//Otherwise contine to next vertex
					} else
						continue;

				}

				//If vertex is not found in minheap, add
				vert.pre = heap.front();
				vert.dist = heap.front().dist + heap.front().neighs.get(i).getvalue();
				heap.push(vert, vert.dist);
				

				//Find vert index in V
				
				for (int n = 0; n < V.size(); n++) {

						//Set vert neighbors to be scanned//
					//Add vert index to traveled list
					if (V.get(n) == vert)
						//vIndex = n;
						traveled.add(vIndex);
				}
			}
			heap.pop();
		}

		
		map = drawPath(map);
		Deconstructor();
		System.out.println(printPath(map));
		return printPath(map);

	}
	char[][] drawPath(char[][] map){
		int iRow,iCol,dist;
		//Pair p = path.get(path.size()-1);
		Vertex v = t;
		dist = v.dist;
		
		while(dist>=0){
			iRow = v.row;
			iCol = v.col;
			map[iRow][iCol] = 'o';

			if(v.pre==null)break;
			v = v.pre;
			dist=v.dist;
		}
		

		return map;
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

			//Check for portals
			
		}
		return vert;
	}

	Vertex findPortal(Vertex open, char[][] map){
		int oCol = open.col;
		int oRow = open.row;
		char portal = map[oCol][oRow];

		//Scan Map
		for(int r = 0; r < map.length;r++){
			for (int c = 0; c < map[r].length; c++) {
				//Find character at alt coordinates
				if(portal==map[r][c]&&(oCol!=c||oRow!=r)){
					//Find vertex with such coordinates in V
					for(int n = 0; n<V.size(); n++){
						Vertex exit = V.get(n);
						if (exit.col==c&&exit.row==r) return exit;
					}
				}
			}	
		}
		return open;
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