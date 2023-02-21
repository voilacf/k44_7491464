package user;

import account.AccountType;
import command.CreateAccountCommand;
import command.ICommand;
import command.LoginCommand;
import command.ViewChangeLogCommand;

public class Administrator extends User {
    private ICommand command;
    private Role role = Role.ADMINISTRATOR;
    private String name;

    public Administrator(String name){
        this.name = name;
        System.out.println("An Administrator has been created.\n");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //TODO: done?
    public void createAccount(String name, AccountType type, double initialBalance){
        command = new CreateAccountCommand(name, type, initialBalance);
        command.execute();
    }

    public void login(String name, String password){
        command = new LoginCommand(name,password);
        command.execute();
    }

    public void viewChangeLog(){
        command = new ViewChangeLogCommand();
        command.execute();
    }
}
