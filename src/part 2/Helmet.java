package src;

public class Helmet implements Headgear {

    private int weightInGrammes;
    private boolean safetyCertified;

    public Helmet(int weightInGrammes, boolean safetyCertified) throws IllegalAccessException {
        if (weightInGrammes <= 0) throw new IllegalAccessException("Weight must be > 0");
        this.weightInGrammes = weightInGrammes;
        this.safetyCertified = safetyCertified;
    }

    @Override
    public int getWeight() {
        return this.weightInGrammes;
    }

    @Override
    public String getType() {

        return "Helmet";
    }

    @Override
    public boolean isSafetyCertified() {

        return this.safetyCertified;
    }

    public class HeadgearTest {

        public static void main(String [] args) throws IllegalAccessException {
            Helmet helmet = new Helmet(500, true);

            System.out.println("Weight: " + helmet.getWeight());
            System.out.println("Type: " + helmet.getType());
            System.out.println("Safety Certified: " + helmet.isSafetyCertified());
        }

    }
}


