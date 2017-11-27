package PokerGame;

import java.util.List;

public abstract class Game{
	
	List<Player> playerList;
	
	public abstract void initializeGame();
	public abstract void start();
	public abstract Player gameLogic();
	
	public Player randomPlayer()
	{
		//Fix it later
		if(playerList.size() <= 0)
		{
			System.out.println("No players in game!");
			return null;
		}
		return playerList.get((int)(Math.random() * 10) * playerList.size());
				
	}
	
	public void invalidInput()
	{
		System.out.println("Invalid Input!");
	}

}
