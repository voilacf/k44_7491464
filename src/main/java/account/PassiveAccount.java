package account;

import memento.AccountMemento;

public class PassiveAccount implements IAccount {
    String name;
    private final AccountType accountType = AccountType.PASSIVE;
    private Debit soll; //TODO: SOLL
    private Credit haben; //TODO: HABEN

    public PassiveAccount(String name, double initialBalance){
        this.name = name;
        this.haben = new Credit(initialBalance);
        haben.setType(DebitCreditType.CREDIT);
        this.soll = new Debit();
        soll.setType(DebitCreditType.DEBIT);
    }

    public AccountMemento save(){
        return new AccountMemento(name,haben.clone(),soll.clone());
    }

    @Override
    public void restore(AccountMemento memento){
        this.name = memento.getName();
        this.soll = memento.getDebit();
        this.haben = memento.getCredit();
    }


    //TODO: change to credit debit
    public Debit getSoll(){
        return soll;
    }

    public Credit getHaben(){
        return haben;
    }

    //Soll oder Haben?
    public DebitCreditType getDebitCreditType(IAccountComponent accountComponent){
        return accountComponent.getAccountComponentType();
    }

    //Aktiv oder Passiv?
    public AccountType getAccountType(){
        return accountType;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
