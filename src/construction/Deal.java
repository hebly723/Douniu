package construction;

import java.util.HashMap;
import java.util.Map;

import unit.Banker;
import unit.Deck;
import unit.Trumps;

public class Deal {
	
	public static void main(String args[])
	{
		Deck deck = new Deck();
//		deck.display();
//		Map<Integer, Integer> score = new HashMap<Integer, Integer>();
//		for (int i = 0;i<11;i++)
//		{
//			score.put(i, 0);
//		}
////		for (int i=0;i<100000;i++){
//			deck.shufflecard();
//			deck.display();
//			Trumps trumps = deck.outCard(5);
//			trumps.display();
//			int n = 73/10;
//			int newScore = score.get(trumps.getNiu()) + 1;
//			score.put(trumps.getNiu(), newScore);
//		}
//		System.out.println("\n");
//		for (int i = 0;i<11;i++)
//		{
//			System.out.println(i + ":" +score.get(i));
//		}
			Banker banker  = new Banker(3);
			banker.play(100000);
			banker.display();
	}

}
