package memento;

import account.ActiveAccount;
import account.Credit;
import account.Debit;
import account.IAccount;

public class ActiveAccountMemento{
    private ActiveAccount account;
    private Credit debit;
    private Debit haveAccount;

    public ActiveAccountMemento(String name, Credit debit, Debit haveAccount, double initialAmount){
        account = new ActiveAccount(name, initialAmount);
        //account.set
        this.debit = debit;
        this.haveAccount = haveAccount;
    }

    public Credit getDebit(){
        return debit;
    }

    public void setDebit(Credit debit){
        this.debit = debit;
    }

    public Debit getHaveAccount(){
        return getHaveAccount();
    }

    public void setHaveAccount(Debit haveAccount){
        this.haveAccount = haveAccount;
    }
}
