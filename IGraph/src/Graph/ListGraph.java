package Graph;
import java.util.LinkedList;
import Exception.MyException;

//import Matrix.Element;

import java.util.ArrayList;
import java.util.Iterator;

public class ListGraph implements IGraph{
	
	public LinkedList<Integer> graphList[];
	public int curSize;																							public int[][] matrix;
	
	public ListGraph (int size){
		
		curSize = size;
		graphList = new LinkedList[size];																		matrix = new int [curSize][curSize];
		
		for(int i = 0; i < curSize; i++) {
			graphList[i] = new LinkedList <Integer> ();
		}
		
	}
	
	public void connect(int vertix1, int vertix2) {
		graphList[vertix1].add(vertix2);																		matrix[vertix1][vertix2] = 1;
		graphList[vertix2].add(vertix1);																		matrix[vertix2][vertix1] = 1;
	}
	
	public void disconnect (int vertix1, int vertix2) {
		graphList[vertix1].remove(vertix2);
		graphList[vertix2].remove(vertix1);
	}
	
	public int getGraph(int v1, int v2) {
		
		if(v1 >= curSize || v2 >= curSize) {
			throw new MyException ("Error");
		}
		else{
			return matrix[v1][v2];
			//return this.graphList[v1].get(v2);
		}
	}
	
	public int getGraphSize(int v) {
		return this.graphList[v].size();
	}

	public boolean equals (IGraph m) {
		
		int flag = 0;
		int t = 0;

		if(curSize == this.curSize){
			for(int i = 0; i < this.curSize; i++){
				
				if( this.graphList[i].size() >  m.getGraphSize(i)) {	t = this.graphList[i].size();}
				else {	t = m.getGraphSize(i);}
				
				for(int j = 0; j < t; j++){
					if(this.graphList[i].size() > j && m.getGraphSize(i) > j) {
						if(this.getGraph(i, j) != m.getGraph(i, j)){
							flag = 1;
						} 
					}
					else {
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
	
	public int getSize() {
		return curSize;
	}
 	
	public final String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < curSize; i++){
			sb.append(i + ": ");
			for(int j = 0; j < graphList[i].size();j++) {
				sb.append(graphList[i].get(j) + " ");
			}
			sb.append("\n");
		} 

		String text = sb.toString();
		return text;
	}
}