public class ActiveAccount extends Account{
    private AccountA debit;
    private AccountB haveAccount;

    public ActiveAccount(){
        super();
    }

    public AccountMemento save(){
        return null;
    }

    public void restore(AccountMemento memento){
        //TODO: fix problem here
        //debit = memento.getDebit();
        //haveAccount = memento.getHaveAccount();
    }
}
