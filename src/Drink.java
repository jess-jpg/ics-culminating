/**
*/

public class Drink extends MenuItem {
   private String sugarLevel; //none less reg extra
   private boolean ice; 
   private char size;
   private boolean hot;
   
   public Drink (String name, double price, boolean hot, int quantity, String sugarLevel, boolean ice, char size){
      super (name, price, quantity);
      this.sugarLevel = sugarLevel;
      if (hot = false){
         this.ice = ice; // even if ice is false you can still have a cold drink without ice
      }else{
         this.ice = false; //can't add ice to a hot drink
      }
      this.size = size;
   }
   public String getSugarLevel(){
      return this.sugarLevel;
   }
   public boolean getIce(){
      return this.ice;
   }
   public char getSize(){
      return this.size;
   }
}
