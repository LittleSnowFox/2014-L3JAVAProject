package core;
import matrices.*;
import dna.*;
import exceptions.BadDNACharacterException;

public class Test {

	/**
	 * @param args
	 * @throws BadDNACharacterException 
	 */
	public static void main(String[] args) throws BadDNACharacterException {
		DNASequence sequence1 = new DNASequence ("Sequence1 : ","ATGGCCCCGTA");
		System.out.println(sequence1);
		

	}

}
