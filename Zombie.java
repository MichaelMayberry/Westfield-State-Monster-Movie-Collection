/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package therealhomework4;

import java.util.ArrayList;

/**
 * Zombie is a Horror Character 
 * @author schmay
 */
public class Zombie extends HorrorCharacter
{
    /**
     * Constructor for Zombie Class
     * @param name - the String name of the horror character
     * @param health -  the int health of the horror character
     * @param vulnerability - the enumeration Vulnerability vulnerability of the horror character 
     */
    public Zombie(String name, int health, Vulnerability vulnerability)
    {
        super(name, health, vulnerability);
    }
    /**
     * The attack associated with Zombie
    */
    @Override
    public void attack()
    {
        System.out.println("Attack Zombie damage was critical");
    }
    /**
     * The flee associated with Zombie
    */
    @Override
    public void flee()
    {
        System.out.println("Flee was successful, Zombie");
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
     * toString outputs the attributes associated with Zombie Class
     * @return the String with all the fields of the class
     */
    @Override
    public String toString() 
    {
        String info = super.toString();
        return info + "Zombie{" + '}';
    }

    
    
}
