package edu.nyu.cs.smw9999;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

/**
 * Q1: A variation of the game of Blackjack (20 pts).
 * 
 * Complete this program according to the instructions below.
 * 
 * In addition, replace NetID in edu.nyu.cs.NetID on the first line with your own NetID,
 * and rename the folder containing this piece of code with your NetID.
 * 

## Instructions
Complete this project, such that it allows a user to play a simplified version of the game of Blackjack against a virtual dealer.
In our simplified version of Blackjack, the play unfolds in order as follows:

1)  Two cards are dealt and displayed to the user.

2)  Two cards are dealt to the dealer, but these are secret and not displayed to the user.

3)  The user is prompted whether they would like an additional card (a "hit"). 
    - This question is repeated and the user may accept as many additional cards as they would like, 
      until they respond with the words "stand", "stop", or "pass". 
    - If the value of the cards exceeds 21 at any point during this process of accepting cards, 
      the user has "busted" and lost, and the game ends.

4)  Assuming the user has not busted, once the user stops accepting new cards, 
    the robotic dealer decides whether to accept as many additional cards as it wants. 

    You can have the robot dealer do this at random if you like, or you can develop an artificial intelligence algorithm of your choosing. 
    If the robot dealer's cards exceed 21 points during this process, the dealer has busted and lost, and the user wins.

5)  Assuming neither the user or dealer busted, then if the user's cards are higher in total value than the dealer's cards, the user wins. 
    Otherwise, the dealer wins.

6) Regardless of how the game ends, whether by a bust or by a win, the program MUST show the user what cards 
   they had and what cards the dealer had at the end of the game and announce the result of the game 
   (either there is a winner, a tie, or one of the players has bust.)


## Activity diagram
The following diagram located in ./images/blackjack_activity_diagram.png shows an overview of the flow of the game.


## Additional notes:
-   Do not worry about drawing the same card twice. Draw cards at random.
-   All "cards" are simply integer values from 2 through 10.
-   These rules are different from how Blackjack is played in casinos. Follow our version's rules.


## Sample output
The following are sample outputs from running the program with various outcomes. User responses are indicated 
on the same line as the program output for ease-of-reading only. In all cases, user input will actually appear on a separate line.

Your program's output should match these patterns.

#### Sample output: user stands, dealer stands
Welcome to Blackjack!
Your cards are: 2 and 4
Would you like to hit or stand? stand
The dealer stands.
The dealer's cards are: 8, 7
Dealer wins!


#### Sample output: dealer wins:
Welcome to Blackjack!
Your cards are: 3 and 7
Would you like to hit or stand? hit
Your cards are: 3, 7, and 4
Would you like to hit or stand? hit
Your cards are: 3, 7, 4, and 2
Would you like to hit or stand? stand
The dealer hits.
The dealer hits.
The dealer hits.
Your cards are: 3, 7, 4, and 2
The dealer's cards are: 8, 3, 4, 3, 3
Dealer wins!


#### Sample output: user wins:
Welcome to Blackjack!
Your cards are: 8 and 2
Would you like to hit or stand? hit
Your cards are: 8, 2, and 8
Would you like to hit or stand? stand
The dealer hits.
The dealer stands.
Your cards are: 8, 2, and 8
The dealer's cards are: 3, 3, and 7
You win!


#### Sample output: tie:
Welcome to Blackjack!
Your cards are: 5 and 6
Would you like to hit or stand? hit
Your cards are: 5, 6, and 3
Would you like to hit or stand? stand
The dealer hits.
The dealer hits.
The dealer stands.
Your cards are: 5, 6, and 3
The dealer's cards are: 2, 6, 2, and 4
Tie!


#### Sample output: dealer busts:
Welcome to Blackjack!
Your cards are: 5 and 6
Would you like to hit or stand? hit
Your cards are: 5, 6, and 3
Would you like to hit or stand? stand
The dealer hits.
The dealer stands.
Your cards are: 5, 6, and 3
The dealer's cards are: 8, 8, and 10
The dealer has bust!
You win!


#### Sample output: user busts:
Welcome to Blackjack!
Your cards are: 5 and 6
Would you like to hit or stand? hit
Your cards are: 5, 6, and 3
Would you like to hit or stand? hit
Your cards are: 5, 6, 3, and 10
You have bust!
The dealer's cards are: 5 and 7
Dealer wins!

 * 
 */


