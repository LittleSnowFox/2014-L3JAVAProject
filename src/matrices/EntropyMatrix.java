package matrices;
import java.lang.Math;


public class EntropyMatrix extends NonMutableDoubleMatrix {

	/**
	 * Attributes
	 */
	private int referenceSum;

	
	/** 
	 * Constructor 
	 */
	public EntropyMatrix(CountMatrix matrix) {
		super(matrix);
		this.referenceSum = matrix.getReferenceSum();
		computeEntropy();
	}

	
	/** 
	 * Compute the entropy matrix. 
	 */
	private void computeEntropy() {

		// Compute the coefficients for each column (Ci).
		double coefficient [] = new double [numberOfColumns];	

		for (int j = 0; j < numberOfColumns; j++) { 
			double sumOfFrequencies = 0;
			for (int i = 0; i < numberOfRows; i++) {
				double probability = getElement(i,j) / (double) referenceSum;
				if (probability>0) {
					sumOfFrequencies = sumOfFrequencies + (((probability)*Math.log(probability)));
				}
			}
			coefficient[j] = 100/Math.log(5)*(sumOfFrequencies+ Math.log(5.0));
			System.out.println("Coefficent of the column : "+coefficient[j]);
		}
		System.out.println("\n");


		// Compute the maximum of each column.
		double maxColumns [] = new double [numberOfColumns];
		for (int j = 0; j < numberOfColumns; j++) {
			maxColumns[j] = 0;
		}
		for (int j = 0; j < numberOfColumns; j++) {
			for (int i = 0; i < numberOfRows; i++) {
				if (maxColumns[j] < getElement(i,j)) {
					maxColumns[j] = getElement(i,j);
				}
			}
			System.out.println("Max of the column : "+maxColumns[j]);
		}
		System.out.println("\n");

		
		// Compute the entries for each column (Wbi). (Mbi is the frequency of each case of the count matrix)
		double [] sum = new double [numberOfColumns];
		for (int j=0 ; j<numberOfColumns ; j++) {
			sum[j] = 0.0;
		}
		for (int j=0; j<numberOfColumns; j++){  		
			for (int i=0; i<numberOfRows; i++){
				sum[j] = sum[j] + coefficient[j]*maxColumns[j];
			}
		}

		MutableDoubleMatrix entriesMatrix = new MutableDoubleMatrix(numberOfRows, numberOfColumns);
		for (int j=0; j<numberOfColumns; j++){  		
			for (int i=0; i<numberOfRows; i++){
				double entries = 0.0;
				entries = (coefficient[j]*getElement(i,j))/sum[j];
				entriesMatrix.setElement(i,j,entries);
			}
		}

		// Replace all the entries.
		for (int j = 0; j < numberOfColumns; j++) {
			for (int i = 0; i < numberOfRows; i++) {
				element[i][j] = entriesMatrix.getElement(i,j);
			}
		}

	}
}
