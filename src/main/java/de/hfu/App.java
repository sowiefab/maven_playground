package de.hfu;
import java.util.Scanner;

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


