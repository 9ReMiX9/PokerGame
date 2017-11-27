package PokerGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class War extends Game{
	
	Deck gameDeck;
	
	Player winner;
	Player human;
	Player bot;
	
	public War()
	{
		gameDeck = new Deck();
		initializeGame();
	}
	
	public void initializeGame()
	{
		gameDeck.shuffle();
		
		System.out.println("How many players?");
		Scanner reader = new Scanner(System.in);
		int howManyPlayers = reader.nextInt();
		if(howManyPlayers == 0)
		{
			//Add Two Bots
		}
		if(howManyPlayers == 1)
		{
			reader.nextLine();
			System.out.println("What is your name?");
			String playerName = reader.next();
			human = new Player(playerName);
			bot = new Player("Bot");
			
			int handSize = gameDeck.getSize() / 2;
			
			while(handSize < gameDeck.getSize())
			{
				human.addCard(gameDeck.getCard(0));
				gameDeck.removeCard(0);
			}
			while(gameDeck.getSize() > 0)
			{
				bot.addCard(gameDeck.getCard(0));
				gameDeck.removeCard(0);
			}
			
			System.out.println("Let's Begin " + human.getName());
			
			start();
		}
		if(howManyPlayers == 2)
		{
			//Add Two Human Players
		}
		if(howManyPlayers > 2 || howManyPlayers < 0)
		{
			invalidInput();
		}
		
	}
	
	boolean playing, war;
	public void start() 
	{
		playing = true;
		while(playing)
		{
			gameLogic();
			if(human.cardsInHand() <= 0)
			{
				winner = bot;
				playing = false;
			}
			if(bot.cardsInHand() <= 0)
			{
				winner = human;
				playing = false;
			}
		}
		System.out.println(winner.getName() + " WINS THE GAME!");
		System.out.println("Play Again? YES or NO");
		Scanner reader = new Scanner(System.in);
		String x = reader.next();
		if(x.equalsIgnoreCase("Yes"))
		{
			initializeGame();
		}
		else
			return;
	}

	public Player gameLogic()
	{
		System.out.println("----------------------------------------------");
		
		Card player1 = new Card(human.getHand().get(0));
		Card player2 = new Card(bot.getHand().get(0));
		
		System.out.println(human.getName() + " draws a " + player1);
		System.out.println(bot.getName() + " draws a " + player2);
		
		if(player1.value.getValue() > player2.value.getValue())
		{
			//Player Wins
			System.out.println(human.getName() + " wins the round!");
			human.addCard(bot.removeAndReturnCard(bot.getHand().get(0)));
			
			human.moveCard(human.getHand().get(0), human.cardsInHand());
			
			System.out.println();
			System.out.println("You have " + human.cardsInHand() + " cards left in hand. Press ENTER to continue.");
			
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return human;
		}
		if(player2.value.getValue() > player1.value.getValue())
		{
			//Bot Wins
			System.out.println(bot.getName() + " wins the round!");
			
			bot.addCard(human.removeAndReturnCard(human.getHand().get(0)));
			
			System.out.println();
			System.out.println("You have " + human.cardsInHand() + " cards left in hand. Press ENTER to continue.");
			
			bot.moveCard(bot.getHand().get(0), bot.cardsInHand());
			
			try {
				System.in.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return bot;
		}
		if(player1.value.getValue() == player2.value.getValue())
		{
			//War
			System.out.println("It's time for war!");
			System.out.println("Two cards from both hands have been set aside!");
			
			Player temp = war();
			System.out.println(temp.getName() + " has won the round!");
			return temp;
		}
		return null;
		

	}
	private Player war()
	{
		List<Card> cardBank = new ArrayList<Card>();
		
		cardBank.add(human.removeAndReturnCard(human.getHand().get(0)));
		cardBank.add(human.removeAndReturnCard(human.getHand().get(0)));
		cardBank.add(human.removeAndReturnCard(human.getHand().get(0)));
		cardBank.add(bot.removeAndReturnCard(bot.getHand().get(0)));
		cardBank.add(bot.removeAndReturnCard(bot.getHand().get(0)));
		cardBank.add(bot.removeAndReturnCard(bot.getHand().get(0)));
		
		Player winner = gameLogic();
		
		while(cardBank.size() > 0)
		{
			System.out.println(winner.getName() + " has won " + cardBank.get(0).toString() + " from the war!");
			winner.addCard(cardBank.get(0));;
			cardBank.remove(0);
		}
		
		
		return winner;
	}

	

}
