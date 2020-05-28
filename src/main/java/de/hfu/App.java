package de.hfu;
import java.util.Scanner;

/**
* <h1>Aus klein mach groß</h1>
* Gibt alles was eingegeben wird, als Großbuchstaben aus
* @author Fabian 
* @version 28.05.2020
*/
public class App 
{
    public static void main( String[] args )
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a text: ");
        String input = reader.next(); 
        reader.close();
        
        System.out.println(input.toUpperCase());
    }
}


