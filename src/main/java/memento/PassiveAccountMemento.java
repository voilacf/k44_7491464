package memento;

import account.AccountA;
import account.AccountB;
import account.AccountComponent;

public class PassiveAccountMemento {
    private AccountB debit;
    private AccountA haveAccount;

    public PassiveAccountMemento(AccountA haveAccount, AccountB debit){
        this.debit = debit;
        this.haveAccount = haveAccount;
    }

    public AccountB getDebit(){
        return null;
    }

    public void setDebit(AccountB debit) {
        this.debit = debit;
    }

    public AccountA getHaveAccount(){
        return null;
    }

    public void setHaveAccount(AccountA haveAccount) {
        this.haveAccount = haveAccount;
    }
}
