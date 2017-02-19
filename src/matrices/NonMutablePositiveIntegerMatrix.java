package matrices;


public class NonMutablePositiveIntegerMatrix extends PositiveIntegerMatrix {

	/**
	 * Constructor1 : Classic matrix creation (with a number of rows and columns).
	 */
	public NonMutablePositiveIntegerMatrix(int numberOfRows, int numberOfColumns) {
		super(numberOfRows, numberOfColumns);
	}

	
	/**
	 * Constructor2 : Matrix creation from a pre-existing PositiveIntegerMatrix matrix.
	 */
	public NonMutablePositiveIntegerMatrix(PositiveIntegerMatrix matrix) {
		super(matrix);
	}
}