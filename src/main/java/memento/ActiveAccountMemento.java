package memento;

import account.Credit;
import account.Debit;

public class ActiveAccountMemento{
    private Credit debit;
    private Debit haveAccount;

    public ActiveAccountMemento(Credit debit, Debit haveAccount){
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
