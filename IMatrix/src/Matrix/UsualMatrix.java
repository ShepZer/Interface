package Matrix;
import Exception.*;

public class UsualMatrix implements IMatrix{
	
	public int curRow;
	public int curColumn;
	public int[][] matrix;

	public UsualMatrix (int row, int column){

		if(row <= 0 || column <= 0){
			throw new MyException ("Error. Matrix with given dimensions could not be created");
		}
		
		curRow = row;
		curColumn = column;
		matrix = new int [curRow][curColumn];

		for(int i = 0; i < curRow; i++){
			for(int j = 0; j < curColumn; j++){
				matrix[i][j] = 0;
			}
		}
	}

	public IMatrix sum (IMatrix q){

		IMatrix matrix = new UsualMatrix(curRow, curColumn);

		if(this.curColumn == q.getColumn() + 1){
			for(int i = 0; i < curRow; i++){
				for(int j = 0; j < curColumn; j++){
					matrix.setElement(i, j, 0);
				}
			}

			if(curRow != q.getRow() || curColumn != q.getColumn() + 1){
				throw new MyException ("Error. Unable to calculate sum of matrices");
			}		

			for(int i = 0; i < curRow; i++){
				for(int j = 0; j < curColumn; j++){
					int t = q.getElement(i, j) + this.getElement(i, j);
					matrix.setElement(i, j, t);
				}
			}
		}
		else{

			for(int i = 0; i < curRow; i++){
				for(int j = 0; j < curColumn; j++){
					matrix.setElement(i, j, 0);
				}
			}

			if(curRow != q.getRow() || curColumn != q.getColumn() ){
				throw new MyException ("Error. Unable to calculate sum of matrices");
			}		
	
			for(int i = 0; i < curRow; i++){
				for(int j = 0; j < curColumn; j++){
					int t = q.getElement(i, j) + this.getElement(i, j);
					matrix.setElement(i, j, t);
				}
			}
		}
		//System.out.println(matrix);
		return matrix;
	}

	public IMatrix product (IMatrix q){

		if(this.curColumn != q.getRow()){
			throw new MyException ("Error. Can't multiply matrices");
		}		

		UsualMatrix matrix = new UsualMatrix(curRow, q.getColumn());

		for(int i = 0; i < curRow; i++){
			for(int j = 0; j < q.getColumn(); j++){
				matrix.setElement(i, j, 0);
			}
		}

		for(int i = 0; i < curRow; i++){
			for(int j = 0; j < q.getColumn(); j++){
				for(int k = 0; k < curColumn; k++){
					int t = matrix.getElement(i, j) + this.getElement(i, k) * q.getElement(k, j);
					matrix.setElement(i, j, t);
				}
			}
		}

		//System.out.println(matrix);
		return matrix;
	}
	
	public int getRow() {
		return curRow;
	}
	
	public int getColumn() {
		return curColumn;
	}

	public void setElement (int row, int column, int value){

		if (row > curRow || row < 0 || column > curColumn || column < 0){
			throw new MyException ("Error. Dimensions exceed matrix dimensions");
		}
		
		matrix[row][column] = value;
	}
	
	public int getElement (int row, int column){

		if(row > curRow || row < 0 || column > curColumn || column < 0){
			throw new MyException ("Error. Element not found");
		}

		return matrix[row][column];
	}

	public boolean equals (IMatrix m){

		int flag = 0;

		if(curRow == this.curRow && curColumn == this.curColumn){
			for(int i = 0; i < curRow; i++){
				for(int j = 0; j < curColumn; j++){
					if(this.getElement(i, j) != m.getElement(i, j)){
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
				sb.append(getElement(i, j) + " ");
			}
			sb.append("\n");
		} 

		String text = sb.toString();
		return text;
	}
}