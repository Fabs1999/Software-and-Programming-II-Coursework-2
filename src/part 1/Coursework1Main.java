package src;


import java.util.Objects;

/**
 * Driver class for the src.CargoBox class of Coursework Part 1
 * in the Software and Programming II module at BBK in 2024/25.
 *
 * @author Carsten Fuhs
 */
public class Coursework1Main {

    /* The following is a tiny "home-grown" testing framework.
     * We will see a more advanced framework, JUnit, later in the module.
     */

    /** Index value for the next test. */
    private static int testNo = 1;

    /** Number of passed tests. */
    private static int passes = 0;

    /** Number of failed tests. */
    private static int fails = 0;

    /** Output for successful test. */
    private static final String YEA = "OK    "; //"PASSED";

    /** Output for unsuccessful test. */
    private static final String NAY = "FAILED";

    /**
     * Acceptable distance from expected value for double values,
     * should be slightly above 0.
     */
    private static final double DELTA = 1e-9;

    /**
     * Tests two int values for equality.
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testIntEqual(String description, int expected, int actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            expected == actual);
    }

    /**
     * Tests two long values for equality.
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testLongEqual(String description, long expected, long actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            expected == actual);
    }

    /**
     * Tests two double values for equality (up to a small "delta").
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testDoubleEqual(String description, double expected, double actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            expected - DELTA <= actual && actual <= expected + DELTA);
        // small rounding errors are ok
    }

    /**
     * Tests two Objects for equality. Works for Object and all its subclasses
     * (String, Product, ...).
     *
     * Side effects: screen output of test result and increment of static
     * counter variables according to result.
     *
     * @param description  to be used as part of the screen output
     * @param expected  the expected value
     * @param actual  the actual value
     */
    public static void testObjectEqual(String description, Object expected, Object actual) {
        sideEffectsForTest(description, expected + "", actual + "",
            Objects.equals(expected, actual));
    }

    /**
     * Helper method for the side effects of the tests for different data types
     * (here already converted to Strings): screen output and increment of
     * static counter variables.
     *
     * @param description  description of the test to be printed
     * @param expected  String representation of the expected value
     * @param actual  String representation of the actual value
     * @param result  true: test has passed; false: test has failed
     */
    private static void sideEffectsForTest(String description, String expected, String actual, boolean result) {
        String output;
        if (result) {
            passes++;
            output = YEA;
        } else {
            fails++;
            output = NAY;
        }
        System.out.println(output + " - Test " + testNo + ": " + description
            + ", expected: " + expected + ", actual: " + actual);
        testNo++;
    }

    /* The code to test our src.CargoBox in particular starts here. */

    /**
     * Constants for use in the tests.
     */
    private static final Item ITEM1 = new Item("Pen", 35);
    private static final Item ITEM2 = new Item("Face mask", 20); 
    private static final Item ITEM3 = new Item("Kilogramme", 1000);
    private static final Item ITEM4 = new Item("Soda", 400);
    private static final Item ITEM5 = new Item("Water", 395);
    private static final Item ITEM6 = new Item("Lemonade", 400);
    private static final Item ITEM7 = new Item("Kilo", 1000);
    private static final Item ITEM8 = new Item("Book", 120);

    /* Methods to create suitably constructed and modified src.CargoBox objects. */

    /**
     * @return a new empty src.CargoBox
     */
    private static CargoBox makeEmptyCargoBox() {
        return new CargoBox();
    }

    /**
     * @return a src.CargoBox to which ITEM1 has been added
     */
    private static CargoBox makeAddOneItemCargoBox() {
        CargoBox k = makeEmptyCargoBox();
        k.add(ITEM1);
        return k;
    }

    /**
     * @return a src.CargoBox to which ITEM8 has been added twice
     */
    private static CargoBox makeAddTwoItemSameCargoBox() {
        CargoBox k = makeEmptyCargoBox();
        k.add(ITEM8);
        k.add(ITEM8);
        return k;
    }

    /**
     * @return a src.CargoBox to which ITEM8, null, ITEM8 have been added
     */
    private static CargoBox makeAddTwoItemSameAndNullCargoBox() {
        CargoBox k = makeEmptyCargoBox();
        k.add(ITEM8);
        k.add((null));
        k.add(ITEM8);
        return k;
    }

    /**
     * @return a src.CargoBox to which ITEM1, null, ITEM2 have been added
     */
    private static CargoBox makeAddTwoItemAndNullCargoBox() {
        CargoBox k = makeEmptyCargoBox();
        k.add(ITEM1);
        k.add((null));
        k.add(ITEM2);
        return k;
    }



    /**
     * @return a src.CargoBox constructed with ITEM1, null, ITEM2 in the argument
     *  array
     */
    private static CargoBox makeConstructorTwoItemAndNullCargoBox() {
        Item[] items = { ITEM1, null, ITEM2 };
        CargoBox k = new CargoBox(items);
        return k;
    }


