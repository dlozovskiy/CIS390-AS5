import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class MinHeap {

	// For the mandatory running times below:
	//
	// n is the number of strings in the MinHeap.
	//
	// Assume the operations of hashtable are O(1) time
	// (they are average case, but not worst-case).

	Hashtable<Vertex, Integer> I; // Maps elements to indices in H and you need this when you define
											// decrease_key()
	ArrayList<Pair> H; // The heap
	int size; // size of your heap

	// Creates an empty MinHeap
	MinHeap() {
		H = new ArrayList<Pair>(); // The heap
		I = new Hashtable<Vertex, Integer>();
		I.clear();
		H.clear();
		size = 0;
	}

	// Returns the number of elements in the MinHeap.
	//
	// Must run in O(1) time.
	int size() {
		return H.size();
	}

	// Pushes a new element x with key p
	// into the MinHeap.
	//
	// Must run in O(log(n)) time.
	void push(Vertex x, int p) {
		H.add(new Pair(x, p));
		bubble_up(H.size() - 1);
	}

	// Returns the vertex at the front of the MinHeap.
	// Undefined behavior if it is empty.
	//
	// Must run in O(1) time.
	Vertex front() {
		return new Vertex(0, 0);
	}

	// Removes the vertex at the front of the MinHeap.
	// Undefined behavior if the MinHeap is empty.
	//
	// Must run in O(log(n)) time.
	void pop() {
		if (H.size() == 0)
			return;

	}

	// If vertex x is in the MinHeap
	// with current key at least new_p,
	// then changes the key of x to new_p.
	// Undefined behavior otherwise.
	//
	// Must run in O(log(n)) time.
	void decrease_key(Vertex x, int new_p) {

	}

	void bubble_up(int i) {
		if (i <= 0)
			return;
		if (H.get(i).val < H.get((i - 1) / 2).val) {
			Collections.swap(H, i, (i - 1 / 2));
			bubble_up((i - 1) / 2);

		}
	}

	void bubble_down(int i) {
		int lChild = (int) H.get(2 * i + 1).val;
		int rChild = H.get(2 * i + 2).val;
		int parent = H.get(i).val;
		if (lChild < rChild && rChild < parent) {
			Collections.swap(H, 2 * i + 1, i);
			bubble_down(2 * i + 1);
		}
		if (rChild < lChild && lChild < parent) {
			Collections.swap(H, 2 * i + 2, i);
			bubble_down(2 * i + 2);
		}
	}

}