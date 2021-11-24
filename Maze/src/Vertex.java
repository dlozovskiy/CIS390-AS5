import java.util.ArrayList;


	
// A helper class implementing a vertex in
// an adjacency-list-based graph.

public class Vertex
{
    public
    Vertex(int r, int c)
    {
        row = r;
        col = c;
        neighs = new ArrayList<Pair>(); 
        pre = null; 
        dist = 100000000; 
    }
    
    // Corresponding row and column location in maze
    int row;
    int col;
    
    // List of neighboring vertices
    ArrayList<Pair> neighs;
    Vertex pre; 
    int dist; 
}