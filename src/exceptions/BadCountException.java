package exceptions;


public class BadCountException extends Exception {
    
	private static final long serialVersionUID = 1L;

	/** 
	 * Default constructor. 
	 */
    public BadCountException () {
    	super();
    }

    
    /** 
     * Constructor. 
     */
    public BadCountException (String string) {
    	super(string);
    }
}