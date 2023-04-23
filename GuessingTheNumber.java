import java.util.Scanner;
import java.util.Random; 

class Guess 
{
	int systemInput; 
	int userInput; 
	int noOfGuesses = 0; 
	int range = 100; 
	
	Guess() 
	{ 
		Random random = new Random(); 
		this.systemInput = random.nextInt(100) + 1; 
	} 
	
	public boolean takeUserInput() 
	{ 
		if (noOfGuesses < 10) 
		{ 
			System.out.print("Guess the number: "); 
			this.userInput = GuessingTheNumber.takeIntegerInput(100); 
			noOfGuesses++; 
			return false; 
		} 
		
		else 
		{ 
			System.out.println("No attempts left. Better luck next time!!\n"); 
			return true; 
			} 
		} 
	
	public boolean isGuessCorrect() 
	{ 
		if (systemInput == userInput) 
		{ 
			System.out.println("Congratulations, you guessed the number " + systemInput + " in " + noOfGuesses + " guesses."); 
			
			switch(noOfGuesses) 
			{
			case 1: System.out.println("Your score is 100."); 
			break; 
			case 2: System.out.println("Your score is 90."); 
			break; 
			case 3: System.out.println("Your score is 80."); 
			break; 
			case 4: System.out.println("Your score is 70."); 
			break; 
			case 5: System.out.println("Your score is 60."); 
			break; 
			case 6: System.out.println("Your score is 50."); 
			break; 
			case 7: System.out.println("Your score is 40."); 
			break; 
			case 8: System.out.println("Your score is 30."); 
			break; 
			case 9: System.out.println("Your score is 20."); 
			break; 
			case 10: System.out.println("Your score is 10."); 
			break; 
			} 
			
			System.out.println(); 
			return true; 
		} 
		
		else if (noOfGuesses < 10 && userInput > systemInput) 
		{ 
			if (userInput - systemInput > 10) 
			{ 
				System.out.println("Too High"); 
			} 
			else 
			{ 
				System.out.println("Little High"); 
			} 
		} 
		
		else if (noOfGuesses < 10 && userInput < systemInput) 
		{ 
			if (systemInput - userInput > 10) 
			{ 
				System.out.println("Too low"); 
			} 
			else 
			{
				System.out.println("Little low"); 
			} 
		} 
		
		return false; 
	}
} 

public class GuessingTheNumber 
{ 
	public static int takeIntegerInput(int limit) 
	{ 
		int input = 0; 
		boolean flag = false; 
		
		while (!flag) 
		{ 
			try 
			{
				Scanner s = new Scanner(System.in); 
				input = s.nextInt(); 
				flag = true; 
				if (flag && input > limit || input < 1) 
				{ 
					System.out.println("Choose the number between 1 and" + limit+"."); 
					flag = false; 
				} 
			} 
			
			catch (Exception E) 
			{ 
				System.out.println("Enter only integer value."); 
				flag = false; 
			} 
		}; 
		
		return input; 
	} 

	public static void main(String args[]) 
	{  
		System.out.println("Welcome to the Number Guessing Game!");
	    System.out.println("You have 10 attempts to guess the number in each round.\nGood luck!");
		System.out.println("1.Start the Game\n2.Exit"); 
		System.out.print("Enter your choice: "); 
		int choice = takeIntegerInput(2); 
		int nextRound = 1; 
		int noOfRound = 0; 
		
		if (choice == 1) 
		{ 
			while (nextRound == 1) 
			{ 
				Guess game = new Guess(); 
				boolean isMatched = false; 
				boolean isLimitCross = false; 
				System.out.println("\n-----*****Round " + noOfRound +"*****-----"); 
			 
				while (!isMatched && !isLimitCross) 
				{ 
					isLimitCross = game.takeUserInput(); 
					isMatched = game.isGuessCorrect(); 
				} 
				
				System.out.println("1.Next Round\n2.Exit"); 
				System.out.println("Enter your choice: "); 
				
				nextRound = takeIntegerInput(2); 
				if (nextRound != 1) 
				{ 
					System.exit(0); 
				} 
			} 
		} 
		
		else 
		{ 
			System.exit(0); 
		} 
	}
}
