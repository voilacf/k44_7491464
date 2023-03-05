package proxy;

import account.AccountType;
import account.FinancialAccounting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import user.Administrator;
import user.Clerk;
import user.Viewer;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyStepdefs {
    private final Administrator admin = new Administrator("TestAdmin", ProxyAccess.md5("test123"));
    private final Clerk clerk = new Clerk("TestClerk", ProxyAccess.md5("123456"));
    private final Viewer viewer = new Viewer("TestViewer", ProxyAccess.md5("376198"));
    private ProxyAccess proxy;

    @Given("A proxy")
    public void proxyAndUser() {
        proxy = new ProxyAccess(new RealAccess());
        proxy.registerUser(admin);
        proxy.registerUser(clerk);
        proxy.registerUser(viewer);
    }

    @When("An Admin logs in")
    public void adminLogsIn() {
        proxy.login("TestAdmin", "test123");
    }

    @Then("The user can create a new account")
    public void userCanCreateNewAccount() {
        proxy.create("test", AccountType.ACTIVE, 2000);
        assertNotNull(FinancialAccounting.getAccount("test"));
    }

    @Then("The user cannot create a new account")
    public void userCannotCreateNewAccount() {
        try {
            proxy.create("test", AccountType.ACTIVE, 2000);
        } catch (RuntimeException e) {
            String message = "You do not have permission to create an account";
            assertEquals(message, e.getMessage());
        }
    }

    @When("A Clerk logs in")
    public void clerkLogsIn() {
        proxy.login("TestClerk", "123456");
    }

    @When("A Viewer logs in")
    public void viewerLogsIn() {
        proxy.login("TestViewer", "376198");
    }

    @Given("A proxy and an account")
    public void proxyAndAccount() {
        proxy = new ProxyAccess(new RealAccess());
        proxy.registerUser(admin);
        proxy.registerUser(clerk);
        proxy.registerUser(viewer);
        proxy.login("TestAdmin", "test123");
        proxy.create("Active", AccountType.ACTIVE, 3000);
    }

    @Then("The user can view the account")
    public void userCanViewAccount() {
        try {
            proxy.view(FinancialAccounting.getAccount("Active"));
        } catch (RuntimeException e) {
            assertNull(e);
        }
    }

    @Then("The user cannot view the account")
    public void userCannotViewAccount() {
        try {
            proxy.view(FinancialAccounting.getAccount("Active"));
        } catch (RuntimeException e) {
            String message = "You do not have permission to view an account";
            assertEquals(message, e.getMessage());
        }
    }

    @Given("A proxy, a user and two accounts")
    public void proxyUserAndTwoAccounts() {
        proxy = new ProxyAccess(new RealAccess());
        proxy.registerUser(admin);
        proxy.registerUser(clerk);
        proxy.registerUser(viewer);
        proxy.login("TestAdmin", "test123");
        proxy.create("active", AccountType.ACTIVE, 3000);
        proxy.create("passive", AccountType.PASSIVE, 1000);
    }

    @Then("The user cannot do a booking")
    public void userCannotDoBooking() {
        String message = "You do not have permission to create a booking";
        try {
            proxy.book(FinancialAccounting.getAccount("active"), FinancialAccounting.getAccount("passive"), 2000);
        } catch (RuntimeException e) {
            assertEquals(message, e.getMessage());
        }
    }

    @Then("The user can do a booking")
    public void userCanDoBooking() {
        try {
            proxy.book(FinancialAccounting.getAccount("active"), FinancialAccounting.getAccount("passive"), 2000);
        } catch (RuntimeException e) {
            assertNull(e.getMessage());
        }
    }

    @Given("A booking")
    public void booking() {
        proxyUserAndTwoAccounts();
        clerkLogsIn();
        userCanDoBooking();
    }

    @Then("The user can undo the last action")
    public void userCanUndoLastAction() {
        try {
            proxy.undo();
        } catch (RuntimeException e) {
            assertNull(e.getMessage());
        }
    }

    @Then("The user cannot undo the last action")
    public void userCannotUndoLastAction() {
        String message = "You do not have permission to undo last action";
        try {
            proxy.undo();
        } catch (RuntimeException e) {
            assertEquals(message, e.getMessage());
        }
    }

    @Then("The user can view the change-log")
    public void userCanViewChangeLog() {
        try {
            proxy.viewChangeLog();
        } catch (RuntimeException e) {
            assertNull(e.getMessage());
        }
    }

    @Then("The user cannot view the change-log")
    public void userCannotViewChangeLog() {
        String message = "You do not have permission to view changelog";
        try {
            proxy.viewChangeLog();
        } catch (RuntimeException e) {
            assertEquals(message, e.getMessage());
        }
    }
}