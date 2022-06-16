/**
*/

public class Drink extends MenuItem {
   private String sugarLevel; //none less reg extra
   private boolean ice; 
   private String size;
   private boolean hot;
   
   public Drink (String name, int quantity, boolean hot, String sugarLevel, boolean ice, String size){
      super (name, quantity);
      this.sugarLevel = sugarLevel;
      this.hot = hot;
      if (!this.hot){
         this.ice = ice; // even if ice is false you can still have a cold drink without ice
      } else {
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
   public String getSize(){
      return this.size;
   }
}