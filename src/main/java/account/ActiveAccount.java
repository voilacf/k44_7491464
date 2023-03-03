package account;

import memento.AccountMemento;

public class ActiveAccount implements IAccount {
    String name;
    private final AccountType accountType = AccountType.ACTIVE;
    private Credit soll; //TODO: Soll
    private Debit haben; //TODO: haben
    //private ArrayList<Double> transactions;

    public ActiveAccount(String name, double amount){
        this.name = name;
        this.soll = new Credit(amount);
        soll.setType(DebitCreditType.CREDIT);
        this.haben = new Debit();
        haben.setType(DebitCreditType.DEBIT);
    }

    @Override
    public AccountMemento save(){
        return new AccountMemento(name, soll.clone(), haben.clone());
    }

    @Override
    public void restore(AccountMemento memento){
        this.name = memento.getName();
        this.soll = memento.getCredit();
        this.haben = memento.getDebit();
    }

    public Credit getSoll(){
        return soll;
    }

    public Debit getHaben(){
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
