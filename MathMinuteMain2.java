import java.util.Random;
import java.awt.List;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayList;
  public class MathMinuteMain2
{
	public static ArrayList<String> namesList = new ArrayList<String>(10);
	public static ArrayList<Integer> scoreList = new ArrayList<Integer>(10);
	public static ArrayList<String> diffList = new ArrayList<String>(10);
	public static int gamestatus = 1;
	public static int instructionstatus = 1;
	public static int printstatus = 1;
	public static int menustatus = 1;

	public static void main(String[] args)
	
	{
		
		while (menustatus==1)
		{
			gamestatus=1;
			instructionstatus=1;
			printstatus=1;
			System.out.println("Welcome to Mad Math Minute!");
			System.out.println("-=-=-=-Select:-=-=-=-");
			System.out.println("(1) Start Game\n(2) Instructions\n(3) High Scores\n(4) Quit");
			Scanner input = new Scanner(System.in);
			int option = input.nextInt();
			if (option == 1)
			{
				option();
				
			}
			if (option == 2)
			{
				printInstructions();
			}
			if (option == 3)
			{
				printScores();
			}
			if (option == 4)
			{
				System.out.println("Thank you for playing, Goodbye!");
				break;
			}
		}
	}

	public static void option()
	{
		Scanner inputDif = new Scanner(System.in);
		System.out.println("Choose the difficulty\n(1)Easy\n(2)Medium\n(3)Hard");
	
		int dif = inputDif.nextInt();
		if (dif==1)
		{
			easyMode();
		}
		if (dif==2)
		{
			mediumMode();
		}
		if (dif==3)
		{
			hardMode();
		}
	}
	public static void printInstructions()
	{
		while (instructionstatus == 1)
		{
			Scanner input = new Scanner(System.in);
			
			System.out.println("You will be given 10 questions one by one to answer.");
			System.out.println("If needed, your answer can be rounded to one decimal place.");
			System.out.println("You get one point for every question answered correctly and");
			System.out.println("you lose a chance for every question answered incorrectly.");
			System.out.println("Be careful! You only have 3 chances!.");
			System.out.println("Enter OK to go back to the main menu...");
			
			String again = input.next();
			if (again.equals(""))
			{
				instructionstatus=0;
			}
			else
			{
				instructionstatus=0;
			}
			
			
		}
	}
	
	public static void printScores()
	{
		//print scores
		while (printstatus == 1 )
		{
			if (namesList.isEmpty()) 
			{
				System.out.println("No Scores Stored...");
			}
			else 
			{
				int length = namesList.size();
				System.out.println("Name.......Score.......Difficulty");
				for (int Counter = 0; Counter<=length; Counter++)
				{
					System.out.println(namesList.get(Counter) + "......." + scoreList.get(Counter)+"......."+ diffList.get(Counter));
				}

			}
			System.out.println("Enter OK to go back to the main menu...");
			Scanner input = new Scanner(System.in);
			String again = input.next();
			if (again.equals(""))
			{
				printstatus=0;
			}
			else
			{
				printstatus=0;
			}
			
		}
		
	}
	
	public static void endMode()
	{
		System.out.println("Thanks for playing!");
	}
	
