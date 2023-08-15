package cards_challange;

public class Card {
	public enum Suit {CLUB, DIAMOND, HEART, SPADE;
		
		public char replaceToSuitSymbol() {
			return switch (this) {
			case CLUB -> (char) 9827;
			case DIAMOND -> (char) 9830;
			case HEART -> (char) 9829;
			case SPADE -> (char) 9824;
			default -> ' ';
			};
		}
	}	
		private Suit suit;
		private String faceValue;
		private int rank;
		
		public Card() {
			this("club","2",0);
		}
		
		public Card(String suitValue, String faceValue, int rank) {
			this.suit = switch (suitValue.toUpperCase()) {
			case "CLUB" -> Suit.CLUB;
			case "DIAMOND" -> Suit.DIAMOND;
			case "HEART" -> Suit.HEART;
			case "SPADE" -> Suit.SPADE;
			default -> null;
			};
			this.faceValue = faceValue;
			this.rank = rank;
		}
		
		public Suit getSuit() {
			return this.suit;
		}
		
		public String getFaceValue() {
			return this.faceValue;
		}
		
		public int getRank() {
			return this.rank;
		}
		
		@Override
		public String toString() {
			return "%s%s(%d)".formatted(this.faceValue, suit.replaceToSuitSymbol(), this.rank);
		}
}
