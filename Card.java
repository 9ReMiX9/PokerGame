package PokerGame;

public class Card {
	
	enum Value
	{
		ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13);
		
		int actualValue;
		
		Value(int x)
		{
			actualValue = x;
		}
		
		int getValue()
		{
			return actualValue;
		}
	}
	
	enum Suit
	{
		SPADE(1), DIAMOND(2), CLUB(3), HEART(4);
		
		int assignedValue;
		
		Suit(int x)
		{
			assignedValue = x;
		}
		
		int getValue()
		{
			return assignedValue;
		}
	}
	
	Value value;
	Suit suit;
	
	public Card(Value inputValue, Suit inputSuit)
	{
		value = inputValue;
		suit = inputSuit;
	}
	
	public Card(Card x)
	{
		value = x.value;
		suit = x.suit;
	}
	
	public String toString()
	{
		return value.name() + " OF " + suit.name() + "S ";
	}

}
