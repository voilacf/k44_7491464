package user;

import account.IAccount;
import command.ICommand;
import command.ViewCommand;

public class Viewer extends User {
    public Viewer(String name, String encryptedPassword){
        super(name, encryptedPassword, Role.VIEWER);
        System.out.println("An viewer has been created.");
    }
}
