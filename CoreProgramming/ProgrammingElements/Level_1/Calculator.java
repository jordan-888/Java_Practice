package CoreProgramming.ProgrammingElements.Level_1;

import java.util.Scanner;

public class Calculator {
   public Calculator() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.print("Enter first number: ");
      double var2 = var1.nextDouble();
      System.out.print("Enter second number: ");
      double var4 = var1.nextDouble();
      double var6 = var2 + var4;
      double var8 = var2 - var4;
      double var10 = var2 * var4;
      double var12 = var2 / var4;
      System.out.printf("The addition, subtraction, multiplication and division value of 2 numbers are : %.2f, %.2f, %.2f and %.2f%n", var6, var8, var10, var12);
      var1.close();
   }
}
