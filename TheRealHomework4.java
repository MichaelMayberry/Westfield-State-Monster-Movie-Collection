/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package therealhomework4;

import java.util.ArrayList;

/**
 * @author schmay
 * 
 * Movie Collection Homework
 * 
 * 
 */ 

public class TheRealHomework4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        HorrorCharacter monster1 = new Vampire("Kevin", 290, Vulnerability.GARLIC);
        HorrorCharacter monster2= new Werewolf("Carly", 90, Vulnerability.SILVER);
        
        HorrorCharacter monster3 = new Zombie("Larry", 890, Vulnerability.FIRE);
        HorrorCharacter monster4 = new Werewolf("Emily", 400, Vulnerability.SILVER);
        
        HorrorCharacter monster5 = new Zombie("Jess", 777, Vulnerability.FIRE);
        HorrorCharacter monster6 = new Vampire("Anna", 500, Vulnerability.GARLIC);
        
        HorrorCharacter monster7 = new Zombie("Karissa", 300, Vulnerability.FIRE);
        HorrorCharacter monster8 = new Vampire("Adam", 386, Vulnerability.GARLIC);
        
        
        ArrayList<HorrorCharacter> horrorCharacters14 = new ArrayList<>();
        horrorCharacters14.add(monster1);
        horrorCharacters14.add(monster2);
        
        ArrayList<HorrorCharacter> horrorCharacters56 = new ArrayList<>();
        horrorCharacters56.add(monster3);
        horrorCharacters56.add(monster4);
        
        ArrayList<HorrorCharacter> horrorCharacters79 = new ArrayList<>();
        horrorCharacters79.add(monster5);
        horrorCharacters79.add(monster6);
        /*
        ArrayList<HorrorCharacter> test = new ArrayList<>();
        test.add(monster1);
        test.add(monster2);
        test.add(monster3);
        test.add(monster4);
        test.add(monster5);
        test.add(monster6);
        test.add(monster7);
        test.add(monster8);
        */
        
        MonsterMovie monsterMovie1 = new MonsterMovie("Craziness From Above", 2004, horrorCharacters14 );
        
        MonsterMovie monsterMovie2 = new MonsterMovie("Polterheist", 2000, horrorCharacters56);
        
        MonsterMovie monsterMovie3 = new MonsterMovie("Sky is Falling", 1978, horrorCharacters79);
        
        MovieCollection movieCollection = new MovieCollection(monsterMovie1, monsterMovie2, monsterMovie3);
       
        
        System.out.println("Display all horrorcharacters in this specific movie: ");
        monsterMovie1.displayHorrorCharacters(horrorCharacters14);
        System.out.println("\n");
        
        System.out.println("Display Most Common Vulnerability in this specific movie: ");
        monsterMovie1.displayMostCommonVul();
        System.out.println("\n");

        
        System.out.println("Sort Horror Characters acoss a specific movie in the order V Z W: " );
        monsterMovie1.assortedList();
        System.out.println("\n");
        
        System.out.println("Display all Movies");
        movieCollection.displayMovies();
        System.out.println("\n");
        
        System.out.println("Add new Movie: ");
        movieCollection.addMovie("Scary Scare scare", 1999, horrorCharacters79);
        movieCollection.displayMovies();
        System.out.println("\n");
        
        System.out.println("Delete A Movie / Movies of of title, characters, or year");
        movieCollection.displayMovies();
        movieCollection.deleteMovie("Craziness From Above", 1999, "Witch");
        movieCollection.displayMovies();

        
        
        
    }
    
}
