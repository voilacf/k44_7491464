package account;

import command.ICommand;
import command.ViewCommand;

import java.time.LocalDateTime;

public class ChangeReceipt {
    private int id;
    private LocalDateTime timeStamp; //TODO: check java libs for date related stuff
    private IAccount debitAccount;
    private IAccount haveAccount;
    private double amount;
    private ActionType type;

    public ChangeReceipt(int id, IAccount debitAccount, IAccount haveAccount, double amount, ActionType type){
        this.id = id;
        this.timeStamp = LocalDateTime.now();
        this.debitAccount = debitAccount;
        this.haveAccount = haveAccount;
        this.amount = amount;
        this.type = type;
    } //TODO: done

    public void printChangeReceipt(){
        System.out.println("Receipt " + id);
        ICommand command = new ViewCommand(debitAccount);
        command.execute();
        command = new ViewCommand(haveAccount);
        command.execute();
        //System.out.println("haveAccount : [" + haveAccount.getContent() + "] state: [" + debitAccount.getContent() + "]");
        System.out.println("Date and Time " + timeStamp);
    }
}
