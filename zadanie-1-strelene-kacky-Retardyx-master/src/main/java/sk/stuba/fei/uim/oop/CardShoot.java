package sk.stuba.fei.uim.oop;

import java.util.Scanner;

public class CardShoot implements ActionCard {
	public final String title = "Vystrelit!";
	public final String description = "Zastreli kacicu na zamierenom policku.";

	
	public String getTitle() {
		return title;
	}

	
	public String getDescription() {
		return description;
	}

	
	public void doAct(GameBoard gameBoard) {
		Scanner scanner = gameBoard.getScanner();
		char input;
		boolean endLoop = false;
	
	
		
			if 	((gameBoard.getSkySet().get(0).getAiming() != null)||
				(gameBoard.getSkySet().get(1).getAiming() != null)||
				(gameBoard.getSkySet().get(2).getAiming() != null)||
				(gameBoard.getSkySet().get(3).getAiming() != null)||
				(gameBoard.getSkySet().get(4).getAiming() != null)||
				(gameBoard.getSkySet().get(5).getAiming() != null)) {
				 
		while(!endLoop) {
			System.out.println("Zadaj pole na ktore chces vystrelit:\n(pre volbu zadaj pismeno vybraneho policka)");
			input = scanner.next().toUpperCase().charAt(0);
			switch (input) {
			case 'A':
				if (gameBoard.getSkySet().get(0).getAiming() == null)
					System.out.println("Toto pole este nie je zamierene!");				
					else {
						gameBoard.vystrelit(0);	
						gameBoard.getSkySet().get(0).removeAiming(this);
							endLoop = true;
				}
				break;
			case 'B':
				if (gameBoard.getSkySet().get(1).getAiming() == null)
					System.out.println("Toto pole este nie je zamierene!");
					else {
						gameBoard.vystrelit(1);
						gameBoard.getSkySet().get(1).removeAiming(this);
							endLoop = true;
				}
				break;
			case 'C':
				if (gameBoard.getSkySet().get(2).getAiming() == null)
					System.out.println("Toto pole este nie je zamierene!");
					else {
						gameBoard.vystrelit(2);
						gameBoard.getSkySet().get(2).removeAiming(this);
							endLoop = true;
				}
				break;
			case 'D':
				if (gameBoard.getSkySet().get(3).getAiming() == null)
					System.out.println("Toto pole este nie je zamierene!");
					else {
						gameBoard.vystrelit(3);
						gameBoard.getSkySet().get(3).removeAiming(this);
							endLoop = true;
				}
				break;
			case 'E':
				if (gameBoard.getSkySet().get(4).getAiming() == null)
					System.out.println("Toto pole este nie je zamierene!");
					else {
						gameBoard.vystrelit(4);
						gameBoard.getSkySet().get(4).removeAiming(this);
							endLoop = true;
				}
				break;
			case 'F':
				if (gameBoard.getSkySet().get(5).getAiming() == null)
					System.out.println("Toto pole este nie je zamierene!");
					else {
						gameBoard.vystrelit(5);
						gameBoard.getSkySet().get(5).removeAiming(this);
							endLoop = true;
				}
				break;
			default:
				System.out.println("Zla volba!");			
			}
		}
		}
			else
				endLoop = false;		
		}	
	}
	
	

	



