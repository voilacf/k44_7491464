package memento;

import account.AccountType;
import account.FinancialAccounting;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import proxy.ProxyAccess;
import proxy.RealAccess;
import user.Administrator;
import user.Clerk;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MementoStepdefs {
    private final Administrator admin = new Administrator("TestAdmin", ProxyAccess.md5("test123"));
    private final Clerk clerk = new Clerk("TestClerk", ProxyAccess.md5("123456"));
    private final ProxyAccess proxy = new ProxyAccess(new RealAccess());

    {
        proxy.registerUser(admin);
        proxy.registerUser(clerk);
    }


    @Given("An admin who has created two accounts")
    public void adminCreatedTwoAccounts() {
        proxy.login("TestAdmin", "test123");
        proxy.create("active", AccountType.ACTIVE, 1000);
        proxy.create("passive", AccountType.PASSIVE, 500);
    }

    @When("A clerk is doing a booking")
    public void clerkDoesBooking() {
        proxy.login("TestClerk", "123456");
        proxy.book(FinancialAccounting.getAccount("active"), FinancialAccounting.getAccount("passive"), 200);
    }

    @Then("Before executing the booking, both accounts are being saved in a memento")
    public void bothAccounstAreSavedToMemento() {
        assertNotNull(MementoCareTaker.getMementoActiveSrc());
        assertNotNull(MementoCareTaker.getMementoPassiveDest());
    }

    @Given("Another booking")
    public void booking() {
        proxy.login("TestAdmin", "test123");
        proxy.create("active2", AccountType.ACTIVE, 1000);
        proxy.create("passive2", AccountType.PASSIVE, 500);
        proxy.login("TestClerk", "123456");
        proxy.book(FinancialAccounting.getAccount("active2"), FinancialAccounting.getAccount("passive2"), 200);
        proxy.book(FinancialAccounting.getAccount("active2"), FinancialAccounting.getAccount("passive2"), 2000);
    }

    @When("Clerk is using the undo command")
    public void clerkUsesUndoCommand() {
        proxy.login("TestClerk", "123456");
        proxy.undo();
    }

    @Then("The booking is being canceled and the accounts are restored")
    public void bookingIsCanceledAndAccountsAreRestored() {
        assertTrue(FinancialAccounting.getAccount("active").getHaben().getBalance() == FinancialAccounting.getAccount("active2").getHaben().getBalance());
        assertTrue(FinancialAccounting.getAccount("active").getSoll().getBalance() == FinancialAccounting.getAccount("active2").getSoll().getBalance());
        assertTrue(FinancialAccounting.getAccount("passive").getHaben().getBalance() == FinancialAccounting.getAccount("passive2").getHaben().getBalance());
        assertTrue(FinancialAccounting.getAccount("passive").getSoll().getBalance() == FinancialAccounting.getAccount("passive2").getSoll().getBalance());
        System.out.println("#likeabosch");
    }
}
