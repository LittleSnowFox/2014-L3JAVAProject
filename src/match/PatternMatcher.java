package match; 
import java.text.DecimalFormat;
import java.util.ArrayList;

import matrices.*;
import exceptions.*;
import dna.*;


public class PatternMatcher {

	/**
	 * Print all occurrences of the matrix in the sequence.
	 * @param matrix A search matrix
	 * @param sequence A DNA sequence
	 * @param threshold The pattern threshold 
	 * @throws BadDNACharacterException 
	 */
	public static void printOccurrences(NonMutableDoubleMatrix matrix, DNASequence sequence, double threshold) throws BadDNACharacterException {

		// Print the threshold
		System.out.println("PatterMatcher (threshold = " + threshold + ")");

		// Some useful values
		int rawSequenceLength = sequence.length();
		int patternLength = matrix.getNumberOfColumns();
		int endIndex = rawSequenceLength - patternLength;
		double score = 0.0;

		// For each possible starting position in the sequence.
		double max = 0.0;
		double min = 100.0;
		ArrayList <Double> scoresList = new ArrayList<Double>();

		for (int i = 0; i <= endIndex; i++) {		
			score = 0.0;
			for(int j = i ; j< patternLength+i ; j++){
				int x = dna.DNAAlphabet.characterToIndex(sequence.charAt(j)); // Retrieve the index x of the character
				score +=  matrix.getElement(x, j-i); // xx += means xx = xx +... // Retrieve and sum the element at the position (i,j) in the entropy matrix
				if (score > max) max = score;
				if (score < min) min = score;
			}
			scoresList.add(score);
		}	
		
		for (int i = 0; i<scoresList.size(); i++) {
			double score2 = ((scoresList.get(i) - min) / (max-min));
			scoresList.set(i, score2);
		}

		// Print the pattern if the score is above the given threshold.
		for (int i = 0; i<= endIndex; i++) {
			if (scoresList.get(i) >= threshold) {
				DecimalFormat df = new DecimalFormat("###0.00");
				System.out.println("Position: "+ i + " \"" + sequence.substring(i, i + patternLength)+ "\" score: " + df.format(scoresList.get(i)));
			}
		}
	}
}
