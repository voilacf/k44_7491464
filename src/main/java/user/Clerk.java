package user;

import account.IAccount;
import command.BookCommand;
import command.ICommand;
import command.UndoCommand;
import command.ViewCommand;

public class Clerk extends User {
    private ICommand command;
    private Role role = Role.CLERK;
    private String name;

    public Clerk(String name){
        this.name = name;
        System.out.println("An user.Clerk has been created.");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //TODO: book, undo, view
    public void book(IAccount sourceAccount, IAccount destinationAccount, double amount){
        command = new BookCommand(sourceAccount, destinationAccount, amount);
        command.execute();
    }

    public void undoLastAction(){
        command = new UndoCommand();
        command.execute();
    }

    public void viewAccount(IAccount account){
        command = new ViewCommand(account);
        command.execute();
    }
}
