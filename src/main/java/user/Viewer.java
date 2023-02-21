package user;

import account.IAccount;
import command.ICommand;
import command.ViewCommand;

public class Viewer extends User {
    private ICommand command;
    private Role role = Role.VIEWER;
    private String name;
    private String password; //TODO: check, does this really belong here?

    public Viewer(String name, ICommand command){
        this.name = name;
        this.command = command;
        System.out.println("An user.Viewer has been created.");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //TODO: done?
    public void viewAccount(IAccount account){
        command = new ViewCommand(account);
        command.execute();
    }
}
