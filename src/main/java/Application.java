import account.IAccount;
import account.PassiveAccount;
import user.Administrator;
import user.Clerk;

public class Application {

    public static void main(String[] args){
        Administrator admin = new Administrator("Test");
        IAccount passive = new PassiveAccount("Test", 1000);
        IAccount active = new PassiveAccount("Test2", 5000.0);
        double i = active.getSoll().getOpeningBalance();
        System.out.println(i);
        Clerk clerk = new Clerk("clerk");
        clerk.book(passive,active,200);
        clerk.book(passive,active,400);
        clerk.book(active,passive,300);
        clerk.book(active,passive,1000);
        clerk.viewAccount(passive);
        clerk.viewAccount(active);
    }

    public void init(){

    }
}
