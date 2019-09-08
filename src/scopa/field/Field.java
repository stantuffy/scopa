package scopa.field;

import java.util.ArrayList;
import java.util.List;

import scopa.card.Card;


public class Field {
	
	private List<Card> cardsOnField;
	
	public Field() {
		cardsOnField = new ArrayList<>();
	}
	
	public void addCard(Card c) {
		cardsOnField.add(c);
	}
	
	public void removeCard(Card c) {
		cardsOnField.remove(c);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("=========== FIELD ===========\n");
		for (Card c : cardsOnField) {
			sb.append(c.toString());
			sb.append("\n");
		}
		sb.append("=============================\n");
		
		return sb.toString();
	}
}
