package Graph;

public interface IGraph {
	void connect (int vertex1, int vertex2);
	void disconnect(int vertex1, int vertex2);
	boolean equals(IGraph m);
	String toString();
	int getGraph(int v1, int v2);
	int getGraphSize(int v);
	public int getSize();
}
