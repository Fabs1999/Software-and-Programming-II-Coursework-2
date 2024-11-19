package src;

public class CargoBoxTest {

        public static void main(String [] args) throws IllegalAccessException {

            CargoBox cargoBox = new CargoBox();

            // test to add items
            cargoBox.add(new Item("pen", 55));
            cargoBox.addHeadgear(new Helmet(600,true));

            // test to print contents
            System.out.println("CargoBox contents: " + cargoBox);

            //test to print weights

            System.out.println("Total Item Weight: " + cargoBox.totalWeightInGrammes() + "g");
            System.out.println("Total Headgear weigth: " + cargoBox.totalHeadgearWeight() + "g");

        }
    }