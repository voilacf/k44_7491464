package command;

import account.*;
import memento.MementoCareTaker;
import user.Clerk;

public class BookCommand implements ICommand {
    private IAccount debit;
    private IAccount credit;
    private double amount;

    //SOLL und HABEN -> Aktiv umgekehrt
    //vom ersten zum zweiten
    public BookCommand(IAccount debit, IAccount credit, double amount){
        this.debit = debit;
        this.credit = credit;
        this.amount = amount;
    }
    //Mit HashMap arbeiten?

    //TODO: make a booking --> DEBIT TO CREDIT SOLL zu HABEN
    public void execute() {
        if(debit.getAccountType() == AccountType.ACTIVE && credit.getAccountType() == AccountType.ACTIVE){
            //ACTIVE ACTIVE -> credit to debit
            debit.getHaben().add(amount);
            credit.getSoll().add(amount);
        }else if(debit.getAccountType() == AccountType.PASSIVE && credit.getAccountType() == AccountType.PASSIVE){
            //PASSIVE PASSIVE -> debit to credit
            debit.getSoll().add(amount);
            credit.getHaben().add(amount);
        }else if(debit.getAccountType() == AccountType.ACTIVE && credit.getAccountType() == AccountType.PASSIVE){
            debit.getHaben().add(amount);
            credit.getHaben().add(amount);
        }else if(debit.getAccountType() == AccountType.PASSIVE && credit.getAccountType() == AccountType.ACTIVE){
            debit.getSoll().add(amount);
            credit.getSoll().add(amount);
        }
        else{
            throw new RuntimeException("Error");
        }

        FinancialAccounting.addReceipt(new ChangeReceipt(debit, credit, amount, ActionType.BOOKING));
    } //TODO: save changes -> load to memento

    /*private IAccount[] book(IAccount debit, IAccount credit){
        debit.getSoll().add(amount);
        credit.getHaben().add(amount);
        return null;
    }*/
}

