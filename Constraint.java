
class Constraint {
	private boolean [] charset;

	private final int CHAR_SET_SIZE = 256;

	public Constraint() {
		charset = new boolean [CHAR_SET_SIZE];
	}

	/**
	* @brief take the intersection of the Constraint's charset with other's charset
	*
	* @param other the Constraint object you are taking the intersection with
	*
	* @return a new Constraint that is the intersection of the two provided constraints
	*/
	public Constraint intersection(Constraint other) {
		Constraint inter = new Constraint();

		for(int i = 0; i < CHAR_SET_SIZE; i++) {
			if (this.hasChar(i) && other.hasChar(i)) {
				inter.addToCharset(i);
			}
		}

		return inter;
	}

	/**
	* @brief sets the Constraint's charset
	*
	* @param charset the array of characters to add to the charset
	*
	* @return void
	*/
	public void setCharset(char [] charset) {
		this.charset = new boolean [CHAR_SET_SIZE];
		addToCharset(charset);
	}

	/**
	* @brief adds a new character to the Constraint's charset
	*
	* @param c the character to add
	*
	* @return void
	*/
	public void addToCharset(int c) {
		charset[c] = true;
	}

	/**
	* @brief adds the new array to the charset
	*
	* @param charset the new characters to add
	*
	* @return void
	*/
	public void addToCharset(char [] charset) {
		for (char c : charset) {
			this.charset[c] = true;
		}
	}

	/**
	* @brief checks if the character is in the Constraint's charset
	*
	* @param c the character to search for
	*
	* @return true if found, false otherwise
	*/
	public boolean hasChar(int c) {
		return charset[c];
	}
}
