/**
*/

import java.util.Scanner;

public class Main {
   public static void main (String [] args) {
      Scanner in = new Scanner (System.in);
      
      double totalPrice = 0;
      int numItems = 0;
      boolean orderMore = true;
      

      System.out.println("Hi Welcome to Fusion! What would you like to order? Type FINISH when you're done ordering and CANCEL if you'd like to cancel the order!");
      while (orderMore = true) {
         String order = in.nextLine();
         if (order.equalsIgnoreCase("finish")) {
            orderMore = false;
         } else if (order.equalsIgnoreCase("cancel")) {
            orderMore = false;
            totalPrice = 0;
            System.out.println("Order canceled");
         } else if (order.equalsIgnoreCase("Pasta")) {
            System.out.println("Would you like Chicken Alfredo or Spaghetti and Meatballs?");
            String pastaOrd = in.nextLine();
            if (pastaOrd.equalsIgnoreCase("Chicken Alfredo")) {
               Pasta ChickAlf = new Pasta("Chicken Alfredo", 1);
               totalPrice = totalPrice + ChickAlf.getPrice();//get price
               numItems += 1;
            }
            if (pastaOrd.equalsIgnoreCase("Spaghetti and meatballs")) {
               Pasta spagMt = new Pasta("Spaghetti and Meatballs", 1);
               totalPrice = totalPrice + spagMt.getPrice();//get price
               numItems += 1;
            }
            //can order directly without saying pasta first
         } else if (order.equalsIgnoreCase("Chicken Alfredo")) {
            Pasta ChickAlf = new Pasta("Chicken Alfredo", 1);
            totalPrice = totalPrice + ChickAlf.getPrice();//get price
            numItems += 1;
         } else if (order.equalsIgnoreCase("Spaghetti and meatballs")) {
            Pasta spagMt = new Pasta("Spaghetti and Meatballs", 1);
            totalPrice = totalPrice + spagMt.getPrice();//get price
            numItems += 1;

            //ORDERING PIZZA
         } else if (order.toLowerCase().contains("pizza")) { // pizza
            String flavour;

            // get pizza flavour
            System.out.println("What flavour of pizza would you like?");
            System.out.println("There is: cheese, pepperoni, and hawaiian.");
            flavour = in.nextLine();

            // only ask for size if the flavour is valid (cheese, pepperoni, hawaiian)
            if (flavour.toLowerCase().contains("cheese") || flavour.toLowerCase().contains("pepperoni") || flavour.toLowerCase().contains("hawaiian")) {
               String size;

               // get pizza size
               System.out.println("What size of pizza would you like?");
               System.out.println("There is: slice, small, medium, large, and x-large.");
               size = in.nextLine();

               // only ask for crust type if the size is valid (slice, small, medium, large, x-large)
               if (size.toLowerCase().contains("slice") || size.toLowerCase().contains("small") || size.toLowerCase().contains("medium") || size.toLowerCase().contains("large") || size.toLowerCase().contains("x-large")) {
                  String crust;

                  // get pizza crust
                  System.out.println("What type of pizza crust would you like?");
                  System.out.println("There is: thin, regular, and stuffed.");
                  crust = in.nextLine();

                  // only ask for extra topping if crust is valid (normal, stuffed, thin)
                  if (crust.toLowerCase().contains("thin") || crust.toLowerCase().contains("regular") || crust.toLowerCase().contains("stuffed")) {
                     // ask if they want extra topping
                     System.out.println("Would you like to add an extra topping onto your pizza?");
                     if (in.nextLine().contains("y")) { // yes topping
                        String extraTopping;

                        // get pizza extra topping
                        System.out.println("The current available toppings are: pepperoni, bacon, and extra cheese");
                        System.out.println("What would you like?");
                        extraTopping = in.nextLine();

                        if (extraTopping.toLowerCase().contains("pepperoni") || extraTopping.toLowerCase().contains("bacon") || extraTopping.toLowerCase().contains("extra cheese")) {
                           int quantity;
                           // ask for quantity
                           System.out.println("How many of these pizzas would you like?");
                           quantity = in.nextInt();

                           // create the pizza
                           System.out.println("Okay, thanks so much! We will start making your pizza right away.");
                           String name; // name of pizza, needed for searching price in menu. only takes size and topping
                           name = size + " pizza with topping";
                           Pizza pizza = new Pizza(name, quantity, flavour, crust, size);

                           // get price
                           totalPrice = totalPrice + pizza.getPrice(); // get price
                           numItems = numItems + quantity; // add to total items

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
                        numItems = numItems + quantity; // add to total items
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

            // ORDERING BUBBLE TEA
         } else if (order.toLowerCase().contains("bubble tea") || order.toLowerCase().contains("bbt") || order.toLowerCase().contains("boba"))  { // bubble tea
            String flavour;
            String topping;
            String size;
            String sugarLevel;
            String iceStr;
            boolean ice;
            String hotStr;
            boolean hot;
            String quantityStr;
            int quantity;

            // construct a bubble tea. if the user at any point wants to stop, leave if.
            flavour = bbtFlavour();
            if (!(flavour.equals("restart"))) {
               topping = bbtTopping(); // get topping
               if (!(topping.equals("restart"))) {
                  size = bbtSize(); // get size
                  if (!(size.equals("restart"))) {
                     sugarLevel = bbtSugarLevel(); // get sugar level
                     if (!(sugarLevel.equals("restart"))) {
                        iceStr = bbtIceLevel(); // get ice
                        if (!(iceStr.equals("restart"))) {
                           ice = Boolean.parseBoolean(iceStr); // ice in boolean
                           hotStr = bbtHot(); // get hot
                           if (!(hotStr.equals("restart"))) {
                              hot = Boolean.parseBoolean(iceStr); // hot in boolean
                              quantityStr = itemQuantity(); // get quantity
                              if (!(quantityStr.equals("remove"))) {
                                 quantity = Integer.parseInt(quantityStr); // quantity in int

                                 // now all parameters needed to construct a bubble tea are given by user. can now construct a bbt.
                                 // creating name of drink, needed to look through menu to find price. depends on size and topping
                                 String name;
                                 if (topping.equals("none")) {
                                    name = size + " bubble tea";
                                 } else {
                                    name = size + " bubble tea with topping";
                                 }

                                 // create drink
                                 System.out.println("Okay, thanks so much! We will start making your bubble tea right away.");
                                 BubbleTea bubbleTea = new BubbleTea(name, quantity, hot, sugarLevel, ice, size, flavour);

                                 // get price
                                 totalPrice = totalPrice + bubbleTea.getPrice(); // get price
                                 numItems = numItems + quantity; // add to total items

                                 System.out.println(name); // TEMP
                                 System.out.println(bubbleTea.getPrice()); // TEMP

                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   //
   }

   static Scanner sc = new Scanner(System.in);

   /**
    * Name: bbtFlavour
    * Description: get the flavour of bubble tea. input must be a valid flavour, or "restart", in which the ordering process will restart.
    * @return flavour of bubble tea
    */
   public static String bbtFlavour() {
      String flavour;
      boolean validInput;

      // get bubble tea flavour

      do {
         System.out.println("What flavour of bubble tea would you like?");
         System.out.println("There is: original, jasmine, mango, matcha, and taro.");
         flavour = sc.nextLine();

         // checking for valid input / restart
         if (!(flavour.toLowerCase().contains("original") || flavour.toLowerCase().contains("jasmine") || flavour.toLowerCase().contains("mango") || flavour.toLowerCase().contains("matcha") || flavour.toLowerCase().contains("taro"))) { // invalid flavour
            validInput = false;
            System.out.println("This is not a valid flavour.");
            System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid flavour.");
         } else if (flavour.toLowerCase().contains("restart")) { // restart
            validInput = true;
            flavour = "restart"; // restart, so there is no flavour. check in the main method for an empty string. if empty, quit ordering.
         } else { // valid flavour
            validInput = true;
         }
      } while (!validInput); // loop until input is a valid flavour, or user wants to restart

      return flavour;
   }

   /**
    * Name: bbtTopping
    * Description: get the topping of bubble tea. input must be a valid topping or "restart", in which the ordering process will restart.
    * @return topping of bubble tea
    */
   public static String bbtTopping() {
      String topping;
      boolean validInput;

      // get bubble tea topping
      do {
         System.out.println("What topping in your bubble tea would you like?");
         System.out.println("There is: tapioca, grass jelly, sago, and none.");
         topping = sc.nextLine();

         // checking for valid input / restart
         if (!(topping.toLowerCase().contains("tapioca") || topping.toLowerCase().contains("grass jelly") || topping.toLowerCase().contains("sago")) || topping.toLowerCase().contains("none")) { // invalid topping
            validInput = false;
            System.out.println("This is not a valid topping.");
            System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid topping.");
         } else if (topping.toLowerCase().contains("restart")) { // restart
            validInput = true;
            topping = "restart"; // user wants to restart, so there is no topping.
         } else { // valid topping
            validInput = true;
         }
      } while (!validInput); // loop until input is a valid topping, or user wants to restart

      return topping;
   }

   /**
    * Name: bbtSize
    * Description: get the size of bubble tea. input must be a valid size, or "restart", in which the ordering process will restart.
    * @return size of bubble tea
    */
   public static String bbtSize() {
      String size;
      boolean validInput;

      // get bubble tea size
      do {
         System.out.println("What size would you like?");
         System.out.println("There is: small, regular, and large.");
         size = sc.nextLine();

         // checking for valid input / restart
         if (!(size.toLowerCase().contains("small") || size.toLowerCase().contains("regular") || size.toLowerCase().contains("large"))) {
            validInput = false;
            System.out.println("This is not a valid size.");
            System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid size.");
         } else if (size.toLowerCase().contains("restart")) { // restart
            validInput = true;
            size = "restart"; // user wants to restart, so there is no size.
         } else { // valid size
            validInput = true;
         }
      } while(!validInput); // loop until input is valid or user wants to restart

      return size;
   }

   /**
    * Name: bbtSugarLevel
    * Description: get the sugar level of bubble tea. input must be valid or "restart", in which the ordering process will restart.
    * @return sugar level of bubble tea
    */
   public static String bbtSugarLevel() {
      String sugarLevel;
      boolean validInput;

      // get bubble tea sugar level
      do {
         System.out.println("What sugar level would you like?");
         System.out.println("There is: none, less, regular, and extra.");
         sugarLevel = sc.nextLine();

         // checking for valid input / restart
         if (!(sugarLevel.toLowerCase().contains("none") || sugarLevel.toLowerCase().contains("less") || sugarLevel.toLowerCase().contains("regular") || sugarLevel.toLowerCase().contains("extra"))) {
            validInput = false;
            System.out.println("This is not a valid sugar level.");
            System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid sugar level.");
         } else if (sugarLevel.toLowerCase().contains("restart")) { // restart
            validInput = true;
            sugarLevel = "restart"; // user wants to restart, so there is no size.
         } else { // valid sugar level
            validInput = true;
         }
      } while (!validInput);

      return sugarLevel;
   }

   /**
    * Name: bbtIceLevel
    * Description: get the ice level of bubble tea. input must be valid or "restart", in which the ordering process will restart. (change to boolean in main method)
    * @return if ice is in the bubble tea
    */
   public static String bbtIceLevel() {
      String iceLevel;
      boolean validInput;

      // get bbt ice level. change string back to boolean in main method
      do {
         System.out.println("Would you like ice?");
         iceLevel = sc.nextLine();
         // split into yes or no ice. asks for temperature if no ice
         if (iceLevel.toLowerCase().startsWith("y")) { // yes ice
            validInput = true;
            iceLevel = "yes";
         } else if (iceLevel.toLowerCase().startsWith("n")) { // no ice
            validInput = true;
            iceLevel = "no";
         } else if (iceLevel.toLowerCase().contains("restart")) { // restart ordering
            validInput = true;
            iceLevel = "restart";
         } else { // neither yes nor no nor restart
            validInput = false;
            iceLevel = "invalid"; // should never return this, just needed to run(?)
            System.out.println("This is not a valid ice level.");
            System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid ice level.");
         }
      } while (!validInput);

      return iceLevel;
   }

   /**
    * Name: bbtHot
    * Description: get the temperature of bubble tea (if its hot or not). input must be valid or "restart", in which the ordering process will restart. (change to boolean in main method)
    * @return if the bubble tea is hot or not
    */
   public static String bbtHot() {
      String hot;
      boolean validInput;

      do {
         System.out.println("Would you like your drink hot?");
         hot = sc.nextLine();

         // check for temperature. change string back to boolean in main method
         if (hot.toLowerCase().startsWith("y")) { // yes hot
            validInput = true;
            hot = "yes";
         } else if (hot.toLowerCase().startsWith("n")) { // not not
            validInput = true;
            hot = "no";
         } else if (hot.toLowerCase().contains("restart")) { // restart ordering
            validInput = true;
            hot = "restart";
         } else { // neither yes nor no nor restart
            validInput = false;
            hot = "invalid"; // should never return this, just needed to run(?)
            System.out.println("This is not a yes or no.");
            System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter yes or no.");
         }
      } while (!validInput);

      return hot;
   }

   // ITEM QUANTITY IS UNFINISHED!!!!!!!!!

   /**
    * Name: itemQuantity
    * Description: number of ordered items. changes to integer in main method
    * @return quantity of how many items the user wants to order, in a string
    */
   public static String itemQuantity() {
      String quantity;
      boolean validInput;

      // get quantity
      System.out.println("How many would you like?");
      // repeat until quantity is not 0, or the user does not want to order the item anymore.
      do {
         quantity = sc.nextLine();

         if (quantity.equals("0")) { // cannot order 0
            validInput = false;
            System.out.println("You can't order an amount of 0!");
            System.out.println("Would you like to delete this order, or order a real amount? Please enter 'remove' or a number: ");
         } else if (quantity.toLowerCase().contains("remove")) { // user wants to remove
            validInput = true;
            quantity = "remove";
         } else { // valid #, not remove
            validInput = true;
         }
      } while (!validInput);

      return quantity;
   }

}

/*


// ORDERING BUBBLE TEA
         } else if (order.toLowerCase().contains("bubble tea")) { // bubble tea
            // flavour, topping, size, sugarLevel, ice, hot
            String flavour;

            // get bubble tea flavour
            System.out.println("What flavour of bubble tea would you like?");
            System.out.println("There is: original, jasmine, mango, matcha, and taro.");
            flavour = in.nextLine();

            // only ask for topping if the flavour is valid (original, jasmine, mango, matcha, taro)
            if (flavour.toLowerCase().contains("original") || flavour.toLowerCase().contains("jasmine") || flavour.toLowerCase().contains("mango") || flavour.toLowerCase().contains("matcha") || flavour.toLowerCase().contains("taro")) {
               String topping;

               // get bubble tea topping
               System.out.println("What toppings in your bubble tea would you like?");
               System.out.println("There is: tapioca, grass jelly, and sago.");
               topping = in.nextLine();

               // only ask for size if the topping is valid (tapioca, grass jelly, sago)
               if (topping.toLowerCase().contains("tapioca") || topping.toLowerCase().contains("grass jelly") || topping.toLowerCase().contains("sago")) {
                  String size;

                  // get bubble tea size
                  System.out.println("What size would you like?");
                  System.out.println("There is: small, regular, and large.");
                  size = in.nextLine();

                  // only ask for sugar level if the size is valid (small, regular, large)
                  if (size.toLowerCase().contains("small") || size.toLowerCase().contains("regular") || size.toLowerCase().contains("large")) {
                     String sugarLevel;

                     // get bubble tea sugar level
                     System.out.println("What sugar level would you like?");
                     System.out.println("There is: none, less, regular, and extra.");
                     sugarLevel = in.nextLine();

                     // only ask for ice level if the sugar level is valid (none, less, regular, extra)
                     if (sugarLevel.toLowerCase().contains("none") || sugarLevel.toLowerCase().contains("less") || sugarLevel.toLowerCase().contains("regular") || sugarLevel.toLowerCase().contains("extra")) {
                        boolean ice;
                        boolean hot;

                        // get bubble tea ice level
                        System.out.println("Would you like ice?");

                        // split into yes or no ice. asks for temperature if no ice
                        if (in.nextLine().toLowerCase().startsWith("y")) { // yes ice
                           ice = true;
                           hot = false; // having ice means hot is false.

                           // ask for quantity
                           int quantity;
                           System.out.print("How many of these bubble teas would you like? Please enter a digit: ");
                           quantity = in.nextInt();

                           // create the pizza
                           System.out.println("Okay, thanks so much! We will start making your bubble tea right away.");
                           String name; // name of pizza, needed for searching price in menu. only takes size and topping
                           name = size + " pizza";
                           Pizza pizza = new Pizza(name, quantity, flavour, crust, size);

                           // get price
                           totalPrice = totalPrice + pizza.getPrice();// get price
                           numItems = numItems + quantity; // add to total items




                           // create the bubble tea

                        } else if (in.nextLine().toLowerCase().startsWith("n")) { // no ice
                           ice = false;


                           // get bubble tea temperature
                           System.out.println("Would you like your drink hot?");
                           if (in.nextLine().toLowerCase().startsWith("y")) { // yes hot
                              hot = true;


                              // create


                           } else if (in.nextLine().toLowerCase().startsWith("n")) { // not not
                              hot = false;



                              // create


                           } else {
                              System.out.println("Sorry, that is not a valid temperature.");
                           }
                        } else {
                           System.out.println("Sorry, that is not valid ice input.");
                        }
                     } else {
                        System.out.println("Sorry, that is not a valid sugar level.");
                     }
                  } else {
                     System.out.println("Sorry, that is not a valid size.");
                  }
               } else {
                  System.out.println("Sorry, that is not a valid topping.");
               }
            } else {
               System.out.println("Sorry, that is not a valid flavour.");
            }




 */