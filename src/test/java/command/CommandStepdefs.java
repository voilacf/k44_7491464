package command;

import account.AccountType;
import account.FinancialAccounting;
import account.IAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import proxy.ProxyAccess;
import proxy.RealAccess;
import user.Administrator;
import user.Clerk;
import user.Viewer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CommandStepdefs {
    private final ProxyAccess proxy = new ProxyAccess(new RealAccess());
    private Administrator admin;
    private Clerk clerk;
    private Viewer viewer;

    @Given("An Admin")
    public void admin() {
        admin = new Administrator("TestAdmin", ProxyAccess.md5("test123"));
        proxy.registerUser(admin);
    }

    @Given("A Clerk")
    public void clerk() {
        clerk = new Clerk("TestClerk", ProxyAccess.md5("123456"));
        proxy.registerUser(clerk);
    }

    @Given("A Viewer")
    public void viewer() {
        viewer = new Viewer("TestViewer", ProxyAccess.md5("376108"));
        proxy.registerUser(viewer);
    }

    @Then("The user enters wrong login data and cannot log in")
    public void userEntersWrongLoginData() {
        String message = "Cannot log in";
        try {
            proxy.login("Not a registered username", "not a registered password");
        } catch (Exception e) {
            assertEquals(message, e.getMessage());
        }
    }

    @Then("The admin enters the correct login data and can log in")
    public void adminEntersCorrectLoginData() {
        String message = null;
        try {
            proxy.login("TestAdmin", "test123");
        } catch (Exception e) {
            assertEquals(message, e.getMessage());
        }
    }

    @Then("The clerk enters the correct login data and can log in")
    public void clerkEntersCorrectLoginData() {
        String message = null;
        try {
            proxy.login("TestClerk", "123456");
        } catch (Exception e) {
            assertNull(message, e.getMessage());
        }
    }

    @Then("The viewer enters the correct login data and can log in")
    public void viewerEntersCorrectLoginData() {
        String message = null;
        try {
            proxy.login("TestViewer", "376108");
        } catch (Exception e) {
            assertEquals(message, e.getMessage());
        }
    }

    @Given("An Admin logs in to proxy")
    public void adminLogsInToProxy() {
        admin();
        proxy.login("TestAdmin", "test123");
    }

    @When("Admin creates new account")
    public void adminCreatesNewAccount() {
        proxy.create("TestAccount", AccountType.PASSIVE, 300);
    }

    @Then("A new account has been created with the initial data given by the admin")
    public void newAccountWhichDataEqualsDataGivenByAdmin() {
        assertEquals("TestAccount", FinancialAccounting.getAccount("TestAccount").getName());
        assertEquals(AccountType.PASSIVE, FinancialAccounting.getAccount("TestAccount").getAccountType());
        assertEquals(300, FinancialAccounting.getAccount("TestAccount").getHaben().getOpeningBalance());
    }

    @Given("Eight accounts")
    public void adminCreatesEightAccounts() {
        admin();
        proxy.login("TestAdmin", "test123");
        proxy.create("active", AccountType.ACTIVE, 1000);
        proxy.create("active2", AccountType.ACTIVE, 1000);
        proxy.create("active3", AccountType.ACTIVE, 1000);
        proxy.create("active4", AccountType.ACTIVE, 1000);
        proxy.create("passive", AccountType.PASSIVE, 500);
        proxy.create("passive2", AccountType.PASSIVE, 500);
        proxy.create("passive3", AccountType.PASSIVE, 500);
        proxy.create("passive4", AccountType.PASSIVE, 500);
    }

    @When("Clerk logs in and is doing four bookings")
    public void clerkDoesFourBookings() {
        clerk();
        proxy.login("TestClerk", "123456");
        proxy.book(FinancialAccounting.getAccount("active"), FinancialAccounting.getAccount("passive"), 200);
        proxy.book(FinancialAccounting.getAccount("passive2"), FinancialAccounting.getAccount("active2"), 200);
        proxy.book(FinancialAccounting.getAccount("active3"), FinancialAccounting.getAccount("active4"), 200);
        proxy.book(FinancialAccounting.getAccount("passive3"), FinancialAccounting.getAccount("passive4"), 200);
    }

    @Then("The accounts have changed correctly")
    public void accountsChangedCorrectly() {
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

}
