package account;

import java.util.ArrayList;

public interface IAccountComponent {

    void add(double amount);

    double getOpeningBalance();

    ArrayList<Double> getContent();

    double getBalance();
}
