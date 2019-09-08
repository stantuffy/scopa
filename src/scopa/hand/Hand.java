package scopa.hand;

import scopa.card.Card;
import scopa.card.Rank;
import scopa.card.Suit;

import java.util.List;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;

public class Hand {
	private List<Card> cardsInHand;
	private List<Card> cardsGained;
	private BitSet score;
	private int scope;
	private boolean winner;

	/**
	 * Default constructor
	 */
	public Hand() {
		cardsInHand = new ArrayList<>();
		cardsGained = new ArrayList<>();
		score = new BitSet(4);
		scope = 0;
		winner = false;
	}
	
	public Card decideNextMove() {
		return null;
	}
	
	public void drawCard(Card c) {
		if (cardsInHand.size() >= 3) {
			throw new IllegalArgumentException("HAND MUST ONLY HAVE THREE OR LESS CARDS.");
		}
		cardsInHand.add(c);
	}
	
	public void removeCard(Card c) {
		cardsInHand.remove(decideNextMove());
	}
	
	public void gainCards(Collection<Card> cards) {
		cardsGained.addAll(cards);
	}
	
	public List<Card> getCardsInHand() {
		return cardsInHand;
	}
	
	public List<Card> getCardsGained() {
		return cardsGained;
	}
	
	public boolean isWinner() {
		return winner;
	}
	
	private boolean hasSetteBello() {
		for (Card c : cardsGained) {
			if (c.getCardRank() == Rank.Sette && c.getCardSuit() == Suit.Denari) {
				return true;
			}
		}
		return false;
	}
	
	private boolean hasMoreCards() {
		return cardsGained.size() > 20;
	}
	
	private boolean hasMoreDenari() {
		int denariCounter = 0;
		for (Card c : cardsGained) {
			if (c.getCardSuit() == Suit.Denari) {
				++denariCounter;
			}
		}
		return denariCounter > 5;
	}
	
	private boolean hasPrimiera() {
		
		int numbers[] = new int[7];
		
		for (Card c : cardsGained) {
			switch (c.getCardNumber()) {
				case 1:
					++numbers[0];
					break;
				case 2:
					++numbers[1];
					break;
				case 3:
					++numbers[2];
					break;
				case 4:
					++numbers[3];
					break;
				case 5:
					++numbers[4];
					break;
				case 6:
					++numbers[5];
					break;
				case 7:
					++numbers[6];
					break;
				default:
					break;
			}
		}
		
		if (numbers[6] > 2)
			return true;
		
		else {
			for (int i=0; i<7; i++) {
				if (numbers[6 - i] == 2 && numbers[5 - i] > 2) {
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * Call this function when the are no
	 * cards left in the deck.
	 */
	public void updateScore() {
		score.set(0, hasMoreCards());
		score.set(1, hasMoreDenari());
		score.set(2, hasSetteBello());
		score.set(3, hasPrimiera());
	}
	
	public BitSet getScore() {
		return score;
	}
	
	public int getNumScope() {
		return scope;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("============ HAND ===========\n");
		for (Card c : cardsInHand) {
			sb.append(c.toString());
			sb.append("\n");
		}
		sb.append("=============================\n");
		
		return sb.toString();
	}
}
