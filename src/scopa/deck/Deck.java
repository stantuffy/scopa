package scopa.deck;

import scopa.card.Card;

import scopa.card.Rank;
import scopa.card.Suit;
import scopa.hand.Hand;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	
	private List<Card> cards;
	
	/**
	 * Default constructor.
	 */
	public Deck() {
		cards = new ArrayList<>();
		fillDeck();
	}
	
	/**
	 * This function initializes the deck.
	 * It is called only once.
	 */
	private void fillDeck() {
		for (Rank r : Rank.values()) {
			for (Suit s : Suit.values()) {
				addCard(new Card(s, r));
			}
		}
		
		shuffleDeck();
	}
	
	/**
	 * Shuffles the deck using the default
	 * method provided by the JCF.
	 */
	private void shuffleDeck() {
		Collections.reverse(cards);
		Collections.shuffle(cards);
	}
	
	/**
	 * Adds a card to the deck.
	 * It is only called by the constructor.
	 * @param c
	 */
	private void addCard(Card c) {
		cards.add(c);
	}
	
	/**
	 * Deals a card to the specified hand
	 * @return The card to be removed.
	 */
	public Card dealCard(Hand hand) {
		 Card c = cards.remove(cards.size() - 1);
		 hand.drawCard(c);
		 return c;
	}
	
	/**
	 * @return The card to be removed.
	 */
	public Card dealCard() {
		Card c = cards.remove(cards.size() - 1);
		return c;
	}
	
	/**
	 * @return The number of cards left.
	 */
	public int getNumOfCards() {
		return cards.size();
	}
	
	/**
	 * @return A list containing the cards
	 * left.
	 */
	public List<Card> getCardsLeft() {
		return cards;
	}
	
	@Override
	public String toString() {
		return "Cards left: " + cards.size();
	}
}
