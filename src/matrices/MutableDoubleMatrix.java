package matrices;


public class MutableDoubleMatrix extends DoubleMatrix {

	/** 
	 * Constructor1 : Create a double matrix 
	 */
    public MutableDoubleMatrix(int numberOfRows, int numberOfColumns) {
    	super(numberOfRows, numberOfColumns);
    }

    
    /** 
     * Constructor2 : Create a MutableDoubleMatrix with a pre-existing DoubleMatrix 
     */
    public MutableDoubleMatrix(DoubleMatrix matrix) {
    	super(matrix);
    }

    
    /** 
     * Constructor3 : Create a MutableDoubleMatrix with a pre-existing PositiveIntegerMatrix 
     */
    public MutableDoubleMatrix(PositiveIntegerMatrix matrix) {
    	super(matrix);
    }

    
    /** 
     * Set the element at row i column j, and return an exception if the value is negative.
     */
    public void setElement(int i, int j, double value) {
    	element[i][j]=value;
    	
		try {
			if (value < 0){
				throw new Exception ("Negative value");
			}
			checkRowIndex(i);
			checkColumnIndex(j);
			element[i][j] = value;
		}
		
		catch (Exception e){
			System.out.println(e);
		} 
    }
    
}