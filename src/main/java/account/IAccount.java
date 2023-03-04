package account;

import memento.AccountMemento;

public interface IAccount {
    DebitCreditType getDebitCreditType(IAccountComponent accountComponent);

    AccountType getAccountType();

    IAccountComponent getSoll();

    IAccountComponent getHaben();

    String getName();

    AccountMemento save();

    void restore(AccountMemento memento);
}
