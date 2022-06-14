/**
*/
public class Coffee extends Drink {
   private boolean decaf;
   
   public Coffee (String name, double price, boolean hot, int quantity, String sugarLevel, boolean ice, String size, boolean decaf){
      super(name, price, hot, quantity, sugarLevel, ice, size);
      this.decaf = decaf;
   }
   
   public boolean isDecaf(){
      return this.decaf;
   }
}