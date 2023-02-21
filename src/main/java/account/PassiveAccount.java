package account;

import memento.PassiveAccountMemento;

import java.util.ArrayList;

public class PassiveAccount implements IAccount {
    String name;
    private final AccountType accountType = AccountType.PASSIVE;
    private Debit soll; //TODO: SOLL
    private Credit haben; //TODO: HABEN
    private ArrayList<Double> transactions;

    public PassiveAccount(String name, double initialBalance){
        this.name = name;
        this.haben = new Credit(initialBalance);
        haben.setType(DebitCreditType.CREDIT);
        this.soll = new Debit();
        soll.setType(DebitCreditType.DEBIT);
    }

    public PassiveAccountMemento save(){
        return null;
    }

    public void restore(PassiveAccountMemento memento){
        this.soll = memento.getDebit();
        this.haben = memento.getHaveAccount();
    }

    //add parameter enum, to choose specific array content
    /*public double[] getContent(){
        double[] content = new double[2];
        content[0] = soll.getReductions();
        content[1] = haben.getOpeningBalance();
        return content;
    }*/

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
