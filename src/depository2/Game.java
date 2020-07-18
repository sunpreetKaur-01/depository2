/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depository2;

/**
 *
 * @author sunpr
 */



import java.util.*;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author Sivagama 
 */
public abstract class Game extends GroupOfCards
{
    private final String gameName;//the title of the game
    public ArrayList <Player> players;// the players of the game
    
    public Game(String givenName)
    {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    public String getGameName() 
    {
        return gameName;
    }
    
     /**
     * @return the players of this game
     */
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList <Player> players) 
    {
        this.players = players;
    }
    
    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    public abstract void play();
    
    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public abstract void declareWinner();
}

class UNOGame extends Game
{
    int turn;
    public UNOGame(String gamename)
    {
        super(gamename);
    }
    ArrayList[] playersdeck;
    ArrayList discardpile=new ArrayList();
    public void play()
    {
        playersdeck=new ArrayList[100];
        for(int l=0;l<getPlayers().size();l++)
        {
        playersdeck[l]=new ArrayList();
        for(int i=0;i<getSize();i++)
        {
        playersdeck[l].add(cards.remove(0));
        }
        }
        discardpile.add(cards.remove(0));
        turn=0;
        do
		{
		    if(turn>getPlayers().size()-1)
		    {
		    turn=0;
		    }
		    System.out.println("PLAYER: "+players.get(turn).getPlayerID()+"'s turn");
		   playTurn(turn);
		    turn =turn+ 1;
		    if(turn>getPlayers().size()-1)
		    {
		    turn=0;
		    }
		}while(playersdeck[turn].size()>0);
    }
    public void declareWinner()
    {
        System.out.println("Congratulations!! Player "+players.get(turn).getPlayerID()+" has won!");
        System.exit(0);
    }
    
    
    
    public void playTurn(int player) 
    {
        boolean checker=false;
        boolean Wildchecker=false;
		int wildlocation=0;
        System.out.println("\n");
		System.out.println("The card on top of the discard pile is "+discardpile.get(discardpile.size()-1));
		if("WILD".equals(discardpile.get(discardpile.size()-1).toString()))
		{
		System.out.println("\nDrawing another card from Draw pile and throwing WILD under the Discard pile\n");
		discardpile.add(cards.remove(0));
		System.out.println("\nThe new card on top of the discard pile is "+discardpile.get(discardpile.size()-1));
		}
		System.out.println("\nCards in "+players.get(player).getPlayerID()+"'s hand are:\n");
		for (int x = 0; x < playersdeck[player].size(); x++)  
        System.out.println(playersdeck[player].get(x) + " "+x );
		
		String topcard=(discardpile.get(discardpile.size()-1)).toString();
		String playerscard="";
		String temp="";
		String temp2="";
		String temp3="";
		String temp4="";
		String temp5="";
		String temp6="";
		for(int x=0;x<topcard.length();x++)
		{
		    if(topcard.charAt(x)==' ')
		    {
		        break;
		    }
		    if(topcard.charAt(x)!=' ')
		    {
		        temp=temp+topcard.charAt(x);
		    }
		}
		
		for(int q=topcard.length()-1;q>=0;q--)
		    {
		        
		        if(topcard.charAt(q)==' ')
		        {
		        break;
		        }
		        if(topcard.charAt(q)!=' ')
		        {
		        temp5=temp5+topcard.charAt(q);
		        }
		    }
		    
		    for(int w=temp5.length()-1;w>=0;w--)
		    {
		        temp6=temp6+temp5.charAt(w);
		    }
		    
		for(int x=0;x<playersdeck[player].size();x++)
		{
		    temp2="";
		    temp3="";
		    temp4="";
		    
		    if("WILD".equals(playersdeck[player].get(x).toString()))
		    {
		        Wildchecker=true;
		        wildlocation=x;
		    }

		    if(discardpile.get(discardpile.size()-1).equals(playersdeck[player].get(x).toString()))
		    {
		        System.out.println("Adding "+playersdeck[player].get(x).toString()+" to the discard pile");
		        discardpile.add(playersdeck[player].remove(x));
		        checker=true;
		        break;
		    }
		    playerscard=playersdeck[player].get(x).toString();
		    for(int y=0;y<playerscard.length();y++)
		    {
		        
		        if(playerscard.charAt(y)==' ')
		        {
		        break;
		        }
		        if(playerscard.charAt(y)!=' ')
		        {
		        temp2=temp2+playerscard.charAt(y);
		        }
		    }
		    for(int y=playerscard.length()-1;y>=0;y--)
		    {
		        
		        if(playerscard.charAt(y)==' ')
		        {
		        break;
		        }
		        if(playerscard.charAt(y)!=' ')
		        {
		        temp3=temp3+playerscard.charAt(y);
		        }
		    }
		    
		    for(int g=temp3.length()-1;g>=0;g--)
		    {
		        temp4=temp4+temp3.charAt(g);
		    }
		    
		    if(temp.equals(temp2))
		    {
		        System.out.println("\nAdding "+playersdeck[player].get(x).toString()+" to the discard pile\n");
		        discardpile.add(playersdeck[player].remove(x));
		        checker=true;
		        break;
		    }
		    if(temp6.equals(temp4))
		    {
		        System.out.println("\nAdding "+playersdeck[player].get(x).toString()+" to the discard pile\n");
		        discardpile.add(playersdeck[player].remove(x));
		        checker=true;
		        break;
		    }
		}
		if(playersdeck[player].size()==0)
		{
		    declareWinner();
		}
		
		
		if(checker==false)
		{
		    if(Wildchecker==true)
		{
		   System.out.println("\nWILD! User played wild card\n"); 
		   if(player==0)
		   {
		   discardpile.add(playersdeck[player].remove(wildlocation));
		   playersdeck[player+1].add(cards.remove(0));
		   playersdeck[player+1].add(cards.remove(0));
		   playersdeck[player+1].add(cards.remove(0));
		   playersdeck[player+1].add(cards.remove(0));
		   }
		   if(player!=0)
		   {
		   discardpile.add(playersdeck[player].remove(wildlocation));
		   playersdeck[player-1].add(cards.remove(0));
		   playersdeck[player-1].add(cards.remove(0));
		   playersdeck[player-1].add(cards.remove(0));
		   playersdeck[player-1].add(cards.remove(0));
		   }
		   Wildchecker=false;
		   
		}
		if(Wildchecker==false)
		{
		  System.out.println("\nNo matching card in player " +players.get(player).getPlayerID()+"'s deck. Adding a card from Draw pile\n");
		playersdeck[player].add(cards.remove(0));
		}
		}

		System.out.println("Player "+players.get(player).getPlayerID()+"'s remaining cards are:\n" );
		for (int x = 0; x < playersdeck[player].size(); x++)  
        System.out.println(playersdeck[player].get(x) + " "+x );
}
}
