package command;

import account.AccountType;
import account.IAccount;
import account.IAccountComponent;

public class BookCommand implements ICommand {
    private IAccount debit;
    private IAccount credit;
    private double amount;
    private IAccountComponent debitAccountComponent;
    private IAccountComponent creditAccountComponent;

    //SOLL und HABEN -> Aktiv umgekehrt
    //vom ersten zum zweiten
    public BookCommand(IAccount debit, IAccount credit, double amount){
        /*if(debit.getAccountType() == AccountType.ACTIVE){
            debitAccountComponent = debit.getDebit();
            creditAccountComponent = credit.getCredit();
        }else{
            debitAccountComponent = credit.getDebit();
            creditAccountComponent = debit.getCredit();
        }*/
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
    }
        //TODO: Transaktionen sollen mit angezeigt werden

    private IAccount[] book(IAccount debit, IAccount credit){
        debit.getSoll().add(amount);
        credit.getHaben().add(amount);
        return null;
    }
}

