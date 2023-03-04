package account;

import java.util.ArrayList;

public class Debit implements IAccountComponent {
    private ArrayList<Double> reductions;

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
    }

    public double getOpeningBalance() {
        return 0;
    }

    public Debit clone() {
        Debit clone = new Debit();
        clone.reductions = (ArrayList<Double>) reductions.clone();
        return clone;
    }
}
