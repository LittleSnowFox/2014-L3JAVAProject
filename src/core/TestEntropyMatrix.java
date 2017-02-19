package core;
import matrices.*;
import exceptions.*;
import match.*;
import dna.*;


public class TestEntropyMatrix {

	/**
	 * Main test procedure.
	 * @throws BadDNACharacterException 
	 */
	public static void main(String[] args) throws BadDNACharacterException {
		int numberOfRows    = 4;
		int numberOfColumns = 5;
		MutablePositiveIntegerMatrix matrix = new MutablePositiveIntegerMatrix(numberOfRows,numberOfColumns);

		// Column 0.
		matrix.setElement(0, 0, 2);
		matrix.setElement(1, 0, 2);
		matrix.setElement(2, 0, 2);
		matrix.setElement(3, 0, 2);

		// Column 1.
		matrix.setElement(0, 1, 2);
		matrix.setElement(1, 1, 0);
		matrix.setElement(2, 1, 3);
		matrix.setElement(3, 1, 3);

		// Column 2.
		matrix.setElement(0, 2, 8);
		matrix.setElement(1, 2, 0);
		matrix.setElement(2, 2, 0);
		matrix.setElement(3, 2, 0);

		// Column 3.
		matrix.setElement(0, 3, 1);
		matrix.setElement(1, 3, 2);
		matrix.setElement(2, 3, 2);
		matrix.setElement(3, 3, 3);

		// Column 4.
		matrix.setElement(0, 4, 2);
		matrix.setElement(1, 4, 2);
		matrix.setElement(2, 4, 2);
		matrix.setElement(3, 4, 2);

		// Print the matrix
		System.out.println("Initial matrix");
		System.out.println(matrix);

		// Create the corresponding CountMatrix.
		CountMatrix countMatrix = null;
		try {
			countMatrix = new CountMatrix(matrix);
		} catch (BadCountException e) {
			System.err.println(e);
			System.exit(1);
		}

		// Print the count matrix
		System.out.println("Count matrix");
		System.out.println(countMatrix);

		// Create the corresponding entropy matrix.
		EntropyMatrix entropyMatrix = new EntropyMatrix(countMatrix);

		// Print the entropy matrix
		System.out.println("Entropy matrix");
		System.out.println(entropyMatrix);

		// Define a DNA Sequence
			String name = new String("Homohibernatus gene");
			String rawSequence = new String("acgctgagacgattaaaaacgatagcagattgggcagataaggaa");
			DNASequence sequence = null;
			try {
				sequence = new DNASequence(name, rawSequence);
				} catch (BadDNACharacterException e) {
				System.err.println("Bad DNA sequence " + e);
			}
			System.out.println("Reference sequence:");
			System.out.println(sequence);

		// Pattern matching part
			PatternMatcher.printOccurrences(entropyMatrix, sequence, .85);
	}
}