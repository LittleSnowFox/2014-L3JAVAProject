package exceptions;


public class BadDNAIndexException extends Exception {
    
	private static final long serialVersionUID = 1L;
	
	/** 
	 * Constructor 
	 */
    public BadDNAIndexException () {
    	super();
    }

    
    /** 
     * Constructor 
     */
    public BadDNAIndexException(String string) {
    	super(string);
    }	
}