package command;

import account.*;
import user.Administrator;

public class CreateAccountCommand implements ICommand {
    //TODO: rename class in diagram.vpp
    private String name;
    private AccountType type;
    private double initialBalance;
    private IAccount account;

    public CreateAccountCommand(String name, AccountType type, double initialBalance){
        this.name = name;
        this.type = type;
        this.initialBalance = initialBalance;
    }

    public IAccount getAccount(){
        return account;
    }

    //TODO: fix account, viewer, clerk and admin issue
    //TODO: save account -> mement
    public void execute(){
        if(AccountType.ACTIVE == type){
            account = new ActiveAccount(name,initialBalance);
        }else{
            account = new PassiveAccount(name, initialBalance);
        }
        System.out.println("A new " + type.toString().toLowerCase() + " Account has been created");
        System.out.println("Name: [" + name + "] initial balance: [" + initialBalance + "]\n");
        Administrator admin = new Administrator("admin");
        admin.addToAccountList(account);
    }
}
