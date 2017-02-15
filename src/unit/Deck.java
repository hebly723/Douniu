package unit;

import java.util.ArrayList;
import java.util.Random;
/**
 * 一副整牌的类
 * @author jenkin
 *
 */
public class Deck {

	/**
	 * 一副牌
	 */
	private ArrayList<Card> deck;
	/**
	 * 发牌位置
	 */
	private int position = 0;
	/**
	 * 初始化一副牌
	 */
	public Deck(){
		deck = new ArrayList<Card>();
		for (int i=1;i<14;i++)
		{
			for (int j=0;j<4;j++)
			{
				Card card = new Card(j, i, true);
				deck.add(card);
			}
		}
		setPosition(0);
	}
	/**
	 * 得到发牌的位置
	 * @return 发牌的位置整数值
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * 设置发牌的位置
	 * @param position 发牌的位置整数值
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * 洗牌
	 */
	public void shufflecard()
	{
			Random seed = new Random();
			for (int i = 0; i < deck.size(); i++) {
				int j = seed.nextInt(deck.size());
				deck.get(i).setHand(true);
				if (j!=i)
				{
					Card temp = deck.get(j);
					deck.set(j, deck.get(i));
					deck.set(i, temp);
				}
			}
			setPosition(0);
	}
	
	/**
	 * 发牌
	 */
	public Trumps outCard( int k)
	{
		Trumps.setNumber(k);
		Trumps trumps = new Trumps(k);
		ArrayList<Card> cards = new ArrayList<>();
		int j = 0;
		int i = getPosition();
		while ( i < deck.size()&&j<k) {
//				System.out.println(i);
				Card card  = deck.get(i);
				cards.add(card);
				card.setHand(false);
				deck.set(i, card);
				j ++;
				i ++;
		}
		setPosition(i);
		if (cards.size()<k)
			Error(1);
		trumps.setTrumps(cards);
		return trumps;
	}
	
	public String toString()
	{
		String string = "整副牌如下\n";
		for (Card card : deck)
		{
			string = string + card + "\n";
		}
		return string;
	}
	
	public void display()
	{
		System.out.println(this);
	}
	/**
	 * 错误的输出函数
	 * @param i 情况(整数)
	 */
	public void Error(int i)
	{
		switch (i) {
		case 1:
			System.out.println("\n~~~~~~~~~~~~牌不够~~~~~~~~~~~~~\n");
			break;

		default:
			System.out.println("未预知的错误情况");
			break;
		}
	}
	
}
