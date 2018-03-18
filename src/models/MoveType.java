package models;

public enum MoveType {
	X('X'),
	O('O'),
	EMPTY('-');
	
	private char displayVal;
	
	private MoveType(char ch) {
		this.displayVal = ch;
	}
	
	public char getDisplayVal() {
		return displayVal;
	}

	public void setDisplayVal(char displayVal) {
		this.displayVal = displayVal;
	}

	public static MoveType getOtherMove(MoveType type) {
		MoveType other = EMPTY;
		other = type == X ? O : X;
		return other;
	}

}
