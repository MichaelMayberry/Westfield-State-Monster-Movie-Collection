/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package therealhomework4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * MonsterMovie represents the movie case where HorrorCharacter objects are placed in and used
 * @author schmay
 */
public class MonsterMovie 
{
    private String title;
    private int yearReleased;
    private ArrayList<HorrorCharacter> horrorCharacters = null;
    HashMap<String, Integer> hcMap = null;

    /**
     * Constructor for Monster Movie Class
     * @param title String title of movie
     * @param yearReleased int year move was released
     * @param horrorCharacters array of Horror Characters used in Movie
     */
    
    public MonsterMovie(String title, int yearReleased, ArrayList<HorrorCharacter> horrorCharacters)
    {
        this.title = title;
        this.yearReleased = yearReleased;
        this.horrorCharacters = horrorCharacters;
        hcMap = new HashMap<>();
        hcMap.put("Vampire", 0);
        hcMap.put("WereWolf", 0);
        hcMap.put("Zombie", 0);
        
    }
    
    /**
     * Gets title
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets title
     * @param title the title to set
     */
    public void setTitle(String title) 
    {
        if(!title.isEmpty())
        {
            this.title = title;
        }
    }
    /**
     * Gets yearReleased
     * @return the yearReleased
     */
    public int getYearReleased() {
        return yearReleased;
    }
    /**
     * Sets yearReleased
     * @param yearReleased the yearReleased to set
     */
    public void setYearReleased(int yearReleased) {
        if(yearReleased < 2027 )
            this.yearReleased = yearReleased;
    }
     /**
      * Gets HorrorCharacters Array
     * @return the HorrorCharacters
     */
    public ArrayList<HorrorCharacter> getHorrorCharacters() {
        return horrorCharacters;
    }
    /**
     * Sets HorrorCharacters Array
     * @param horrorCharacters the horrorCharacters to set
     */
    public void setHorrorCharacters(ArrayList<HorrorCharacter> horrorCharacters) {
        if(horrorCharacters != null)
        {
            this.horrorCharacters = horrorCharacters;
        }
    }

