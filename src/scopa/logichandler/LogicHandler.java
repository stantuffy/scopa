package scopa.logichandler;

import java.util.Scanner;

import scopa.deck.Deck;
import scopa.hand.Hand;
import scopa.field.Field;

public class LogicHandler {
	
	private Field field;
	private Deck deck;
	private Hand player;
	private Hand ai;
	private Scanner scanner;
	private boolean finished;
	
	public LogicHandler() {
		this.field = new Field();
		this.deck = new Deck();
		this.player = new Hand();
		this.ai = new Hand();
		this.scanner = new Scanner(System.in);
	}
	
	public void play() {
		initializeBoard();
		while (!finished) {
			
		}
	}
	
	private void initializeBoard() {
		for (int i=0; i<3; i++)
			deck.dealCard(player);
		
		for (int i=0; i<3; i++)
			deck.dealCard(ai);
		
		for (int i=0; i<4; i++)
			field.addCard(deck.dealCard());
		
		printBoard();
	}
	
	private void printBoard() {
		System.out.print(ai.toString());
		System.out.print(field.toString());
		System.out.print(player.toString());
		
	}
}
