package proxy;

import account.AccountType;
import account.IAccount;
import command.*;
import memento.MementoCareTaker;

public class RealAccess implements IAccess {
    private ICommand command;
    private static double amount;

    public static double getAmount() {
        return amount;
    }

    @Override
    public void create(String name, AccountType type, double initialBalance) {
        new CreateAccountCommand(name, type, initialBalance).execute();
    }

    @Override
    public void book(IAccount debit, IAccount credit, double amount) {
        this.amount = amount;
        MementoCareTaker.setMementoActiveSrc(credit.save());
        MementoCareTaker.setMementoPassiveDest(debit.save());
        System.out.println("\n----------memento has been set----------\n");

        command = new BookCommand(debit, credit, amount);
        command.execute();
        System.out.println("\n----------booking has been executed----------\n");
    }

    @Override
    public void undo() {
        command = new UndoCommand();
        command.execute();
        System.out.println("\n----------last action has been reset----------\n");
    }

    @Override
    public void view(IAccount account) {
        command = new ViewCommand(account);
        command.execute();
    }

    @Override
    public void viewChangeLog() {
        command = new ViewChangeLogCommand();
        command.execute();
    }
}
