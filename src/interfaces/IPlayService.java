package interfaces;

import exceptions.InvalidMoveException;

public interface IPlayService {
	
	public void move(int x, int y) throws InvalidMoveException;

	public void printgrid();
	
	public void exit();
}
