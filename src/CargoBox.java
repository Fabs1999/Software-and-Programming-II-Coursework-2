package src;

import java.util.ArrayList;
import java.util.*;

/**
 * A src.CargoBox holds zero or more Items and can provide information about the
 * Items. One can add Items to a src.CargoBox during its lifetime, empty the
 * src.CargoBox, create a copy which contains Items only up to a certain weight,
 * and make various queries to the src.CargoBox. (Thus, the number of Items that
 * will be stored by a src.CargoBox object is not yet known when the new object
 * is created, and it may grow and shrink over the lifetime of a src.CargoBox
 * object.)
 *
 * @author
 */
public class CargoBox{
    // TO DO
    private ArrayList<Item> items;
    /* Constructors */
    /**
     * Constructs a new src.CargoBox without any Items.
     */
    public CargoBox() {
        // TO DO
        items = new ArrayList<>(); //adding each non nul items from the array to src.CargoBox
    }

    /**
     * Constructs a new src.CargoBox containing the non-null Items in items.
     * The items array may be modified by the caller afterwards without
     * affecting this src.CargoBox, and it will not be modified by this
     * constructor.
     *
     * @param items must not be null; non-null elements are added to the
     *              constructed src.CargoBox
     */
    public CargoBox(Item[] items) {
        // TO DO
        // initialize items as empty arrayList if the input array is null,
        // otherwise, create an arrayList with an inital capacity matching the input array's length
        this.items = (items == null) ? new ArrayList<>() : new ArrayList<>(items.length);

        if (items != null){ // If items is not null, add it
            for (Item i : items) { // checking all the items
                if (i != null){ //if not null? add into the list
                    this.items.add(i);
                }
            }
        }
    }

    /* Modifiers */

    /**
     * Adds an src.Item e to this src.CargoBox if e is not null; does not modify this
     * src.CargoBox otherwise. Returns true if e is not null, false otherwise.
     *
     * @param e an item to be added to this src.CargoBox
     * @return true if e is not null, false otherwise
     */
    public boolean add(Item e) {
        // TO DO
        return (e != null) ? items.add(e) : false;
    } // adding the item if its not null,
      // return true if its added and false if its not

    /**
     * Adds all non-null Items in items to this src.CargoBox.
     *
     * @param items contains the src.Item objects to be added to
     *              this src.CargoBox; must not be null (but may contain null)
     * @return true if at least one element of items is non-null;
     * false otherwise
     */
    public boolean addAll(Item[] items) {
        // TO DO
        // go through the arays, get non-null elements + add them to the items list
        // return true if the non-null were added, if not, FALSE
        long count = Arrays.stream(items).filter(item -> item != null)
                . filter(this.items::add).count();
        return count > 0;
    }
    /**
     * Empties this src.CargoBox to a src.CargoBox that contains 0 Items.
     */
    public void empty() {
        // TO DO
        items.clear();
    }


    /**
     * Removes certain Items from this src.CargoBox. Exactly those Items are kept
     * whose weight in grammes is less than or equal to the specified maximum
     * weight in grammes.
     *
     * @param maxItemWeightInGrammes the maximum weight in grammes for the
     *                               Items that are kept
     */
    public void keepOnlyItemsWith(int maxItemWeightInGrammes) {
        // TO DO
        for (int i = items.size() - 1; i >= 0; i--) {
            if (items.get(i).getWeightInGrammes() > maxItemWeightInGrammes) {
                items.remove(i);
            }
        }

    }

    /* Accessors */

    /**
     * Returns the number of non-null Items in this src.CargoBox.
     *
     * @return the number of non-null Items in this src.CargoBox
     */
    public int numberOfItems() {
        // TO DO
        return items.size();
    }

    /**
     * Returns the total weight of the Items in this src.CargoBox.
     *
     * @return the total weight of the Items in this src.CargoBox.
     */
    public int totalWeightInGrammes() {
        // TO DO
        return items.stream() // summing the weight of all non num items
                .filter(item -> item != null)
                .mapToInt(Item::getWeightInGrammes).sum();
    }

    /**
     * Returns the average weight in grammes of the (non-null) Items
     * in this src.CargoBox. In case there is no src.Item in this src.CargoBox,
     * -1.0 is returned.
     * <p>
     * For example, if this src.CargoBox has the contents
     * new src.Item("clock", 400)
     * and
     * new src.Item("textbook", 395),
     * the result is: 397.5
     *
     * @return the average length of the Items in this src.CargoBox,
     * or -1.0 if there is no such src.Item.
     */
    public double averageWeightInGrammes() {
        // TO DO
        int totalWeight = 0;
        int validItemCount = 0;

        for (Item item : items) { // only consider non null items
            if (item != null) {
                totalWeight += item.getWeightInGrammes();
                validItemCount++;
            }
        }
        return (validItemCount > 0) ? (double) totalWeight / validItemCount : -1.0;
    }

