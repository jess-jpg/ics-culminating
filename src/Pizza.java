/**
 * Creates a customizable pizza.
 * Can choose its:
 * - flavour (cheese, pepperoni, vegetarian, hawaiian, margherita)
 * - crust type (normal, stuffed, thin)
 * - size (slice, small, medium, large , x-large)
 * - toppings. up to 3!
 * - quantity bought
 * doc: https://docs.google.com/document/d/16ZgsrNlRkXmWFkHTEPmhlCGocNgx0-H4AAG2QmCvUXI/edit?usp=sharing
 * Course: ICS4U
 * Date: June 06 2022
 * @author Jessica Lu
 */

public class Pizza extends MenuItem {
    /* attributes */
    /** pizza flavour */
    private String flavour;

    /** pizza crust */
    private String crust;

    /** pizza size */
    private String size;

    /** pizza extra topping 1, if any */
    private String extraTopping1;

    /** pizza extra topping 2, if any */
    private String extraTopping2;

    /** pizza extra topping 3, if any */
    private String extraTopping3;

    /* constructors */

    /**
     * Name: Pizza
     * Description: Creates a default pizza: one medium cheese pizza. no additional toppings
     */
    public Pizza() {
        super("Cheese Pizza", 16, 1); // $8 for one medium cheese pizza.
        this.flavour = "cheese";
        this.crust = "normal";
        this.size = "medium";
        this.extraTopping1 = "none";
        this.extraTopping2 = "none";
        this.extraTopping3 = "none";
    }

    /**
     * Name: Pizza
     * Description: Creates a pizza with customized flavour and crust. no additional toppings
     * @param name name of pizza
     * @param price price of pizza
     * @param quantity amount of pizza sold
     * @param flavour flavour of pizza
     * @param crust crust type of pizza
     * @param size size of pizza
     */
    public Pizza(String name, double price, int quantity, String flavour, String crust, String size) {
        super(name, price, quantity); // constructs from MenuItem superclass

        // no extra toppings
        this.extraTopping1 = "none";
        this.extraTopping2 = "none";
        this.extraTopping3 = "none";

        // flavour must be: cheese, pepperoni, vegetarian, hawaiian, margherita
        if (flavour.toLowerCase().equals("cheese") || flavour.toLowerCase().equals("pepperoni") || flavour.toLowerCase().equals("vegetarian") || flavour.toLowerCase().equals("hawaiian") || flavour.toLowerCase().equals("margherita")) {
            this.flavour = flavour;
        } else { // if not, flavour defaults to cheese
            this.flavour = "cheese";
        }

        // crust must be: thin, normal, stuffed
        if (crust.toLowerCase().equals("thin") || crust.toLowerCase().equals("regular") || crust.toLowerCase().equals("stuffed")) {
            this.crust = crust;
        } else { // if not, crust defaults to regular
            this.crust = "regular";
        }

        // size must be: slice, small, medium, large , x-large
        if (size.toLowerCase().equals("slice") || size.toLowerCase().equals("small") || size.toLowerCase().equals("medium") || size.toLowerCase().equals("large") || size.toLowerCase().equals("x-large")) {
            this.size = size;
        } else { // if not, size defaults to medium
            this.size = "medium";
        }
    }

    /**
     * Name: Pizza
     * Description: Creates a pizza with customized flavour and crust. ONE additional topping
     * @param name name of pizza
     * @param price price of pizza
     * @param quantity amount of pizza sold
     * @param flavour flavour of pizza
     * @param crust crust type of pizza
     * @param size size of pizza
     * @param extraTopping1 extra topping #1 on pizza
     */
    public Pizza(String name, double price, int quantity, String flavour, String crust, String size, String extraTopping1) {
        super(name, price, quantity); // constructs from MenuItem superclass

        // extra toppings
        this.extraTopping1 = extraTopping1;
        this.extraTopping2 = "none";
        this.extraTopping3 = "none";

        // flavour must be: cheese, pepperoni, vegetarian, hawaiian, margherita
        if (flavour.toLowerCase().equals("cheese") || flavour.toLowerCase().equals("pepperoni") || flavour.toLowerCase().equals("vegetarian") || flavour.toLowerCase().equals("hawaiian") || flavour.toLowerCase().equals("margherita")) {
            this.flavour = flavour;
        } else { // if not, flavour defaults to cheese
            this.flavour = "cheese";
        }

        // crust must be: thin, normal, stuffed
        if (crust.toLowerCase().equals("thin") || crust.toLowerCase().equals("regular") || crust.toLowerCase().equals("stuffed")) {
            this.crust = crust;
        } else { // if not, crust defaults to regular
            this.crust = "regular";
        }

        // size must be: slice, small, medium, large , x-large
        if (size.toLowerCase().equals("slice") || size.toLowerCase().equals("small") || size.toLowerCase().equals("medium") || size.toLowerCase().equals("large") || size.toLowerCase().equals("x-large")) {
            this.size = size;
        } else { // if not, size defaults to medium
            this.size = "medium";
        }
    }

