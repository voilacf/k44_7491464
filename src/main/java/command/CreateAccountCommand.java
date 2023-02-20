package command;

import account.AccountType;
import command.ICommand;

public class CreateAccountCommand implements ICommand {
    //TODO: rename class in diagram.vpp
    private String name;
    private AccountType type;
    private double initialBalance;

    public CreateAccountCommand(String name, AccountType type, double initialBalance){
        this.name = name;
        this.type = type;
        this.initialBalance = initialBalance;
    }

    public void execute(){

    }
}
