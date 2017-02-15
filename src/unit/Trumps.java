package unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 玩家手上的一副牌
 * @author jenkin
 *
 */
public class Trumps {
	/**
	 * 玩家手里的一副牌
	 */
	ArrayList< Card> trumps;

	/**
	 * 这副牌的有效点数
	 */
	private int point = 0;
	
	/**
	 * 这副牌的张数(统一)
	 */
	static int number = 5;
	/**
	 * 是否有"牛"
	 * 数字代表牛几,0则是没有牛
	 */
	private int niu = 0;
	/**
	 * 初始化玩家手上的一副牌
	 * @param number 玩家手上一副牌的张数
	 */
	public Trumps(int number)
	{
		trumps = new ArrayList<Card>();
		setNumber(number);
	}

	/**
	 * 得到一共能有几张牌
	 * @return 牌的整数数目
	 */
	public static int getNumber() {
		return number;
	}
	
	/**
	 * 判断是否有牛
	 * @return 整数值,数字代表牛几,0则是没有牛
	 */
	public int getNiu() {
		return niu;
	}

	/**
	 * 设定是否有牛
	 * @param niu 整数值,数字代表牛几,0则是没有牛
	 */
	public void setNiu(int niu) {
		this.niu = niu;
	}
	
	public void plusNiu(int fd) {
		this.niu += fd;
	}

	/**
	 * 设定牌的数目
	 * @param numbe 牌的整数数目
	 */
	public static void setNumber(int numbe) {
		number = numbe;
	}

	/**
	 * 得到牌
	 * @return 牌的数组(ArrayList)
	 */
	public ArrayList<Card> getTrumps() {
		return trumps;
	}

	/**
	 * 设定牌
	 * @param trumps 牌的数组(ArrayList)
	 */
	public void setTrumps(ArrayList<Card> trumps) {
		this.trumps = trumps;
		order();
	}
	
	public String toString()
	{
		String string = "牌组如下\n";
		if (this.getNiu()>0)
			string = string + "牛" + this.getNiu() + "\n";
		else
			string = string + "无牛" + "\n";
		string = string + "有效点数为 " + this.getPoint() + "\n";
		for (Card card : trumps)
		{
			string = string + card + "\n";
		}
		return string;
	}
	//TODO 三张牌相加得到整数的函数, 
	//整理三张牌后, 剩下两张牌的值就设为true,其余三张是false
	//10以上优先选取小的牌加入这三张牌
	//没有"牛"的牌组是全false,此时在标志量niu中设0
	//有"牛"的牌组在标志量niu中设是牛几,整数值是其余两张牌的值相加
	/**
	 * 将手中的牌整理()
	 */
	public void order()
	{
		int sum = 0;
		for (Card card : trumps)
		{
			if (card.getPoint()<=10)
			sum += card.getPoint();
			else
				sum +=10;
			
		}
		int[] mir = new int[getNumber()];
		int i=0;
		for (Card card : trumps)
		{
			if (card.getPoint()<=10)
			mir[i++] = (sum - card.getPoint())%10;
			else
				mir[i++] = sum%10;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int j = 0; j < i;j++)
		{
			if (map.get(mir[j]) != null)
			{
				if (trumps.get(map.get(mir[j])).getPoint()>=trumps.get(j).getPoint())
				{
					continue;
				}
				else
				{
					map.put(mir[j], j);
				}
			}
			else
				map.put(mir[j], j);
		}
		
		for (int j= 0;j<i;j++)
		{
			if (trumps.get(j).getPoint()<=10){
			if (map.get(trumps.get(j).getPoint())!=null&&(map.get(trumps.get(j).getPoint())!=j))
			{
				//TODO 这里或许还要考虑大小问题
				this.setNiu(0);
				Card card = trumps.get(j);
				card.setHand(true);
				if (card.getPoint()<=10)
					this.plusNiu(card.getPoint());
					else
						this.plusNiu(10);
				card = trumps.get(map.get(trumps.get(j).getPoint()));
				card.setHand(true);
				if (card.getPoint()<=10)
					this.plusNiu(card.getPoint());
					else
						this.plusNiu(10);
				break;
			}
			}
			else if (map.get(10)!=null&&(map.get(trumps.get(j).getPoint())!=j))
			{
				//TODO 这里或许还要考虑大小问题
				this.setNiu(0);
				Card card = trumps.get(j);
				card.setHand(true);
				if (card.getPoint()<=10)
				this.plusNiu(card.getPoint());
				else
					this.plusNiu(10);
				card = trumps.get(10);
				card.setHand(true);
				if (card.getPoint()<=10)
					this.plusNiu(card.getPoint());
					else
						this.plusNiu(10);
				break;
			}
		}
		if (this.getNiu()>10)
		this.setNiu(this.getNiu()-10);
		this.setPoint();
	}
	/**
	 * 得到有效点数的值(整数值)
	 * @return 有效点数的值(整数值)
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * 设定有效点数的值(整数值)
	 * @param point 有效点数的值(整数值)
	 */
	public void setPoint(int point) {
		this.point = point;
	}
	
	/**
	 * 设定有效点数的值(整数值)
	 * 根据牌中最大的数字,将其值乘以十加上它的花色
	 */
	public void setPoint() {
		int i = 0;
		if (trumps.size()>0){
			int max = i;
			i++;
			while (i<trumps.size())
			{
				if ((trumps.get(max).getPoint()*10+trumps.get(max).getSuit()) < (trumps.get(i).getPoint()*10+trumps.get(i).getSuit()))
					max = i;
				i++;
			}
			setPoint(trumps.get(max).getPoint()*10+trumps.get(max).getSuit());
		}
	}

	public void display()
	{
		System.out.println(this);
	}
	
}
