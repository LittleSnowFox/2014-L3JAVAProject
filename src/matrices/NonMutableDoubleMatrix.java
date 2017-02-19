package matrices;


public class NonMutableDoubleMatrix extends DoubleMatrix {

	/** 
	 * Constructor1 : Create a NonMutableDoubleMatrix 
	 */
	public NonMutableDoubleMatrix(int numberOfRows, int numberOfColumns) {
		super(numberOfRows, numberOfColumns);
	}

	
	/** 
	 * Constructor2 : Create a NonMutableDoubleMatrix with a pre-existing DoubleMatrix 
	 */
	public NonMutableDoubleMatrix(DoubleMatrix matrix) {
		super(matrix);
	}

	
	/** 
	 * Constructor3 : Create a NonMutableDoubleMatrix with a pre-existing PositiveIntegerMatrix 
	 */
	public NonMutableDoubleMatrix(PositiveIntegerMatrix matrix) {
		super(matrix);
	}
}