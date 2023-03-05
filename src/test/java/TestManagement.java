
import account.AccountType;
import account.FinancialAccounting;
import account.IAccount;
import memento.MementoCareTaker;
import org.junit.jupiter.api.*;
import proxy.ProxyAccess;
import proxy.RealAccess;
import user.Administrator;
import user.Clerk;
import user.Viewer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestManagement {
    private final Administrator admin = new Administrator("TestAdmin", ProxyAccess.md5("test123"));
    private final Clerk clerk = new Clerk("TestClerk", ProxyAccess.md5("123456"));
    private final Viewer viewer = new Viewer("TestViewer",ProxyAccess.md5("1234"));
    private final ProxyAccess proxy = new ProxyAccess(new RealAccess());

    @BeforeEach
    public void setUp() {
        proxy.registerUser(admin);
        proxy.registerUser(clerk);
        proxy.registerUser(viewer);
    }

    @Test
    @Order(1)
    //Testing command
    public void testBookingCommand() {
        proxy.login("TestAdmin", "test123");
        proxy.create("active", AccountType.ACTIVE, 1000);
        proxy.create("active2", AccountType.ACTIVE, 1000);
        proxy.create("active3", AccountType.ACTIVE, 1000);
        proxy.create("active4", AccountType.ACTIVE, 1000);
        proxy.create("passive", AccountType.PASSIVE, 500);
        proxy.create("passive2", AccountType.PASSIVE, 500);
        proxy.create("passive3", AccountType.PASSIVE, 500);
        proxy.create("passive4", AccountType.PASSIVE, 500);
        proxy.login("TestClerk", "123456");
        proxy.book(FinancialAccounting.getAccount("active"), FinancialAccounting.getAccount("passive"), 200);
        proxy.book(FinancialAccounting.getAccount("passive2"), FinancialAccounting.getAccount("active2"), 200);
        proxy.book(FinancialAccounting.getAccount("active3"), FinancialAccounting.getAccount("active4"), 200);
        proxy.book(FinancialAccounting.getAccount("passive3"), FinancialAccounting.getAccount("passive4"), 200);
        IAccount active = FinancialAccounting.getAccount("active");
        IAccount passive = FinancialAccounting.getAccount("passive");
        assertEquals(200, active.getHaben().getBalance());
        assertEquals(1000, active.getSoll().getBalance());
        assertEquals(700, passive.getHaben().getBalance());
        assertEquals(0, passive.getSoll().getBalance());
        IAccount passive2 = FinancialAccounting.getAccount("passive2");
        IAccount active2 = FinancialAccounting.getAccount("active2");
        assertEquals(500, passive2.getHaben().getBalance());
        assertEquals(200, passive2.getSoll().getBalance());
        assertEquals(0, active2.getHaben().getBalance());
        assertEquals(1200, active2.getSoll().getBalance());
        IAccount active3 = FinancialAccounting.getAccount("active3");
        IAccount active4 = FinancialAccounting.getAccount("active4");
        assertEquals(200, active3.getHaben().getBalance());
        assertEquals(1000, active3.getSoll().getBalance());
        assertEquals(0, active4.getHaben().getBalance());
        assertEquals(1200, active4.getSoll().getBalance());
        IAccount passive3 = FinancialAccounting.getAccount("passive3");
        IAccount passive4 = FinancialAccounting.getAccount("passive4");
        assertEquals(500, passive3.getHaben().getBalance());
        assertEquals(200, passive3.getSoll().getBalance());
        assertEquals(700, passive4.getHaben().getBalance());
        assertEquals(0, passive4.getSoll().getBalance());
        System.out.println("#likeabosch");
    }
    // rest of command is tested with cucumber

    @Test
    @Order(2)
    //Testing memento
    public void testMemento() {
        proxy.login("TestAdmin", "test123");
        proxy.create("active", AccountType.ACTIVE, 1000);
        proxy.create("passive", AccountType.PASSIVE, 500);
        proxy.login("TestClerk", "123456");
        proxy.book(FinancialAccounting.getAccount("active"), FinancialAccounting.getAccount("passive"), 200);
        assertNotNull(MementoCareTaker.getMementoActiveSrc());
        assertNotNull(MementoCareTaker.getMementoPassiveDest());
        proxy.login("TestAdmin", "test123");
        proxy.create("active2", AccountType.ACTIVE, 1000);
        proxy.create("passive2", AccountType.PASSIVE, 500);
        proxy.login("TestClerk", "123456");
        proxy.book(FinancialAccounting.getAccount("active2"), FinancialAccounting.getAccount("passive2"), 200);
        proxy.book(FinancialAccounting.getAccount("active2"), FinancialAccounting.getAccount("passive2"), 2000);
        proxy.login("TestClerk", "123456");
        proxy.undo();
        assertTrue(FinancialAccounting.getAccount("active").getHaben().getBalance() == FinancialAccounting.getAccount("active2").getHaben().getBalance());
        assertTrue(FinancialAccounting.getAccount("active").getSoll().getBalance() == FinancialAccounting.getAccount("active2").getSoll().getBalance());
        assertTrue(FinancialAccounting.getAccount("passive").getHaben().getBalance() == FinancialAccounting.getAccount("passive2").getHaben().getBalance());
        assertTrue(FinancialAccounting.getAccount("passive").getSoll().getBalance() == FinancialAccounting.getAccount("passive2").getSoll().getBalance());
        System.out.println("#likeabosch");
    }

    @Test
    @Order(3)
    //Testing proxy
    public void testProxyCreateAccountPermission() {
        proxy.login("TestAdmin", "test123");
        proxy.create("test", AccountType.ACTIVE, 2000);
        assertNotNull(FinancialAccounting.getAccount("test"));
        proxy.login("TestClerk", "123456");
        try {
            proxy.create("test", AccountType.ACTIVE, 2000);
        } catch (RuntimeException e) {
            String message = "You do not have permission to create an account";
            assertEquals(message, e.getMessage());
        }
        proxy.login("TestViewer", "1234");
        try {
            proxy.create("test", AccountType.ACTIVE, 2000);
        } catch (RuntimeException e) {
            String message = "You do not have permission to create an account";
            assertEquals(message, e.getMessage());
        }
    }
    // rest of proxy is tested with cucumber

}
