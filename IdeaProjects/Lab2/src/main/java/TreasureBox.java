public class TreasureBox {
    /**
     * <h1>Lab0D</h1>
     * <h2>CISC 181-052L Spring 2021</h2>
     * <h3>University of Delaware</h3>
     * <p>
     * The Lab2 program implements an application that has us work with creating
     * different classes and the different states you can have them to learn when it is
     * appropriate to have a method public or private and when we need a method to be static.
     * We also worked with constants and using this to reference variables to keep it consistent.
     *
     * @author London Kumar
     * @since 2021-03-14
     */

    /**
     * Pts_per_gold_coin is a constant for how many points you get per gold coin
     * Pts_per_silver_coin is a constant for how many points you get per silver coin
     * gold_coins is a double of how many gold coins you have
     * silver_coins is a double of how many silver coins you have
     * totalCoins is the amount of coins you have in total
     */
    public static final double  PTS_PER_GOLD_COIN = 15.0;
    public static final double PTS_PER_SILVER_COIN = 7.5;
    private double gold_coins;
    private double silver_coins;
    private double totalCoins;

    /**
     * This method references totalCoins at the global scope and has it set to the total points with
     * the gold coins times points per gold coin and the same thing with silver to get the total. This is
     * method has no return statement because it is used to just update the total points
     */
    private void updateTotalPoints(){
        this.totalCoins = (this.PTS_PER_GOLD_COIN * this.gold_coins) + (this.PTS_PER_SILVER_COIN * this.silver_coins);
    }

    /**
     * This constructor allows  you to pass the amount of gold and silver coins
     * the treasure box starts off with
     * @param gold_coins gold_coins is a double of how many gold coins you have
     * @param silver_coins gold_coins is a double of how many silver coins you have
     * calls the private method update method to get the total with the amounts passed
     */
    public TreasureBox(double gold_coins, double silver_coins){
        this.gold_coins = gold_coins;
        this.silver_coins = silver_coins;
        updateTotalPoints();
    }

    /**
     * This constructor is a default that references the constructor above and passes 0 and 0 for
     * silver and gold coins and then calls updateTotalPoints to update the total
     */
    public TreasureBox(){
        this(0,0);
        updateTotalPoints();
    }

    /**
     * This method gets the total coins the treasure box has
     * @return double totalCoins, the amount of coins in the treasure box
     */
    public double getTotalPoints(){
        return this.totalCoins;
    }

    /**
     * This method gets the number of gold coins a treasure box has
     * @return double gold_coins, the number of gold coins in the treasure box
     */
    public double getNumGoldCoins(){
        return this.gold_coins;
    }

    /**
     * This method gets the number of silver coins a treasure box has
     * @return double gold_coins, the number of silver coins in the treasure box
     */
    public double getNumSilverCoins(){
        return this.silver_coins;
    }

    /**
     * This method gets the amount of gold and silver coins you want to
     * add to the treasure box
     * @param addGoldCoins ,This double represents the amount of gold coins you want to
     *                     have added
     * @param addSilverCoins ,This double represents the amount of silver coins you want to
     *                     have added
     * Then it calls the updateTotalPoints to update the total
     */
    public void collectCoins(int addGoldCoins, int addSilverCoins){
        this.gold_coins += addGoldCoins;
        this.silver_coins += addSilverCoins;
        updateTotalPoints();
    }

    /**
     * This method removes gold coins and makes sure that it removes the amount of gold coins
     * that the treasure box has only
     * @param removeGoldCoins , is a double that is the amount of gold coins they want to
     *                        remove
     * @return true or false, it returns true if it was able to remove the gold coins
     * and returns false if the user asks from more gold coins than it doesn't have
     * and then updates the total points the box has
     */
    public boolean removeGoldCoins(int removeGoldCoins){
        //checking to make sure if the amount they want to remove is less than
        //the amount they have so they don't remove more than the box has have
        if(this.gold_coins < removeGoldCoins){
            return false;
        }else{
            this.gold_coins -= removeGoldCoins;
            updateTotalPoints();
            return true;
        }
    }

    /**
     * This method removes the amount of silver coins in the treasurebox and then updates total points
     * @param removeSilverCoins, is a int that is the amount of silver coins that is supposed to be
     *                           removed
     */
    public void removeSilverCoins(int removeSilverCoins){
        this.silver_coins =  this.silver_coins - removeSilverCoins;
        updateTotalPoints();
    }

    /**
     * This method takes a silver coin and transfers it to gold coins
     * @return true or false. This function returns false if the the amount of silver is less than silver and
     * the transfer doesn't happen. If there amount of silver is greater than 0, the transfer commences and the function
     * returns true.
     */
    public boolean tradeSilverCoins(){
        if(this.silver_coins <= 0){
            return false;
        }else{
            this.gold_coins += this.silver_coins;
            this.silver_coins = 0;
            updateTotalPoints();
            return true;
        }
    }

    /**
     * This method takes 2 treasure box objects and checks the amount of gold and total points to
     * balance out the box with the negative amount. The only things getting transferred is gold.
     * @param TreasureBox box1, a treasure box object
     * @param TreasureBox box2, a treasure box object
     * @return true if the balance happens and false if it doesn't
     */
    public static boolean balanceBoxes(TreasureBox box1, TreasureBox box2){
        int transferOfGold = 1;

        if(box1.getTotalPoints() < 0 || box2.getTotalPoints() < 0){
            //Transferring from box 2 to 1 as long as it fits the requirement
            if(box1.getTotalPoints() < box2.getTotalPoints() && box1.getTotalPoints() < 0 && box2.getNumGoldCoins() > 0){
                //transferring gold as long as it fits the requirements
                while((box2.getNumGoldCoins() >= 0) && (box2.getTotalPoints()-PTS_PER_GOLD_COIN >= box1.getTotalPoints()+ PTS_PER_GOLD_COIN)&& (box1.getTotalPoints() < 0)){
                    box2.removeGoldCoins(transferOfGold);
                    box1.collectCoins(transferOfGold,0);

                }
                return true;
            }
            //Transferring from box 1 to 2 as long as it fits the requirement
            if(box2.getTotalPoints() < box1.getTotalPoints() && box2.getTotalPoints() < 0 && box1.getNumGoldCoins() > 0){
                //transferring gold as long as it fits the requirements
                while((box1.getNumGoldCoins() >= 0 )&& (box1.getTotalPoints()-PTS_PER_GOLD_COIN >= box2.getTotalPoints()+PTS_PER_GOLD_COIN)&& (box2.getTotalPoints() < 0)){
                    box1.removeGoldCoins(transferOfGold);
                    box2.collectCoins(transferOfGold,0);
                }
                return true;
            }

        }
        return false;
    }



}
