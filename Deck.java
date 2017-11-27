package PokerGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import PokerGame.Card.Suit;
import PokerGame.Card.Value;

public class Deck {
	
	private List<Card> deck;
	
	public Deck()
	{
		deck = new ArrayList<Card>();
		for(Value x:Value.values())
		{
			for(Suit y: Suit.values())
			{
				deck.add(new Card(x,y));
			}
		}
		System.out.println("Created deck with " + deck.size() + " cards.");
	}
	
	public void shuffle()
	{
		Collections.shuffle(deck);
		System.out.println("Shuffled Deck");
	}
	
	public void shuffle(int shuffleTimes)
	{
		Collections.shuffle(deck);
		shuffle(shuffleTimes--);
		if(shuffleTimes == 0)
			System.out.println("Shuffled Deck");
	}
	
	public Card getCard(int position)
	{
		return deck.get(position);
	}
	
	public int getSize()
	{
		return deck.size();
	}
	
	public void removeCard(int position)
	{
		deck.remove(position);
	}
	
	public String toString()
	{
		for(Card e: deck)
		{
			System.out.println(e.toString());
		}
		return "Done";
	}

}
