package cards_challange;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Deck deck = new Deck ();
		System.out.println("_".repeat(20)+"Cards in deck"+"_".repeat(20));
		deck.addFullDeckOfCards();
		deck.printDeckOfCards(4);
		
		System.out.println("_".repeat(20)+"After shuffling"+"_".repeat(20));
		deck.shuffleDeck();
		deck.printDeckOfCards(4);
		
		List<Player> players = addPlayers();
		
		System.out.println("_".repeat(20)+"After Cutting"+"_".repeat(20));
		deck.cutDeck();
		deck.printDeckOfCards(4);
		
		System.out.println("_".repeat(20)+"After Distribution"+"_".repeat(20));
		deck.cardDistribute(players, 5);
		players.forEach(System.out::println);
		
		
		System.out.println("_".repeat(20)+"Score Board"+"_".repeat(20));
		players.sort((o1, o2) -> o1.getScore() < o2.getScore() ? -1 : o1.getScore() == o2.getScore() ? 0 : 1);
		players.forEach(System.out::println);
	}
	
	private static ArrayList<Player> addPlayers() {
		return new ArrayList<>(
				List.of(
						new Player("Jagadeesh"),
						new Player("Saravanavel"),
						new Player("JD"),
						new Player("Guru")
						)
				);
	}
}
