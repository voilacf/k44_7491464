package account;

import memento.AccountMemento;

public class ActiveAccount implements IAccount {
    private final AccountType accountType = AccountType.ACTIVE;
    String name;
    private Credit soll; //TODO: Soll
    private Debit haben; //TODO: haben

    public ActiveAccount(String name, double amount) {
        this.name = name;
        this.soll = new Credit(amount);
        this.haben = new Debit();
    }

    @Override
    public AccountMemento save() {
        return new AccountMemento(name, soll.clone(), haben.clone());
    }

    @Override
    public void restore(AccountMemento memento) {
        this.name = memento.getName();
        this.soll = memento.getCredit();
        this.haben = memento.getDebit();
    }

    public Credit getSoll() {
        return soll;
    }

    public Debit getHaben() {
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
