package codsoft;
import java.util.Scanner;
import java.util.Random;
public class TASK1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
        Random rn = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int rounds = 0;

        while (playAgain) 
        {
            int numberToGuess = rn.nextInt(100) + 1; // Generate a random number (1-100)
            int maxAttempts = 5; // Max attempts per round
            boolean hasWon = false;

            System.out.println( "ROUND " + (rounds + 1) +  ": THE COMPUTER HAS CHOSEN A NUMBER BETWEEN 1 AND 100");

            for (int i = 1; i <= maxAttempts; i++) {
                System.out.print("ATTEMPT " + i + ": ENTER THE NUMBER YOU GUESSED: ");
                int userGuess = sc.nextInt();

                if (userGuess == numberToGuess) 
                {
                    System.out.println("CONGRATULATIONS! YOU GUESSED THE NUMBER IN " + i + " ATTEMPTS");
                    totalScore += (maxAttempts - i + 1); // More attempts left = higher score
                    hasWon = true;
                    break;
                } 
                else if (userGuess > numberToGuess) 
                {
                    System.out.println("TOO HIGH");
                } 
                else 
                {
                    System.out.println("TOO LOW!");
                }

                System.out.println("ATTEMPTS LEFT:" + (maxAttempts - i));
            }

            if (!hasWon) 
            {
                System.out.println("YOU HAVE USED ALL YOUR ATTEMPTS. THE NUMBER WAS: " + numberToGuess);
            }

            rounds++;
            System.out.println("\nYOUR TOTAL SCORE: " + totalScore);
            
            System.out.print("DO YOU WANT TO PLAY ANOTHER ROUND (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
        }

        System.out.println(" YOU PLAYED " + rounds+ " ROUND(s) WITH A TOTAL SCORE : " + totalScore);
        sc.close();
    }


	}


