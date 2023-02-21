package memento;

import account.Credit;
import account.Debit;

public class PassiveAccountMemento {
    private Debit debit;
    private Credit haveAccount;

    public PassiveAccountMemento(Credit haveAccount, Debit debit){
        this.debit = debit;
        this.haveAccount = haveAccount;
    }

    public Debit getDebit(){
        return null;
    }

    public void setDebit(Debit debit) {
        this.debit = debit;
    }

    public Credit getHaveAccount(){
        return null;
    }

    public void setHaveAccount(Credit haveAccount) {
        this.haveAccount = haveAccount;
    }
}
