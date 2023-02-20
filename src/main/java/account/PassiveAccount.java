package account;

import memento.PassiveAccountMemento;

public class PassiveAccount implements IAccount {
    private AccountB debit;
    private AccountA haveAccount;

    public PassiveAccount(AccountB debit, AccountA haveAccount){
        this.debit = debit;
        this.haveAccount = haveAccount;
    }

    public PassiveAccountMemento save(){
        return null;
    }

    public void restore(PassiveAccountMemento memento){
        this.debit = memento.getDebit();
        this.haveAccount = memento.getHaveAccount();
    }

    //add parameter enum, to choose specific array content
    public double[] getContent(){
        double[] content = new double[2];
        content[0] = debit.getReductions();
        content[1] = haveAccount.getIncreases();
        return content;
    }
}