public class Blackjack {
  /**
   * The main function is automatically called first in a Java program.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {

    // Enter code here

    //printing a welcoming statement
    System.out.println("Welcome to Blackjack!");

    //using the math.random method to generate two random numbers and then printing them out
    int player_starting_card1 = (int) (Math.random() * 10) + 2;
    int player_starting_card2 = (int) (Math.random() * 10) + 2;
    System.out.println("Your cards are: "+player_starting_card1+" and "+player_starting_card2);

    //Storing all of my cards in an array
    ArrayList<Integer> playerCards = new ArrayList<Integer>();
    playerCards.add(player_starting_card1);
    playerCards.add(player_starting_card2);

    //creating a boolean for my while loop and another boolean that determines whether the player busts or not
    boolean loop = true;
    boolean player_bust = false;

    // using a while loop to reprompt the user until they choose to stand
    while (loop) 
    {
      //prompting the player for their choice with a scanner
      Scanner player_choice = new Scanner(System.in);
      System.out.print("Would you like to hit or stand? ");
      String player_choiceAsString = player_choice.nextLine();

      //using an if statement when they choose hit
      if (player_choiceAsString.equals("hit")) 
      {
        //generating another random card and adding it to the player cards array
        int hit_card = (int) (Math.random() * 10) + 2;
        playerCards.add(hit_card);
       
        //creating an empty string to use to be concatenated with the numbers for formatting purposes
        String proper_formatting = "";
        
        //Creating a for loop that adds all of the cards to my empty string
        for (int i = 0; i < playerCards.size(); i++) 
        {
          String card_as_String = Integer.toString(playerCards.get(i));

          //using a conditional if statement that adds an "and" to the last card in the array
          if (i == playerCards.size()-1) 
          {
            proper_formatting = proper_formatting+" and "+card_as_String;
          }

          //otherwise, it adds a comma instead
          else
          {
            proper_formatting = proper_formatting+" "+card_as_String+",";
          }

        }

        //i then find the player's total sum of the cards
        int player_total_sum = 0;
        for (int i = 0; i < playerCards.size(); i++) 
        {
        player_total_sum = playerCards.get(i)+player_total_sum;
        }

        //printing the user's cards
        System.out.println("Your cards are:"+proper_formatting);

        //if the player's total sum exceeds 21, i tell them 
        if (player_total_sum > 21) 
        {
          System.out.println("You busted!");
          player_bust = true;
          loop = false;
        }
      }

      //using an else if conditional that terminates the loop when the user says stand or something similar
      else if (player_choiceAsString.equals("stand") || player_choiceAsString.equals("pass") || player_choiceAsString.equals("stop")) 
      {
        loop = false;
      }
    }

    //creating a for loop that calculates the total sum outside of the player while loop to store for the winning condition
    int player_total_sum = 0;
    for (int i = 0; i < playerCards.size(); i++) 
    {
        player_total_sum = playerCards.get(i)+player_total_sum;
    }

    //the dealer now plays after the user plays

    //i determine the dealer's starting hand with the math.random command and print the hand out
    int dealer_start1 = (int) (Math.random() *10) + 2;
    int dealer_start2 = (int) (Math.random() *10) + 2;

    //creating an array list to store the dealer's cards
    ArrayList<Integer> dealerCards = new ArrayList<Integer>();
    dealerCards.add(dealer_start1);
    dealerCards.add(dealer_start2);

    //having a boolean value to make managing my while loop easier
    //if the player busts:
    if (player_bust == true) 
    {
      System.out.println("The dealer's cards are: "+dealer_start1+" and "+dealer_start2);
      System.out.println("Dealer wins!");
      System.exit(0);
    }

    //if the player doesn't bust:
    else if (player_bust == false) 
    {

      //creating a boolean variable for my dealer loop
      boolean dealer_loop = true;

      // my dealer loop:
      while (dealer_loop) 
      {

        //using the math.random to generate either a 1 or 2
        int dealer_choice = (int) (Math.random()* 2) +1;

        //calculating the dealer total sum of cards within the program
        int dealer_total_sum = 0;
        

        //i set the value "1" as hit:
        if (dealer_choice == 1) 
        {

          //I generate the dealer's next card with the math.random function
          int dealer_hit = (int) (Math.random() *10) +2;
          dealerCards.add(dealer_hit);

          //and then i tell the player the dealer's decision
          System.out.println("The dealer hits.");
        }
        
        //if the dealer stands, so if the value is 2:
        else if (dealer_choice == 2 || dealer_total_sum > 21) 
        {

          //i tell the user that the dealer stands and the loop breaks:
          System.out.println("The dealer stands.");
          dealer_loop = false;

        }

        //calculating the total sum at the end
        for (int i = 0; i < dealerCards.size(); i++) 
        {
          dealer_total_sum = dealerCards.get(i)+dealer_total_sum;
        }
      }
    }

    //recalculating the dealer sum outside of the loop for use
    int dealer_total_sum = 0;
    for (int i = 0; i < dealerCards.size(); i++) {
      dealer_total_sum = dealerCards.get(i)+dealer_total_sum;
    }

    //creating an empty string to use to be concatenated with the numbers for formatting purposes
    String dealer_proper_formatting = "";

    //Creating a for loop that adds all of the cards to my empty string for formatting
    for (int n = 0; n < dealerCards.size(); n++) {
      String dealer_card_as_String = Integer.toString(dealerCards.get(n));

      //using a conditional if statement that adds an "and" to the last card in the array
      if (n == dealerCards.size()-1) {
        dealer_proper_formatting = dealer_proper_formatting+" and "+dealer_card_as_String;
        }

      //otherwise, it adds a comma instead
      else{
        dealer_proper_formatting = dealer_proper_formatting+" "+dealer_card_as_String+",";
        }
      }

    //Here, i copy and paste my formatting loop for the player so it can print at the end of the game:
    String proper_formatting = "";

    //Creating a for loop that adds all of the cards to my empty string
    for (int i = 0; i < playerCards.size(); i++) {
      String card_as_String = Integer.toString(playerCards.get(i));

      if (playerCards.size() == 2){
        proper_formatting = " "+playerCards.get(0)+" and "+playerCards.get(1);
      }

      else {
        //using a conditional if statement that adds an "and" to the last card in the array
        if (i == playerCards.size()-1) {
          proper_formatting = proper_formatting+" and "+card_as_String;
        }

        //otherwise, it adds a comma instead
        else{
          proper_formatting = proper_formatting+" "+card_as_String+",";
        }

      }
      
    }

    //printing out cards for both dealer and player:
    System.out.println("Your cards are:"+proper_formatting);
    System.out.println("The dealer's cards are:"+dealer_proper_formatting);
    
    //using a bunch of conditional statements for to determine who wins:

    //if the dealer busts:
    if (dealer_total_sum > 21) {
      System.out.println("The dealer has bust!");
      System.out.println("You win!");
    }

    //if the dealer has a higher num than the player but the player doesn't bust
    else if (dealer_total_sum > player_total_sum && dealer_total_sum <= 21) {
      System.out.println("Dealer wins!");
    }

    //they tie if their sums are equal
    else if (dealer_total_sum == player_total_sum) {
      System.out.println("Tie!");
    }

    //player wins if player has a higher num than dealer and player doesn't bust
    else if (dealer_total_sum < player_total_sum && player_total_sum <=21) {
      System.out.println("You win!");
    }
    
      
    }
  


  }


