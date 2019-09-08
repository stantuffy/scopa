package scopa.card;

import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Card extends Parent {
	private final Suit suit;
	private final Rank rank;
	
	private int width;
	private int height;
	
	/**
	 * Default constructor
	 * @param suit
	 * @param rank
	 */
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		this.width = 60;
		this.height = 100;
		
		setUpTexture();
	}
	
	/**
	 * Provided a suit and a rank, this function 
	 * handles the graphics of the card
	 */
	private void setUpTexture() {
		Rectangle rect = new Rectangle(width, height);
		rect.setArcWidth(20);
		rect.setArcHeight(20);
		rect.setFill(Color.WHITE);
		
		Text text = new Text(this.toString());
		text.setWrappingWidth(40);
		
		this.getChildren().add(new StackPane(rect, text));
	}
	
	/**
	 * @return The card's suit
	 */
	public Suit getCardSuit() {
		return this.suit;
	}
	
	/**
	 * @return The card's rank
	 */
	public Rank getCardRank() {
		return this.rank;
	}
	
	/**
	 * @return The card's rank expressed by a number
	 * that goes from 1 to 10
	 */
	public int getCardNumber() {
		return this.rank.value;
	}
	
	@Override
	public String toString() {
		return rank.value + " di " + suit.toString();
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		Card that = (Card)o;
		return this.rank == that.rank && this.suit == that.suit;
	}
}
