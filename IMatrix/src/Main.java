import Matrix.*;
import java.util.Scanner;
 
public class Main {

	public static void main(String[] args) {
		
		SquareMatrix sqm = new SquareMatrix (10);
		SparseMatrix spm = new SparseMatrix (10, 10);
		UsualMatrix um = new UsualMatrix (10, 10);
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(i == j) {
					spm.setElement(i, j, 1);
				}
			}
		}
		
		//System.out.println(spm1);
		System.out.println(spm.product(sqm));
		//System.out.println(sqm.product(um));
		
		System.out.println(sqm.product(um).equals(spm.product(um)));
		System.out.println(sqm.sum(um).equals(spm.sum(um)));
	}

}
