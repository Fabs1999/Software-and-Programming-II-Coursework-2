package src;

public class Helmet implements Headgear {

    private int weightInGrammes;
    private boolean safetyCertified;

    /**
     * With this class the objective was to create a Helmet Object with specific weight
     * and safety certification.
     *
     * @param weightInGrammes
     * @param safetyCertified
     * @throws IllegalAccessException
     */
    public Helmet(int weightInGrammes, boolean safetyCertified) throws IllegalAccessException {
        // Ensuring that the weight is greater than 0
        if (weightInGrammes <= 0) {
            throw new IllegalAccessException("Weight must be > 0");
        }
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
     //Tester!!
    public class HeadgearTest {

        public static void main(String [] args) throws IllegalAccessException {
            // creating a helmet object
            Helmet helmet = new Helmet(500, true);
            // print out the properties
            System.out.println("Weight: " + helmet.getWeight());
            System.out.println("Type: " + helmet.getType());
            System.out.println("Safety Certified: " + helmet.isSafetyCertified());
        }

    }
}


