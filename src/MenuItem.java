/**
Name: Sophia Wang
Date: June 2
Description: Class for all menu items
*/
public class MenuItem {

   /** Attributes */
   private String name;
   private double price;
   private boolean hot;
   private int quantity;
   
   /** Constructors */
   //defualt constructs an order as x1 if unspecified
   public MenuItem (String name, double price, boolean hot){
      this.name = name;
      this.price = price;
      this.hot = hot;
      this.quantity = 1;
   }
   
   public MenuItem (String name, double price, boolean hot, int quantity){
      this.name = name;
      this.price = price;
      this.hot = hot;
      this.quantity = quantity;
   }
   
   /** accessors */   ///////////////JAVA DOC COMMENTS FOR  A N Y  METHOD
   public String getName(){
      return this.name;
   }
   public double getPrice(){
      return this.price;
   }
   public boolean isHot(){
      return this.hot;
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
