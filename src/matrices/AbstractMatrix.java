package matrices;


public abstract class AbstractMatrix {
	
	/** 
	 * Attributes
	 */
	protected int numberOfRows;
	protected int numberOfColumns;

	
	/** 
	 * Constructor1 : Classic matrix creation (with a number of rows and columns). 
	 */
	public AbstractMatrix(int numberOfRows, int numberOfColumns) {
		this.numberOfRows = numberOfRows;
		this.numberOfColumns = numberOfColumns;
	}

	
	/**
	 * Constructor2 : Matrix creation from a pre-existing matrix.
	 */
	public AbstractMatrix(AbstractMatrix matrix) {
		this.numberOfRows = matrix.getNumberOfRows();
		this.numberOfColumns = matrix.getNumberOfColumns();
	}
	
	
	/** 
	 * Return the number of rows of the matrix. 
	 */
	public int getNumberOfRows() {
		return(numberOfRows);
	}

	
	/** 
	 * Return the number of columns of the matrix. 
	 */
	public int getNumberOfColumns() {
		return(numberOfColumns);
	}
	
	
	/**
	 * Throw IndexOutOfBoundsException in case of incorrect row index. 
	 */
	public void checkRowIndex(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= numberOfRows) {
			throw new IndexOutOfBoundsException("Bad row index: " + i);
		}
	}

	
	/** 
	 * Throw IndexOutOfBoundsException in case of incorrect column index. 
	 */
	public void checkColumnIndex(int j) throws IndexOutOfBoundsException {
		if (j < 0 || j >= numberOfColumns) {
			throw new IndexOutOfBoundsException("Bad column index: " + j);
		}
	}
}