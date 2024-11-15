/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package therealhomework4;

import java.util.ArrayList;

/**
 * HorrorCharacter represents the basic functionality of the characters
 * @author schmay
 */
public abstract class HorrorCharacter 
{

          
    private String name;
    private int health;
    private Vulnerability vulnerability;
    
    /**
     * Constructor for HorrorCharacter Class
     * @param name - the String name of the horror character
     * @param health -  the int health of the horror character
     * @param vulnerability - the enumeration Vulnerability vulnerability of the horror character 
     */
    public HorrorCharacter(String name, int health, Vulnerability vulnerability)
    {
        this.health = health;
        this.name = name;
        this.vulnerability = vulnerability;
    }
    
    /**
     * Outputs the character and the attack damage
     */
    public abstract void attack();

    /**
     * Outputs the monster and how it flee
     */
    public abstract void flee();

    /**
     * Gets Name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets Health
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets health
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets Vulnerability
     * @return the vulnerability
     */
    public Vulnerability getVulnerability() {
        return vulnerability;
    }

    /**
     * Sets Vulnerability
     * @param vulnerability the vulnerability to set
     */
    public void setVulnerability(Vulnerability vulnerability) {
        this.vulnerability = vulnerability;
    }
    /**
     * Gets the Horror Character in the array horrorCharacters at position pos to determine the decider which tells us what type of vulnerability that the 
     * Horror Character has in an integer form
     * @param horrorCharacters - the array containing Horror Characters
     * @param pos - the position in the array indicating which Horror Character is being implemented
     * 
     */
    public int compareTo(ArrayList<HorrorCharacter> horrorCharacters, int pos)
    {
       int decider = 0;
       if(horrorCharacters.get(pos).getVulnerability() == Vulnerability.GARLIC)
       {
           decider = 1; //Vampire is 1
       }
       else if(horrorCharacters.get(pos).getVulnerability() == Vulnerability.FIRE)
       {
           decider = 2;//Zombie is 2
       }
       else if(horrorCharacters.get(pos).getVulnerability() == Vulnerability.SILVER)
       {
           decider = 3;//WereWolf is 3
       }
       
        return decider;
    }

    /**
     * toString outputs the attributes associated with HorrorCharacter Class
     * @return the String with all the fields of the class
     */
    @Override
    public String toString() 
    {
        return "HorrorCharacter{" + "name=" + name + ", health=" + health + ", vulnerability=" + vulnerability + '}';
    }
    



}
