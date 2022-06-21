/**
Sophia Wang 
June 20
Drink class -- subclass of menuItem and has differernt temperatures, sugar levels, sizes, and ice or not
*/

public class Drink extends MenuItem {
   /*Attributes*/
  
   /**sugar level of drink*/
   private String sugarLevel; //none less regular extra
   
   /** ice of drink*/
   private boolean ice; 
   
   /** size of drink*/
   private String size;
   
   /** temp of drink*/
   private boolean hot;
   
   
    /* constructor */

    /**
     * Name: Drink
     * Description: Creates a drink
     * @param name name of drink
     * @param quantity amount of drink
     * @param hot temperature of drink
     * @param sugarLevel sugar level of drink (none, less, regular, extra)
     * @param ice if drink has ice in it (true/false)
     * @param size size of drink
     */
   public Drink (String name, int quantity, boolean hot, String sugarLevel, boolean ice, String size){
      super (name, quantity); // from menuItem
      this.sugarLevel = sugarLevel;
      this.hot = hot;
      if (!this.hot){
         this.ice = ice; // even if ice is false you can still have a cold drink without ice
      } else {
         this.ice = false; //can't add ice to a hot drink
      }
      this.size = size;
   }
   
   /* accessors */

   /**
    * Name: getSugarLevel
    * Description: get drink sugar level
    * @return sugar level of drink
   */
   public String getSugarLevel(){
      return this.sugarLevel;
   }
   /**
    * Name: getIce
    * Description: get drink ice
    * @return if drink order has ice or not
   */
   public boolean getIce(){
      return this.ice;
   }
   
   /**
    * Name: getSize
    * Description: get drink size
    * @return size of drink
   */
   public String getSize(){
      return this.size;
   }
}
