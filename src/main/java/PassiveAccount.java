public class PassiveAccount extends Account{
    private AccountB debit;
    private AccountA haveAccount;

    public PassiveAccount(AccountB debit, AccountA haveAccount){
        this.debit = debit;
        this.haveAccount = haveAccount;
    }

    public AccountMemento save(){
        return null;
    }

    public void restore(AccountMemento memento){
        //TODO: fix the problem here
        /*this.debit = memento.getDebit();
        this.haveAccount = memento.getHaveAccount();*/
    }
}
