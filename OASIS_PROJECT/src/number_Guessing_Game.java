/*
* Start
* Enter information
* Welcome and instructions
* ask for difficulty check
* 3 levels (1-10, 1-100, 1-200)
* start the game
* end game
* Exit */

import java.util.Random;
import java.util.Scanner;
public class number_Guessing_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name here:");
        String name = sc.nextLine();

        System.out.println("Enter your Age: ");
        int age = sc.nextInt();

        System.out.println("\n\n");

        System.out.println("Welcome " + name + "!!, this is the best number guessing game.");
        System.out.println("Choose the level of difficulty(1. Easy,2. Medium,3. Hard).");
        int n = sc.nextInt();


        switch (n) {
            case 1: {
                System.out.println("Level of difficulty: Easy\n");
                Random num_gen = new Random();

                int correct = num_gen.nextInt(10);
                int chances = 0;

                System.out.println("Guess a number between 1 to 10, You will have 7 turns!");
                System.out.println("Good Luck!!");

                int guess;
                int a = 0;
                boolean win = false;

                while (!win) {
                    System.out.println("Choose a no.: ");
                    guess = sc.nextInt();
                    chances++;

                    if (guess == correct) {
                        win = true;
                    } else if (a > 5) {
                        System.out.println("You loose! the right answer was: " + correct);
                        return;
                    } else if (guess < correct) {
                        a++;
                        System.out.println("Your guess is Lower than the right guess! chances left: " + (7 - a) + "\n");

                    } else {
                        a++;
                        System.out.println("Your Guess Is Higher Than THe Right Guess! chances left: " + (7 - a) + "\n");
                    }
                }

                System.out.println("You win!");
                System.out.println("Then number was " + correct);
                System.out.println("You used " + chances + " chances to guess the right number ");
                System.out.println("Your score is " + ((11 - chances) * 10) + " out of 100");
            }
            break;


            case 2: {
                System.out.println("Level of difficulty: Medium\n");
                Random num_gen = new Random();

                int correct = num_gen.nextInt(100);
                int chances = 0;

                System.out.println("Guess a number between 1 to 100, You will have 10 turns!");
                System.out.println("Good Luck!!");

                int guess;
                int a = 0;
                boolean win = false;

                while (!win) {
                    guess = sc.nextInt();
                    chances++;

                    if (guess == correct) {
                        win = true;
                    } else if (a > 8) {
                        System.out.println("You loose! the right answer was: " + correct);
                        return;
                    } else if (guess < correct) {
                        a++;
                        System.out.println("Your guess is Lower than the right guess! chances left: " + (10 - a) + "\n");

                    } else {
                        a++;
                        System.out.println("Your Guess Is Higher Than THe Right Guess! chances left: " + (10 - a) + "\n");
                    }
                }

                System.out.println("\nYou won!\n");

                System.out.println("You used " + chances + " chances to guess the right number.\n ");
                System.out.println("Your score is " + ((11 - chances) * 10) + " out of 100");
            }
            break;

            case 3: {
                System.out.println("Level of difficulty: Medium\n");
                Random num_gen = new Random();

                int correct = num_gen.nextInt(200);
                int chances = 0;

                System.out.println("Guess a number between 1 to 200, You will have 15 turns!");
                System.out.println("Good Luck!!");

                int guess;
                int a = 0;
                boolean win = false;

                while (!win) {
                    guess = sc.nextInt();
                    chances++;

                    if (guess == correct) {
                        win = true;
                    } else if (a > 13) {
                        System.out.println("You loose! the right answer was: " + correct);
                        return;
                    } else if (guess < correct) {
                        a++;
                        System.out.println("Your guess is Lower than the right guess! chances left: " + (15 - a) + "\n");

                    } else {
                        a++;
                        System.out.println("Your Guess Is Higher Than THe Right Guess! chances left: " + (15 - a) + "\n");
                    }
                }

                System.out.println("\nYou won!\n");

                System.out.println("You used " + chances + " chances to guess the right number.\n ");
                System.out.println("Your score is " + ((16 - chances) * 10) + " out of 100");
            }
        }


    }
}
