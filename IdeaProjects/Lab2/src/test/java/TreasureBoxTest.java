import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TreasureBoxTest {

    @Test
    public void testingTreasureBox () {
        System.out.println("\nTesting Treasure Box Constructors");
        // create an instance using 2 parameter constructor
        TreasureBox testBox1 = new TreasureBox(10, 5);
        // use getters to test num of coins
        assertEquals(5,testBox1.getNumSilverCoins());
        // test total number of points
        assertEquals((int) (1000 * (150 + 7.5 * 5)),(int) (1000 * testBox1.getTotalPoints()));

        // create an instance using 0 parameter constructor
        TreasureBox testBox2 = new TreasureBox();
        // use getters to test num of coins
        assertEquals(0,testBox2.getNumGoldCoins());
        assertEquals(0,testBox2.getNumGoldCoins());
        // test total number of points
        assertEquals(0,(int) testBox2.getTotalPoints());

        // create an instance using 2 parameter constructor
        TreasureBox testBox3 = new TreasureBox(10, -5);
        // use getters to test num of coins
        assertEquals(10,testBox3.getNumGoldCoins());
        assertEquals(-5,testBox3.getNumSilverCoins());
        // test total number of points
        assertEquals((int) (1000 * (150 + 7.5 * -5)),(int) (1000 * testBox3.getTotalPoints()));

    }



    @Test
    public void testingCollectCoins() {
        System.out.println("\nTesting Treasure Box collectCoins");

        // create an instance using 2 parameter constructor
        TreasureBox testBox1 = new TreasureBox(3, 6);
        // collect some coins
        testBox1.collectCoins(2, 3);
        // use getters to test num of coins
        assertEquals(5,testBox1.getNumGoldCoins());
        assertEquals(9,testBox1.getNumSilverCoins());
        // test total number of points
        assertEquals((int) (1000 * (75 + 7.5 * 9)),(int) (1000 * testBox1.getTotalPoints()));
    }




    @Test
    public void testingRemoveGoldCoins() {
        System.out.println("\nTesting Treasure Box removeGoldCoins");

        // create an instance using 2 parameter constructor
        TreasureBox testBox1 = new TreasureBox(12, 8);

        // remove some gold coins
        assertTrue(testBox1.removeGoldCoins(5));
        // use getters to test num of coins
        assertEquals(7,testBox1.getNumGoldCoins());
        assertEquals(8,testBox1.getNumSilverCoins());
        // test total number of points
        assertEquals((int) (1000 * (7 * 15 + 7.5 * 8)),(int) (1000 * testBox1.getTotalPoints()));

        // try removing more gold coins than exist - should return false
        assertFalse(testBox1.removeGoldCoins(15));
        // use getters to test num of coins
        assertEquals(7,testBox1.getNumGoldCoins());
        assertEquals(8,testBox1.getNumSilverCoins());
        // test total number of points
        assertEquals((int) (1000 * (7 * 15 + 7.5 * 8)),(int) (1000 * testBox1.getTotalPoints()));

        // try removing all the rest of the gold coins than exist
        assertTrue(testBox1.removeGoldCoins(7));
        // use getters to test num of coins
        assertEquals(0,testBox1.getNumGoldCoins());
        assertEquals(8,testBox1.getNumSilverCoins());
        // test total number of points
        assertEquals(0,0);
    }




    @Test
    public void testingRemoveSilverCoins() {
        System.out.println("\nTesting Treasure Box removeSilverCoins");

        // create an instance using 2 parameter constructor
        TreasureBox testBox1 = new TreasureBox(3, 10);

        // remove some silver coins
        testBox1.removeSilverCoins(4);
        // use getters to test num of coins
        assertEquals(3,testBox1.getNumGoldCoins());
        assertEquals(6,testBox1.getNumSilverCoins());
        // test total number of points
        assertEquals((int) (1000 * (3 * 15 + 7.5 * 6)),(int) (1000 * testBox1.getTotalPoints()));

        // try removing more silver coins than exist
        testBox1.removeSilverCoins(15);
        // use getters to test num of coins
        assertEquals(3,testBox1.getNumGoldCoins());
        assertEquals(-9,testBox1.getNumSilverCoins());
        // test total number of points
        assertEquals( (int) (1000 * (45 + (7.5 * -9))),(int) (1000 * testBox1.getTotalPoints()));

        // all silver coins and try removing all of them - (boundary conditions)
        testBox1.collectCoins(0,18);
        testBox1.removeSilverCoins(9);
        // use getters to test num of coins
        assertEquals(3,testBox1.getNumGoldCoins());
        assertEquals(0,testBox1.getNumSilverCoins());
        // test total number of points
        assertEquals(45,(int)testBox1.getTotalPoints());
    }



    @Test
    public void testingTradeSilverCoins() {
        System.out.println("\nTesting Treasure Box tradeSilverCoins");

        // create an instance using 2 parameter constructor
        TreasureBox testBox1 = new TreasureBox(3, 2);

        // test trade silver coins when there are silver coins
        assertTrue(testBox1.tradeSilverCoins());
        // use getters to test num of coins
        assertEquals(5,testBox1.getNumGoldCoins());
        assertEquals(0,testBox1.getNumSilverCoins());
        // test total number of points
        assertEquals( (int) (1000 * (5 * 15)),(int) (1000 * testBox1.getTotalPoints()));

        // test trade silver coins when there are 0 silver coins
        assertFalse(testBox1.tradeSilverCoins());
        // use getters to test num of coins
        assertEquals(5,testBox1.getNumGoldCoins());
        assertEquals(0,testBox1.getNumSilverCoins());
        // test total number of points
        assertEquals((int) (1000 * (5 * 15)),(int) (1000 * testBox1.getTotalPoints()));

        // test trade silver coins when there are negative silver coins
        // first remove silver coins
        testBox1.removeSilverCoins(3);
        assertFalse(testBox1.tradeSilverCoins());
        // use getters to test num of coins
        assertEquals(5,testBox1.getNumGoldCoins());
        assertEquals(-3,testBox1.getNumSilverCoins());
        // test total number of points
        assertEquals( (int) (1000 * ((5 * 15)   + (-3 * 7.5))),(int) (1000 * testBox1.getTotalPoints()));
    }




    @Test
    public void testingBalanceBoxes1() {
        System.out.println("\nTesting Treasure Box balanceBoxes - 1");

        // create an instance using 2 parameter constructor
        TreasureBox testBox1 = new TreasureBox(0,-1);
        TreasureBox testBox2 = new TreasureBox(1,1);

        assertTrue(TreasureBox.balanceBoxes(testBox1,testBox2));
        // use getters to test num of coins
        assertEquals(1,testBox1.getNumGoldCoins());
        assertEquals(-1,testBox1.getNumSilverCoins());
        assertEquals(0,testBox2.getNumGoldCoins());
        assertEquals(1,testBox2.getNumSilverCoins());
        // test total number of points
        assertEquals( (int) (1000 * (7.5)),(int) (1000 * testBox1.getTotalPoints()));
        assertEquals((int) (1000 * (7.5)),(int) (1000 * testBox2.getTotalPoints()));
    }




    @Test
    public void testingBalanceBoxes2() {
        System.out.println("\nTesting Treasure Box balanceBoxes 2");
        // second test
        TreasureBox testBox1 = new TreasureBox(0,10);
        TreasureBox testBox2 = new TreasureBox(0,-1);

        assertFalse(TreasureBox.balanceBoxes(testBox1,testBox2));
        // use getters to test num of coins
        assertEquals(0,testBox1.getNumGoldCoins());
        assertEquals(10,testBox1.getNumSilverCoins());
        assertEquals(0,testBox2.getNumGoldCoins());
        assertEquals(-1,testBox2.getNumSilverCoins());
        // test total number of points
        assertEquals((int) (1000 * (75)),(int) (1000 * testBox1.getTotalPoints()));
        assertEquals((int) (1000 * (-7.5)),(int) (1000 * testBox2.getTotalPoints()));
    }


/*
    @Test
    public void testingBalanceBoxes3() {
        System.out.println("\nTesting Treasure Box balanceBoxes 3");

        // third test
        TreasureBox testBox1 = new TreasureBox(5,0);
        TreasureBox testBox2 = new TreasureBox(1,-11);

        assertTrue(TreasureBox.balanceBoxes(testBox1,testBox2));
        // use getters to test num of coins
        assertEquals(1,testBox1.getNumGoldCoins());
        assertEquals(0,testBox1.getNumSilverCoins());
        assertEquals(5,testBox2.getNumGoldCoins());
        assertEquals(-11,testBox2.getNumSilverCoins());
        // test total number of points
        assertEquals( (int) (1000 * (15)),(int) (1000 * testBox1.getTotalPoints()));
        assertEquals((int) (1000 * (75 + (-11*7.5))),(int) (1000 * testBox2.getTotalPoints()));
    }



    @Test
    public void testingBalanceBoxes4() {
        System.out.println("\nTesting Treasure Box balanceBoxes 4");

        TreasureBox testBox1 = new TreasureBox(3,2);
        TreasureBox testBox2 = new TreasureBox(1,-5);

        assertTrue(TreasureBox.balanceBoxes(testBox1,testBox2));
        // use getters to test num of coins
        assertEquals(1,testBox1.getNumGoldCoins());
        assertEquals(2,testBox1.getNumSilverCoins());
        assertEquals(3,testBox2.getNumGoldCoins());
        assertEquals(-5,testBox2.getNumSilverCoins());
        // test total number of points
        assertEquals((int) (1000 * (30)),(int) (1000 * testBox1.getTotalPoints()));
        assertEquals( (int) (1000 * (45 + (-5*7.5))),(int) (1000 * testBox2.getTotalPoints()));
    }
    */

}