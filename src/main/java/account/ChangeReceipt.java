package account;

public class ChangeReceipt {
    private int id;
    private double timeStamp; //TODO: check java libs for date related stuff
    private IAccount debitAccount;
    private IAccount haveAccount;
    private double amount;
    private ActionType type;

    public ChangeReceipt(int id, double timeStamp, IAccount debitAccount, IAccount haveAccount, double amount, ActionType type){
        this.id = id;
        this.timeStamp = timeStamp;
        this.debitAccount = debitAccount;
        this.haveAccount = haveAccount;
        this.amount = amount;
        this.type = type;
    } //TODO: done

    public void printChangeReceipt(){
        System.out.println("Receipt " + id);
        System.out.println("haveAccount : [" + haveAccount.getContent() + "] state: [" + debitAccount.getContent() + "]");
        System.out.println("Date and Time " + timeStamp);
    }
}
