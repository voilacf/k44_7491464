package account;

import memento.ActiveAccountMemento;

public class ActiveAccount implements IAccount {
    private AccountA debit;
    private AccountB haveAccount;

    public ActiveAccount(AccountA debit, AccountB haveAccount){
        this.debit = debit;
        this.haveAccount = haveAccount;
    }

    public ActiveAccountMemento save(){
        return null;
    }

    public void restore(ActiveAccountMemento memento){
        debit = memento.getDebit();
        haveAccount = memento.getHaveAccount();
    }

    public double[] getContent(){
        double[] content = new double[2];
        content[0] = debit.getIncreases();
        content[1] = haveAccount.getReductions();
        return content;
    }
}
