package user;

import account.AccountType;
import account.IAccount;
import command.CreateAccountCommand;
import command.ICommand;
import command.LoginCommand;
import command.ViewChangeLogCommand;

import java.util.HashMap;

public class Administrator extends User {
    private ICommand command;
    private Role role = Role.ADMINISTRATOR;
    private String name;
    private HashMap<String, IAccount>  accountList;

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

    public void addToAccountList(IAccount account){
        accountList.put(account.getName(),account);
    }

    //TODO: methode die Nutzer seinen Accoutn zuweist/gibt
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
