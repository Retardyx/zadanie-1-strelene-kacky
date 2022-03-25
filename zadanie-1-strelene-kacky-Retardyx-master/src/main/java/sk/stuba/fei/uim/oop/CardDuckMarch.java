package sk.stuba.fei.uim.oop;


public class CardDuckMarch implements ActionCard {
	public static final String TITLE = "Kacací pochod";
	public static final String DESCRIPTION = "Posunie vsetky kacice o jednu do lava";

	

	public String getTitle() {
		return TITLE;
	}

	public String getDescription() {
		return DESCRIPTION;
	
	}

	public void doAct(GameBoard gameBoard) {
		
		System.out.println("Vsetky kacice sa posuvaju o jednu");
			gameBoard.kacaciPochod();		
	}

}
	
