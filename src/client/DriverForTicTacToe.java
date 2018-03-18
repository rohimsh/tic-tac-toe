package client;

import java.util.Scanner;

import exceptions.InvalidMoveException;
import services.PlayService;

public class DriverForTicTacToe {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {		
			System.out.println("Enter grid size: ");
			int size = sc.nextInt();
			System.out.println("Choose X or O to start with: ");
			String choice = sc.next();
			PlayService playService = new PlayService(size, choice);
			playService.printgrid();
			while(true) {
				try {
					System.out.println("Your move: ");
					int x = sc.nextInt();
					int y = sc.nextInt();
					playService.move(x, y);
				} catch(InvalidMoveException ime) {
					System.out.println(ime.getMessage());
				}
			}
		} catch(Exception e) {
			System.out.println("Something went wrong...");
		} finally {
			sc.close();
		}
	}
}
