package src;

public class ScooterHelmet extends ProtectiveHeadgear {

    private boolean hasVisor;

    public ScooterHelmet(double protectionFactor, boolean hasVisor) throws IllegalArgumentException, IllegalAccessException {
        super(protectionFactor);
        this.hasVisor = hasVisor;
    }
    @Override
    public double computeValue(){
        int c1= hasVisor ? 160 : 80;
        int c2 = 400;
        return c1 + getProtectionFactor() * c2;
    }

    @Override
    public String toString() {
        return "Scooter Helmet with visor: " + hasVisor + ", protection factor: " +
                getProtectionFactor() + ", value: " + computeValue();
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public String getType() {
        return "";
    }

    @Override
    public boolean isSafetyCertified() {
        return false;
    }

    @Override
    public double valueComputed() {
        return 0;
    }
}
