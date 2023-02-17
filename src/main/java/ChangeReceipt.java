public class ChangeReceipt {
    private int id;
    private double timeStamp; //TODO: check java libs for date related stuff
    private Account debitAccount;
    private Account haveAccount;
    private double amount;
    private ActionType type;

    public ChangeReceipt(int id, double timeStamp, Account debitAccount, Account haveAccount, double amount, ActionType type){
        this.id = id;
        this.timeStamp = timeStamp;
        this.debitAccount = debitAccount;
        this.haveAccount = haveAccount;
        this.amount = amount;
        this.type = type;
    } //TODO: done
}
