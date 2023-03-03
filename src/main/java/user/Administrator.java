package user;

import account.AccountType;
import account.IAccount;
import command.CreateAccountCommand;
import command.ICommand;
import command.LoginCommand;
import command.ViewChangeLogCommand;

import java.util.HashMap;

public class Administrator extends User {
    public Administrator(String name, String encryptedPassword){
        super(name, encryptedPassword, Role.ADMINISTRATOR);
        System.out.println("An viewer has been created.");
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
