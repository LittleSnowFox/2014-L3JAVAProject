package matrices;
import java.text.DecimalFormat;


public abstract class PositiveIntegerMatrix extends AbstractMatrix {
	
	/** 
	 * Attributes 
	 */
	protected int element[][];  // 2DArray to store the elements

	
	/** 
	 * Constructor1 : Classic matrix creation (with a number of rows and columns). 
	 */
	public PositiveIntegerMatrix(int numberOfRows, int numberOfColumns) {
		super(numberOfRows, numberOfColumns);
		element = new int[numberOfRows][numberOfColumns];
		for ( int i = 0; i < numberOfRows; i++ ) {
			for ( int j = 0; j < numberOfColumns; j++ ) {
				element[i][j] = 0;
			}
		}
	}

	
	/**
	 * Constructor2 : Create a matrix from a pre-existing matrix.
	 */
	public PositiveIntegerMatrix(PositiveIntegerMatrix matrix) {
		super(matrix);
		element = new int [numberOfRows][numberOfColumns];
		for (int i = 0; i < numberOfRows ; i++){
			for (int j = 0; j< numberOfColumns; j++){
				element[i][j] = matrix.getElement(i,j);
			}
		}
	}

	
	/** 
	 * Return the element at row i column j. 
	 */
	public int getElement(int i, int j) {
		return element[i][j];
	}

	
	/** 
	 * Raise IllegalArgumentException if value is negative. 
	 */
	protected void checkValue(int value) throws IllegalArgumentException {
		if (value < 0) {
			throw new IllegalArgumentException("Negative value : " + value);
		}
	}

	
	/** 
	 * Convert the matrix to a String for pretty printing. 
	 */
	public String toString() {
		StringBuffer st = new StringBuffer(numberOfRows * numberOfColumns * 25);
		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfColumns; j++) {
				DecimalFormat df = new DecimalFormat("###00");
				st.append(" " + df.format(element[i][j]));
			}
			st.append("\n");
		}
		return(st.toString());
	}
}