/**
Name: Sophia Wang
Date: June 2
Description: Class for all menu items
*/
public class MenuItem {

   /** Attributes */
   private String name;
   private double price;
   private int quantity;
   
   /** Constructors */
   // default constructs an order as x1 if unspecified
   public MenuItem (String name, double price){
      this.name = name;
      this.price = price;
      this.quantity = 1;
   }
   
   public MenuItem (String name, double price, int quantity){
      this.name = name;
      this.price = price;
      this.quantity = quantity;
   }
   
   /** accessors */   ///////////////JAVA DOC COMMENTS FOR  A N Y  METHOD
   public String getName(){
      return this.name;
   }
   public double getPrice(){
      return this.price;
   }
   public int getQuantity(){
      return this.quantity;
   }


//add another?
   public void addAnother(){
      this.quantity = this.quantity + 1;
   }
//remove one
   public void removeOne() {
      this.quantity = this.quantity - 1;
   }
}