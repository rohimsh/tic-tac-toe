package models;

public class Grid {
		
	private int dim;
	private MoveType playerChoice;
	private MoveType systemChoice;
	private char[][] arr;
	private int noOfEmptyPositions;
	

	public Grid(int size, String choice){
		this.dim = size;
		this.noOfEmptyPositions = dim * dim;
		this.arr = new char[dim][dim];
		for(int i = 0; i < dim; i++) {
			for(int j = 0; j < dim; j++) {
				arr[i][j] = MoveType.EMPTY.getDisplayVal();		
			}
		}	
		
		this.playerChoice = MoveType.valueOf(choice);
		this.systemChoice = MoveType.getOtherMove(playerChoice);
	}
	

	public int getDim() {
		return dim;
	}


	public void setDim(int dim) {
		this.dim = dim;
	}


	public char[][] getArr() {
		return arr;
	}


	public void setArr(char[][] arr) {
		this.arr = arr;
	}


	public MoveType getPlayerChoice() {
		return playerChoice;
	}


	public void setPlayerChoice(MoveType choice) {
		this.playerChoice = choice;
	}


	public MoveType getSystemChoice() {
		return systemChoice;
	}


	public void setSystemChoice(MoveType systemChoice) {
		this.systemChoice = systemChoice;
	}

	
	public int getNoOfEmptyPositions() {
		return noOfEmptyPositions;
	}


	public void setNoOfEmptyPositions(int noOfEmptyPositions) {
		this.noOfEmptyPositions = noOfEmptyPositions;
	}


	public void setMoveInGrid(int x, int y, MoveType moveType) {
		arr[x][y] = moveType.getDisplayVal();
		noOfEmptyPositions--;
	}

}
