package src;

public class ScooterHelmet extends ProtectiveHeadgear {

    private boolean hasVisor;

    /**
     * Creates a Scooter Helmet with a specific protection factor and visor open
     *
     * @param protectionFactor the level of protection that this helmet offers - must be positive
     * @param hasVisor confirms if the helmet includes a visor
     * @throws IllegalArgumentException if protection factor is invalid.
     * @throws IllegalAccessException if protection factor is invalid.
     */

    public ScooterHelmet(double protectionFactor, boolean hasVisor) throws IllegalArgumentException, IllegalAccessException {
        super(protectionFactor);
        this.hasVisor = hasVisor;
    }
    @Override
    public double computeValue(){
        // calculates the value of this scooter helmet.
        // the value it will depend on the protection and if it has a value.
        int c1= hasVisor ? 160 : 80;
        int c2 = 400;
        return c1 + getProtectionFactor() * c2;
    }

    @Override
    public String toString() {
        return "Scooter Helmet with visor: " + hasVisor + ", protection factor: " +
                getProtectionFactor() + ", value: " + computeValue();
    }


    public int getWeight() {
        return 0;
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
