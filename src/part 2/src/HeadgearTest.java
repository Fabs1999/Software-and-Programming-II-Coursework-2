package src;

public class HeadgearTest {

    public static void main(String [] args) throws IllegalArgumentException, IllegalAccessException {
        // test crown
        Headgear crown = new Crown(5);
        System.out.println(crown);

        //test BobbleHat
        Headgear bobbleHat = new BobbleHat(1.5,10);
        System.out.println(bobbleHat);

        //test ScooterHelmet
        Headgear scooterHelmet = new ScooterHelmet(2.0,true);
        System.out.println(scooterHelmet);


        Headgear[] headgearArray = {crown, scooterHelmet, bobbleHat};
        System.out.println("Total Value is: " + Headgear.totalValue(headgearArray));
    }
}
