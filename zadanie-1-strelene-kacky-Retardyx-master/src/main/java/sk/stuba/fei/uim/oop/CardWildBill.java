package sk.stuba.fei.uim.oop;

import java.util.Scanner;

public class CardWildBill implements ActionCard {

	public static final String TITLE = "Divoky Bill";
	public static final String DESCRIPTION = "Funguje ako kombin·cia kariet Zamieriù a Vystreliù:\n(pre volbu zadaj pismeno vybraneho policka)";
	
	
	public void doAct(GameBoard gameBoard) {
		Scanner scanner = gameBoard.getScanner();
		char input;
		boolean endLoop = false;
		
		while(!endLoop) {
			System.out.println("Zadaj pole na ktore chces vystrelit");
			input = scanner.next().toUpperCase().charAt(0);
			switch (input) {
			case 'A':
			
					gameBoard.vystrelit(0);
					gameBoard.getSkySet().get(0).removeAiming(this);
						endLoop = true;
				
				break;
			case 'B':
					gameBoard.vystrelit(1);
					gameBoard.getSkySet().get(1).removeAiming(this);
						endLoop = true;
				
				break;
			case 'C':
					gameBoard.vystrelit(2);
					gameBoard.getSkySet().get(2).removeAiming(this);
						endLoop = true;
				
				break;
			case 'D':
					gameBoard.vystrelit(3);
					gameBoard.getSkySet().get(3).removeAiming(this);
						endLoop = true;
				break;
			case 'E':
					gameBoard.vystrelit(4);
					gameBoard.getSkySet().get(4).removeAiming(this);
						endLoop = true;
				break;
			case 'F':
					gameBoard.vystrelit(5);
					gameBoard.getSkySet().get(5).removeAiming(this);
					endLoop = true;
				break;
			default:
				System.out.println("Zla volba!");
			}
		}
	}
	

	public String getTitle() {
		return TITLE;
	}

	public String getDescription() {
		return DESCRIPTION;
	}
}
