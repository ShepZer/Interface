package Matrix;

public interface IMatrix {
	int getElement (int row, int column);
	void setElement (int row, int column, int value);
	IMatrix product (IMatrix q);
	IMatrix sum (IMatrix q);
	int getRow();
	int getColumn();
	boolean equals(IMatrix q);
}
