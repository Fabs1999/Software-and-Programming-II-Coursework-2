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
    public Helmet(int weightInGrammes, boolean safetyCertified) throws IllegalArgumentException{
        // Ensuring that the weight is greater than 0
        if (weightInGrammes <= 0) {
            throw new IllegalArgumentException("Weight must be > 0");
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

    @Override
    public double valueComputed() {
        return 0;
    }
    
}


