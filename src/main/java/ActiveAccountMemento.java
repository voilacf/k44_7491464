public class ActiveAccountMemento extends AccountMemento{
    private AccountA debit;
    private AccountB haveAccount;

    public ActiveAccountMemento(AccountA debit, AccountB haveAccount){
        this.debit = debit;
        this.haveAccount = haveAccount;
    }

    public AccountA getDebit(){
        return debit;
    }

    public void setDebit(AccountA debit){
        this.debit = debit;
    }

    public AccountB getHaveAccount(){
        return getHaveAccount();
    }

    public void setHaveAccount(AccountB haveAccount){
        this.haveAccount = haveAccount;
    }
}
