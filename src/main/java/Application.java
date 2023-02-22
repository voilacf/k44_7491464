import account.AccountType;
import account.ActiveAccount;
import account.IAccount;
import account.PassiveAccount;
import command.ICommand;
import command.ViewCommand;
import user.Administrator;
import user.Clerk;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args){
        Administrator admin = new Administrator("Test");
        IAccount passive = new PassiveAccount("Test", 1000);
        IAccount active = new PassiveAccount("Test2", 5000.0);
        double i = active.getSoll().getOpeningBalance();
        System.out.println(i);
        Clerk clerk = new Clerk("clerk");
        clerk.book(passive,active,200);
        clerk.viewAccount(passive);
        clerk.viewAccount(active);

    }

    public void init(){

    }
}
