/**
Name: Sophia Wang
Date: June 2
Description: Class for all menu items
*/
import java.io.*;

public class MenuItem {

   /** Attributes */
   private String name;
   private double price;
   private int quantity;
   
   /** Constructors */
   //defualt constructs an order as x1 if unspecified
   public MenuItem (String name){
      this.name = name;
      this.quantity = 1;
      
      try {
         File f = new File ("Menu.txt");
         FileReader fr = new FileReader(f);
         BufferedReader br = new BufferedReader(fr);
         
         //reading a line from the file
         System.out.println(br.readLine());
         String line;
       
         //while there are more lines to read
         while ((line = br.readLine()) != null) {
            //using the text nuances to find my data
            if (line.contains(this.name)) {
               this.price = br.nextLine();
            }
         }
         br.close();
         fr.close();
      } catch (IOException e) {
         System.out.println("Cannot read file");
      }
      
   }
   
   public MenuItem (String name, int quantity){
      this.name = name;
      this.quantity = quantity;
      
      try {
         File f = new File ("Menu.txt");
         FileReader fr = new FileReader(f);
         BufferedReader br = new BufferedReader(fr);
         
         //reading a line from the file
         System.out.println(br.readLine());
         String line;
       
         //while there are more lines to read
         while ((line = br.readLine()) != null) {
            //using the text nuances to find my data
            if (line.contains(this.name)) {
               this.price = br.nextLine();
            }
         }
         br.close();
         fr.close();
      } catch (IOException e) {
         System.out.println("Cannot read file");
      }
      
   }
   
   /** accessors */   ///////////////JAVA DOC COMMENTS FOR  A N Y  METHOD
   public String getName(){
      return this.name;
   }
   public double getPrice(){
      return this.price;
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
