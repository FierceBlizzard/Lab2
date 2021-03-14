public class PieceScooby {
    //Problem 1 A
    private String symbol;
    private int numScoobySnacks;
    private boolean hidden;
    private boolean canMove;
    private boolean original;

    PieceScooby(String symbol, int numScoobySnacks, boolean hidden, boolean canMove, boolean original){
        this.symbol = symbol;
        this.numScoobySnacks = numScoobySnacks;
        this.hidden = hidden;
        this.canMove = canMove;
        this.original = original;
    }
    PieceScooby(){
        this.symbol = "S";
        this.numScoobySnacks = 0;
        this.hidden = false;
        this.canMove = true;
        this.original = true;
    }
    public String getSymbol(){
        return symbol;
    }
    public int getNumScoobySnacks(){
        return numScoobySnacks;
    }
    public boolean isHidden(){
        return hidden;
    }
    public boolean isEntangled(){
        if(canMove == false){
            return true;
        }else{
            return false;
        }
    }
    public boolean canSpawn(){
        return original;
    }
    public void setSymbol(String symbol){
        this.symbol = symbol;
    }
    public void setHidden(boolean hidden){
        this.hidden = hidden;
    }
    public void entangle(){
        this.canMove = false;
    }
    public void speak(){
        System.out.println("Scooby-Dooby-Doo!");
    }
    private void eatScoobySnacks(){
        if(numScoobySnacks > 0){
            this.numScoobySnacks -= 1;
            this.canMove = true;
        }
    }
    public void collectScoobySnacks(int addScoobySnacks){
        if(addScoobySnacks > 0) {
            this.numScoobySnacks = numScoobySnacks + addScoobySnacks;
            eatScoobySnacks();
        }
    }
    public PieceScooby spawn(){
        this.symbol = "SD";
        this.numScoobySnacks = numScoobySnacks;
        this.hidden = false;
        this.canMove = canMove;
        this.original = false;
        PieceScooby scrappy = new PieceScooby(this.symbol,this.numScoobySnacks,this.hidden,this.canMove,this.original);
        return scrappy;
    }
}
