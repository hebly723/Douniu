package unit;

import java.util.ArrayList;
import java.util.HashMap;

import inteface.Board;

public class Banker extends Board {

	static int LOW_PAY  = 1;
	static int MID_PAY   = 1;
	static int HIG_PAY   =  2;
	/**
	 * 初始化玩家记录,手牌
	 */
	public Banker(int number){
		init(number);
	}
	/**
	 * 初始化玩家记录,手牌
	 */
	public Banker(){
		init(2);
	}
	
	public void play() {
		this.deck.shufflecard();
		//发牌
		for (int i = 0; i < this.playerNumber; i++) {
			this.trumpsList.set(i, deck.outCard(Trumps.number));
		}
		//比较
		//只需与庄家进行比较就行
		int max = (this.trumpsList.get(0).getPoint())/10;
		for (int i = 1; i < playerNumber; i++) {
			if (this.trumpsList.get(i).getPoint()>this.trumpsList.get(0).getPoint())
			{
				int oldScore = this.score.get(i);
				this.score.set(i, oldScore+1);
				int oldPlayerMoney = this.money.get(i);
				int oldBankerMoney = this.money.get(0);
				max = (this.trumpsList.get(i).getPoint())/10;
				switch (max) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
					this.money.set(i, oldPlayerMoney+LOW_PAY);
					this.money.set(0, oldBankerMoney-LOW_PAY);
				break;
				
				case 8:	
				case 9:
					this.money.set(i, oldPlayerMoney+MID_PAY);
					this.money.set(0, oldBankerMoney-MID_PAY);
					break;
					
				case 10:
				case 11:
				case 12:
				case 13:
					this.money.set(i, oldPlayerMoney+HIG_PAY);
					this.money.set(0, oldBankerMoney-HIG_PAY);
					break;

				default:
					Error(1);
					break;
				}
			}
			else
			{
				int oldPlayerMoney = this.money.get(i);
				int oldBankerMoney = this.money.get(0);
				switch (max) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
					this.money.set(i, oldPlayerMoney-LOW_PAY);
					this.money.set(0, oldBankerMoney+LOW_PAY);
				break;
				
				case 8:	
				case 9:
					this.money.set(i, oldPlayerMoney-MID_PAY);
					this.money.set(0, oldBankerMoney+MID_PAY);
					break;
					
				case 10:
				case 11:
				case 12:
				case 13:
					this.money.set(i, oldPlayerMoney-HIG_PAY);
					this.money.set(0, oldBankerMoney+HIG_PAY);
					break;

				default:
					Error(1);
					break;
				}
			}
			}
		}

	private void Error(int situation) {
		switch (situation) {
		case 1:
			System.out.println("牌的有效点数在允许范围外");
			break;

		default:
			System.out.println("未定义的错误情况");
			break;
		}
	}
	public void play(int k) {
		for (int i = 0; i < k; i++) {
			play();
		}

	}
	
	public void init(int number) {
		this.setPlayerNumber(number);
	}
	
	/**
	 * 得到玩家的数量
	 * @return 玩家数量的整数值
	 */
	public int getPlayerNumber() {
		return playerNumber;
	}
	
	/**
	 * 设定玩家的数量
	 * @param playerNumber 玩家数量的整数值
	 */
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
		for (int i = 0; i < this.playerNumber; i++) {
			this.score.add(i,0);
			this.money.add(i,0);
			this.trumpsList.add(i, null);
		}
	}
	
	@Override
	public String toString() {
		String string = "场上情况如下所示:\n玩家手牌:\n";
		int i = 0;
		for (Trumps  trumps : this.trumpsList){
			string  = string + "第" + i + "\n----------\n" +  trumps;
			i++;
		}
		i= 0;
		string  = string +"场上资金:\n" ;
		for (Integer  trumps : this.money){
			string  = string +  "\n"  + "第" + i + ":" + trumps;
			i++;
		}
		i = 0;
		string  = string +"\n场上历史胜利次数:\n" ;
		for (Integer  trumps : this.score){
			if (i>0){
			string  = string +  "\n"  + "第" + i + ":" + trumps;
			}
			i++;
		}
		return string;
	}
	
	@Override
	public void display() {
//		System.out.println(super.toString());
		System.out.println(this.toString());
	}

}
