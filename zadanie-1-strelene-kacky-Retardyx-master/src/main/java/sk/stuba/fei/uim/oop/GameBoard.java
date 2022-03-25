package sk.stuba.fei.uim.oop;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class GameBoard {
	public static final int NUM_OF_CARDS_ON_HAND = 3;
	public static final int NUM_OF_DUCKS = 6;
	
	public static final int NUM_OF_SKIES = 6;
	private static final int NUM_OF_EMPTY_SURFACE = 6;
	private static final int NUM_OF_ACTCARD_AIM = 10;
	private static final int NUM_OF_ACTCARD_SHOOT = 12;
	private static final int NUM_OF_ACTCARD_WILDBILL = 2;
	private static final int NUM_OF_ACTCARD_DUCKMARCH = 6;
	private static final int NUM_OF_ACTCARD_TURBODUCK = 20;
	private static final int NUM_OF_ACTCARD_SHUFFLING = 20;
	private static final int NUM_OF_ACTCARD_DUCKDANCE = 20;
	
	private static final String STRING_TITLE_SKYSET = " _____[A]_____    _____[B]_____    _____[C]_____    _____[D]_____    _____[E]_____    _____[F]_____   ";

	private static final String STRING_DUCK_ROW_1 = "|  888        |";
	private static final String STRING_DUCK_ROW_2 = "|<88^88       |";
	private static final String STRING_DUCK_ROW_3 = "|  8888     8 |";
	private static final String STRING_DUCK_ROW_4 = "|  8888    888|";
	private static final String STRING_DUCK_ROW_5 = "|  88888888888|";
	private static final String STRING_DUCK_ROW_6 = "|  8888888888 |";
	private static final String STRING_DUCK_ROW_7 = "|~~~88888888~~|";
	private static final String STRING_DUCK_EMPTY = "|             |";
	private static final String STRING_DUCK_SURFACE = "|~~~~~~~~~~~~~|";
	private static final String STRING_DUCK_GAP = "  ";
	private static final int DUCK_SIZE = 15;
	private static final String STRING_AIM_TOP_ROW_1 = "     _    _    ";
	private static final String STRING_AIM_TOP_ROW_2 = "    |      |   ";
	private static final String STRING_AIM_MID_ROW_1 = "       \\/      ";
	private static final String STRING_AIM_MID_ROW_2 = "       /\\      ";
	private static final String STRING_AIM_BOT_ROW = "    |_    _|   ";
	private static final String STRING_AIM_EMPTY = "               ";

	
	
	private ArrayList<ActionCard> discardSet;
	private ArrayList<CardSky> skySet;
	private ArrayList<DuckCard> duckCardsSet;
	private ArrayList<ActionCard> actionCardsSet;
	private ArrayList<Player> playerSet;
	
	private Scanner scanner;
	
	public GameBoard(Scanner scanner) {
		this.actionCardsSet = GameBoard.createActionCardSet();
		this.duckCardsSet = GameBoard.createDuckCardSet();
		this.skySet = GameBoard.createSkySet();
		this.playerSet = new ArrayList<Player>();
		this.discardSet = new ArrayList<ActionCard>();
		this.scanner = scanner;
	}
	
	public static ArrayList<DuckCard> createDuckCardSet() {
		ArrayList<DuckCard> set = new ArrayList<DuckCard>();
		for(int i=0; i<NUM_OF_EMPTY_SURFACE; i++) 
			set.add(new EmptyDuckCard());
		return set;
	}

	public static ArrayList<CardSky> createSkySet() {
		ArrayList<CardSky> set = new ArrayList<CardSky>();
		for(int i=0; i<NUM_OF_SKIES; i++) 
			set.add(new CardSky());
		System.out.println("Vytvorene pole o velkosti: " + set.size());
		return set;
	}
	
	public static ArrayList<ActionCard> createActionCardSet(){
		ArrayList<ActionCard> set = new ArrayList<ActionCard>();
		for(int i=0; i<NUM_OF_ACTCARD_AIM; i++) 
			set.add(new CardAim());
		for(int i=0; i<NUM_OF_ACTCARD_SHOOT; i++)
			set.add(new CardShoot());
		for(int i=0; i<NUM_OF_ACTCARD_DUCKMARCH; i++)
			set.add(new CardDuckMarch());
		for(int i=0; i<NUM_OF_ACTCARD_TURBODUCK; i++)
			set.add(new CardTurboDuck());
		for(int i=0; i<NUM_OF_ACTCARD_WILDBILL; i++)
			set.add(new CardWildBill());
		for(int i=0; i<NUM_OF_ACTCARD_SHUFFLING; i++)
			set.add(new CardShuffling());
		for(int i=0; i<NUM_OF_ACTCARD_DUCKDANCE; i++)
			set.add(new CardDuckDance());
		return set;
	}

	public ArrayList<ActionCard> getDiscardSet() {
		return discardSet;
	}

	public void setDiscardSet(ArrayList<ActionCard> discardSet) {
		this.discardSet = discardSet;
	}

	public ArrayList<CardSky> getSkySet() {
		return skySet;
	}

	public void setSkySet(ArrayList<CardSky> skySet) {
		this.skySet = skySet;
	}
	
	public Scanner getScanner() {
		return scanner;
	}

	public ArrayList<DuckCard> getDuckCardsSet() {
		return duckCardsSet;
	}

	public void setDuckCardsSet(ArrayList<DuckCard> duckCardsSet) {
		this.duckCardsSet = duckCardsSet;
	}

	public ArrayList<ActionCard> getActionCardsSet() {
		return actionCardsSet;
	}

	public void setActionCardsSet(ArrayList<ActionCard> actionCardsSet) {
		this.actionCardsSet = actionCardsSet;
	}
	
	public void shuffleActionCadsSet() {
		Random rand = new Random();
		ArrayList<ActionCard> newList = new ArrayList<ActionCard>(actionCardsSet.size());

		while(actionCardsSet.size()>0) {
			int rndmIndex = rand.nextInt(actionCardsSet.size());
			newList.add(actionCardsSet.get(rndmIndex));
			actionCardsSet.remove(rndmIndex);
		}
		this.actionCardsSet = newList;
	}
	
	public void shuffleDuckCadsSet() {
		Random rand = new Random();
		ArrayList<DuckCard> newList = new ArrayList<DuckCard>(duckCardsSet.size());

		while(duckCardsSet.size()>0) {
			int rndmIndex = rand.nextInt(duckCardsSet.size());
			newList.add(duckCardsSet.get(rndmIndex));
			duckCardsSet.remove(rndmIndex);
		}
		this.duckCardsSet = newList;
	}

	public void addNewPlayer(Player newPlayer) {
		playerSet.add(newPlayer);
	}
	
	public ArrayList<Player> getPlayerSet(){
		return playerSet;
	}
	
	public ActionCard getActionCard() {
		ActionCard card = this.actionCardsSet.get(0);
		this.actionCardsSet.remove(0);		
		return card;
	}
	
	public void addToDiscardSet(ActionCard card) {
		this.discardSet.add(card);
	}
	
	public void refillActionCardSet() {
		this.actionCardsSet = this.discardSet;
		this.discardSet = new ArrayList<ActionCard>();
	}
	
	public void addCardFromSetToPlayerHand(int playerOrder) {
		this.playerSet.get(playerOrder).restockHand(this.actionCardsSet.get(0));
		this.actionCardsSet.remove(0);
	}
	
	public void addDuckFromSetToSky(int skyOrder) {
		skySet.get(skyOrder).setOccupant(duckCardsSet.get(1));
		duckCardsSet.remove(1);
	}
	
	private String drawDucks() {
		String ducks = "";
		PlayersDuckCard duckCard = null;
		
		ducks += STRING_TITLE_SKYSET + "\n";
		for(CardSky currCardSky : this.skySet)
			ducks += (currCardSky.getOccupant().getClass() == PlayersDuckCard.class) ? STRING_DUCK_ROW_1  + STRING_DUCK_GAP: STRING_DUCK_EMPTY + STRING_DUCK_GAP;
		ducks += "\n";
		for(CardSky currCardSky : this.skySet)
			ducks += (currCardSky.getOccupant().getClass() == PlayersDuckCard.class) ? STRING_DUCK_ROW_2 + STRING_DUCK_GAP : STRING_DUCK_EMPTY + STRING_DUCK_GAP;
		ducks += "\n";
		for(CardSky currCardSky : this.skySet) 
			ducks += (currCardSky.getOccupant().getClass() == PlayersDuckCard.class) ? STRING_DUCK_ROW_3 + STRING_DUCK_GAP : STRING_DUCK_EMPTY + STRING_DUCK_GAP;
		ducks += "\n";
		for(CardSky currCardSky : this.skySet) 
			ducks += (currCardSky.getOccupant().getClass() == PlayersDuckCard.class) ? STRING_DUCK_ROW_4 + STRING_DUCK_GAP : STRING_DUCK_EMPTY + STRING_DUCK_GAP;
		ducks += "\n";
		for(CardSky currCardSky : this.skySet)
			ducks += (currCardSky.getOccupant().getClass() == PlayersDuckCard.class) ? STRING_DUCK_ROW_5 + STRING_DUCK_GAP : STRING_DUCK_EMPTY + STRING_DUCK_GAP;
		ducks += "\n";
		for(CardSky currCardSky : this.skySet)
			ducks += (currCardSky.getOccupant().getClass() == PlayersDuckCard.class) ? STRING_DUCK_ROW_6 + STRING_DUCK_GAP : STRING_DUCK_EMPTY + STRING_DUCK_GAP;
		ducks += "\n";
		for(CardSky currCardSky : this.skySet)
			ducks += (currCardSky.getOccupant().getClass() == PlayersDuckCard.class) ? STRING_DUCK_ROW_7 + STRING_DUCK_GAP: STRING_DUCK_SURFACE + STRING_DUCK_GAP;
		ducks += "\n";
		for(int i = 0; i<NUM_OF_SKIES; i++)
			ducks += STRING_DUCK_EMPTY + STRING_DUCK_GAP;
		ducks += "\n";
		for (CardSky currCardSky : this.skySet) {
			if(currCardSky.getOccupant().getClass() == PlayersDuckCard.class) {
				duckCard = (PlayersDuckCard) currCardSky.getOccupant();
				ducks += makeUpString(duckCard.getOwner().getName(), DUCK_SIZE) + STRING_DUCK_GAP;
			}
			else
				ducks += STRING_DUCK_EMPTY + STRING_DUCK_GAP;
		}
		return ducks;
	}
	
	private String drawAiming() {
		String aim = "";
		for(int i = 0; i<NUM_OF_SKIES; i++) 
			aim += STRING_AIM_TOP_ROW_1 + STRING_DUCK_GAP;
		aim += "\n";
		for(int i = 0; i<NUM_OF_SKIES; i++) 
			aim += STRING_AIM_TOP_ROW_2 + STRING_DUCK_GAP;
		aim += "\n";
		for(CardSky currCardSky : this.skySet) 
			aim += (currCardSky.getAiming() != null) ? STRING_AIM_MID_ROW_1 + STRING_DUCK_GAP : STRING_AIM_EMPTY + STRING_DUCK_GAP;
		aim += "\n";
		for(CardSky currCardSky : this.skySet) 
			aim += (currCardSky.getAiming() != null) ? STRING_AIM_MID_ROW_2 + STRING_DUCK_GAP : STRING_AIM_EMPTY + STRING_DUCK_GAP;
		aim += "\n";
		for(int i = 0; i<NUM_OF_SKIES; i++) 
			aim += STRING_AIM_BOT_ROW + STRING_DUCK_GAP;
		aim += "\n";
		return aim;
	}
	
	public String formattedGameBoard() {
		String strGameBoard = "\n";
		
		strGameBoard += drawAiming() + drawDucks();
		
		return strGameBoard;
	}
	
	public String makeUpString(String inputString, int length) {
		 int numOfSpacesFromLeft = ((length - 2)-inputString.length()) /2;
		 int numOfSpacesFromRight = ((length - 2)-inputString.length()) - numOfSpacesFromLeft;

		 String output = "|";
		for(int i=0; i<numOfSpacesFromLeft; i++)
			output += " ";
		output += inputString;
		for(int j=0; j<numOfSpacesFromRight ; j++)
			output += " ";
		output += "|";
		return output;
	}

	public void kacaciPochod() {
		DuckCard currCard = null;
		duckCardsSet.add(skySet.get(0).getOccupant());
		
		for(int i=1; i<skySet.size(); i++) {
			currCard = skySet.get(i).getOccupant();
			skySet.get(i-1).setOccupant(currCard);
		}
		skySet.get(skySet.size()-1).setOccupant(duckCardsSet.get(0));
		duckCardsSet.remove(0);
		
	}
	
	public void vystrelit(int shoot) {
		DuckCard currCard = null;
		duckCardsSet.add(skySet.get(shoot).getOccupant());
		
		for(int i=shoot+1; i<skySet.size(); i++) {
			currCard = skySet.get(i).getOccupant();
			skySet.get(i-1).setOccupant(currCard);
		}
		skySet.get(skySet.size()-1).setOccupant(duckCardsSet.get(0));
		duckCardsSet.remove(0);	
		
		
	}

	public void turboDuck(int turbo) {
		
		for(int i = 0; i<=turbo; i++) {
			Collections.swap(skySet, turbo, i);
		}	
	}

	public void rosambo() {
		
		for(int i=0; i<=getSkySet().size(); i++)
		{
		Collections.shuffle(skySet);
		}
	}

	public void kacaciTanec() {
		
		for (int i = 0; i < getSkySet().size(); i++) {
			duckCardsSet.add(skySet.get(i).getOccupant());
		}
		Collections.shuffle(duckCardsSet);
		for (int i = 0; i < getSkySet().size(); i++)
			addDuckFromSetToSky(i);
	}
	public boolean back() {
		boolean endLoop = false;
		return endLoop;
		
	}
	
}
