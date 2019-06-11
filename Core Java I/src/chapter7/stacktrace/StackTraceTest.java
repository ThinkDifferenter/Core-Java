package chapter7.stacktrace;

import java.util.*;

/**
 * A program that displays a trace feature of a recursive method call.
 * @version 1.10 2017-12-14
 * @author Cay Horstmann
 */
public class StackTraceTest
{
   /**
    * Computes the factorial of a number
    * @param n a non-negative integer
    * @return n! = 1 * 2 * . . . * n
    */
   public static int factorial(int n)
   {
      System.out.println("factorial(" + n + "):");
      Throwable t = new Throwable();
      StackTraceElement[] frame = t.getStackTrace();
      for(StackTraceElement f : frame){
         System.out.println(f);
      }
      int r;
      if (n <= 2) {
         r = 1;
      } else {
         r = factorial(n - 2) + factorial(n - 1);
      }
      System.out.println("return " + r);
      return r;
   }

   public static void main(String[] args)
   {
      try (Scanner in = new Scanner(System.in))
      {
         System.out.print("Enter n: ");
         int n = in.nextInt();
         factorial(n);
      }
   }
}
