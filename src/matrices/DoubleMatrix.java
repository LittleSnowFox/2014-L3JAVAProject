package matrices;
import java.text.DecimalFormat;


public abstract class DoubleMatrix extends AbstractMatrix {

	/**
	 * Attributes
	 */
	protected double element[][];	// 2DArray to store the elements.

	
	/** 
	 * Constructor1 : Create a DoubleMatrix.
	 */
	public DoubleMatrix(int numberOfRows, int numberOfColumns) {
		super(numberOfRows, numberOfColumns);
		element = new double[numberOfRows][numberOfColumns];
		for ( int i = 0; i < numberOfRows; i++ ) {
		    for ( int j = 0; j < numberOfColumns; j++ ) {
			element[i][j] = 0.0;
		    }
		}
	}

	
	/** 
	 * Constructor2 : Create a DoubleMatrix with a pre-existing matrix.
	 */
	public DoubleMatrix(DoubleMatrix matrix) {
		super(matrix);
		element = new double [numberOfRows][numberOfColumns];
		for (int i = 0; i < numberOfRows ; i++){
			for (int j =0; j< numberOfColumns ; j++){
				element[i][j] = matrix.getElement(i,j);
			}
		}
	}

	
	/** 
	 * Constructor3 : Create a DoubleMatrix with a pre-existing PositiveIntegerMatrix.
	 */
	public DoubleMatrix(PositiveIntegerMatrix matrix) {
		super(matrix);
		element = new double[numberOfRows][numberOfColumns];
		for ( int i = 0; i < numberOfRows; i++ ) {
		    for ( int j = 0; j < numberOfColumns; j++ ) {
			element[i][j] = matrix.getElement(i,j);	
		    }
		}
	}
	
	
	/** 
	 * Return the element at row i column j. 
	 */
	public double getElement(int i, int j) {
		return(element[i][j]);
	}

	/** 
	 * Convert the matrix to a String for pretty printing. 
	 */
	public String toString() {
		StringBuffer st = new StringBuffer(numberOfRows * numberOfColumns * 25);
		for ( int i = 0; i < numberOfRows; i++ ) {
			for ( int j = 0; j < numberOfColumns; j++ ) {
				DecimalFormat df = new DecimalFormat("###0.00");
				st.append(" " + df.format(element[i][j]));
			}
			st.append("\n");
		}
		return (st.toString());
	}
}