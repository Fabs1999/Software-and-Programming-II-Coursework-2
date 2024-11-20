package src;

public class Crown implements Headgear{

    private int jewelsQuantity;

    /**
     * Creates a Crown with a specific number of jewels.
     *
     * @param jewelsQuantity the number of jewels in the crown -- must be positive
     * @throws IllegalArgumentException if the number of jewels is negative.
     */
    public Crown(int jewelsQuantity){
        if (jewelsQuantity < 0){
            throw new IllegalArgumentException("The Number of jewels can't be negative.");
        }
        this.jewelsQuantity = jewelsQuantity;
    }


    public int getWeight() {
        return 0;
    }


    public String getType() {
        return "Crown"; // type of headgear
    }


    public boolean isSafetyCertified() {
        return false; // as it's not for safety purposes.
    }


    public double valueComputed(){
        return jewelsQuantity * 200000; // it computes value of the crown
    }

    @Override
    public String toString() {
        return "Crown with " + jewelsQuantity + " jewels, value " + valueComputed();
    } // the crown!!
}
