package account;

import memento.AccountMemento;

public class ActiveAccount implements IAccount {
    private final AccountType accountType = AccountType.ACTIVE;
    String name;
    private Credit debit;
    private Debit credit;

    public ActiveAccount(String name, double amount) {
        this.name = name;
        this.debit = new Credit(amount);
        this.credit = new Debit();
    }

    @Override
    public AccountMemento save() {
        return new AccountMemento(name, debit.clone(), credit.clone());
    }

    @Override
    public void restore(AccountMemento memento) {
        this.name = memento.getName();
        this.debit = memento.getCredit();
        this.credit = memento.getDebit();
    }

    public Credit getSoll() {
        return debit;
    }

    public Debit getHaben() {
        return credit;
    }

    //Aktiv oder Passiv?
    public AccountType getAccountType() {
        return accountType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
