import java.util.ArrayList;


public class Maze {
	
Vertex s; //origin
Vertex t; //sink
ArrayList<Vertex> V; //the list of adjacency lists of vertices in the graph

Maze(){
	    s = null;
	    t = null;
            V = new ArrayList<Vertex>(); 
 }
 
//remember to call this at the end of solve()
void Deconstructor(){
	s = null;
	t = null;
	V.clear();
}
 
//Implement the Dijkstra Algorithm to Compute the Shortest Path
String solve(String maze){
    return "null";
}
        




}