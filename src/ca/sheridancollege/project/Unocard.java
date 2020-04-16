/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

/**
 *
 * Modified are Sukhreet, Mulllaly, Ripandeep and Bennud
 */
import java.util.Random;
public class Unocard {
    private static Unocard uno=null; //We are apply singleton Desgn pattern in this line
    private String color;//encapsulation satisfy here
    private int value;
    private Random rand;
    private String face;

    public Unocard(int v, String c)//constructor with arguments
    {
        value = v;
        color = c; 
    }

    // Creates a random card
    private Unocard()//singleton pattern satisfy this situation
    {
        rand = new Random();
        value = rand.nextInt(28); // 108 cards in a standard Uno deck. Can be reduced to 27 (disregarding colors)
        // Assigning value
        if (value >= 14) // Some cards are more common than others
            value -= 14;
        // Assigning color
        rand = new Random();
         switch(rand.nextInt(4) )
        {
            case 0: color = "Red"; 
                break;
            case 1: color = "Green"; 
                break;
            case 2: color = "Blue"; 
                break;
            case 3: color = "Yellow"; 
                break;
        }
        // If the card is a wild card
        if (value >= 13)
            color = "none";
    }

    public String getFace()
    {
        /* Returns the face of the card (what the player sees)
         * Ex. [Red 5]
         */
        face = "[";
        if (getColor() != "none")
        {
            face += this.getColor() + " ";
        }
         switch(this.getValue())
        {
            default: face += String.valueOf(this.getValue()); 
                break;
            case 10: face += "Skip"; 
                break;
            case 11: face += "Reverse"; 
                break;
            case 12: face += "Draw 2"; 
                break;
            case 13: face += "Wild"; 
                break;
            case 14: face += "Wild Draw 4"; 
                break;
        }
        face += "]";
        return face;
    }

    // Determines if you can place this card on top of a given card
    // The color needs to be specified because if a wild card was chosen in the previous round, the color would have changed, but the card staying the same
    public boolean canPlace(Unocard o, String c)
    {
         if (this.getColor() == c)
            return true;
        else if (this.getValue() == o.getValue())
            return true;
        else if (this.getColor() == "none") // Wild cards
            return true;
        return false;
    }

    /**
     * @return the color
     */
    public String getColor() {//getter method
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {//setter method
        this.color = color;
    }

    /**
     * @return the value
     */
    public int getValue() {//getter method
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {//setter method
        this.value = value;
    }
    
public static Unocard getInstance()//singleton pattern satisfy this situation
    {
        if(uno == null)
        {
            uno = new Unocard();
        } 
        return uno;
    }
}