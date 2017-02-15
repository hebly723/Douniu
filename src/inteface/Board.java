package inteface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import unit.Deck;
import unit.Trumps;

public abstract class Board {
	/**
	 * 场上的整副牌
	 */
	public Deck deck = new Deck();
	/**
	 * 在场的玩家数量
	 */
	public int playerNumber = 2;
	/**
	 * 场上的资金情况
	 */
	public ArrayList<Integer> money = new ArrayList<Integer>();
	/**
	 * 在场上的牌组数组
	 */
	public ArrayList<Trumps> trumpsList = new ArrayList<Trumps>();
	/**
	 * 记录输赢次数(英雄榜)的散列序列
	 */
	public ArrayList<Integer> score = new ArrayList<Integer>();
	/**
	 * 开始游戏(一局)
	 * 判定谁胜谁负
	 */
	void play(){
		
	}
	/**
	 * 开始游戏
	 * @param k 局数
	 */
	void play(int k){
		
	}
	/**
	 * 初始化玩家记录,手牌
	 */
	void init(int number){
		
	}

	private void Error(int situation) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString()
	{
		return "Board";
	}
	public void display(){
		System.out.println(this.toString());
	}
}
