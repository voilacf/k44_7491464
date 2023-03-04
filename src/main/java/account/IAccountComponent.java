package account;

import java.util.ArrayList;

public interface IAccountComponent {
    DebitCreditType getAccountComponentType();

    void add(double amount);

    double getOpeningBalance();

    ArrayList<Double> getContent();

    double getBalance();
}