    /**
     * Adds a Horror Character using the parameters
     * @param name String name of Horror Character
     * @param health int health of Horror Character
     * @param vulnerability vulnerability enum of Horror Character
     * @param monsterType String monsterType of Horror Character later mapped to Vulnerability
     */
    public HorrorCharacter addHC(String name, int health, Vulnerability vulnerability, String monsterType)
    {
        HorrorCharacter newCharacter = null;
        
        int vCount = 0;
        int wCount = 0;
        int zCount = 0;
        
        try
        {
        if(monsterType.equalsIgnoreCase("Vampire"))
        {
            newCharacter = new Vampire(name, health, vulnerability);
            vCount++;
            hcMap.put("Vampire", vCount);           
        }
        else if(monsterType.equalsIgnoreCase("Zombie"))
        {
            newCharacter = new Zombie(name, health, vulnerability);
            zCount++;            
            hcMap.put("Zombie", zCount);
        }
        else if(monsterType.equalsIgnoreCase("Werewolf"))
        {
            newCharacter = new Werewolf(name, health, vulnerability);
            wCount++;
            hcMap.put("Werewolf", wCount);
        }
        else
        {
            System.out.println("Please enter Vampire, Zombie, or Werewolf");
            
        }
        horrorCharacters.add(newCharacter);
        }
        catch(Exception e)
        {
            System.out.println("Please enter valid Parameter");
        }
        return newCharacter;
    }
    /**
     * Displays HorrorCharacters by getting Vulnerability and adding a count to that associated Monster Type, then added to a Hash Map
     * @param exHC Array of Horror Characters that is used in polymorphism to get the associated values
     */
    public void displayHorrorCharacters(ArrayList <HorrorCharacter> exHC)
    {
        int vCount = 0;
        int wCount = 0;
        int zCount = 0;
        HorrorCharacter newCharacter = null;
        try
        {
        for(int i = 0; i < exHC.size(); i++)
        {
            newCharacter = exHC.get(i);
            if(newCharacter.getVulnerability() == Vulnerability.FIRE)
            {
                zCount++;            
                hcMap.put("Zombie", zCount);
            }
            else if(newCharacter.getVulnerability() == Vulnerability.GARLIC)
            {
                vCount++;
                hcMap.put("Vampire", vCount);         
            } 
            else if(newCharacter.getVulnerability() == Vulnerability.SILVER)
            {
                wCount++;
                hcMap.put("WereWolf", wCount);
            }
        
        }
        }
        catch(Exception e)
        {
            System.out.println("Please enter valid parameter");
        }
        
        System.out.println(hcMap);
    }
    /**
     * Displays most common vulnerability in the Horror Characters Movie by using the horrorCharacter array to get the Monster
     * Type at that very point in the array and associating a count with that monster type
     */
    public void displayMostCommonVul()
    {
        int gCount = 0;
        int fCount = 0;
        int sCount = 0;
        for(int i = 0; i < horrorCharacters.size(); i++)
        {
            HorrorCharacter exCharacter = horrorCharacters.get(i);
                if(exCharacter.getVulnerability().equals(Vulnerability.FIRE))
                {
                    fCount ++;
                }
                else if(exCharacter.getVulnerability().equals(Vulnerability.SILVER))
                {
                    sCount++;
                }
                else if(exCharacter.getVulnerability().equals(Vulnerability.GARLIC))
                {
                    gCount++;
                }
       }
                if(fCount > sCount && fCount > gCount)
                {
                    System.out.println("Fire is the most common vulnerability");
                }
                else if (sCount > fCount && sCount > gCount )
                {
                    System.out.println("Silver is the most common vulnerability");
                }
                else if (gCount > fCount && gCount > sCount )
                {
                    System.out.println("Garlic is the most common vulnerability");
                }
                else if (sCount == fCount && gCount < sCount)
                {
                    System.out.println("Silver and Fire are the most common vulnerability");
                }
                else if (sCount == gCount && gCount > fCount)
                {
                    System.out.println("Silver and Garlic are the most common vulnerability");
                }
                else if (gCount == fCount && sCount < gCount)
                {
                    System.out.println("Garlic and Fire are the most common vulnerability");
                }
                else 
                {
                    System.out.println("All Vulnerabilities are equally common");
                }
    }
    /**
     * A sort that takes the vulnerability at horrorCharacter position and compares it to a goal integer, compareTo is used
     * to get this integer and it is stored in decifer, decifer is then compared to the current goal if it is equal it does nothing but 
     * if it is not assortedList will find the next currentGoal related monster and swap the previous monster with that one until
     * the list follows a pattern such as :vvvzzzwww
     */
    public void assortedList()
    {
        int currentGoal = 1;
        int decifer = 0;
        HorrorCharacter exCharacter = null;
        HorrorCharacter exCharacter2 = null;
        
        for(int i = 0; i < horrorCharacters.size(); i++)
        {
            exCharacter = horrorCharacters.get(i);
            decifer = exCharacter.compareTo(horrorCharacters, i);
            if(decifer != currentGoal)
            {
                for(int j = i; j < horrorCharacters.size(); j++ )
                {
                
                    decifer = exCharacter.compareTo(horrorCharacters, j);
                    exCharacter2 = horrorCharacters.get(j);
                    if(decifer == currentGoal)
                    {
                        horrorCharacters.set(j, exCharacter);
                        horrorCharacters.set(i, exCharacter2);
                        //System.out.println("Swapped");
                        break;
                    }
                    if(j == horrorCharacters.size() - 1)
                        {
                            //System.out.println("Current Goal Updated");
                            currentGoal++;
                            j = i;
                        }
                }
                
            }
            System.out.println(horrorCharacters.get(i));
        }
        
            /*
            HorrorCharacter monster1 = new Vampire("Kevin", 290, Vulnerability.GARLIC);
            HorrorCharacter monster2 = new Werewolf("Carly", 90, Vulnerability.SILVER);

            HorrorCharacter monster3 = new Zombie("Larry", 890, Vulnerability.FIRE);
            HorrorCharacter monster4 = new Werewolf("Emily", 400, Vulnerability.SILVER);

            HorrorCharacter monster5 = new Zombie("Jess", 777, Vulnerability.FIRE);
            HorrorCharacter monster6 = new Vampire("Anna", 500, Vulnerability.GARLIC);

            HorrorCharacter monster7 = new Zombie("Karissa", 300, Vulnerability.FIRE);
            HorrorCharacter monster8 = new Vampire("Adam", 386, Vulnerability.GARLIC);

            Kevin
            Anna
            Adam
            Emily // is a werewolf in wrong pos, should be second to last, swaps with 
            Jess
            Karissa
            Larry
            Carly
            
            Kevin Carly Larry Emily Jess Anna Karissa Adam
            Kevin "Anna" Larry Emily Jess "Carly" Karissa Adam
            Kevin Anna "Adam" Emily Jess Carly Karissa "Larry"
            
            Kevin Anna Adam "Jess" "Emily" Carly Karissa Larry
            Kevin Anna Adam Jess "Karissa" Carly "Emily" Larry
            Kevin Anna Adam Jess Karissa "Larry" Emily "Carly"
            
            Kevin Anna Adam Jess Karissa Larry Emily Carly
            */
            // tells me that this horror character at i is this type of horror character
            // 1 is garlic
            // 2 is fire
            // 3 is silver
            // V W Z W Z V Z V
            // V V Z W Z W Z V
            // V V V W Z W Z Z
            // ^THIS IS WHERE THE PROBLEM IS HAPPENING
            // V V V Z W W Z Z
            // V V V Z Z W W Z
            // V V V Z Z Z W W
            // V = 1 Z = 2 W = 3
            // V W Z W Z V Z V
            //i is at position 0 and exCharacter takes the horrorCharacter at pos i
            //decifer then gets the horrorCharacter Vulnerability at pos i which is 1 Garlic
            // decifer is equal to current goal so loop stops
            //i is now position 1 which is W, 3, Silver
            // decifer is now 3 which does not equal current goal so goes through if loop
            //j is at pos 2 and is Z, 2, Fire
            //decifer is now equal to the horrorcharacter in the array at position j which is 2
            //exCharacter2 is the set to the horrorCharacter at position J, Z, 2, Fire
            //decifer is not equal to current goal doesnt go through if loop
            //j is now equal to position 3 which returns a decifer of 3
            //this happens until j is at position 5 which returns a decifer of 1
            //current goal is 1 and decifer is 1 so exCharacter at pos i swaps with exCharacter2 at position j vice versa
            //loop breaks prints out character at position i
            //i increments and is now at pos 2 
            // decifer is gets a value of 2 which does not equal current goal
            //j is now pos 2 and decifer pulls a 2 which is not equal to current goal so it does not go through if loop
            //j increments and is now pos 3 and decifer pulls a 3 which is not equal to current goal so it does not go through if loop
            //happens until j increments to pos 7 which then decifer pulls a 1 which is equal to current goal
            //those swap
            //i increments to pos 3 which is a Z
            //current goal is still 1, decifer pulls a value of 2
            //goes through j for loop 
            //j is pos 3 and decifer is equal to 2, current goal is 1
            //j does not go through either if loop
            //this happens until j is position 7 which then j goes through if loop to update current value
            //current value is now 2 which means we are looking for zombies and vampires are sorted
            //j is now set to i + 1 which is pos 4
            //pos 4 is a W, 3, Silver which does not equal current value
            //does not go through if loop
            //j is now position 5 which is a Z

            //PROBLEM: When j was position 3 there is no vampire left in the array to swap, 
            // so it eventually updates the value current goal and breaks
            // position 3 value now doesnt ever get revisted at pos i updates to 4 and 
            // it gets assumed that pos 3 is sorted
            //PROBLEM: Karissa is coming before Jess
            //SOLUTION: Right before J breaks set j back to position i + 1 to do the sort again
            //SOLUTION: ???
        
        
    
    }
    /**
     * toString outputs the attributes associated with MonsterMovie Class
     * @return the String with all the fields of the class
     */
    @Override
    public String toString() {
        return "MonsterMovie{" + "title=" + title + ", yearReleased=" + yearReleased + ", horrorCharacters=" + horrorCharacters + ", hcMap=" + hcMap + '}';
    }

    
    
    
    
    
}
