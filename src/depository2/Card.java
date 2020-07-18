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
import java.util.Collections;
import java.util.Scanner;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author Sivagama
 */

public abstract class Card 
{
	    public enum Suit{RED,GREEN,BLUE,YELLOW};
        public enum Value1{DRAW_FOUR,WILD};
        public enum Value{ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE,SKIP,REVERSE,DRAW_TWO};
        private Suit suit;
        private Value value;
        
        public Card(Suit s, Value gVal)
        {
           suit =s;
           value= gVal;
        }
        
        public Card()
        {
        }
        
	public Value getValue() {
		return this.value;
	}

	
	public Suit getSuit() {
		return this.suit;
        }

    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
    @Override
    public abstract String toString();
    
}

class UNOCards extends Card
{
    public ArrayList cards=new ArrayList(108);
    public void deckMaker()
    {
        int counter=-1;
        for(int j=0;j<4;j++)
        {
            counter++;
            Suit s=Suit.values()[j];
            cards.add(counter,"ZERO of "+s.toString());
        for(int i=0;i<12;i++)
        {
            counter++;
            cards.add(counter,Value.values()[i]+" of "+s.toString());
            counter++;
            cards.add(counter,Value.values()[i]+" of "+s);
        }
        }
        
        for(int i=0;i<2;i++)
        {
            counter++;
            cards.add(counter,Value1.values()[i]);
            counter++;
            cards.add(counter,Value1.values()[i]);
            counter++;
            cards.add(counter,Value1.values()[i]);
            counter++;
            cards.add(counter,Value1.values()[i]);
        }
        
    }
    
    public String toString()
    {
        String output="";
        System.out.println("Cards in the Draw pile after shuffling are!"); 
        System.out.println("\n"); 
        for (int x = 0; x < cards.size(); x++)  
        {
        System.out.println(cards.get(x)); 
        output=output+cards.get(x) + "      ";
        }
        System.out.println("\n"); 
        System.out.println("\n"); 
        
        return output;
    }
}

