package account;

import memento.AccountMemento;

public interface IAccount {

    AccountType getAccountType();

    IAccountComponent getSoll();

    IAccountComponent getHaben();

    String getName();

    AccountMemento save();

    void restore(AccountMemento memento);
}
