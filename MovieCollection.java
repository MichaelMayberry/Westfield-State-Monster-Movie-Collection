/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package therealhomework4;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * MovieCollection represents a collection of Movie Objects
 * @author schmay
 */
public class MovieCollection 
{
    HashMap<String, Integer> mmMap = null;
    ArrayList<MonsterMovie> mmArray = null;
    /**
     * Constructor for Movie Collection Class
     * @param monsterMovie1 - monsterMovie object 1
     * @param monsterMovie2 - monsterMovie object 2
     * @param monsterMovie3 - monsterMovie object 3
     */
    
    public MovieCollection(MonsterMovie monsterMovie1, MonsterMovie monsterMovie2, MonsterMovie monsterMovie3)
    {
        mmMap = new HashMap<>();
        mmArray = new ArrayList<>();
        mmArray.add(monsterMovie1);
        mmArray.add(monsterMovie2);
        mmArray.add(monsterMovie3);
        mmMap.put(monsterMovie1.getTitle(), monsterMovie1.getYearReleased());
        mmMap.put(monsterMovie2.getTitle(), monsterMovie2.getYearReleased());
        mmMap.put(monsterMovie3.getTitle(), monsterMovie3.getYearReleased());
         
    }
    /**
     * Adds a movie using the parameters to create an instance that is added to an Array and HashMap
     * @param title title of movie
     * @param year year of movie released
     * @param horrorCharacters array of Horror Characters associated with the movie
     */
    public void addMovie(String title, int year, ArrayList<HorrorCharacter> horrorCharacters)
    {
        try
        {
        MonsterMovie monsterMovieEX = new MonsterMovie(title, year, horrorCharacters);
        mmArray.add(monsterMovieEX);
        mmMap.put(monsterMovieEX.getTitle(), monsterMovieEX.getYearReleased());
        } 
        catch(Exception e)
        {
            System.out.println("Please enter valid Parameter");
        }
    }
    /**
     * Displays all the movies that are associated in the Hash maop
     */
    public void displayMovies()
    {
       System.out.println(mmMap);
    }
    /**
     * Deletes a Movie based on matching the parameters to what is saved in the Monster Movie Array
     * @param title title of movie
     * @param yearReleased year of movie released
     * @param monsterType String of a monster type that is matched to its vulnerability
     */
    public void deleteMovie(String title, int yearReleased, String monsterType)
    {
        
        MonsterMovie monsterMovieEX2 = null;
        Vulnerability vulnerability = null;
        Vulnerability vulnerability2 = null;
        int yearValueIterate = 0;
        String arrTitle;
        int arrYear;
        try
        {
        
        if(monsterType.equalsIgnoreCase("Zombie"))
        {
            vulnerability = Vulnerability.FIRE;
        }
        else if(monsterType.equalsIgnoreCase("Vampire"))
        {
            vulnerability = Vulnerability.GARLIC;
        }
        else if(monsterType.equalsIgnoreCase("Werewolf"))
        {
            vulnerability = Vulnerability.SILVER;
        }
        
            
        for(int i = 0; i < mmArray.size(); i++)
        {
            monsterMovieEX2 = mmArray.get(i);
            arrTitle = monsterMovieEX2.getTitle();
            arrYear = monsterMovieEX2.getYearReleased();
            if(title.equalsIgnoreCase(monsterMovieEX2.getTitle()))
            {
                mmMap.remove(arrTitle, arrYear);
                mmArray.set(i, null);
                break;
            }
            else if(yearReleased == monsterMovieEX2.getYearReleased())
            {
                mmArray.set(i, null);
                mmMap.remove(arrTitle, arrYear);
                break;
            }
            else if(vulnerability != null)
            {
                for(int j = 0; j < monsterMovieEX2.getHorrorCharacters().size(); j++)
                {
                    vulnerability2 = monsterMovieEX2.getHorrorCharacters().get(j).getVulnerability();
                    if(vulnerability == vulnerability2)
                    {
                        mmArray.set(i, null);
                        mmMap.remove(arrTitle, arrYear);
                        break;
                    }
                }
                
            }
        }
        }
        catch(Exception e)
        {
            System.out.println("Please enter valid input");
        }
    }
     /**
     * toString outputs the attributes associated with Movie Collection Class
     * @return the String with all the fields of the class
     */
    @Override
    public String toString() {
        return "MovieCollection{" + "mmMap=" + mmMap + ", mmArray=" + mmArray + '}';
    }
    
}
