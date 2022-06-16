/**
 * Creates a customizable pizza.
 * Has file reading!
 * Can choose its:
 * - flavour (cheese, pepperoni, hawaiian)
 * - crust type (normal, stuffed, thin)
 * - size (slice, small, medium, large , x-large)
 * - toppings. up to 1!
 * - quantity bought
 * doc: https://docs.google.com/document/d/16ZgsrNlRkXmWFkHTEPmhlCGocNgx0-H4AAG2QmCvUXI/edit?usp=sharing
 * Course: ICS4U
 * Date: June 15 2022
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

    /* constructors */

    /**
     * Name: Pizza
     * Description: Creates a default pizza: one medium cheese pizza. no additional toppings
     */
    public Pizza() {
        super("Cheese Pizza", 1);
        this.flavour = "cheese";
        this.crust = "normal";
        this.size = "medium";
        this.extraTopping1 = "none";
    }

    /**
     * Name: Pizza
     * Description: Creates a pizza with customized flavour and crust. no additional toppings
     * @param name name of pizza
     * @param quantity amount of pizza sold
     * @param flavour flavour of pizza
     * @param crust crust type of pizza
     * @param size size of pizza
     */
    public Pizza(String name, int quantity, String flavour, String crust, String size) {
        super(name, quantity); // constructs from MenuItem superclass

        // no extra toppings
        this.extraTopping1 = "none";

        // flavour must be: cheese, pepperoni, hawaiian
        if (flavour.equalsIgnoreCase("cheese") || flavour.equalsIgnoreCase("pepperoni") || flavour.equalsIgnoreCase("hawaiian")) {
            this.flavour = flavour;
        } else { // if not, flavour defaults to cheese
            this.flavour = "cheese";
        }

        // crust must be: thin, normal, stuffed
        if (crust.equalsIgnoreCase("thin") || crust.equalsIgnoreCase("regular") || crust.equalsIgnoreCase("stuffed")) {
            this.crust = crust;
        } else { // if not, crust defaults to regular
            this.crust = "regular";
        }

        // size must be: slice, small, medium, large , x-large
        if (size.equalsIgnoreCase("slice") || size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large") || size.equalsIgnoreCase("x-large")) {
            this.size = size;
        } else { // if not, size defaults to medium
            this.size = "medium";
        }
    }

    /**
     * Name: Pizza
     * Description: Creates a pizza with customized flavour and crust. ONE additional topping
     * @param name name of pizza
     * @param quantity amount of pizza sold
     * @param flavour flavour of pizza
     * @param crust crust type of pizza
     * @param size size of pizza
     * @param extraTopping extra topping #1 on pizza
     */
    public Pizza(String name, int quantity, String flavour, String crust, String size, String extraTopping) {
        super(name, quantity); // constructs from MenuItem superclass

        // extra toppings
        this.extraTopping1 = extraTopping;

        // flavour must be: cheese, pepperoni, hawaiian
        if (flavour.equalsIgnoreCase("cheese") || flavour.equalsIgnoreCase("pepperoni") || flavour.equalsIgnoreCase("hawaiian")) {
            this.flavour = flavour;
        } else { // if not, flavour defaults to cheese
            this.flavour = "cheese";
        }

        // crust must be: thin, normal, stuffed
        if (crust.equalsIgnoreCase("thin") || crust.equalsIgnoreCase("regular") || crust.equalsIgnoreCase("stuffed")) {
            this.crust = crust;
        } else { // if not, crust defaults to regular
            this.crust = "regular";
        }

        // size must be: slice, small, medium, large , x-large
        if (size.equalsIgnoreCase("slice") || size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large") || size.equalsIgnoreCase("x-large")) {
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
}
