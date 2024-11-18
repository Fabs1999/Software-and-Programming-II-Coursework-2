package src;

/**
 * This is just a hat class to implement headgear interface.
 */

public class Hat implements Headgear{

    private int weightInGrammes;
    private String material;

    public Hat(int weightInGrammes, String material) throws IllegalAccessException {
        if (weightInGrammes <=0) throw new IllegalAccessException("Weight must be > 0");
        if (material == null || material.isBlank()) throw new IllegalAccessException("Material cannot be null ro blank");
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
}
