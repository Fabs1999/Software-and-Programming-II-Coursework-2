import src.Headgear;

public abstract class ProtectiveHeadgear implements Headgear {
    private double protectionFactor;

    public ProtectiveHeadgear(double protectionFactor){
        setProtectionFactor(protectionFactor);
    }

    public double setProtectionFactor(double protectionFactor){
        if (protectionFactor < 0){
            throw new IllegalAccessException("Protection factor cannot be negative!")
        }
        return protectionFactor;
    }
    public double getProtectionFactor(){
        return protectionFactor;
    }

    @Override
    public String toString() {
        return "Protection Factor: " + protectionFactor;
    }
}
