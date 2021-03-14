public class TreasureBox {

    public static final double  PTS_PER_GOLD_COIN = 15.0;
    public static final double PTS_PER_SILVER_COIN = 7.5;
    private double gold_coins;
    private double silver_coins;
    private double totalCoins;

    private void updateTotalPoints(){
        this.totalCoins = (this.PTS_PER_GOLD_COIN * this.gold_coins)+ (this.PTS_PER_SILVER_COIN * this.silver_coins);
    }

    public TreasureBox(double gold_coins, double silver_coins){
        this.gold_coins = gold_coins;
        this.silver_coins = silver_coins;
        updateTotalPoints();
    }
    public TreasureBox(){
        this(0,0);
    }
    public double getTotalPoints(){
        return this.totalCoins;
    }
    public double getNumGoldCoins(){
        return this.gold_coins;
    }
    public double getNumSilverCoins(){
        return this.silver_coins;
    }
    public void collectCoins(int addGoldCoins, int addSilverCoins){
        this.gold_coins += addGoldCoins;
        this.silver_coins += addSilverCoins;
        updateTotalPoints();
    }
    public boolean removeGoldCoins(int removeGoldCoins){
        if(this.gold_coins < removeGoldCoins){
            return false;
        }else{
            this.gold_coins -= removeGoldCoins;
            updateTotalPoints();
            return true;
        }
    }
    public void removeSilverCoins(int removeSilverCoins){
        this.silver_coins =  this.silver_coins - removeSilverCoins;
        updateTotalPoints();
    }
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
    public static void balanceBox(){

    }

}