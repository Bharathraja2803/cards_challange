package cards_challange;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private List<Card> deckOfCards = new ArrayList<>();
	private List<String> suits = new ArrayList<>(List.of("CLUB", "DIAMOND", "HEART", "SPADE"));
	private List<String> faces = new ArrayList<>(List.of("2","3","4","5","6","7","8","9","10","J","Q","K","A"));
	public void addFullDeckOfCards() {
		for(String suit : suits) {
			for (String face: faces) {
				deckOfCards.add(new Card(suit, face, faces.indexOf(face)));
			}
		}
	}
			
	public void addFullDeckOfCards(int noOfDecks) {
		for (int i=0; i< noOfDecks; i++) {
			for(String suit : suits) {
				for (String face: faces) {
					deckOfCards.add(new Card(suit, face, faces.indexOf(face)));
				}
			}	
		}
	}
	
	public void printDeckOfCards(int rowCount) {
		int noOfCardsPerRow = deckOfCards.size() / rowCount;
		for (int i =0; i< deckOfCards.size(); i++) {
			if(i%noOfCardsPerRow==0 && i !=0) {
				System.out.println();
			}
			System.out.print("%7s".formatted(deckOfCards.get(i)));
		}
		System.out.println();
	}
	
	public Card getCard(String suit, int number) {
		for (Card c: deckOfCards) {
			if(c.getSuit().toString().equals(suit.toUpperCase()) && Integer.parseInt(c.getFaceValue())==number) {
				return c;
			}
		}
		System.out.println("%30s".formatted("No cards match"));
		return null;
	}
	
	public Card getCard(String suit, String face) {
		for (Card c: deckOfCards) {
			if(c.getSuit().toString().equals(suit.toUpperCase()) && c.getFaceValue().equals(face)) {
				return c;
			}
		}
		System.out.println("%30s".formatted("No cards match"));
		return null;
	}
	
	public void shuffleDeck() {
		Collections.shuffle(deckOfCards);
	}
	
	public void cutDeck() {
		int randomMiddle = new Random().nextInt(15,35);
		Collections.rotate(deckOfCards, randomMiddle);
	}
	
	public void cardDistribute(List<Player> players, int noOfCardsEach) {
		for (int deckIndex =0, i=0; i<noOfCardsEach; i++) {
			for(Player p : players) {
				p.takeCard(deckOfCards.get(deckIndex++));
			}
		}
	}
	
}
