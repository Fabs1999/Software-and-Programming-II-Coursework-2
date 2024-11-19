package src;

public class Crown implements Headgear{

    private int jewelsQuantity;

    public Crown(int jewelsQuantity){
        if (jewelsQuantity < 0){
            throw new IllegalArgumentException("The Number of jewels can't be negative.");
        }
        this.jewelsQuantity = jewelsQuantity;
    }

    @Override
    public int getWeight() {
        return 0;
    }


    public String getType() {
        return "Crown";
    }

    @Override
    public boolean isSafetyCertified() {
        return false;
    }

    @Override
    public double valueComputed(){
        return jewelsQuantity * 200000;
    }

    @Override
    public String toString() {
        return "Crown with " + jewelsQuantity + " jewels, value " + valueComputed();
    }
}
