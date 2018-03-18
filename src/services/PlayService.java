package services;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Random;

import exceptions.InvalidMoveException;
import interfaces.IPlayService;
import models.Grid;
import models.MoveType;

public class PlayService implements IPlayService{

	private Grid grid;
	private Random random;
	
	public PlayService(int gridSize, String choice) {
		this.grid = new Grid(gridSize, choice);
		this.random = new Random();
	}

	@Override
	public void move(int x, int y) throws InvalidMoveException {
		if(!isValidMove(x, y))
			throw new InvalidMoveException("Invalid Move - X: " + x + " Y: " + y);
		
		grid.setMoveInGrid(x, y, grid.getPlayerChoice());
		
		if(hasWon(grid.getPlayerChoice().getDisplayVal())) {
			System.out.println("Player won!");
			printgrid();
			exit();
		} else {
			if(checkIfCanBePlayedFurther()) {
				generateRandomMove();
				if(hasWon(grid.getSystemChoice().getDisplayVal())) {
					System.out.println("System won!");
					exit();
				}
			}
		}
		if(!checkIfCanBePlayedFurther()) {
				System.out.println("Game over!");
				exit();
		}
	}

	private boolean isValidMove(int x, int y) {
		return (x >= 0 && x < grid.getDim() && y >= 0 && y < grid.getDim() 
				&& grid.getArr()[x][y] == MoveType.EMPTY.getDisplayVal());
		
	}

	private void generateRandomMove() {
		
		List<Integer> emptyXPositions = new ArrayList<Integer>();
		List<Integer> emptyYPositions = new ArrayList<Integer>();
		
		
		for(int i = 0; i < grid.getDim(); i++) {
			for(int j = 0; j < grid.getDim(); j++) {
				if(grid.getArr()[i][j] == MoveType.EMPTY.getDisplayVal()) {
					emptyXPositions.add(i);
					emptyYPositions.add(j);
				}
			}
		}	
				
		int pos = random.nextInt(emptyXPositions.size());
		int randX = emptyXPositions.get(pos);
		int randY = emptyYPositions.get(pos);
		
		grid.setMoveInGrid(randX, randY, grid.getSystemChoice());
		printgrid();
	}

	@Override
	public void printgrid() {
		for(int i = 0; i < grid.getDim(); i++) {
			for(int j = 0; j < grid.getDim(); j++) {
				System.out.print(grid.getArr()[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	@Override
	public void exit() {
		System.out.println("Exit game...");
		grid = null;
		System.exit(0);
	}
	
	
	public boolean checkIfCanBePlayedFurther(){
		if(grid.getNoOfEmptyPositions() == 0) {
			return false;
		} 
		return true;
	}
	
	private boolean hasWon(char moveType) {
		boolean won = true;		
		for(int i = 0; i < grid.getDim(); i++) {
			for(int j = 0; j < grid.getDim(); j++) {
				if(grid.getArr()[i][j] != moveType) {
					won = false;
					break;
				}
			}
			if(won)
				return won;
		}
		
		won = true;
		
		for(int i = 0; i < grid.getDim(); i++) {
			for(int j = 0; j < grid.getDim(); j++) {
				if(grid.getArr()[j][i] != moveType) {
					won = false;
					break;
				}
			}
			if(won)
				return won;
		}		
		
		won = true;
		
		for(int i = 0; i < grid.getDim(); i++) {
			if(grid.getArr()[i][i] != moveType) {
				won = false;
				break;
			}
		}
		
		if(won)
			return won;
		
		won = true;
		
		for(int i = grid.getDim() - 1; i >= 0; i--) {
			if(grid.getArr()[grid.getDim() - 1 - i][i] != moveType) {
				won = false;
				break;
			}
		}
		
		if(won)
			return won;
		
		return false;
		
	}
	
	
	public Grid getGrid() {
		return grid;
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

}
