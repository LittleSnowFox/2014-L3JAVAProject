package dna;
import exceptions.*;


public class DNAAlphabet {
	
	/**
	 * DNA indices
	 */
	private static final int A_INDEX = 0;
	private static final int C_INDEX = 1;
	private static final int G_INDEX = 2;
	private static final int T_INDEX = 3;

	/**
	 * DNA characters
	 */
	private static final char A_CHARACTER = 'A';
	private static final char C_CHARACTER = 'C';
	private static final char G_CHARACTER = 'G';
	private static final char T_CHARACTER = 'T';

	
	/** 
	 * Raise BadDNACharacterException if the given character is not a valid DNA letter.
	 * @param c The DNA character.
	 */
	private static void checkDNACharacter(char c) throws BadDNACharacterException {
		if (c != DNAAlphabet.A_CHARACTER &&
				c != C_CHARACTER && 
				c != G_CHARACTER && 
				c != T_CHARACTER) {
			throw new BadDNACharacterException("Bad DNA sequence, the character \"" + c + "\" is not a valid letter.");
		}
	}

	
	/**
	 * Check the given sequence for bad DNA characters.
	 * @param rawSequence The DNA raw sequence.
	 */
	public static void checkRawSequence(String rawSequence) throws BadDNACharacterException {
		for (int i = 0; i < rawSequence.length(); ++i) {
			DNAAlphabet.checkDNACharacter(rawSequence.charAt(i));
		}
	}

	
	/**
	 * Return the corresponding index of the given DNA character.
	 * Raise BadDNACharacterException if the given character is not a valid DNA letter.
	 * @param matrix A DNA character.
	 */
	public static int characterToIndex(char c) throws BadDNACharacterException {
		switch (c) {
		case A_CHARACTER:
			return(A_INDEX);
		case C_CHARACTER:
			return(C_INDEX);
		case G_CHARACTER:
			return(G_INDEX);
		case T_CHARACTER:
			return(T_INDEX);
		default:
			throw new BadDNACharacterException("Bad DNA sequence, the character \"" + c + "\" is not a valid letter.");
		}
	}

	
	/**
	 * Return the corresponding DNA character of the given DNA index.
	 * Raise BadDNIndexException if the given index is not a valid DNA index.
	 * @param index A DNA index.
	 */
	public static int indexToCharacter(int index) throws BadDNAIndexException {
		switch (index) {
		case 0:
			return(A_CHARACTER);
		case 1:
			return(C_CHARACTER);
		case 2:
			return(G_CHARACTER);
		case 3:
			return(T_CHARACTER);
		default:
			throw new BadDNAIndexException("Bad DNA sequence, the index \"" + index + "\" don't correspond with a valid letter.");
		}
	}
}