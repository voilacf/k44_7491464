public class PassiveAccountMemento extends AccountMemento{
    private AccountB debit;
    private AccountA haveAccount;

    public PassiveAccountMemento(AccountA haveAccount, AccountB debit){
        this.debit = debit;
        this.haveAccount = haveAccount;
    }

    public AccountComponent getDebit(){
        return null;
    }

    public void setDebit(AccountB debit) {
        this.debit = debit;
    }

    public AccountComponent getHaveAccount(){
        return null;
    }

    public void setHaveAccount(AccountA haveAccount) {
        this.haveAccount = haveAccount;
    }
}
