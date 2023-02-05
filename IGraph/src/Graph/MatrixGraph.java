package Graph;

public class MatrixGraph implements IGraph{
	
	public int curRow;
	public int curColumn;
	public int[][] matrix;
	
	public MatrixGraph (int size){
		
		curRow = size;
		curColumn = size;
		matrix = new int [curRow][curColumn];

		for(int i = 0; i < curRow; i++){
			for(int j = 0; j < curColumn; j++){
				//if(i == j){
					//matrix[i][j] = 1;
				//}
			}
		}
	}
		
	public void connect (int vertex1, int vertex2){
		matrix[vertex1][vertex2] = 1;
		matrix[vertex2][vertex1] = 1;
	}
	
	public void disconnect (int vertex1, int vertex2) {
		matrix[vertex1][vertex2] = 0;
		matrix[vertex2][vertex1] = 0;
	}
	
	public int getGraph(int v1, int v2) {
		return matrix[v1][v2];
	}
	
	public int getSize() {
		return curRow;
	}
	
	public boolean equals (IGraph m){

		int flag = 0;

		if(curRow == this.curRow && curColumn == this.curColumn){
			for(int i = 0; i < curRow; i++){
				for(int j = 0; j < curColumn; j++){
					if(this.getGraph(i, j) != m.getGraph(i, j)){
						flag = 1;
					} 
				}
			}
		}
		else{
			flag = 1;
		}

		if(flag == 0) return true;
		else return false;
	}
	
	public final String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < curRow; i++){
			for(int j = 0; j < curColumn; j++){ 
				sb.append(matrix[i][j] + " ");
			}
			sb.append("\n");
		} 

		String text = sb.toString();
		return text;
	}
	
	public int getGraphSize (int v) {
		return curRow;
	}
}