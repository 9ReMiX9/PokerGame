package PokerGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private List<Card> hand = new ArrayList<Card>();
	private String playerName;
	
	public Player(String name)
	{
		playerName = name;
	}
	
	public void addCard(Card x)
	{
		hand.add(x);
	}
	
	public void removeCard(Card x)
	{
		hand.remove(x);		
	}
	
	public Card removeAndReturnCard(Card x)
	{
		Card temp = new Card(x);
		hand.remove(x);
		return temp;
	}
	
	public List<Card> getHand()
	{
		return hand;
	}
	
	public String getName()
	{
		return playerName;
	}
	
	public int cardsInHand()
	{
		return hand.size();
	}
	
	public String toString()
	{
		System.out.println(hand);
		return "";
	}

	public void moveCard(Card card, int cardsInHand) {
		Card temp = new Card(card);
		hand.remove(card);
		hand.add(temp);
	}

}
