/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package therealhomework4;

import java.util.ArrayList;

/**
 * Werewolf is Horror Character 
 * @author schmay
 */
public class Werewolf extends HorrorCharacter implements Transformable 
{
    private boolean transform;
    /**
     * Constructor for HorrorCharacter Class
     * @param name - the String name of the horror character
     * @param health -  the int health of the horror character
     * @param vulnerability - the enumeration Vulnerability vulnerability of the horror character
     */
    public Werewolf(String name, int health, Vulnerability vulnerability)
    {
        super(name, health, vulnerability);
        transform = false;
    } 
    /**
    * Attack associated with WereWolf according to boolean Transform value
    */
    @Override
    public void attack()
    {
        if(transform)
        {
            System.out.println("Attack werewolf damage was critical");
        }
        else
             System.out.println("Attack werewolf damage was minor please trasnform");
            
    }
    /**
     * The flee associated with WereWolf
    */
    @Override
    public void flee()
    {
        System.out.println("Flee was successful, werewolf");
    }
    /**
     * Werewolf can transform, changes boolean transform to True
    */
    @Override
    public void transform() 
   {
       transform = true;
   }
    /**
    * Calls CompareTo from Parent class, does not change effect at all
    * @return the int decifer which is the vulnerability in integer form
    */
    @Override
    public int compareTo(ArrayList<HorrorCharacter> horrorCharacters, int pos)
    {
        int decifer = super.compareTo(horrorCharacters, pos);
        return decifer;
    }
    /**
     * toString outputs the attributes associated with WereWolf Class
     * @return the String with all the fields of the class
     */ 
    @Override
    public String toString() 
    {
        String info = super.toString();
        return info + "Werewolf{" + "transform=" + transform + '}';
    }

 
    
}
//