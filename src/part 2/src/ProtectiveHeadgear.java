package src;

public abstract class ProtectiveHeadgear implements Headgear {
    private double protectionFactor;

    /**
     * Constructs a protectiveHeadgear with the specific protection factor.
     *
     * @param protectionFactor
     * @throws IllegalAccessException if the protection factor is negative
     */

    public ProtectiveHeadgear(double protectionFactor) throws IllegalAccessException {
        setProtectionFactor(protectionFactor);
    }

    public double setProtectionFactor(double protectionFactor) throws IllegalArgumentException {
        if (protectionFactor < 0) {
            throw new IllegalArgumentException("Protection factor cannot be negative!");
        }
        this.protectionFactor = protectionFactor;
        return protectionFactor;
    }


    // gets the protection factor of the headgear
    public double getProtectionFactor() {
        return protectionFactor;
    }


    public abstract double computeValue();

    @Override
    public String toString() {
        return "Protection Factor: " + protectionFactor;
    }
}