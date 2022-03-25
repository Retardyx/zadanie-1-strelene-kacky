package sk.stuba.fei.uim.oop;


public class CardShuffling implements ActionCard {

	public static final String TITLE = "Rosambo";
	public static final String DESCRIPTION = "Nahodne premiesa pozicie vsetkych kariet v rybniku. ";
	
	public void doAct(GameBoard gameBoard) {
		gameBoard.rosambo();
	}

	
	public String getTitle() {
		return TITLE;
	}

	
	public String getDescription() {
		return DESCRIPTION;
	}

}
