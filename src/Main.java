/**
*/

import java.util.Scanner;

public class Main {

   static Scanner sc = new Scanner(System.in);
   static double totalPrice = 0;
   static int numItems = 0;
   static boolean orderMore = true;

   public static void main (String[] args) {
      Scanner in = new Scanner (System.in);

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

         } else if (order.toLowerCase().contains("pizza")) { //ORDERING PIZZA
            orderPizza();
         } else if (order.toLowerCase().contains("bubble tea") || order.toLowerCase().contains("bbt") || order.toLowerCase().contains("boba"))  { // ORDERING BUBBLE TEA
            orderBubbleTea();
         }
      }
   }

   /* ordering item methods */

   /**
    * Name: orderPizza
    * Description: the user orders a pizza. at any time, they can stop. if they type in something that does not exist, they can try again or stop ordering.
    */
   public static void orderPizza() {
      // parameters
      String flavour;
      String size;
      String crust;
      String extraTopping;
      String quantityStr;
      int quantity;

      // construct a pizza. if the user at any point wants to stop, leave the if block.
      flavour = pizzaFlavour(); // get flavour
      if (!(flavour.equals("restart"))) {
         size = pizzaSize(); // get size
         if (!(size.equals("restart"))) {
            crust = pizzaCrust(); // get crust
            if (!(crust.equals("restart"))) {
               extraTopping = pizzaExtraTopping(); // get extra topping
               if (!(extraTopping.equals("restart"))) {
                  quantityStr = itemQuantity(); // get quantity of order
                  if (!(quantityStr.equals("remove"))) {
                     quantity = Integer.parseInt(quantityStr); // quantity in int

                     // now all parameters needed to construct a pizza are given by user. can now construct the pizza.
                     // create name of pizza, needed to look through the menu to find price. depends on size and topping
                     String name;
                     if (extraTopping.equals("none")) {
                        name = size + " pizza";
                     } else {
                        name = size + " pizza with topping";
                     }

                     // create pizza
                     System.out.println("Okay, thanks so much! We will start making your pizza right away.");
                     Pizza pizza = new Pizza(name, quantity, flavour, crust, size);

                     // output order item (pizza)
                     System.out.println();
                     if (extraTopping.equals("none")) { // without topping
                        System.out.println("YOUR ORDER IS: " + quantity + " " + size + " " + flavour + " pizza.");
                     } else { // with topping
                        System.out.println("YOUR ORDER IS: " + quantity + " " + size + " " + flavour + " pizza with added " + extraTopping);
                     }

                     // add to price and item count
                     totalPrice = totalPrice + pizza.getPrice(); // get price
                     numItems = numItems + quantity; // add to total items
                  }
               }
            }
         }
      }
   }

   /**
    * Name: orderBubbleTea
    * Description: the user orders a bubble tea. at any time, they can stop. if they type in something that does not exist, they can try again or stop ordering.
    */
   public static void orderBubbleTea() {
      // parameters
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

      // construct a bubble tea. if the user at any point wants to stop, leave the if block.
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

                     // only ask for if drink is hot if there is no ice
                     if (ice) { // ice is true = cannot be hot
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
                           BubbleTea bubbleTea = new BubbleTea(name, quantity, false, sugarLevel, ice, size, flavour);

                           // output drink details (ice = true, hot = false)
                           System.out.println();
                           if (topping.equals("none")) { // without topping
                              System.out.println("YOUR ORDER IS: " + quantity + " " + size + " " + flavour + " bubble tea, with ice.");
                           } else { // with topping
                              System.out.println("YOUR ORDER IS: " + quantity + " " + size + " " + flavour + " bubble tea with " + topping + ", with ice.");
                           }

                           // get price
                           totalPrice = totalPrice + bubbleTea.getPrice(); // get price
                           numItems = numItems + quantity; // add to total items
                        }
                     } else { // ice is false = drink could be hot
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

                              // output drink details (ice = false, hot = either true or false)
                              System.out.println();
                              if (hot) { // hot
                                 System.out.println("YOUR ORDER IS: " + quantity + " " + size + " " + flavour + " bubble tea, hot.");
                              } else { // not hot
                                 if (topping.equals("none")) { // without topping
                                    System.out.println("YOUR ORDER IS: " + quantity + " " + size + " " + flavour + " bubble tea, no ice.");
                                 } else { // with topping
                                    System.out.println("YOUR ORDER IS: " + quantity + " " + size + " " + flavour + " bubble tea with " + topping + ", no ice.");
                                 }
                              }

                              // get price
                              totalPrice = totalPrice + bubbleTea.getPrice(); // get price
                              numItems = numItems + quantity; // add to total items
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   /* getting pizza parameter methods */

   /**
    * Name: pizzaFlavour
    * Description: gets and returns the pizza flavour. input must be a valid flavour, or "restart", in which the ordering process will restart.
    * @return pizza flavour
    */
   public static String pizzaFlavour() {
      String flavour;
      boolean validInput;

      // get flavour
      do {
      System.out.println("What flavour of pizza would you like?");
      System.out.println("There is: cheese, pepperoni, and hawaiian.");
      flavour = sc.nextLine();

      if (flavour.toLowerCase().contains("cheese")) { // valid flavour
         validInput = true;
         flavour = "cheese";
      } else if (flavour.toLowerCase().contains("pepperoni")) { // valid flavour
         validInput = true;
         flavour = "pepperoni";
      } else if (flavour.toLowerCase().contains("hawaiian")) { // valid flavour
         validInput = true;
         flavour = "hawaiian";
      } else if (flavour.toLowerCase().contains("restart")) { // restart
         validInput = true;
         flavour = "restart"; // returns "restart" to main method
      } else { // invalid flavour, not a restart
         validInput = false;
         System.out.println("This is not a valid flavour.");
         System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid flavour.");
      }
   } while (!validInput); // loop while input is invalid

      return flavour;
   }

   /**
    * Name: pizzaSize
    * Description: gets and returns the pizza size. input must be a valid flavour, or "restart", in which the ordering process will restart.
    * @return pizza size
    */
   public static String pizzaSize() {
      String size;
      boolean validInput;

      // get size
      do {
         System.out.println("What size of pizza would you like?");
         System.out.println("There is: slice, small, medium, large, and x-large.");
         size = sc.nextLine();

         if (size.toLowerCase().contains("slice")) { // valid
            validInput = true;
            size = "slice";
         } else if (size.toLowerCase().contains("small") || size.equalsIgnoreCase("s")) { // valid
            validInput = true;
            size = "small";
         } else if (size.toLowerCase().contains("medium") || size.equalsIgnoreCase("m")) { // valid
            validInput = true;
            size = "medium";
         } else if (size.toLowerCase().contains("large") || size.equalsIgnoreCase("l")) { // valid
            validInput = true;
            size = "large";
         } else if (size.toLowerCase().contains("x-large") || size.toLowerCase().contains("xlarge") || size.equalsIgnoreCase("xl")) { // valid
            validInput = true;
            size = "x-large";
         } else if (size.toLowerCase().contains("restart")) { // restart
            validInput = true;
            size = "restart"; // returns "restart" to main method
         } else { // invalid, not a restart
            validInput = false;
            System.out.println("This is not a valid size.");
            System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid size.");
         }
      } while (!validInput); // loop while input is invalid

      return size;
   }

   /**
    * Name: pizzaCrust
    * Description: gets and returns the pizza crust type. input must be a valid flavour, or "restart", in which the ordering process will restart.
    * @return pizza crust type
    */
   public static String pizzaCrust() {
      String crust;
      boolean validInput;

      // get crust type
      do {
         System.out.println("What type of pizza crust would you like?");
         System.out.println("There is: thin, regular, and stuffed.");
         crust = sc.nextLine();

         if (crust.toLowerCase().contains("thin")) { // valid
            validInput = true;
            crust = "thin";
         } else if (crust.toLowerCase().contains("regular")) { // valid
            validInput = true;
            crust = "regular";
         } else if (crust.toLowerCase().contains("stuffed")) { // valid
            validInput = true;
            crust = "stuffed";
         } else if (crust.toLowerCase().contains("restart")) { // restart
            validInput = true;
            crust = "restart"; // returns "restart" to main method
         } else { // invalid, not a restart
            validInput = false;
            System.out.println("This is not a valid crust type.");
            System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid crust type.");
         }
      } while (!validInput); // loop while input is invalid

      return crust;
   }

   /**
    * Name: pizzaExtraTopping
    * Description: gets and returns the pizza extra topping. input must be a valid flavour, or "restart", in which the ordering process will restart.
    * @return pizza extra topping
    */
   public static String pizzaExtraTopping() {
      String topping;
      boolean validInput;

      // ask if they want extra topping
      System.out.println("Would you like to add an extra topping onto your pizza?");
      if (sc.nextLine().toLowerCase().startsWith("y")) { // yes topping
         // get extra topping
         do {
            System.out.println("What extra topping would you like?");
            System.out.println("There is currently: pepperoni, bacon, and extra cheese.");
            topping = sc.nextLine();

            if (topping.toLowerCase().contains("pepperoni")) { // valid
               validInput = true;
               topping = "pepperoni";
            } else if (topping.toLowerCase().contains("bacon")) { // valid
               validInput = true;
               topping = "bacon";
            } else if (topping.toLowerCase().contains("extra cheese")) { // valid
               validInput = true;
               topping = "extra cheese";
            } else if (topping.toLowerCase().contains("restart")) { // restart
               validInput = true;
               topping = "restart"; // returns "restart" to main method
            } else if (topping.toLowerCase().contains("no")) { // no topping
               validInput = true;
               topping = "none";
            } else { // invalid, not a restart
               validInput = false;
               System.out.println("This is not a valid topping.");
               System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid topping.");
               System.out.println("If you would no longer like an extra topping, type 'no'.");
            }
         } while (!validInput); // loop while input is invalid
      } else {
         topping = "none";
      }

      return topping;
   }

   /* getting bubble tea parameter methods */

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

         if (flavour.toLowerCase().contains("original")) { // valid flavour
            validInput = true;
            flavour = "original";
         } else if (flavour.toLowerCase().contains("jasmine")) { // valid flavour
            validInput = true;
            flavour = "jasmine";
         } else if (flavour.toLowerCase().contains("mango")) { // valid flavour
            validInput = true;
            flavour = "mango";
         } else if (flavour.toLowerCase().contains("matcha")) { // valid flavour
            validInput = true;
            flavour = "matcha";
         } else if (flavour.toLowerCase().contains("taro")) { // valid flavour
            validInput = true;
            flavour = "taro";
         } else if (flavour.toLowerCase().contains("restart")) { // restart
            validInput = true;
            flavour = "restart"; // returns "restart" to main method
         } else { // invalid flavour, not a restart
            validInput = false;
            System.out.println("This is not a valid flavour.");
            System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid flavour.");
         }
      } while (!validInput); // loop while input is invalid

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


      // ask if they want extra topping
      System.out.println("Would you like to add a topping in your bubble tea?");
      if (sc.nextLine().toLowerCase().startsWith("y")) { // yes topping
         // get topping
         do {
            System.out.println("What topping in your bubble tea would you like?");
            System.out.println("There is: tapioca, grass jelly, and sago.");
            topping = sc.nextLine();

            if (topping.toLowerCase().contains("tapioca")) { // valid
               validInput = true;
               topping = "tapioca";
            } else if (topping.toLowerCase().contains("grass jelly")) { // valid
               validInput = true;
               topping = "grass jelly";
            } else if (topping.toLowerCase().contains("sago")) { // valid
               validInput = true;
               topping = "sago";
            } else if (topping.toLowerCase().contains("restart")) { // restart
               validInput = true;
               topping = "restart"; // returns "restart" to main method
            } else if (topping.toLowerCase().contains("no")) { // no topping
               validInput = true;
               topping = "none";
            } else { // invalid, not a restart
               validInput = false;
               System.out.println("This is not a valid topping.");
               System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid topping.");
               System.out.println("If you would no longer like an extra topping, type 'no'.");
            }
         } while (!validInput); // loop while input is invalid
      } else {
         topping = "none";
      }
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
         System.out.println("What size drink would you like?");
         System.out.println("There is: small, medium and large.");
         size = sc.nextLine();

         if (size.toLowerCase().contains("small") || size.equalsIgnoreCase("s")) { // valid
            validInput = true;
            size = "small";
         } else if (size.toLowerCase().contains("medium") || size.equalsIgnoreCase("m")) { // valid
            validInput = true;
            size = "medium";
         } else if (size.toLowerCase().contains("large") || size.equalsIgnoreCase("l")) { // valid
            validInput = true;
            size = "large";
         } else if (size.toLowerCase().contains("restart")) { // restart
            validInput = true;
            size = "restart"; // returns "restart" to main method
         } else { // invalid, not a restart
            validInput = false;
            System.out.println("This is not a valid size.");
            System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid size.");
         }
      } while (!validInput); // loop while input is invalid

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

         if (sugarLevel.toLowerCase().contains("none")) { // valid
            validInput = true;
            sugarLevel = "none";
         } else if (sugarLevel.toLowerCase().contains("less")) { // valid
            validInput = true;
            sugarLevel = "less";
         } else if (sugarLevel.toLowerCase().contains("regular")) { // valid
            validInput = true;
            sugarLevel = "regular";
         } else if (sugarLevel.toLowerCase().contains("extra")) { // valid
            validInput = true;
            sugarLevel = "extra";
         } else if (sugarLevel.toLowerCase().contains("restart")) { // restart
            validInput = true;
            sugarLevel = "restart"; // returns "restart" to main method
         } else { // invalid, not a restart
            validInput = false;
            System.out.println("This is not a valid size.");
            System.out.println("If you would like to restart ordering, please type 'restart'. Otherwise, please enter a valid size.");
         }
      } while (!validInput); // loop while input is invalid

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
            iceLevel = "true";
         } else if (iceLevel.toLowerCase().startsWith("n")) { // no ice
            validInput = true;
            iceLevel = "false";
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
            hot = "true";
         } else if (hot.toLowerCase().startsWith("n")) { // not not
            validInput = true;
            hot = "false";
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
      System.out.println("How many of this item would you like to order?");
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