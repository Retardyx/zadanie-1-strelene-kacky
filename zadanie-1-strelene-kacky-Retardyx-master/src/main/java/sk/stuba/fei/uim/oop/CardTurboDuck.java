package sk.stuba.fei.uim.oop;

import java.util.Scanner;

public class CardTurboDuck implements ActionCard {

	public static final String TITLE = "Turbokacka";
	public static final String DESCRIPTION = "Posunie ¾ubovo¾nú kaèku na políèko najviac v predu rybníka. Kaèky, ktoré predbehla, posunie o jedno miesto dozadu.";
	
	
	
	
	public String getTitle() {
		return TITLE;
	}

	
	public String getDescription() {
		return DESCRIPTION;
	}
	public void doAct(GameBoard gameBoard) {
		Scanner scanner = gameBoard.getScanner();
		char input;
		int turbo;

		
		boolean endLoop = false;

		while (!endLoop) {
			System.out.println("Vyber si svoju Turbokacku:\n(pre volbu zadaj pismeno vybraneho policka)");
			input = scanner.next().toUpperCase().charAt(0);
			
		switch(input) {
		case 'A' :  turbo = 0;
			gameBoard.turboDuck(turbo);
				endLoop = true;
			break;
		case 'B' :  turbo = 1;
			gameBoard.turboDuck(turbo);
				endLoop = true;
			break;
		case 'C' :  turbo = 2;		
			gameBoard.turboDuck(turbo);
				endLoop = true;
			break;
		case 'D' :  turbo = 3;
			gameBoard.turboDuck(turbo);
				endLoop = true;
			break;
		case 'E' :  turbo = 4;
			gameBoard.turboDuck(turbo);
				endLoop = true;
			break;
		case 'F' :  turbo = 5;
			gameBoard.turboDuck(turbo);
				endLoop = true;
			break;
		
		default:
			System.out.println("Zla volba!");
		}
	}		
	}
}
