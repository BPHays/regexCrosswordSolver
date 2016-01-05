class Charset {
	private Long [] chars;

	/**
	* @brief default constructor create an empty charset
	*/
	Charset() {
		chars = new Long[2];
	}

	/**
	* @brief create a new charset from a bitmap
	*
	* @param chars the bitmap to use for the charset
	*/
	Charset(Long [] chars) {
		this.chars = chars;
	}

	/**
	* @brief set the bit corresponding to the char
	*
	* @param c the character to add to the charset
	*
	* @return void
	*/
	public void addChar(char c) {
		if (chars < 64) chars[0] |= 1 << (byte) c;
		else chars[1] |= 1 << (byte) c;
	}

	/**
	* @brief remove the bit corresponding to the char
	*
	* @param c the character to remove from the charset
	*
	* @return void
	*/
	public void removeChar(char c) {
		if (chars < 64) chars[0] &= ~(1 << (byte) c);
		else chars[1] &= ~(1 << (byte) c);
	}

	/**
	* @brief create a new charset that is the intersection of the two params
	*
	* @param c1 the first charset to intersect
	* @param c2 the second charset to intersect
	*
	* @return a new charset that is the intersection of the params
	*/
	public static Charset intersection(Charset c1, Charset c2) {
		Long [] chars = new Long[2];
		chars[0] = c1.chars[0] & c2.chars[0];
		chars[1] = c1.chars[1] & c2.chars[1];
		return new Charset(chars);
	}

	/**
	* @brief create a new charset that is the union of the two params
	*
	* @param c1 the first charset to union
	* @param c2 the second charset to union
	*
	* @return a new charset that is the intersection of the params
	*/
	public static Charset union(Charset c1, Charset c2) {
		Long [] chars = new Long[2];
		chars[0] = c1.chars[0] | c2.chars[0];
		chars[1] = c1.chars[1] | c2.chars[1];
		return new Charset(chars);
	}
}
