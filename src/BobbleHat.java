package src;

public class BobbleHat extends ProtectiveHeadgear {
    private int bobbleDiameter;

    public BobbleHat(double protectionFactor, int bobbleDiameter) throws IllegalArgumentException {
        super(protectionFactor);
        if (bobbleDiameter <= 0){
            throw new IllegalArgumentException("the Bobble diameter has to be positive!");
        }
        this.bobbleDiameter = bobbleDiameter;
    }

    public double computeValue(){
        return bobbleDiameter * 4 * getProtectionFactor();
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
        return false;
    }


    public double valueComputed() {
        return 0;
    }
}
