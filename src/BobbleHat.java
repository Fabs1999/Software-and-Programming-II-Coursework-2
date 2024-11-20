package src;

public class BobbleHat extends ProtectiveHeadgear {
    private int bobbleDiameter;

    /**
     * Creates a Bobble hat with a specific protection factor and bobble diameter.
     *
     * @param protectionFactor the level of protection this hat offers must be NON-NEGATIVE
     * @param bobbleDiameter the diameter of the bobble in millimeters - and it has to be positive
     * @throws IllegalArgumentException if the bobble diameter is invalid.
     * @throws IllegalAccessException just in case if it's invalid.
     */

    public BobbleHat(double protectionFactor, int bobbleDiameter) throws IllegalArgumentException, IllegalAccessException {
        super(protectionFactor);
        if (bobbleDiameter <= 0){
            throw new IllegalArgumentException("the Bobble diameter has to be positive!");
        }
        this.bobbleDiameter = bobbleDiameter;
    }

    public double computeValue(){
        return bobbleDiameter * 4 * getProtectionFactor(); // return 0, as it uses a different value logic
    }

    @Override
    public String toString() {
        return "BobbleHat with bobble diameter: " + bobbleDiameter +
                ", protection factor: " + getProtectionFactor() +
                ", value: " + computeValue();
    }


    public int getWeight() {
        throw new UnsupportedOperationException("Weight is N/A for bobbleHat");
    }


    public String getType() {
        return "";
    }


    public boolean isSafetyCertified() {
        return false; // alays false as bobble hats are not for safety
    }


    public double valueComputed() {
        return 0;
    }
}
