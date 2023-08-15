package cards_challange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player {
	private String name;
	private int score;
	private List<Card> cards;
	
	public Player (String name) {
		this.name = name;
		this.cards = new ArrayList<>();
		this.score = 0;
	}
	
	public void takeCard(Card card) {
		cards.add(card);
		calculateScore(card);
		cards.sort(sortRankReverseSuit());
	}
	
	private Comparator<Card> sortRankReverseSuit(){
		return Comparator.comparing(Card::getRank).reversed().thenComparing(Card::getSuit);
	}
	
	private void calculateScore(Card card) {
		this.score += card.getRank();
	}
	
	public int getScore() {
		return this.score;
	}
	
	@Override
	public String toString() {
		return "%15s - %d in hand %30s".formatted(this.name, this.score, this.cards);
	}
}
