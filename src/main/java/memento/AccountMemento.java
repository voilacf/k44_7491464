package memento;

import account.Credit;
import account.Debit;

public class AccountMemento {
    private final String name;
    private final Credit credit;
    private final Debit debit;

    public AccountMemento(String name, Credit credit, Debit debit) {
        this.name = name;
        this.credit = credit;
        this.debit = debit;
    }

    public String getName() {
        return name;
    }

    public Credit getCredit() {
        return credit;
    }

    public Debit getDebit() {
        return debit;
    }
}
