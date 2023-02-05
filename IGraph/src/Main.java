import Graph.*;
public class Main {
	
	public static int visited[];
	
	public static void main(String[] args) {
		
		MatrixGraph matr1 = new MatrixGraph (5);
		ListGraph lgr1 = new ListGraph (5);
		
		matr1.connect(0, 1);
		matr1.connect(0, 2);
		matr1.connect(0, 4);
		matr1.connect(1, 3);
		matr1.connect(1, 4);
		matr1.connect(2, 3);
		matr1.connect(3, 4);
		
		lgr1.connect(0, 1);
		lgr1.connect(0, 2);
		lgr1.connect(0, 4);
		lgr1.connect(1, 3);
		lgr1.connect(1, 4);
		lgr1.connect(2, 3);
		lgr1.connect(3, 4);
		
		System.out.println(matr1);
		System.out.println(lgr1);
		
		
		visited = new int[10];
		DFS(lgr1, 0);
		System.out.print("\n");
		visited = new int[10];
		DFS(matr1, 0);
	}
	
	static void DFS(IGraph t, int r){
		visited[r] = 1;
		System.out.print(r + " ");
	
		for(int j = 0; j < t.getSize(); j++) {				
			if(t.getGraph(r, j) == 1 && visited[j] == 0) {
				visited[j] = 1;
				DFS(t, j);
			}
		}
    }
}
