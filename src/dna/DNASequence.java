package dna;
import exceptions.*;


public class DNASequence {

	String name; // The name of the DNA sequence.	
	String rawSequence; // The raw sequence (alphabet 'A', 'C', 'G', 'T').

	/** 
	 * Constructor1 : Create a DNA raw sequence (alphabet 'A', 'C', 'G', 'T'). 
     * @param rawSequence : A DNA raw sequence (alphabet 'A', 'C', 'G', 'T').
	 */
	public DNASequence(String rawSequence) throws BadDNACharacterException 
	{
		this.name = new String("No name");
		this.rawSequence = rawSequence.toUpperCase();
		DNAAlphabet.checkRawSequence(this.rawSequence);
	}

	
	/**
	 * Constructor2 : Give a name to the DNA sequence and create a DNA raw sequence (alphabet 'A', 'C', 'G', 'T'). 
	 * @param name : The name of the DNA sequence.
	 * @param rawSequence : A DNA raw sequence (alphabet 'A', 'C', 'G', 'T').
	 */
	public DNASequence(String name, String rawSequence) throws BadDNACharacterException 
	{
		this.name = new String(name);
		this.rawSequence = rawSequence.toUpperCase();
		DNAAlphabet.checkRawSequence(this.rawSequence);
	}

	
	/** 
	 * Constructor3 : sequence A DNA sequence. 
	 * @param sequence : A DNA sequence.
	 */
	public DNASequence(DNASequence sequence) {
		name = new String(sequence.name);
		rawSequence = new String(sequence.rawSequence);
	}

	
	/** 
	 * Return a copy of the name of the DNA sequence. 
	 */
	public String getName() {
		return(new String(name));
	}

	
	/** 
	 * Return a copy of the DNA sequence.
	 */
	public String getRawSequence() {
		return(new String(rawSequence));
	}

	
	/** 
	 * Return the length of the raw sequence of the DNA sequence.
	 */
	public int length() {
		return(rawSequence.length());
	}

	
	/** 
	 * Return the character at position i in the DNA raw sequence.
	 */
	public char charAt(int i) {
		return(rawSequence.charAt(i));
	}

	
	/** 
	 * Return a substring of the raw sequence. 
	 */
	public String substring(int beginIndex, int endIndex) {
		return(rawSequence.substring(beginIndex, endIndex));
	}

	
	/** 
	 * Stringify the DNA sequence in FASTA-like format.
	 */
	public String toString() {
		int size = name.length() + rawSequence.length();
		StringBuffer buffer = new StringBuffer(size + 5);

		// Write the prefix FASTA
		buffer.append("> ");
		buffer.append(name);
		buffer.append("\n");

		// Write the DNA rawSequence in 80 columns format.
		int beginIndex = 0;
		while (beginIndex < rawSequence.length()) {
			int endIndex = beginIndex + 80;
			if (endIndex >= rawSequence.length()) {
				endIndex = rawSequence.length() - 1;
			}
			buffer.append(rawSequence.substring(beginIndex, endIndex));
			buffer.append("\n");
			beginIndex = endIndex + 1;
		}
		buffer.append("\n");

		// That's all !!!
		return(buffer.toString());
	}
}