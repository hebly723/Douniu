package unit;
/**
 * 卡牌类
 * @author jenkin
 */
public class Card {
	/**
	 * 花色，用数字表示因为每种花色是可以比较大小的
	 */
	private int suit ;
	/**
	 * 点数，用数字表示
	 */
	private int point;
	/**
	 * 判断当前牌是否可用
	 * true 可用
	 * false不可用
	 */
	private boolean hand;
	
	/**
	 * 初始化一张牌
	 * @param suit
	 * @param point
	 * @param hand
	 */
	public Card(int suit, int point, boolean hand){
		setHand(hand);
		setPoint(point);
		setSuit(suit);
	}
	/**
	 * 得到当前牌是否可用的信息
	 * @return 布尔值，true可用，false不可用
	 */
	public boolean isHand() {
		return hand;
	}
	/**
	 * 设定当前牌的可用情况
	 * @param hand 布尔值，true可用，false不可用
	 */
	public void setHand(boolean hand) {
		this.hand = hand;
	}
	/**
	 * 得到花色的值
	 * @return 花色，用0~3的整数表示，越大优先级越高
	 */
	public int getSuit() {
		return suit;
	}
	/**
	 * 设定花色的值
	 * @param suit 0~3的整数值
	 */
	public void setSuit(int suit) {
		this.suit = suit;
	}
	/**
	 * 得到点数的整数值
	 * @return 1~13的点数值
	 */
	public int getPoint() {
		return point;
	}
	/**
	 * 设定点数的值
	 * @param point 1~13的点数值
	 */
	public void setPoint(int point) {
		this.point = point;
	}
	
	public String toString()
	{
		return "\n 花色为 " + suit + " 点数为  " + point + " 手上? " + hand;
	}
	
	public void display()
	{
		System.out.println(this);
	}

}
