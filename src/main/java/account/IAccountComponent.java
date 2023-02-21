package account;

public interface IAccountComponent {
    DebitCreditType getAccountComponentType();
    void add(double amount);
}
