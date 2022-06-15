/**
*/

import java.util.Scanner;

public class Main {
   public static void main (String [] args) {
      Scanner in = new Scanner (System.in);
      
      double totalPrice = 0;
      int numItems = 0;
      
      System.out.println("Hi Welcome to Fusion! What would you like to order?");
      String order = in.nextLine();
      if (order.equalsIgnoreCase("Pasta")){
         System.out.println("Would you like Chicken Alfredo, Spaghetti and Meatballs, or a custom order?");
         String pastaOrd = in.nextLine();
         if (pastaOrd.equalsIgnoreCase("Chicken Alfredo")){
            Pasta ChickAlf = new Pasta ("Chicken Alfredo", 1);
            totalPrice = totalPrice + ChickAlf.getPrice();//get price
            numItems += 1;
         }
         if (pastaOrd.equalsIgnoreCase("Spaghetti and meatballs")){
            Pasta spagMt = new Pasta ("Spaghetti and Meatballs", 1);
            totalPrice = totalPrice + spagMt.getPrice();//get price
            numItems += 1;
         }
      //can order directly without saying pasta first
      }
      else if (order.equalsIgnoreCase("Chicken Alfredo")){
         Pasta ChickAlf = new Pasta ("Chicken Alfredo", 1);
         totalPrice = totalPrice + ChickAlf.getPrice();//get price
         numItems += 1;
      }
      else if (order.equalsIgnoreCase("Spaghetti and meatballs")){
         Pasta spagMt = new Pasta ("Spaghetti and Meatballs", 1);
         totalPrice = totalPrice + spagMt.getPrice();//get price
         numItems += 1;
      }
      else {
         System.out.println ("Sorry we don't serve that, but this is our menu:"); //file read to get the menu data
         
      }
      System.out.println(totalPrice);
   }
}