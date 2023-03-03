package proxy;

import account.AccountType;
import account.IAccount;
import command.ICommand;
import user.Role;
import user.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class ProxyAccess implements IAccess {
    private final ArrayList<User> users = new ArrayList<>();
    private Role currentUserRole = null;
    private final RealAccess realAccess;

    public ProxyAccess(RealAccess realAccess){
        this.realAccess = realAccess;
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void login(String username, String password) {
        Role newRole = null;

        for(User user : users) {
            if(user.getName().equals(username)) {
                if(user.getEncryptedPassword().equals(md5(password))){
                    newRole = user.getRole();
                } else {
                    System.out.println("Cannot login as " + username + " because of wrong password");
                }
            }
        }

        this.currentUserRole = newRole;
    }

    @Override
    public void create(String name, AccountType type, double initialBalance) {
        if(currentUserRole == Role.ADMINISTRATOR) {
            realAccess.create(name, type, initialBalance);
        } else {
            System.out.println("You do not have permission to create an account");
        }
    }

    @Override
    public void book(IAccount credit, IAccount debit, double amount) {
        if (currentUserRole == Role.CLERK) {
            realAccess.book(credit,debit,amount);
        } else {
            System.out.println("You do not have permission to create a booking");
        }
    }

    @Override
    public void undo() {
        if(currentUserRole == Role.CLERK) {
            realAccess.undo();
        } else {
            System.out.println("You do not have permission to undo last action");
        }
    }

    @Override
    public void view(IAccount account) {
        if(currentUserRole == Role.CLERK || currentUserRole == Role.VIEWER) {
            realAccess.view(account);
        } else {
            System.out.println("You do not have permission to view an account");
        }
    }

    @Override
    public void viewChangeLog() {
        if(currentUserRole == Role.ADMINISTRATOR) {
            realAccess.viewChangeLog();
        } else {
            System.out.println("You do not have permission to view changelog");
        }
    }

    public static String md5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] digest = md.digest();
            return new String(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
