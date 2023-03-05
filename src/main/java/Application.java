import account.AccountType;
import account.FinancialAccounting;
import account.IAccount;
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
        proxy.create("Passiv1", AccountType.PASSIVE, 1000.0);
        proxy.create("Passiv2", AccountType.PASSIVE, 4000.0);
        proxy.create("Passiv3", AccountType.PASSIVE, 2000.0);
        proxy.create("Aktiv1", AccountType.ACTIVE, 5000.0);
        proxy.create("Aktiv2", AccountType.ACTIVE, 8000.0);
        proxy.create("Aktiv3", AccountType.ACTIVE, 4000.0);
        IAccount passive1 = FinancialAccounting.getAccount("Passiv1");
        IAccount passive2 = FinancialAccounting.getAccount("Passiv2");
        IAccount passive3 = FinancialAccounting.getAccount("Passiv3");
        IAccount active1 = FinancialAccounting.getAccount("Aktiv1");
        IAccount active2 = FinancialAccounting.getAccount("Aktiv2");
        IAccount active3 = FinancialAccounting.getAccount("Aktiv3");

        proxy.login("TestViewer", "3269544");
        proxy.view(passive1);
        proxy.view(passive2);
        proxy.view(passive3);
        proxy.view(active1);
        proxy.view(active2);
        proxy.view(active3);

        proxy.login("TestClerk", "123456");
        proxy.book(active1, passive1, 1000.0);
        proxy.book(active3, passive2, 700.0);
        proxy.book(active1, passive3, 350.0);
        proxy.book(active3, passive1, 60.0);
        proxy.book(active2, passive2, 400.0);

        proxy.book(passive1, active1, 1000.0);
        proxy.book(passive2, active3, 500.0);
        proxy.undo();
        proxy.book(passive2, active2, 200.0);
        proxy.book(passive3, active1, 100.0);
        proxy.book(passive1, active2, 50.0);

        proxy.book(active1, passive2, 800.0);
        proxy.book(active2, passive1, 1000.0);
        proxy.book(active2, passive3, 500.0);
        proxy.book(active3, passive3, 200.0);
        proxy.book(active1, active2, 50.0);

        proxy.book(passive1, active3, 1000.0);
        proxy.undo();
        proxy.book(passive2, active1, 70.0);
        proxy.book(passive3, active2, 300.0);
        proxy.book(passive3, active3, 200.0);
        proxy.book(passive1, passive2, 50.0);

        proxy.book(active2, active3, 65.0);
        proxy.book(active1, active3, 750.0);
        proxy.book(passive3, passive1, 30.0);
        proxy.book(passive2, passive1, 800.0);
        proxy.book(active2, active1, 25.0);
        proxy.undo();

        proxy.login("TestViewer", "3269544");
        proxy.view(active1);
        proxy.view(active2);
        proxy.view(active3);
        proxy.view(passive1);
        proxy.view(passive2);
        proxy.view(passive3);

        proxy.login("TestAdmin", "test123");
        proxy.viewChangeLog();

        proxy.login("TestClerk", "123456");
    }

}
