package edu.nyu.cs.smw9999;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Q2: Prime numbers (10 pts)
 * 
 * Write a Java program that prints out all prime numbers between 
 * two integer inputs `a` and `b` (without the quotes), inclusive.
 * 
 * In addition, replace NetID in edu.nyu.cs.NetID on the first line with your own NetID,
 * and rename the folder containing this piece of code with your NetID.
 * 
 * 
 * Notes:
 *    This problem asks you to write a complex program, which may be difficult for novice programmers.
 * 
 *    Don't panic! 
 * 
 *    The key to developing a programmatic solution for this problem, and for
 *    many other problems, is to break it into subproblems and develop solutions 
 *    for each of them in turn.
 * 
 *    In particular, do not attempt to develop a complete solution in the first trial. 
 * 
 *    I suggest breaking down this problem into three components:
 *      i)    Prompting the user for input and checking if the input is correct (see instructions).
 *      ii)   Checking whether a given positive integer is prime.
 *      iii)  Expand the program to test whether other numbers are prime in a loop.
 * 
 *    If you can complete steps i)-iii), then you should be in a good position to complete this problem!
 * 
 * 
 * Instructions:
 * 1) The inputs a and b (defined in the main method for your convenience) should be provided by the user.
 * 
 *    You may use any methods from the Scanner class to help you do so. 
 * 
 *    The inputs a and b should be i) integers, ii) strictly positive (>= 1) and iii) the input b should be greater or equal than a. 
 *      - You may assume the input will always be entered as integers. You do NOT need to check this.
 *      - However, you MUST check whether the inputs are strictly positive and whether b >= a.
 *        If the inputs are incorrect, your program should print "Incorrect input!" and stop. 
 * 
 * 
 * 2) An integer greater than 1 is prime if its only positive divisor is 1 or itself.
 *    For example, the numbers 2,3,5,7 are all prime numbers, but 4,6,8, and 9 are not.
 * 
 *    To determine whether a number is prime, check whether it is divisible by a number between 2 and number/2.
 * 
 * 
 * 3) Your code should print out all prime numbers between the integer inputs a and b, inclusive.
 *    The formatting of the output is not important; you'll get full marks as long as the input is checked
 *    for correctness and all the correct prime numbers are printed,
 */


public class PrimeNumbers{
  /**
   * The main function is automatically called first in a Java program.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) throws Exception {


    // Enter code here

    //Using scanner to prompt the user, and then storing the values of their two numbers
    Scanner a = new Scanner(System.in);
    System.out.print("Enter a starting number: ");
    String a_as_String = a.nextLine();

    Scanner b = new Scanner(System.in);
    System.out.print("Enter an ending number greater than the starting number: ");
    String b_as_String = b.nextLine();

    //declaring global variables to store my a and b as integers:
    int a_as_Integer;
    int b_as_Integer;

    //declaring more variables for when i find the prime numbers:
    int num;
    String formatted_prime = "";

    //creating an array to store my prime numbers
    ArrayList <Integer> prime_numbers = new ArrayList<Integer>();

    //creating a boolean variable to act as a flag for my prime number for loops
    boolean non_prime = false;
    

    //Using a while loop to check the user's input, which will instantly break and end the program if the user
    //enters the wrong input
    while (true)
    {
      //using a try catch to determine whether the user input is an integer by trying to parse it 
      try 
      {
        a_as_Integer = Integer.parseInt(a_as_String);
      
      }
      catch (NumberFormatException e) 
      {
        System.out.println("Incorrect input!");
        break;
      }

      try
      {
        b_as_Integer = Integer.parseInt(b_as_String);
      }
      catch (NumberFormatException e) 
      {
        System.out.println("Incorrect input!");
        break;
      }

      //using an if statement to determine whether the numbers are positive or not or whether b is greater than a:
      if (a_as_Integer < 1 || b_as_Integer < 1 || b_as_Integer < a_as_Integer) 
      {
        System.out.println("Incorrect input!");
        break;
      }

      //I continue with the program once the user is able to input something correctly:
      else 
      { 
        //using a for loop to loop thru the numbers between a and b, checking if they're prime :
        for (num = a_as_Integer; num <= b_as_Integer; num++) 
        { 

          //using another nested for loop to actually figure out if the number is prime by dividing from 2 to num/2 for the current number:
          for (int divisor = 2; divisor <= num/2; divisor++) 
          {
            //if it finds a non prime number by finding the remainder:
            if (num % divisor == 0) 
            {
              //it marks the non_prime flag as true and then breaks the loop
              non_prime = true;
              break;
            }
            else 
            {
              //otherwise it keeps it as false until the loop ends or it turns true
              non_prime = false;
            }
          }

          //if the non_prime flag is false for the num, then it adds that number to my array list of prime numbers
          if (non_prime == false) 
          {
            prime_numbers.add(num);
          }
        }
        
        //then i add a conditional that runs if there are no prime numbers:
        if (prime_numbers.size() == 0)
        {
          //i tell the user that there are no prime numbers:
          System.out.println("There are no prime numbers between "+a_as_String+" and "+b_as_String);

        }
        
        //if the only number in the array is 1, due to the loop considering it as prime, then i use another conditional that tells the user
        //that there are no prime numberss:
        else if (prime_numbers.size() == 1 && prime_numbers.get(0) == 1) 
        {
          System.out.println("There are no prime numbers between "+a_as_String+" and "+b_as_String);
        }

        //if there are prime numbers:
        else 
        {
          //if the user has 1 in their list of numbers, i make sure to remove it as the loops above will consider 1 prime
          if (prime_numbers.get(0) == 1) 
          {
            prime_numbers.remove(0);
          }

          //then i use a for loop that formats the arraylist of prime numbers
          for (int n = 0; n < prime_numbers.size(); n++)
          {
            //using concatenation of strings and making sure the last number doesn't have a comma
            if (n == prime_numbers.size()-1) 
            {
              formatted_prime = formatted_prime+prime_numbers.get(n);
            }
            //if it's not the last number of the array list, then it adds a comma
            else 
            {
              formatted_prime = formatted_prime+prime_numbers.get(n)+", ";
            }
          }
          //finally i print out everything:
          System.out.println("The prime numbers between "+a_as_String+" and "+b_as_String+" are: "+formatted_prime);
        }

        //and then i break the loop at the end after everything runs successfully
        break;
      }

    }

  }
}
