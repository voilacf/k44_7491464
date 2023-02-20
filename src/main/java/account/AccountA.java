package account;

public class AccountA extends AccountComponent{
    private double openingBalance;
    private double increases; //TODO: is this useful?

    public AccountA(double openingBalance, double increases){
        this.openingBalance = openingBalance;
        this.increases = increases;
    }

    public void addToAccount(double increases){
        openingBalance += increases;
    }

    public double getOpeningBalance(){
        return openingBalance;
    }

    public double getIncreases(){
        return increases;
    }
}
