package account;

import command.ICommand;
import command.ViewCommand;

import java.time.LocalDateTime;

public class ChangeReceipt {
    private int id;
    private static int idCounter;
    private LocalDateTime timeStamp;
    private IAccount debitAccount;
    private IAccount haveAccount;
    private double amount;
    private ActionType type;

    public ChangeReceipt(IAccount debitAccount, IAccount haveAccount, double amount, ActionType type){
        this.id = ++idCounter;
        this.timeStamp = LocalDateTime.now();
        this.debitAccount = debitAccount;
        this.haveAccount = haveAccount;
        this.amount = amount;
        this.type = type;
    }

    public void printChangeReceipt(){
        System.out.println("-------------- Receipt " + id + " ---------------");
        ICommand command = new ViewCommand(debitAccount);
        command.execute();
        command = new ViewCommand(haveAccount);
        command.execute();
        System.out.println("Date and Time " + timeStamp);
        System.out.println("----------------------------------------\n");
    }
}
