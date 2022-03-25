package sk.stuba.fei.uim.oop;


import java.util.ArrayList;

public class Player {
	private int id;
	private String name;
	private ArrayList<ActionCard> hand;

	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		this.hand = new ArrayList<ActionCard>(3);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<ActionCard> getHand() {
		return hand;
	}
	
	public void restockHand(ActionCard card) {
		if(hand.size()>2)
			System.out.println("AJAJA volaco sa pokazilo");
		else
			hand.add(card);
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + "]";
	}

	public void throwCardFromHand(ActionCard playedCard) {
		this.hand.remove(playedCard);		
	}
	
}
