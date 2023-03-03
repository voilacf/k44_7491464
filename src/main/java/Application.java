import account.*;
import proxy.ProxyAccess;
import proxy.RealAccess;
import user.Administrator;
import user.Clerk;
import user.Viewer;

public class Application {

    public static void main(String[] args) {
        Administrator admin = new Administrator("TestAdmin", ProxyAccess.md5("test123"));
        Clerk clerk = new Clerk("TestClerk", ProxyAccess.md5("123456"));
        Viewer viewer = new Viewer("TestViewer", ProxyAccess.md5("3269544"));

        ProxyAccess proxy = new ProxyAccess(new RealAccess());
        proxy.registerUser(admin);
        proxy.registerUser(clerk);
        proxy.registerUser(viewer);

        proxy.login("TestAdmin", "test123");
        proxy.create("Passiv", AccountType.PASSIVE, 1000.0);
        proxy.create("Aktiv", AccountType.ACTIVE, 5000.0);
        IAccount passive = FinancialAccounting.getAccount("Passiv");
        IAccount active = FinancialAccounting.getAccount("Aktiv");

        double i = active.getSoll().getOpeningBalance();
        System.out.println(i);

        proxy.login("TestClerk", "123456");
        proxy.view(active);
        proxy.view(passive);
        proxy.book(active, passive, 1000.0);
        proxy.view(active);
        proxy.view(passive);

        proxy.undo();
        proxy.login("TestViewer", "3269544");
        proxy.view(active);
        proxy.view(passive);

        proxy.login("TestAdmin", "test123");
        proxy.viewChangeLog();
    }

    public void init() {

    }
}
