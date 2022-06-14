/**
 * Creates a customizable bubble tea drink.
 * Can choose its:
 * - flavour (original, jasmine, mango, matcha, taro)
 * - toppings (tapioca, grass jelly, sago)
 * - temperature (hot/cold)
 * - sugar level (0-100%)
 * - ice level (true/false)
 * - drink size (s/m/l)
 * - quantity bought
 * Course: ICS4U
 * Date: June 06 2022
 * @author Jessica Lu
 */

public class BubbleTea extends Drink {
    /* attributes */

    /** bubble tea flavour */
    private String flavour;
    /** bubble tea topping */
    private String topping; // tapioca, grass jelly, sago

    /* constructor */

    // Drink parameters: String name, double price, boolean hot, int quantity, String sugarLevel, boolean ice, char size
    // Bubble Tea parameters: [all of drink parameters] + String flavour, String topping

    /**
     * Name: BubbleTea
     * Description: Creates a default bubble tea: one iced medium Original flavour with tapioca. reg sugar
     */
    public BubbleTea() {
        super("Original Milk Tea with Tapioca", 5, false, 1, "reg", true, "medium"); // Drink constructor
        this.flavour = "original";
        this.topping = "tapioca";
    }

    /**
     * Name: BubbleTea
     * Description: Creates a bubble tea with customized flavour, no topping
     * @param name name of bubble tea
     * @param price price of bubble tea
     * @param hot temperature of bubble tea
     * @param quantity amount of bubble tea sold
     * @param sugarLevel sugar level of bubble tea (none, less, reg, extra)
     * @param ice if bubble tea has ice in it (true/false)
     * @param size size of bubble tea
     * @param flavour flavour of bubble tea
     */
    public BubbleTea(String name, double price, boolean hot, int quantity, String sugarLevel, boolean ice, String size, String flavour) {
        super(name, price, hot, quantity, sugarLevel, ice, size); // Drink constructor

        // flavour must be original, jasmine, mango, matcha or taro
        if (flavour.equalsIgnoreCase("original") || flavour.equalsIgnoreCase("jasmine") || flavour.equalsIgnoreCase("mango") || flavour.equalsIgnoreCase("matcha") || flavour.equalsIgnoreCase("taro")) {
            this.flavour = flavour;
        } else { // if not, flavour defaults to original
            this.flavour = "original";
        }

        // no topping
        this.topping = "none";
    }

    /**
     * Name: BubbleTea
     * Description: Creates a bubble tea with customized flavour and topping
     * @param name name of bubble tea
     * @param price price of bubble tea
     * @param hot temperature of bubble tea
     * @param quantity amount of bubble tea sold
     * @param sugarLevel sugar level of bubble tea (none, less, reg, extra)
     * @param ice if bubble tea has ice in it (true/false)
     * @param size size of bubble tea
     * @param flavour flavour of bubble tea
     * @param topping toppings in bubble tea
     */
    public BubbleTea(String name, double price, boolean hot, int quantity, String sugarLevel, boolean ice, String size, String flavour, String topping) {
        super(name, price, hot, quantity, sugarLevel, ice, size); // Drink constructor

        // flavour must be original, jasmine, mango, matcha or taro
        if (flavour.equalsIgnoreCase("original") || flavour.equalsIgnoreCase("jasmine") || flavour.equalsIgnoreCase("mango") || flavour.equalsIgnoreCase("matcha") || flavour.equalsIgnoreCase("taro")) {
            this.flavour = flavour;
        } else { // if not, flavour defaults to original
            this.flavour = "original";
        }

        // toppings must be tapioca, grass jelly or sago
        if (topping.equalsIgnoreCase("tapioca") || topping.equalsIgnoreCase("grass jelly") || topping.equalsIgnoreCase("sago")) {
            this.topping = topping;
        } else { // if not, topping defaults to none
            this.topping = "none";
        }
    }

    /* accessors */

    /**
     * Name: getFlavour
     * Description: get bubble tea flavour
     * @return flavour of bubble tea
     */
    public String getFlavour() {
        return this.flavour;
    }

    /**
     * Name: getTopping
     * Description: get bubble tea topping
     * @return topping in bubble tea
     */
    public String getTopping() {
        return this.topping;
    }

    /* mutators */
    // none
    /* other methods */
    // none
}
