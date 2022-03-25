package sk.stuba.fei.uim.oop;

public class CardDuckDance implements ActionCard {

	public static final String TITLE = "Kacaci tanec";
	public static final String DESCRIPTION = "Zoberie karty z rybníka a zamiesa ich s balickom s kacicami. ";
	
	public void doAct(GameBoard gameBoard) {
		gameBoard.kacaciTanec();
	}

	public String getTitle() {
		return TITLE;
	}

	public String getDescription() {
		return DESCRIPTION;
	}

}
