package account;

import memento.AccountMemento;

public class PassiveAccount implements IAccount {
    private final AccountType accountType = AccountType.PASSIVE;
    String name;
    private Debit soll; //TODO: SOLL
    private Credit haben; //TODO: HABEN

    public PassiveAccount(String name, double initialBalance) {
        this.name = name;
        this.haben = new Credit(initialBalance);
        this.soll = new Debit();
    }

    public AccountMemento save() {
        return new AccountMemento(name, haben.clone(), soll.clone());
    }

    @Override
    public void restore(AccountMemento memento) {
        this.name = memento.getName();
        this.soll = memento.getDebit();
        this.haben = memento.getCredit();
    }

    //TODO: change to credit debit
    public Debit getSoll() {
        return soll;
    }

    public Credit getHaben() {
        return haben;
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
