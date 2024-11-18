package src;

public interface Headgear {

    /**
     * First we need to get the weight of headgear in grams.
     * @return the weight in grams
     */
    int getWeight();

    /**
     * now we need to the type of the headgear.
     * @return the type as a string.
     */
    String getType();

    /**
     * check if the headear is Safety Certified.
     * @return has to be true if it is safety certfied, othewise FALSE.
     */
    boolean isSafetyCertified();
}

