package sk.stuba.fei.uim.oop;


public class PlayersDuckCard implements DuckCard {
	private final Player owner;
	
	public PlayersDuckCard(Player owner) {
		this.owner = owner;
	}
	
	public Player getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return " " + owner + " ";
	}
}
