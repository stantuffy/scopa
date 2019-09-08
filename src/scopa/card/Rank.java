package scopa.card;

public enum Rank {
	Asso(1), 
	Due(2),
	Tre(3),
	Quattro(4),
	Cinque(5),
	Sei(6),
	Sette(7),
	Otto(8),
	Nove(9),
	Dieci(10);
	
	final int value;
	
	private Rank(int value) {
		this.value = value;
	}
}
