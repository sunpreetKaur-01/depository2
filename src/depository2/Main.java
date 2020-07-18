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
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
		System.out.println("Select the Game you want to play\nPress 1 for a game of UNO");
		Scanner scn = new Scanner(System.in);
        int game = scn.nextInt();
        UNOGame uno=new UNOGame("UNO");
        if(game==1)
        {
           System.out.println("Starting a game of UNO..."); 
            uno.deckMaker();
            uno.shuffle();
            uno.toString();
        }
        if(game!=1)
        {
           System.out.println("INVALID ENTRY! TRY LATER"); 
        }

        System.out.println("How many players are there?");
        int players = scn.nextInt();
        ArrayList<Player> player=new ArrayList<>();
        String temp;
        for(int i=0;i<players;i++)
        {
        System.out.println("\n");
        System.out.println("Enter the name of player "+(i+1));
        temp=scn.next();
        player.add(new PlayerDetails(temp));
        uno.setPlayers(player);
        System.out.println("\n");
        }
        uno.play();
	}
}

