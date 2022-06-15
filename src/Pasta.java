/**
*/
public class Pasta extends MenuItem {
   private String sauce;
   private String sauceAmount;
   private String protein;
   private String pastaShape;
   
   //unspecified sauce amount defaults to regular
   public Pasta (String name, int quantity){
      super (name, quantity);

      if (name.equalsIgnoreCase("Chicken Alfredo")) {
         this.sauce = "Alfredo";
         this.protein = "Chicken";
         this.pastaShape = "Linguine";
      }
      
      if (name.equalsIgnoreCase("Spaghetti and Meatballs")) {
         this.sauce = "Marinara";
         this.protein = "Beef Meatballs";
         this.pastaShape = "Spaghetti";
      }  
   
   }
   
   public Pasta (String name, int quantity, String sauce, String sauceAmount, String protein, String pastaShape){
      super (name, quantity);
      this.sauce = sauce;
      this.sauceAmount = sauceAmount;
      this.protein = protein;
      this.pastaShape = pastaShape;
      
      if (name.equalsIgnoreCase("Chicken Alfredo")) {
         this.sauce = "Alfredo";
         this.protein = "Chicken";
         this.pastaShape = "Linguine";
        
         
      }
   
      if (name.equalsIgnoreCase("Spaghetti and Meatballs")) {
         this.sauce = "Marinara";
         this.protein = "Beef Meatballs";
         this.pastaShape = "Spaghetti";
      }  
   
   }
   
   
}
   
   //do we need getters...? 