package exceptions;


public class BadDNACharacterException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    /** 
     * Default constructor. 
     */
    public BadDNACharacterException () {
    	super();
    }

    
    /** 
     * Constructor 
     */
    public BadDNACharacterException(String string) {
    	super(string);
    }	
  
}