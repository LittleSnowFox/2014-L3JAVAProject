package matrices;
import exceptions.BadCountException;


public class CountMatrix extends NonMutablePositiveIntegerMatrix {

	/**
	 * Attributes
	 */
	protected int referenceSum ;

	
	/** 
	 * Constructor : Check if the number of rows is equals to 4 and if the values are positives.
	 */
	public CountMatrix(PositiveIntegerMatrix matrix) throws BadCountException {
		super(matrix);
		if (matrix.getNumberOfRows() != 4) {
			throw new BadCountException("The number of rows must be equals to 4.");
		}

		for (int i=0; i<matrix.numberOfRows; i++){
			for (int j=0; j<numberOfColumns; j++){
				if (element[i][j] < 0){
					throw new BadCountException ("Negative value");
				}
			}
		}

		for (int i = 0; i < matrix.numberOfRows; i++) {
			referenceSum = referenceSum + matrix.getElement(i, 0);
		}
		checkColumns();	
	}

	
	/** Return the reference sum **/
	public int getReferenceSum() {
		return referenceSum;
	}

	
	/** Raise BadCountException in case of all columns do not sum to the same value **/
	private void checkColumns() {
		try {
			int sumOfColumn [] = new int [numberOfColumns];

			// Initialize all the elements of the table to 0
			for (int j=0 ; j<numberOfColumns ; j++) {
				sumOfColumn[j] = 0;
			}

			// Check all columns are equals to the first sum
			for (int j=0 ; j<numberOfColumns; j++) {
				for (int i=0 ; i<numberOfRows ; i++) {
					sumOfColumn[j] = sumOfColumn[j] + element[i][j];
				}
			}

			for(int j=1 ; j<numberOfColumns; j++) {
				if(sumOfColumn[j] != referenceSum){
					System.out.println(sumOfColumn[j] +"  "+ referenceSum);
					throw new BadCountException ("Sums of colums must be equals.");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}