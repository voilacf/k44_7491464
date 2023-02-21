package account;

public abstract interface IAccount {
    //double[] getContent();
    DebitCreditType getDebitCreditType(IAccountComponent accountComponent);
    AccountType getAccountType();
    IAccountComponent getSoll();
    IAccountComponent getHaben();
    String getName();
}
