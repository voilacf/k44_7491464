package proxy;

import account.AccountType;
import account.IAccount;

public interface IAccess {
    void create(String name, AccountType type, double initialBalance);

    void book(IAccount credit, IAccount debit, double amount);

    void undo();

    void view(IAccount account);

    void viewChangeLog();
}
