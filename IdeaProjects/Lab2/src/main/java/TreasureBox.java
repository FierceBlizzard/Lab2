public class TreasureBox {

    public static final double  PTS_PER_GOLD_COIN = 15.0;
    public static final double PTS_PER_SILVER_COIN = 7.5;
    private double gold_coins;
    private double silver_coins;
    private double totalCoins;

    private void updateTotalPoints(){
        this.totalCoins = (this.PTS_PER_GOLD_COIN * this.gold_coins) + (this.PTS_PER_SILVER_COIN * this.silver_coins);
    }

    public TreasureBox(double gold_coins, double silver_coins){
        this.gold_coins = gold_coins;
        this.silver_coins = silver_coins;
        updateTotalPoints();
    }
    public TreasureBox(){
        this(0,0);
        updateTotalPoints();
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
    public static boolean balanceBoxes(TreasureBox box1, TreasureBox box2){
        int transferOfGold = 1;

        //Transferring from box 2 to 1
        if(box1.getTotalPoints() < 0 || box2.getTotalPoints() < 0){
            if(box1.getTotalPoints() < box2.getTotalPoints() && box1.getTotalPoints() < 0 && box2.getNumGoldCoins() > 0){
                while((box2.getNumGoldCoins() >= 0) && (box2.getTotalPoints()-PTS_PER_GOLD_COIN >= box1.getTotalPoints()+ PTS_PER_GOLD_COIN)&& (box1.getTotalPoints() < 0)){
                    box2.removeGoldCoins(transferOfGold);
                    box1.collectCoins(transferOfGold,0);
                    System.out.println("total points 1: "+box1.getTotalPoints()+" total points 2: "+box2.getTotalPoints());

                }
                System.out.println("First If");
                return true;
            }
            if(box2.getTotalPoints() < box1.getTotalPoints() && box2.getTotalPoints() < 0 && box1.getNumGoldCoins() > 0){
                while((box1.getNumGoldCoins() >= 0 )&& (box1.getTotalPoints()-PTS_PER_GOLD_COIN >= box2.getTotalPoints()+PTS_PER_GOLD_COIN)&& (box2.getTotalPoints() < 0)){
                    box1.removeGoldCoins(transferOfGold);
                    box2.collectCoins(transferOfGold,0);
                    System.out.println("total points 1: "+box1.getTotalPoints()+" total points 2: "+box2.getTotalPoints());
                }
                System.out.println("Second If");
                return true;
            }

        }
        System.out.println("No If");
        return false;
    }



}
