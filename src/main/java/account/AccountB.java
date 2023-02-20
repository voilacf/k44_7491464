package account;

public class AccountB extends AccountComponent{
    private double reductions;

    public AccountB(double reductions){
        this.reductions = reductions;
    }

    public void addReduction(double reductions){
        this.reductions += reductions;
    }

    public double getReductions(){
        return reductions;
    }
}
