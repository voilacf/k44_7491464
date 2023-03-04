package user;

public class Clerk extends User {
    public Clerk(String name, String encryptedPassword) {
        super(name, encryptedPassword, Role.CLERK);
        System.out.println("An Clerk has been created.");
    }

    /*//TODO: book √, undo X, view √
    public void book(IAccount sourceAccount, IAccount destinationAccount, double amount){
        mementoCareTaker.setMementoActiveSrc(sourceAccount.save());
        mementoCareTaker.setMementoPassiveDest(destinationAccount.save());
        System.out.println("\n----------memento has been set----------\n");
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        command = new BookCommand(sourceAccount, destinationAccount, amount, this);
        command.execute();
        System.out.println("\n----------booking has been executed----------\n");
    }

    public void undoLastAction(){
        command = new UndoCommand(sourceAccount, destinationAccount, mementoCareTaker, this);
        command.execute();
        System.out.println("\n----------last action has been reset----------\n");
    }

    public void viewAccount(IAccount account){
        command = new ViewCommand(account);
        command.execute();
    }*/
}
