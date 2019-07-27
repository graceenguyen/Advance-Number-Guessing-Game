package code;

import java.util.Scanner;

//advance number guessing game with methods
public class Advance_Number_Guess {

	public static String heat ( int guess , double number)
	{
		int diff = 0;
		diff = (int)(number) - guess;
		diff = Math.abs(diff); // absolute value of difference for hot warm cold
		String heat = "";
		//instructions 
		System.out.println("Hot = 1 number off");
		System.out.println("Warm = 2-3 number off");
		System.out.println("Cold = 4+ number off");
		//System.out.println("Incorrect.");
		if ( diff == 1)
		{
			heat = "Hot";
		}
		else if ( diff < 4)
		{
			heat = "Warm";
		}
		else if ( diff > 3)
		{
			heat = "Cold";
		}
		return heat;
	}
	
	public static int errorTrapping ( int level, int guess, int max)
	{
		boolean success = true;
			
		do
		{
			Scanner input = new Scanner (System.in);
			success = true;
			try
			{
				System.out.println("Please enter your guessing number from 1-" + max + " inclusive");
				guess = input.nextInt();
			}
			catch ( Exception e)
			{
				success = false;
				String garbage = input.nextLine();
			}
			if (guess > 10 || guess < 1) //int out of bound
			{
				System.out.println("Invalid. Please insert a number within range.");
				success = false;
			}
		} while (success == false);
		
		//input.close();
		return guess;
	}
	
	public static void main (String[] args)// main game
	{
		double number = 0;
		int max= 10, min = 1 ;	
		int x = 1;
		int guess = 0;
//		int diff = 0;
		int level = 1;
		int score = 0;
		int total = 0;
		Scanner input = new Scanner (System.in);	
		
		do
		{
			number = (int)(Math.random()*(max-min +1)+ min); // random number generator
			
			
			System.out.println("****Welcome to the Number Guessing Game****");
			System.out.println();
			System.out.println("You are at level " + level + " out of 3 levels");
			System.out.println("Score: " + score + "/" + total); // score keeping
			System.out.println(); 
			total = total + 1;
			
			
			for ( x = 1; x <=3; x++)
			{
				System.out.println("This is attepmt number " + x + "/3");
				if (level ==3) // level 3
				{
					max = 15;
					min = 1;
				}
				
				guess = errorTrapping(level, guess, max); // error trap and input

				if (guess == number)// correct!
				{	
					//x = 3;
					score = score + 1 ;
					System.out.println("Congratulation! You are correct__________________________________");
	//				System.out.println("To replay press 1. To quit press 2.");
	//				replay = input.nextInt();
					level = level + 1;
					x = 5;
				}
				else if ( x == 3 )// 3 tries over
				{
					System.out.println("Game Over. The number was " + number );
					level = 4; 
	//				System.out.println("To replay press 1. To quit press 2. ");
	//				replay = input.nextInt();
	//				System.out.println("Print replay" + replay);
				}
				else if (guess != number)//repeat guess 1
				{
					System.out.println("Incorrect.");
					if (level == 1) // level 2 does not have hot warm cold
					{
						System.out.println(heat (guess, number));
					}
				}
				System.out.println();// formatting
			
				if (level == 4)// if lost
				{
					System.out.println("To replay press 1. ");
					level = input.nextInt();//replay token
				}
			}
		}while ( level < 4 ); //repeat 3 levels 
		input.close();
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