	public static void easyMode()
	{
		while (gamestatus==1) 
		{
			Scanner input = new Scanner(System.in);
			
			int Questions = 0;
			int RightAns = 0;
			int Chances = 3;
			System.out.println ("Answer the following questions:");
			for (int Counter = 1; Counter<=11; Counter++)
			{
				
				if (Chances == 0)
				{
					Scanner nameInput = new Scanner(System.in);
					System.out.println("Game over! 0 chances remaining! Score: " + RightAns +"... Enter your name:");
					String name = nameInput.nextLine();
					namesList.add(name);
					scoreList.add(RightAns);
					diffList.add("Easy");
					System.out.println(namesList+ " " + scoreList+ " " + diffList); 
					System.out.println("Would you like to play again? (Y/N)");
					String again = input.next();
					if (again.equals("Y"))
					{
						gamestatus=1;
						Chances=3;
						Questions=0;
						RightAns=0;
						option();
					}
					else
					{
						gamestatus=0;
						break;
					}
				}
				
				if (Questions == 10)
				{
					Scanner nameInput = new Scanner(System.in);
					System.out.println("Game over! Score: " + RightAns +"... Enter your name:");
					String name = nameInput.nextLine();
					namesList.add(name);
					scoreList.add(RightAns);
					diffList.add("Easy");
					System.out.println(namesList+ " " + scoreList + " " + diffList); 
					System.out.println("Would you like to play again? (Y/N)");
					String again = input.next();
					if (again.equals("Y"))
					{
						gamestatus=1;
						Chances=3;
						Questions=0;
						RightAns=0;
						option();
					}
					else
					{
						gamestatus=0;
						break;
					}
				}
				
				int rand1 = (int) (Math.random() * (12 - 0)) + 0;
				int rand2 = (int) (Math.random() * (12 - 0)) + 0;
				int rand3 = (int) (Math.random() * (5 - 1)) + 1;

				if (rand3==1)
				{
					System.out.println("What is ("+rand1+") + ("+rand2+") ?");
					int sol = rand1 + rand2;
					int answer = input.nextInt();
					if (answer==sol) 
					{
						RightAns++;
						Questions++;
						System.out.println("Correct!" + " " + Questions + " questions answered... " + Chances + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances--;
						Questions++;
						System.out.println("Incorrect!" + " " + Questions + " questions answered... " + Chances + " chances remaining...");
						System.out.println("");
					}
				}
				else if (rand3==2)
				{
					System.out.println("What is ("+rand1+") - ("+rand2+") ?");
					int sol = rand1 - rand2;
					int answer = input.nextInt();
					if (answer==sol) 
					{
						RightAns++;
						Questions++;
						System.out.println("Correct!" + " " + Questions + " questions answered... " + Chances + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances--;
						Questions++;
						System.out.println("Incorrect!" + " " + Questions + " questions answered... " + Chances + " chances remaining...");
						System.out.println("");
					}
				}
				else if (rand3==3)
				{
					System.out.println("What is ("+rand1+") x ("+rand2+") ?");
					int sol = rand1 * rand2;
					int answer = input.nextInt();
					if (answer==sol) 
					{
						RightAns++;
						Questions++;
						System.out.println("Correct!" + " " + Questions + " questions answered... " + Chances + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances--;
						Questions++;
						System.out.println("Incorrect!" + " " + Questions + " questions answered... " + Chances + " chances remaining...");
						System.out.println("");
					}
				}
				else if (rand3==4)
				{
					System.out.println("What is ("+rand1+") / ("+rand2+") ?");
					DecimalFormat df = new DecimalFormat("#.#"); 
					double sol2 = (double)rand1 / (double)rand2;
					double sol = Double.valueOf(df.format(sol2));
					double answer = input.nextDouble();
					//System.out.println(sol + "<- solution");
					if (answer==sol)
					{
						RightAns++;
						Questions++;
						System.out.println("Correct!" + " " + Questions + " questions answered... " + Chances + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances--;
						Questions++;
						System.out.println("Incorrect!" + " " + Questions + " questions answered... " + Chances + " chances remaining...");
						System.out.println("");
					}
				}
			}
		}
	}
			public static void mediumMode()
			{
					while (gamestatus==1) 
		{
			Scanner input1 = new Scanner(System.in);
			int Questions1 = 0;
			int RightAns1 = 0;
			int Chances1 = 3;
			System.out.println ("Answer the following questions:");
			for (int Counter1 = 1; Counter1<=11; Counter1++)
			{
				
				if (Chances1 == 0)
				{
					Scanner nameInput = new Scanner(System.in);
					System.out.println("Game over! 0 chances remaining! Score: " + RightAns1 +"... Enter your name:");
					String name = nameInput.nextLine();
					namesList.add(name);
					scoreList.add(RightAns1);
					diffList.add("Medium");
					System.out.println(namesList+ " " + scoreList + " " + diffList); 
					System.out.println("Would you like to play again? (Y/N)");
					String again = input1.next();
					if (again.equals("Y"))
					{
						gamestatus=1;
						Chances1=3;
						Questions1=0;
						RightAns1=0;
						option();
					}
					else
					{
						gamestatus=0;
						break;
					}
				}
				
				if (Questions1 == 10)
				{
					Scanner nameInput = new Scanner(System.in);
					System.out.println("Game over! Score: " + RightAns1 +"... Enter your name:");
					String name = nameInput.nextLine();
					namesList.add(name);
					scoreList.add(RightAns1);
					diffList.add("Medium");
					System.out.println(namesList+ " " + scoreList + " " + diffList); 
					System.out.println("Would you like to play again? (Y/N)");
					String again = input1.next();
					if (again.equals("Y"))
					{
						gamestatus=1;
						Chances1=3;
						Questions1=0;
						RightAns1=0;
						option();
					}
					else
					{
						gamestatus=0;
						break;
					}
				}
				
				int rand1 = (int) (Math.random() * (12 - -12)) + -12;
				int rand2 = (int) (Math.random() * (12 - -12)) + -12;
				int rand3 = (int) (Math.random() * (5 - 1)) + 1;

				if (rand3==1)
				{
					System.out.println("What is ("+rand1+") + ("+rand2+") ?");
					int sol = rand1 + rand2;
					int answer = input1.nextInt();
					if (answer==sol) 
					{
						RightAns1++;
						Questions1++;
						System.out.println("Correct!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances1--;
						Questions1++;
						System.out.println("Incorrect!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
				}
				else if (rand3==2)
				{
					System.out.println("What is ("+rand1+") - ("+rand2+") ?");
					int sol = rand1 - rand2;
					int answer = input1.nextInt();
					if (answer==sol) 
					{
						RightAns1++;
						Questions1++;
						System.out.println("Correct!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances1--;
						Questions1++;
						System.out.println("Incorrect!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
				}
				else if (rand3==3)
				{
					System.out.println("What is ("+rand1+") x ("+rand2+") ?");
					int sol = rand1 * rand2;
					int answer = input1.nextInt();
					if (answer==sol) 
					{
						RightAns1++;
						Questions1++;
						System.out.println("Correct!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances1--;
						Questions1++;
						System.out.println("Incorrect!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
				}
				else if (rand3==4)
				{
					System.out.println("What is ("+rand1+") / ("+rand2+") ?");
					DecimalFormat df = new DecimalFormat("#.#"); 
					double sol2 = (double)rand1 / (double)rand2;
					double sol = Double.valueOf(df.format(sol2));
					double answer = input1.nextDouble();
					//System.out.println(sol + "<- solution");
					if (answer==sol)
					{
						RightAns1++;
						Questions1++;
						System.out.println("Correct!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances1--;
						Questions1++;
						System.out.println("Incorrect!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
				}
			}
		}
	}

  public static void hardMode()
  {
	  while (gamestatus==1) 
		{
			Scanner input1 = new Scanner(System.in);
			int Questions1 = 0;
			int RightAns1 = 0;
			int Chances1 = 3;
			System.out.println ("Answer the following questions:");
			for (int Counter1 = 1; Counter1<=11; Counter1++)
			{
				
				if (Chances1 == 0)
				{
					Scanner nameInput = new Scanner(System.in);
					System.out.println("Game over! 0 chances remaining! Score: " + RightAns1 +"... Enter your name:");
					String name = nameInput.nextLine();
					namesList.add(name);
					scoreList.add(RightAns1);
					diffList.add("Hard");
					System.out.println(namesList+ " " + scoreList + " " + diffList); 
					System.out.println("Would you like to play again? (Y/N)");
					String again = input1.next();
					if (again.equals("Y"))
					{
						gamestatus=1;
						Chances1=3;
						Questions1=0;
						RightAns1=0;
						option();
					}
					else
					{
						gamestatus=0;
						break;
					}
				}
				
				if (Questions1 == 10)
				{
					Scanner nameInput = new Scanner(System.in);
					System.out.println("Game over! Score: " + RightAns1 +"... Enter your name:");
					String name = nameInput.nextLine();
					namesList.add(name);
					scoreList.add(RightAns1);
					diffList.add("Hard");
					System.out.println(namesList+ " " + scoreList + " " + diffList); 
					System.out.println("Would you like to play again? (Y/N)");
					String again = input1.next();
					if (again.equals("Y"))
					{
						gamestatus=1;
						Chances1=3;
						Questions1=0;
						RightAns1=0;
						option();
					}
					else
					{
						gamestatus=0;
						break;
					}
				}
				
				int rand1 = (int) (Math.random() * (20 - -20)) + -20;
				int rand2 = (int) (Math.random() * (20 - -20)) + -20;
				int rand3 = (int) (Math.random() * (5 - 1)) + 1;

				if (rand3==1)
				{
					System.out.println("What is ("+rand1+") + ("+rand2+") ?");
					int sol = rand1 + rand2;
					int answer = input1.nextInt();
					if (answer==sol) 
					{
						RightAns1++;
						Questions1++;
						System.out.println("Correct!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances1--;
						Questions1++;
						System.out.println("Incorrect!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
				}
				else if (rand3==2)
				{
					System.out.println("What is ("+rand1+") - ("+rand2+") ?");
					int sol = rand1 - rand2;
					int answer = input1.nextInt();
					if (answer==sol) 
					{
						RightAns1++;
						Questions1++;
						System.out.println("Correct!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances1--;
						Questions1++;
						System.out.println("Incorrect!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
				}
				else if (rand3==3)
				{
					System.out.println("What is ("+rand1+") x ("+rand2+") ?");
					int sol = rand1 * rand2;
					int answer = input1.nextInt();
					if (answer==sol) 
					{
						RightAns1++;
						Questions1++;
						System.out.println("Correct!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances1--;
						Questions1++;
						System.out.println("Incorrect!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
				}
				else if (rand3==4)
				{
					System.out.println("What is ("+rand1+") / ("+rand2+") ?");
					DecimalFormat df = new DecimalFormat("#.#"); 
					double sol2 = (double)rand1 / (double)rand2;
					double sol = Double.valueOf(df.format(sol2));
					double answer = input1.nextDouble();
					//System.out.println(sol + "<- solution");
					if (answer==sol)
					{
						RightAns1++;
						Questions1++;
						System.out.println("Correct!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
					else 
					{
						Chances1--;
						Questions1++;
						System.out.println("Incorrect!" + " " + Questions1 + " questions answered... " + Chances1 + " chances remaining...");
						System.out.println("");
					}
				}
			}
		}
	}
	  
  }