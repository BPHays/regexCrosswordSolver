
class Parser {
	/**
	* @brief parse the clue into its constraint object
	*
	* @param constraints array of constraint objects corrosponding to the pieces of the clue
	* @param clue the regex clue for that section of the puzzle
	*/
	public static void parseRegex(Constraint[] constraints, String clue) {
		int currConst = 0;
		char c;
		for (int i = 0; i < clue.length(); i++) {
			switch (c = clue.charAt(i)) {
				case '|':
					currConst = 0;
					break;
				case '[':
					// add all of the elements in the character class
					for(i++; (c = clue.charAt(i)) != ']'; i++) {
						constraints[currConst].addToCharset((int) c);
					}
					currConst++;
					break;
				default :
					// add the character to the character set
					constraints[currConst].addToCharset((int) c);
					currConst++;
					break;
			}
		}
	}
}
