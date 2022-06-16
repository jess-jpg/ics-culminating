/**
*/
public class Coffee extends Drink {
   private boolean decaf;
   
   public Coffee (String name, int quantity, boolean hot, String sugarLevel, boolean ice, String size, boolean decaf){
      super(name, quantity, hot, sugarLevel, ice, size);
      this.decaf = decaf;
   }
   
   public boolean isDecaf(){
      return this.decaf;
   }
}