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
      } else if (order.toLowerCase().contains("pizza")) { // pizza
         String flavour;

         // get pizza flavour
         System.out.println("What flavour of pizza would you like?");
         System.out.println("There is: cheese, pepperoni, and hawaiian.");
         flavour = in.nextLine();

         // only ask for size if the flavour is valid (cheese, pepperoni, hawaiian)
         if (flavour.equalsIgnoreCase("cheese") || flavour.equalsIgnoreCase("pepperoni") || flavour.equalsIgnoreCase("hawaiian")) {
            String size;

            // get pizza size
            System.out.println("What size of pizza would you like?");
            System.out.println("There is: slice, small, medium, large, and x-large.");
            size = in.nextLine();

            // only ask for crust type if the size is valid (slice, small, medium, large, x-large)
            if (size.equalsIgnoreCase("slice") || size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large") || size.equalsIgnoreCase("x-large")) {
               String crust;

               // get pizza crust
               System.out.println("What type of pizza crust would you like?");
               System.out.println("There is: normal, stuffed, and thin.");
               crust = in.nextLine();

               // only ask for extra topping if crust is valid (normal, stuffed, thin)
               if (crust.equalsIgnoreCase("thin") || crust.equalsIgnoreCase("regular") || crust.equalsIgnoreCase("stuffed")) {
                  // ask if they want extra topping
                  System.out.println("Would you like to add an extra topping onto your pizza?");
                  System.out.println("The current available toppings are: pepperoni, bacon, and extra cheese");
                  if (in.nextLine().contains("y")) { // yes topping
                     String extraTopping;

                     // get pizza extra topping
                     System.out.println("What would you like?");
                     extraTopping = in.nextLine();

                     if (extraTopping.equalsIgnoreCase("pepperoni") || extraTopping.equalsIgnoreCase("bacon") || extraTopping.equalsIgnoreCase("extra cheese")) {
                        int quantity;
                        // ask for quantity
                        System.out.print("How many of these pizzas would you like? Please enter a digit: ");
                        quantity = in.nextInt();

                        // create the pizza
                        System.out.println("Okay, thanks so much! We will start making your pizza right away.");
                        String name; // name of pizza, needed for searching price in menu. only takes size and topping
                        name = size + " pizza with topping";
                        Pizza pizza = new Pizza(name, quantity, flavour, crust, size);

                        // get price
                        totalPrice = totalPrice + pizza.getPrice();// get price
                        numItems += 1;

                     } else { // invalid extra topping input
                        System.out.println("Sorry, that is not a valid extra topping.");
                     }
                  } else { // no topping. ask for quantity
                     int quantity;
                     // ask for quantity
                     System.out.print("How many of these pizzas would you like? Please enter a digit: ");
                     quantity = in.nextInt();

                     // create the pizza
                     System.out.println("Okay, thanks so much! We will start making your pizza right away.");
                     String name; // name of pizza, needed for searching price in menu. only takes size and topping
                     name = size + " pizza";
                     Pizza pizza = new Pizza(name, quantity, flavour, crust, size);

                     // get price
                     totalPrice = totalPrice + pizza.getPrice();// get price
                     numItems += 1;

                     // file io not wokring? ******* FILE READING CANT READ


                  }

               } else { // invalid crust input
                  System.out.println("Sorry, that is not a valid crust type.");
               }

            } else { // invalid size input
               System.out.println("Sorry, that is not a valid size.");
            }

         } else { // invalid flavour input
            System.out.println("Sorry, that is not a valid flavour.");
         }

      }


      else {
         System.out.println ("Sorry we don't serve that, but this is our menu:"); //file read to get the menu data
         
      }
      System.out.println(totalPrice);
   }
}