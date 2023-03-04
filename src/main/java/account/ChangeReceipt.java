package account;

import command.ICommand;
import command.ViewCommand;

import java.time.LocalDateTime;

public class ChangeReceipt {
    private static int idCounter;
    private final int id;
    private final LocalDateTime timeStamp;
    private final IAccount debitAccount;
    private final IAccount haveAccount;
    private final double amount;
    private final ActionType type;

    public ChangeReceipt(IAccount debitAccount, IAccount haveAccount, double amount, ActionType type) {
        this.id = ++idCounter;
        this.timeStamp = LocalDateTime.now();
        this.debitAccount = debitAccount;
        this.haveAccount = haveAccount;
        this.amount = amount;
        this.type = type;
    }

    public void printChangeReceipt() {
        System.out.println("----------------- Receipt " + id + " ------------------");
        System.out.println("- a " + type.toString().toLowerCase() + " of " + amount + " haas been executed -");
        ICommand command = new ViewCommand(debitAccount);
        command.execute();
        command = new ViewCommand(haveAccount);
        command.execute();
        System.out.println("Date and Time " + timeStamp);
        System.out.println("----------------------------------------------\n");
    }
}
