/**
*/
public class drink extends menuItem {
   private String sugarLevel; //none less reg extra
   private boolean ice; 
   private String size;
   
   public drink (String name, double price, boolean hot, int quantity, String sugarLevel, boolean ice, String size){
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
   public String getSize(){
      return this.size;
   }
}
