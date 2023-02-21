package command;

import account.AccountType;
import account.IAccount;

import java.util.ArrayList;

public class ViewCommand implements ICommand {
    private IAccount account;
    private ArrayList<Double> test;

    public ViewCommand(IAccount account){
        this.account = account;
    }

    //TODO: Stand Konto und Transaktionen
    public void execute(){
        if(account.getAccountType() == AccountType.ACTIVE){
            System.out.println("Current balance: " + account.getHaben());
        }else{
            System.out.println("Current balance: " + account.getSoll());
        }
        //TODO: Transaktionen mit ausgeben
    }

}