    /**
     * @return a src.CargoBox on which the keepOnlyItemsWith() mutator has been
     *  called to remove some items
     */
    private static CargoBox makeKeepCargoBox() {
        Item[] items = { ITEM3, null, ITEM4, ITEM5, ITEM6, ITEM7, ITEM8, null, null, ITEM8  };
        CargoBox k = new CargoBox(items);
        k.add(ITEM2);
        k.keepOnlyItemsWith(400);
        return k;
    }

    /**
     * @return an array with two CargoBoxs: the first one has ITEM1, ITEM2,
     *  and the second one has ITEM3
     */
    private static CargoBox[] makeTwoCargoBoxs() {
        return new CargoBox[] { new CargoBox(new Item[] { ITEM1, ITEM2 }),
                                new CargoBox(new Item[] { ITEM3 })};
    }

    /**
     * Main method that drives the tests.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
        CargoBox cargo;
        cargo = makeEmptyCargoBox();
        testObjectEqual("toString", "[]", cargo.toString());
        cargo = makeEmptyCargoBox();
        testObjectEqual("greatestItem", null, cargo.greatestItem());
        cargo = makeEmptyCargoBox();
        testIntEqual("numberOfItems", 0, cargo.numberOfItems());
        cargo = makeEmptyCargoBox();
        testIntEqual("makeNewCargoBoxWith", 0, cargo.makeNewCargoBoxWith(120).numberOfItems());


        cargo = makeAddOneItemCargoBox();
        testObjectEqual("toString", "[" + ITEM1 + "]", cargo.toString());
        cargo = makeAddOneItemCargoBox();
        testObjectEqual("greatestItem", ITEM1, cargo.greatestItem());
        cargo = makeAddOneItemCargoBox();
        testIntEqual("numberOfItems", 1, cargo.numberOfItems());
        cargo = makeAddOneItemCargoBox();
        testIntEqual("makeNewCargoBoxWith", 1, cargo.makeNewCargoBoxWith(120).numberOfItems());
        cargo = makeAddOneItemCargoBox();
        testIntEqual("makeNewCargoBoxWith", 0, cargo.makeNewCargoBoxWith(10).numberOfItems());


        cargo = makeAddTwoItemSameCargoBox();
        testObjectEqual("toString", "[" + ITEM8 + ", " + ITEM8 + "]", cargo.toString());
        cargo = makeAddTwoItemSameCargoBox();
        testObjectEqual("greatestItem", ITEM8, cargo.greatestItem());
        cargo = makeAddTwoItemSameCargoBox();
        testIntEqual("numberOfItems", 2, cargo.numberOfItems());
        cargo = makeAddTwoItemSameCargoBox();
        testIntEqual("makeNewCargoBoxWith", 2, cargo.makeNewCargoBoxWith(120).numberOfItems());


        cargo = makeAddTwoItemSameAndNullCargoBox();
        testObjectEqual("toString", "[" + ITEM8 + ", " + ITEM8 + "]", cargo.toString());

        cargo = makeAddTwoItemAndNullCargoBox();
        testObjectEqual("greatestItem", ITEM1, cargo.greatestItem());
        cargo = makeAddTwoItemAndNullCargoBox();
        testIntEqual("numberOfItems", 2, cargo.numberOfItems());
        cargo = makeAddTwoItemAndNullCargoBox();





        cargo = makeConstructorTwoItemAndNullCargoBox();
        testObjectEqual("greatestItem", ITEM1, cargo.greatestItem());
        cargo = makeConstructorTwoItemAndNullCargoBox();
        testIntEqual("numberOfItems", 2, cargo.numberOfItems());
        cargo = makeConstructorTwoItemAndNullCargoBox();




        cargo = makeEmptyCargoBox();
        testObjectEqual("toString", "[]", cargo.toString());
        cargo = makeEmptyCargoBox();
        testObjectEqual("greatestItem", null, cargo.greatestItem());
        cargo = makeEmptyCargoBox();
        testIntEqual("numberOfItems", 0, cargo.numberOfItems());
        cargo = makeEmptyCargoBox();


        cargo = makeKeepCargoBox();
        testIntEqual("greatestItem", 400, cargo.greatestItem().getWeightInGrammes());
        cargo = makeKeepCargoBox();
        testIntEqual("numberOfItems", 6, cargo.numberOfItems());
        cargo = makeKeepCargoBox();
        testIntEqual("makeNewCargoBoxWith", 3, cargo.makeNewCargoBoxWith(120).numberOfItems());


        testObjectEqual("heaviestCargoBox", null, CargoBox.heaviestCargoBox(new CargoBox[0]));

        CargoBox[] cargoes = makeTwoCargoBoxs();
        testIntEqual("heaviestCargoBox", 1000, CargoBox.heaviestCargoBox(cargoes).totalWeightInGrammes());

        System.out.println();
        System.out.println(YEA + ": " + passes);
        System.out.println(NAY + ": " + fails);
    }
}