    /**
     * Returns the greatest src.Item in this src.CargoBox according to the
     * natural ordering of src.Item given by its compareTo method;
     * null if this src.CargoBox does not contain any src.Item objects
     *
     * @return the greatest src.Item in this src.CargoBox according to the
     *  natural ordering of src.Item given by its compareTo method;
     *  null if this src.CargoBox does not contain any src.Item objects
     */
    public Item greatestItem() {
        // TO DO
        if (items.isEmpty()){
            return null;
        }

        Item grestest = items.get(0);
        for (Item item : items){
            if (item != null && item.compareTo(grestest) > 0){
                grestest = item;
            }
        }
        return grestest;
    }

    /**
     * Returns a new src.CargoBox with exactly those Items of this src.CargoBox
     * whose weight is less than or equal to the specified method parameter.
     * Does not modify this src.CargoBox.
     *
     * @param maxItemWeightInGrammes the maximum weight in grammes for the
     *  Items in the new src.CargoBox
     * @return a new src.CargoBox with exactly those Items of this src.CargoBox
     *  whose weight is less than or equal to the specified method parameter
     */
    public CargoBox makeNewCargoBoxWith(int maxItemWeightInGrammes) {
        // TO DO
        CargoBox newBox = new CargoBox();

        for (Item item : items){
            if (item != null && item.getWeightInGrammes() <= maxItemWeightInGrammes){
                newBox.add(item); // add item to newBox if it meet the weight condition
            }
        }
        return newBox;
    }

    /**
     * Returns a string representation of this src.CargoBox. The string
     * representation consists of a list of the src.CargoBox's contents,
     * enclosed in square brackets ("[]"). Adjacent Items are
     * separated by the characters ", " (comma and space). Items are
     * converted to strings as by their toString() method. The
     * representation does not mention any null references.
     *
     * So for
     *
     * src.Item i1 = new src.Item("Pen", 15);
     * src.Item i2 = new src.Item("Letter", 20);
     * src.Item i3 = null;
     * src.Item[] items = { i1, i2, i3, i1 };
     * src.CargoBox k = new src.CargoBox(items);
     *
     * the call k.toString() will return one of the three following Strings:
     *
     * "[(Pen, 15g), (Pen, 15g), (Letter, 20g)]"
     * "[(Pen, 15g), (Letter, 20g), (Pen, 15g)]"
     * "[(Letter, 20g), (Pen, 15g), (Pen, 15g)]"
     *
     * @return a String representation of this src.CargoBox
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        // TO DO
        List<String> itemString = new ArrayList<>();
        for (Item item : items){
            if (item != null){
                itemString.add(item.toString()); //only adding non-null items
            }
        }
        return "[" + String.join(", ", itemString) + "]";
    }

    /* class methods */

    /**
     * Class method to return a src.CargoBox with the highest total weight from an
     * array of CargoBoxs. If we have an array with a src.CargoBox of 3000 grammes
     * and a src.CargoBox with 4000 grammes, the src.CargoBox with 4000 grammes is
     * returned.
     *
     * Entries of the array may be null, and your method should work also in
     * the presence of such entries. So if in the above example we had an
     * additional third array entry null, the result would be exactly the same.
     *
     * If there are several CargoBoxs with the same weight, it is up to the
     * method implementation to choose one of them as the result (i.e., the
     * choice is implementation-specific, and method users should not rely on
     * any particular behaviour).
     *
     * @param CargoBoxs must not be null, but may contain null
     * @return one of the CargoBoxs with the highest total weight among all
     *  CargoBoxs in the parameter array; null if there is no non-null
     *  reference in CargoBoxs
     */
    public static CargoBox heaviestCargoBox(CargoBox[] CargoBoxs) {
        // TO DO
       CargoBox heaviestBox =  null;
       int maxWeight = 0; // max weight during iteration

       for (CargoBox box : CargoBoxs){ // loop through cargoBox
           if (box != null){ //only carry on if src.CargoBox is not null
               int boxWeight = box.totalWeightInGrammes(); //get total weight of src.CargoBox
               if (heaviestBox == null || boxWeight > maxWeight){
                   heaviestBox = box; //update heaviestBox weight
                   maxWeight = boxWeight; //update maxWeight
               }
           }
       }
       return heaviestBox; // return null if all entries are null,
                            // or the heaviest non-null src.CargoBox
    }
}
