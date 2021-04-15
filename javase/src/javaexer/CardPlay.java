package javaexer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CardPlay {
	public final static int ALL_CARDS = 54;

	public static void main(String[] args) {
		System.out.println("====================== 新牌 ======================");
		ArrayList<Card> cards = init();
		show(cards);

		// 洗牌
		System.out.println("====================== 洗牌 ======================");
		shuffle(cards);
		show(cards);

		// 整理牌
		System.out.println("====================== 理牌 ======================");
		arrange(cards);
		show(cards);
	}

	// 1.自定义类 - 牌
	// 2.定义方法:生成一副牌(ALL_CARDS)
	public static ArrayList<Card> init() {

		ArrayList<Card> cards = new ArrayList<Card>();
		CardNum[] nums = CardNum.values();
		cardColor[] colors = cardColor.values();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				Card card = new Card(colors[i], nums[j]);
				cards.add(card);
			}
		}
		cards.add(new Card(null, nums[CardNum.BLACK_JOKER.getCardNumber() - 1]));
		cards.add(new Card(null, nums[CardNum.RED_JOKER.getCardNumber() - 1]));
		return cards;
	}

	// 3.定义方法:洗牌,每次执行,洗牌后的顺序都不应该完全相同(随机打乱牌的顺序)
	public static void shuffle(List<Card> cards) {
		int randLoc;
		for (int i = ALL_CARDS; i > 1; i--) {

			randLoc = new Random().nextInt(i);
			cards.add(ALL_CARDS - 1, cards.remove(randLoc));
		}

	}

	// 4.定义方法:整理牌, 安照 红桃,方块,黑桃,梅花,王(点数从小到大)的顺序排序(可以使用TreeSet)
	public static void arrange(List<Card> cards) {
		Collections.sort(cards, new Comparator<Card>() {

			@Override
			public int compare(Card c1, Card c2) {
				if (c1.getCardColor() == null && c2.getCardColor() == null) {
					return c1.getNumber().getCardNumber() - c2.getNumber().getCardNumber();
				} else if (c1.getCardColor() == null) {
					return 1;
				} else if (c2.getCardColor() == null) {
					return -1;
				}
				if (c1.getCardColor().getName().equals(c2.getCardColor().getName())) {
					return c1.getNumber().getCardNumber() - c2.getNumber().getCardNumber();
				}

				return c1.getCardColor().getColorNum() - c2.getCardColor().getColorNum();
			}
		});
	}

	// 定义方法:展示牌面
	public static void show(List<Card> cards) {
		int count = 0;
		for (Card card : cards) {

			if (card.getCardColor() != null) {
				System.out.print(card.getCardColor().getName() + card.getNumber().getCardMark() + "\t");
			} else {
				System.out.print(card.getNumber().getCardMark() + "\t");
			}
			count++;
			if (count % 4 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
}

class Card {
	private cardColor cardColor;
	private CardNum number;

	public Card() {
		super();
	}

	public Card(javaexer.cardColor cardColor, CardNum number) {
		super();
		this.cardColor = cardColor;
		this.number = number;
	}

	public cardColor getCardColor() {
		return cardColor;
	}

	public void setCardColor(cardColor cardColor) {
		this.cardColor = cardColor;
	}

	public CardNum getNumber() {
		return number;
	}

	public void setNumber(CardNum number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Card [cardColor=" + cardColor + ", number=" + number + "]";
	}

}

enum cardColor {
	HEARTS("红桃", 1), SPADES("黑桃", 3), DIAMONDS("方块", 2), CLUBS("梅花", 4);

	private String name;
	private int colorNum;

	private cardColor(String name, int colorNum) {
		this.name = name;
		this.colorNum = colorNum;
	}

	public String getName() {
		return name;
	}

	public int getColorNum() {
		return colorNum;
	}

}

enum CardNum {
	ONE("A", 1), TWO("2", 2), THREE("3", 3), FOUR("4", 4), FIVE("5", 5), SIX("6", 6), SEVEN("7", 7), EIGHT("8", 8),
	NINE("9", 9), TEN("10", 10), ELEVEN("J", 11), TWELVE("Q", 12), THIRTEEN("K", 13), BLACK_JOKER("小王", 14),
	RED_JOKER("大王", 15);

	private String cardMark;
	private int cardNum;

	private CardNum(String cardMark, int CardNum) {
		this.cardMark = cardMark;
		this.cardNum = CardNum;
	}

	public String getCardMark() {
		return cardMark;
	}

	public int getCardNumber() {
		return cardNum;
	}

}
