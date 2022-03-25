package sk.stuba.fei.uim.oop;


import java.util.Scanner;

public class CardAim implements ActionCard {
	public final String title = "Zamierit!";
	public final String description = "Ten, kto zahra kartu \"Zamierit!\", moze umiestnit kartu zameriavaca nad jednu lubovolnu kartu oblohy.";

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void doAct(GameBoard gameBoard) {
		Scanner scanner = gameBoard.getScanner();
		char input;
		boolean endLoop = false;

		while (!endLoop) {
			System.out.println("Zadaj pole na ktore chces zamierit:\n(pre volbu zadaj pismeno vybraneho policka)");
			input = scanner.next().toUpperCase().charAt(0);
			switch (input) {
			case 'A':
				if (gameBoard.getSkySet().get(0).getAiming() != null)
					System.out.println("Toto pole uz je zamierene!");
				else {
					gameBoard.getSkySet().get(0).setAiming(this);
					endLoop = true;
				}
				break;
			case 'B':
				if (gameBoard.getSkySet().get(1).getAiming() != null)
					System.out.println("Toto pole uz je zamierene!");
				else {
					gameBoard.getSkySet().get(1).setAiming(this);
					endLoop = true;
				}
				break;
			case 'C':
				if (gameBoard.getSkySet().get(2).getAiming() != null)
					System.out.println("Toto pole uz je zamierene!");
				else {
					gameBoard.getSkySet().get(2).setAiming(this);
					endLoop = true;
				}
				break;
			case 'D':
				if (gameBoard.getSkySet().get(3).getAiming() != null)
					System.out.println("Toto pole uz je zamierene!");
				else {
					gameBoard.getSkySet().get(3).setAiming(this);
					endLoop = true;
				}
				break;
			case 'E':
				if (gameBoard.getSkySet().get(4).getAiming() != null)
					System.out.println("Toto pole uz je zamierene!");
				else {
					gameBoard.getSkySet().get(4).setAiming(this);
					endLoop = true;
				}
				break;
			case 'F':
				if (gameBoard.getSkySet().get(5).getAiming() != null)
					System.out.println("Toto pole uz je zamierene!");
				else {
					gameBoard.getSkySet().get(5).setAiming(this);
					endLoop = true;
				}
				break;
			default:
				System.out.println("Zla volba!");
			}
		}
		
		

	}

}
