/**
*/

public class Drink extends MenuItem {
   private String sugarLevel; //none less reg extra
   private boolean ice; 
   private char size;
   
   public Drink (String name, double price, boolean hot, int quantity, String sugarLevel, boolean ice, char size){
      super (name, price, hot, quantity);
      this.sugarLevel = sugarLevel;
      this.ice = ice;
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
