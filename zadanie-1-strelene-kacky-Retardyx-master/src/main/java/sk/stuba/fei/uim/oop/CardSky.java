package sk.stuba.fei.uim.oop;


public class CardSky {

	private DuckCard currentOccupant;
	private CardAim aiming;

	
	public CardSky() {
		this.currentOccupant = new EmptyDuckCard();
		this.aiming = null;
	}
	
	public void setOccupant(DuckCard currentOccupant) {
		this.currentOccupant = currentOccupant;
	}
	
	public DuckCard getOccupant() {
		return currentOccupant;
	}

	public ActionCard getAiming() {
		return aiming;
	}

	public void setAiming(ActionCard aiming) {
		if(aiming.getClass() == CardAim.class)
			this.aiming = (CardAim) aiming;
		else
			System.out.println("ERROR: snazis sa zamierit zlou kartou");
	}
	
	public void removeAiming(ActionCard aiming) {
		if(aiming.getClass() != CardAim.class)
			this.aiming = null;
	}

	
	public String toString() {
		return "CardSky [currentOccupant=" + currentOccupant + ", aiming=" + aiming + "]";
	}	
}
