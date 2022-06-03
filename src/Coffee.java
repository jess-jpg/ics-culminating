/**
*/
public class Coffee extends Drink {
   private boolean decaf;
   
   public Coffee (String name, double price, boolean hot, int quantity, String sugarLevel, boolean ice, char size, boolean decaf){
      super(name, price, hot, quantity, sugarLevel, ice, size);
      this.decaf = decaf;
   }
   
   public boolean isDecaf(){
      return this.decaf;
   }
}
