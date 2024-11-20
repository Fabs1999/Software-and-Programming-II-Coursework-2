package src;

/**
 * This is just a hat class to implement headgear interface.
 */

public class Hat implements Headgear{

    private int weightInGrammes;
    private String material;

    public Hat(int weightInGrammes, String material) throws IllegalArgumentException {
        // validade the weight is greater than 0
        if (weightInGrammes <=0) {
            throw new IllegalArgumentException("Weight must be > 0");
        } // validade that it's not null or blank
        if (material == null || material.isBlank()){
            throw new IllegalArgumentException("Material cannot be null ro blank");
        }
        // initialize fields with validade values
        this.weightInGrammes = weightInGrammes;
        this.material = material;

    }

    @Override
    public int getWeight() {
        return weightInGrammes;
    }

    @Override
    public String getType() {
        return "Hat";
    }

    @Override
    public boolean isSafetyCertified() {
        return false; // hats are not safety certified!!
    }

    @Override
    public double valueComputed() {
        return 0;
    }
}
