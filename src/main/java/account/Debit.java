package account;

import java.util.ArrayList;

public class Debit implements IAccountComponent {
    private ArrayList<Double> reductions;
    private DebitCreditType type;

    public Debit() {
        reductions = new ArrayList<>();
    }

    public ArrayList<Double> getContent() {
        return reductions;
    }

    public double getBalance() {
        double sum = 0;
        for (int i = 0; i < reductions.size(); i++) {
            sum += reductions.get(i);
        }
        return sum;
    }

    public void add(double amount) {
        reductions.add(amount);
        //System.out.println("The " + type.toString().toLowerCase() + " has been reduced by " + amount);
    }

    public double getOpeningBalance() {
        return 0;
    }

    /*public void reduce(double reductions){
        this.reductions += reductions;
    }*/


    public DebitCreditType getAccountComponentType() {
        return type;
    }

    public void setType(DebitCreditType type) {
        this.type = type;
    }

    public Debit clone() {
        Debit clone = new Debit();
        clone.reductions = (ArrayList<Double>) reductions.clone();
        clone.type = type;
        return clone;
    }
}
