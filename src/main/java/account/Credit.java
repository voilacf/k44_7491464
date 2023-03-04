package account;

import java.util.ArrayList;

public class Credit implements IAccountComponent {
    private final double openingBalance;
    private final ArrayList<Double> increases;

    public Credit(double openingBalance) {
        this.openingBalance = openingBalance;
        increases = new ArrayList<>();
    }

    public double getOpeningBalance() {
        return openingBalance;
    }

    public void add(double amount) {
        increases.add(amount);
    }

    public double getBalance() {
        double balance = openingBalance;
        for (int i = 0; i < increases.size(); i++) {
            balance += increases.get(i);
        }
        return balance;
    }

    public ArrayList<Double> getContent() {
        return increases;
    }


    public Credit clone() {
        Credit clone = new Credit(openingBalance);
        for (int i = 0; i < increases.size(); i++) {
            clone.add(increases.get(i));
        }
        return clone;
    }
}
