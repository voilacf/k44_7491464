import account.AccountType;
import account.ActiveAccount;
import account.IAccount;
import account.PassiveAccount;
import command.ICommand;
import command.ViewCommand;
import user.Administrator;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args){
        //Administrator admin = new Administrator("Test");
        //admin.createAccount("Test", AccountType.ACTIVE,100.00);
        PassiveAccount test = new PassiveAccount("Test", 10000);
        test.getHaben().add(100);
        test.getHaben().add(500);
        test.getHaben().add(2000);
        test.getSoll().add(2000);
        test.getSoll().add(2000);
        test.getSoll().add(2000);
        test.getSoll().add(2000);
        ICommand command = new ViewCommand(test);
        command.execute();
        ActiveAccount account = new ActiveAccount("AKTIVKONTO", 20000.00);
        account.getHaben().add(8888.89);
        account.getHaben().add(348.89);
        account.getHaben().add(2344.90);
        account.getHaben().add(3249);
        account.getHaben().add(8888.89);
        account.getSoll().add(23902);
        account.getSoll().add(23902);
        ICommand command1 = new ViewCommand(account);
        command1.execute();
    }

    public void init(){

    }
}
