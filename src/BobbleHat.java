package src;

public class BobbleHat extends ProtectiveHeadgear {
    private int bobbleDiameter;

    public BobbleHat(double protectionFactor, int bobbleDiameter) throws IllegalAccessException {
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
                ", valur: " + computeValue();
    }
}