    /**
     * Name: Pizza
     * Description: Creates a pizza with customized flavour and crust. TWO additional toppings
     * @param name name of pizza
     * @param price price of pizza
     * @param quantity amount of pizza sold
     * @param flavour flavour of pizza
     * @param crust crust type of pizza
     * @param size size of pizza
     * @param extraTopping1 extra topping #1 on pizza
     * @param extraTopping2 extra topping #2 on pizza
     */
    public Pizza(String name, double price, int quantity, String flavour, String crust, String size, String extraTopping1, String extraTopping2) {
        super(name, price, quantity); // constructs from MenuItem superclass

        // extra toppings
        this.extraTopping1 = extraTopping1;
        this.extraTopping2 = extraTopping2;
        this.extraTopping3 = "none";

        // flavour must be: cheese, pepperoni, vegetarian, hawaiian, margherita
        if (flavour.toLowerCase().equals("cheese") || flavour.toLowerCase().equals("pepperoni") || flavour.toLowerCase().equals("vegetarian") || flavour.toLowerCase().equals("hawaiian") || flavour.toLowerCase().equals("margherita")) {
            this.flavour = flavour;
        } else { // if not, flavour defaults to cheese
            this.flavour = "cheese";
        }

        // crust must be: thin, normal, stuffed
        if (crust.toLowerCase().equals("thin") || crust.toLowerCase().equals("regular") || crust.toLowerCase().equals("stuffed")) {
            this.crust = crust;
        } else { // if not, crust defaults to regular
            this.crust = "regular";
        }

        // size must be: slice, small, medium, large , x-large
        if (size.toLowerCase().equals("slice") || size.toLowerCase().equals("small") || size.toLowerCase().equals("medium") || size.toLowerCase().equals("large") || size.toLowerCase().equals("x-large")) {
            this.size = size;
        } else { // if not, size defaults to medium
            this.size = "medium";
        }
    }

    /**
     * Name: Pizza
     * Description: Creates a pizza with customized flavour and crust. TWO additional toppings
     * @param name name of pizza
     * @param price price of pizza
     * @param quantity amount of pizza sold
     * @param flavour flavour of pizza
     * @param crust crust type of pizza
     * @param size size of pizza
     * @param extraTopping1 extra topping #1 on pizza
     * @param extraTopping2 extra topping #2 on pizza
     * @param extraTopping3 extra topping #3 on pizza
     */
    public Pizza(String name, double price, int quantity, String flavour, String crust, String size, String extraTopping1, String extraTopping2, String extraTopping3) {
        super(name, price, quantity); // constructs from MenuItem superclass

        // extra toppings
        this.extraTopping1 = extraTopping1;
        this.extraTopping2 = extraTopping2;
        this.extraTopping3 = extraTopping3;

        // flavour must be: cheese, pepperoni, vegetarian, hawaiian, margherita
        if (flavour.toLowerCase().equals("cheese") || flavour.toLowerCase().equals("pepperoni") || flavour.toLowerCase().equals("vegetarian") || flavour.toLowerCase().equals("hawaiian") || flavour.toLowerCase().equals("margherita")) {
            this.flavour = flavour;
        } else { // if not, flavour defaults to cheese
            this.flavour = "cheese";
        }

        // crust must be: thin, normal, stuffed
        if (crust.toLowerCase().equals("thin") || crust.toLowerCase().equals("regular") || crust.toLowerCase().equals("stuffed")) {
            this.crust = crust;
        } else { // if not, crust defaults to regular
            this.crust = "regular";
        }

        // size must be: slice, small, medium, large , x-large
        if (size.toLowerCase().equals("slice") || size.toLowerCase().equals("small") || size.toLowerCase().equals("medium") || size.toLowerCase().equals("large") || size.toLowerCase().equals("x-large")) {
            this.size = size;
        } else { // if not, size defaults to medium
            this.size = "medium";
        }
    }

    /* accessors */

    /**
     * Name: getFlavour
     * Description: returns pizza flavour
     * @return pizza flavour
     */
    public String getFlavour() {
        return this.flavour;
    }

    /**
     * Name: getCrust
     * Description: returns pizza crust type
     * @return pizza crust type
     */
    public String getCrust() {
        return this.crust;
    }

    /**
     * Name: getSize
     * Description: returns pizza size
     * @return pizza size
     */
    public String getSize() {
        return this.size;
    }

    /**
     * Name: getExtraTopping1
     * Description: returns pizza extra topping #1
     * @return pizza extra topping #1
     */
    public String getExtraTopping1() {
        return this.extraTopping1;
    }

    /**
     * Name: getExtraTopping2
     * Description: returns pizza extra topping #2
     * @return pizza extra topping #2
     */
    public String getExtraTopping2() {
        return this.extraTopping2;
    }

    /**
     * Name: getExtraTopping3
     * Description: returns pizza extra topping #3
     * @return pizza extra topping #3
     */
    public String getExtraTopping3() {
        return this.extraTopping3;
    }

    /* mutators */
    // none
    /* other methods */
    // none

    // testing main method!!
    // runs everything in here (all constructors, accessors)
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza(); // creates a default pizza

        // creates a large pepperoni pizza with no extra toppings
        Pizza pizza2 = new Pizza("Pepperoni Pizza", 17, 1, "pepperoni", "stuffed", "large");
    }
}
