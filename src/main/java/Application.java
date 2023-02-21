import account.AccountType;
import account.IAccount;
import user.Administrator;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args){
        Administrator admin = new Administrator("Test");
        admin.createAccount("Test", AccountType.ACTIVE,100.00);
    }

    public void init(){

    }
}
