package src;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

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
public class CargoBox {
    // TO DO
    private ArrayList<Item> items;
    // new field for Headgear
    private ArrayList<Headgear> headgearList;

    /* Constructors */

    /**
     * Constructs a new src.CargoBox without any Items.
     */
    public CargoBox() {
        this.items = new ArrayList<>(); // adding each non-null item to src.CargoBox
        this.headgearList = new ArrayList<>(); // initializing headgear
    }

    /**
     * Adding a Headgear Object to the CargoBox if it's not null
     *
     * @param headgear the Headgear object to be added
     * @return true if the Headgear was added, false otherwise
     */
    public boolean addHeadgear(Headgear headgear) {
        if (headgear != null) { // if not null, add it
            headgearList.add(headgear);
            return true;
        }
        return false;
    } // return string representation of headgear

    // calculate total weight of all headgear
    public int totalHeadgearWeight() {
        int totalWeight = 0;
        for (Headgear gear : headgearList) {
            totalWeight += gear.getWeight();
        }
        return totalWeight;
    }

    /**
     * Returns a string representation of this src.CargoBox.
     *
     * @return a String representation of this src.CargoBox
     * @see Object#toString()
     */

    /**
     * Constructs a new src.CargoBox containing the non-null Items in items.
     *
     * @param items must not be null; non-null elements are added to the
     *              constructed src.CargoBox
     */
    public CargoBox(Item[] items) {
        this.items = new ArrayList<>();
        //initialize items as empty ArrayList

        if (items != null) { // if not null, add them!
            for (Item item : items) {
                if (item != null) {
                    this.items.add(item);
                }
            }
        }
    }

    /* Modifiers */

    /**
     * Adds an src.Item e to this src.CargoBox if e is not null; does not modify this
     * src.CargoBox otherwise.
     *
     * @param itemToAdd item to be added to this src.CargoBox
     * @return true if e is not null, false otherwise
     */
    public boolean add(Item itemToAdd) {
        if (itemToAdd != null) { // if not null, add it
            this.items.add(itemToAdd);
            return true;
        }
        return false;
    }

    public boolean addAllItems(Item[] itemsToAdd) throws IllegalAccessException {
        if (itemsToAdd == null){ // using week 8 material to make sure thing will run smoothly
            throw new IllegalAccessException("Input array can't be null");
        }
        if (itemsToAdd != null) { // ensuring that is not null
            for (Item item : itemsToAdd) {
                if (item != null) { // skip null items in the array
                    this.items.add(item);
                    added = true;
                }
            }
        }
        return added; // only return if they were added
    }

    public int numberOfItems() {

        return items.size();
    }

    public CargoBox makeNewCargoBoxWith(int maxWeightInGrammes) {
        CargoBox newBox = new CargoBox(); // initialize a new empty cargobox
        for (Item item : items) {
            // check if the item is non-null and its weight is correct
            if (item != null && item.getWeightInGrammes() <= maxWeightInGrammes) {
                newBox.add(item); // add it
            }
        }
        return newBox; // the finilized cargobox
    }

    @Override
    public String toString() {
        return items.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    /**
     * Adds all non-null Items in items to this src.CargoBox.
     *
     * @param items contains the src.Item objects to be added
     * @return true if at least one element of items is non-null; false otherwise
     */
    public boolean addAll(Item[] items) {
        long count = Arrays.stream(items)
                .filter(item -> item != null) // exclude non-null items
                .filter(this.items::add) // add item and keep filter to keep only the good ones
                .count(); // count the number of added items
        return count > 0; // return true is
    }

    /**
     * Empties this src.CargoBox to a src.CargoBox that contains 0 Items.
     */
    public void empty() {

        items.clear();
    }

    /**
     * Removes certain Items from this src.CargoBox.
     *
     * @param maxItemWeightInGrammes the maximum weight in grammes for the Items
     *                               that are kept
     */
    public void keepOnlyItemsWith(int maxItemWeightInGrammes) {
        items.removeIf(item -> item == null || item.getWeightInGrammes() > maxItemWeightInGrammes);
    }

    /* Accessors */

    /**
     * Returns the total weight of the Items in this src.CargoBox.
     *
     * @return the total weight of the Items in this src.CargoBox.
     */
    public int totalWeightInGrammes() {
        return items.stream()
                .filter(Objects::nonNull) // remove null items
                .mapToInt(Item::getWeightInGrammes)// remove items execeeding max weight
                .sum();
    }

    /**
     * Returns the average weight in grammes of the (non-null) Items
     * in this src.CargoBox.
     *
     * @return the average length of the Items in this src.CargoBox,
     * or -1.0 if there is no such src.Item.
     */
    public double averageWeightInGrammes() {
        int totalWeight = 0;
        int validItemCount = 0;

        for (Item item : items) {
            if (item != null) {
                totalWeight += item.getWeightInGrammes(); // add item's weight to the total
                validItemCount++;
            }
        } // return average weight, or -1.0 if there are no valid items
        return (validItemCount > 0) ? (double) totalWeight / validItemCount : -1.0;
    }

    /**
     * Returns the greatest src.Item in this src.CargoBox according to the
     * natural ordering of src.Item given by its compareTo method;
     * null if this src.CargoBox does not contain any src.Item objects
     *
     * @return the greatest src.Item in this src.CargoBox
     */
    public Item greatestItem() {
        return items.stream()
                .filter(Objects::nonNull) // exclude null items
                .max(Item::compareTo) // find the max item using natual ordering of Item class
                .orElse(null); // return null if no max is found
    }

    /* Class methods */

    /**
     * Class method to return a src.CargoBox with the highest total weight from an
     * array of CargoBoxs.
     *
     * @param CargoBoxs must not be null, but may contain null
     * @return one of the CargoBoxs with the highest total weight among all
     *         CargoBoxs in the parameter array; null if there is no non-null
     *         reference in CargoBoxs
     */
    public static CargoBox heaviestCargoBox(CargoBox[] CargoBoxs) {
        CargoBox heaviestBox = null;
        int maxWeight = 0;

        for (CargoBox box : CargoBoxs) {
            if (box != null) {
                int boxWeight = box.totalWeightInGrammes();
                if (heaviestBox == null || boxWeight > maxWeight) {
                    heaviestBox = box;
                    maxWeight = boxWeight;
                }
            }
        }
        return heaviestBox;
    }
}
