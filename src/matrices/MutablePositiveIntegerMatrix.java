package matrices;


public class MutablePositiveIntegerMatrix extends PositiveIntegerMatrix {

	/** 
	 * Constructor1 : : Classic matrix creation (with a number of rows and columns).
	 */
	public MutablePositiveIntegerMatrix(int numberOfRows, int numberOfColumns) {
		super(numberOfRows, numberOfColumns);
	}


	/** 
	 * Constructor2 : Matrix creation from a pre-existing PositiveIntegerMatrix.
	 */
	public MutablePositiveIntegerMatrix(PositiveIntegerMatrix matrix) {
		super(matrix);
	}


	/** 
	 * Set the element at row i column j 
	 */
	public void setElement(int i, int j, int value) {
		/*checkValue(value);
		checkRowIndex(i);
		checkColumnIndex(j);
		element[i][j] = value; */

		/*try {
			if (value < 0){
				throw new Exception ("Negative value");
			}
			checkRowIndex(i);
			checkColumnIndex(j);
			element[i][j] = value;
		}

		catch (Exception e){
			System.out.println(e);
		}*/

		// Or we can also use :
		if (value>=0) {
			element[i][j]=value;
		} else {
			System.out.println("Rentrez une valeur positive");
		} 
	}
}