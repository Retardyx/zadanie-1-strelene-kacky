package sk.stuba.fei.uim.oop;


import java.util.Scanner;

public class Game {
	private static final String TEXT_WELLCOME_MESSAGE = "Vitajte v hre Strelene kacice!";
	private static final String TEXT_NUM_OF_PLAYERS_REQUEST = "\nZadajte pocet hracov (2-6): ";
	private static final String TEXT_ERROR_OUT_OF_BOUND = "\nNespravny pocet hracov!";
	private static final String TEXT_ERROR_WRONG_FORMAT = "\nNespravny format,pouzi cele cislo!";

	private GameBoard gameBoard;
	private Scanner scanner;
	private String inputString;
	private int numOfPlayers;
	private int inputNum;
	private int currTurn;

	public Game() {
		this.scanner = new Scanner(System.in);
		this.currTurn = 0;
		this.gameBoard = new GameBoard(scanner);
		setNumberOfPlayers();
		setPlayersProperties();
	}

	private void setNumberOfPlayers() {

		boolean endLoop = false;
		System.out.print(TEXT_WELLCOME_MESSAGE);

		while (!endLoop) {
			System.out.print(TEXT_NUM_OF_PLAYERS_REQUEST);
			inputString = scanner.next();
			if (isInteger(inputString)) {
				numOfPlayers = Integer.parseInt(inputString);
				if (numOfPlayers > 1 && numOfPlayers < 7)
					endLoop = true;
				else
					System.out.print(TEXT_ERROR_OUT_OF_BOUND);
			} else
				System.out.print(TEXT_ERROR_WRONG_FORMAT);
		}
	}

	private void setPlayersProperties() {
		for (int i = 1; i <= numOfPlayers; i++) {
			System.out.print("Zadajte meno " + i + ". hraca: ");
			inputString = scanner.next();
			Player newPlayer = new Player(i, inputString);
			this.gameBoard.addNewPlayer(newPlayer);

			for (int j = 0; j < GameBoard.NUM_OF_DUCKS; j++)
				this.gameBoard.getDuckCardsSet().add(new PlayersDuckCard(newPlayer));

		}
	}

	public void prepareGame() {

		gameBoard.shuffleActionCadsSet();
		for (int i = 0; i < this.gameBoard.getPlayerSet().size(); i++) {
			for (int j = 0; j < GameBoard.NUM_OF_CARDS_ON_HAND; j++)
				this.gameBoard.addCardFromSetToPlayerHand(i);
		}
		gameBoard.shuffleDuckCadsSet();
		for (int i = 0; i < gameBoard.getSkySet().size(); i++)
			this.gameBoard.addDuckFromSetToSky(i);
		
	

	}

	public void startGame() {
		Player currPlayer = null;
		boolean endLoop = false;

		while (isPlaying()){ 
			currPlayer = getCurrentPlayer(currTurn);
			
			System.out.print(gameBoard.formattedGameBoard());
			
			System.out.print("\n"
					+ getPlayerCardsInfo(currPlayer, false) + currPlayer.getName());
			while (!endLoop){ 
				System.out.print(
						"info: Pre hru kartou zadaj cislo pri karte, pre dalsie informacie zadaj lubovolny znak\n"
								+ currPlayer.getName() + ": ");
				inputString = scanner.next();
				if (isInteger(inputString)) {
					inputNum = Integer.parseInt(inputString);
					if (inputNum > 0 & inputNum < 4)
						endLoop = true;
					else 
						System.out.print("\n" + getPlayerCardsInfo(currPlayer, true));
						} 
					else {
						System.out.print("\n" + getPlayerCardsInfo(currPlayer, true));
					}
				
			}
			ActionCard playedCard = getCurrentPlayer(currTurn).getHand().get(inputNum - 1);
			playedCard.doAct(gameBoard);	
			gameBoard.addToDiscardSet(playedCard);
			getCurrentPlayer(currTurn).throwCardFromHand(playedCard);
			if (gameBoard.getActionCardsSet().size() == 0)
				gameBoard.refillActionCardSet();
			getCurrentPlayer(currTurn).restockHand(gameBoard.getActionCard());

			System.out.println("\n\n\nPOUZITE KARTY: " + gameBoard.getDiscardSet().size() + "\tZOSTAVA V BALICKU: "
					+ gameBoard.getActionCardsSet().size());
			
			endLoop = false;
			currTurn++;
		}
			}
		
	
	private Player getCurrentPlayer(int turn) {
		if (turn >= numOfPlayers) {
			this.currTurn = 0;
			return this.gameBoard.getPlayerSet().get(currTurn);
		} else
			return this.gameBoard.getPlayerSet().get(turn);
	}
	

	private String getPlayerCardsInfo(Player inPlayer, boolean description) {
		String output = "";
		for (int i = 0; i < GameBoard.NUM_OF_CARDS_ON_HAND; i++) {
			ActionCard currActCard = inPlayer.getHand().get(i);
			if (description)
				output += "[" + (i + 1) + "] -> " + currActCard.getTitle() + ": " + currActCard.getDescription() + "\n";
			else
				output += "[" + (i + 1) + "] -> " + currActCard.getTitle() + "\n";
		}
		return output;
	}

	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public boolean isPlaying() {
		Player player = null;
		PlayersDuckCard duckCard = null;
		for (DuckCard currentCard : gameBoard.getDuckCardsSet()) {
			if (currentCard.getClass() == PlayersDuckCard.class) {
				duckCard = (PlayersDuckCard) currentCard;
				if (player == null || player == duckCard.getOwner())
					player = duckCard.getOwner();
				else
					return true;
			}
		}
		
		return false;
	}
}
