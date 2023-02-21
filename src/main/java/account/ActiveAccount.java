package account;

import memento.ActiveAccountMemento;

import java.util.ArrayList;

public class ActiveAccount implements IAccount {
    String name;
    private final AccountType accountType = AccountType.ACTIVE;
    private Credit soll; //TODO: HABEN
    private Debit haben; //TODO: SOLL
    private ArrayList<Double> transactions;

    public ActiveAccount(String name, double amount){
        this.name = name;
        this.soll = new Credit(amount);
        soll.setType(DebitCreditType.CREDIT);
        this.haben = new Debit();
        haben.setType(DebitCreditType.DEBIT);
    }

    public ActiveAccountMemento save(){
        return null;
    }

    public void restore(ActiveAccountMemento memento){
        soll = memento.getDebit();
        haben = memento.getHaveAccount();
    }

    /*public double[] getContent(){
        double[] content = new double[2];
        content[0] = soll.getOpeningBalance();
        content[1] = haben.getReductions();
        return content;
    }*/

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
