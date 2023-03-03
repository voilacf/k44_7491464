package account;

import java.util.ArrayList;

public class Credit implements IAccountComponent {
    private double openingBalance; //TODO: final?
    private ArrayList<Double> increases; //TODO: is this useful?
    private DebitCreditType type;

    public Credit(double openingBalance){
        this.openingBalance = openingBalance;
        increases = new ArrayList<>();
    }

    public double getOpeningBalance(){
        return openingBalance;
    }

    public void add(double amount){
        increases.add(amount);
        //System.out.println("The " + type.toString().toLowerCase() + " has been increased by " + amount);
    }

    public double getBalance(){
        double balance = openingBalance;
        for (int i = 0; i < increases.size(); i++) {
            balance += increases.get(i);
        }
        return balance;
    }

    public ArrayList<Double> getContent() {
        return increases;
    }

    public void setType(DebitCreditType type){
        this.type = type;
    }

    public DebitCreditType getAccountComponentType(){
        return type;
    }

    public Credit clone(){
        Credit clone = new Credit(openingBalance);
        clone.setType(type);
        for (int i = 0; i < increases.size(); i++) {
            clone.add(increases.get(i));
        }
        return clone;
    }
}
