package command;

import account.*;

public class BookCommand implements ICommand {
    private final IAccount debit;
    private final IAccount credit;
    private final double amount;

    //vom ersten zum zweiten --> soll an haben
    public BookCommand(IAccount debit, IAccount credit, double amount) {
        this.debit = debit;
        this.credit = credit;
        this.amount = amount;
    }

    public void execute() {
        if (debit.getAccountType() == AccountType.ACTIVE && credit.getAccountType() == AccountType.ACTIVE) {
            //ACTIVE ACTIVE -> credit to debit
            debit.getHaben().add(amount);
            credit.getSoll().add(amount);
        } else if (debit.getAccountType() == AccountType.PASSIVE && credit.getAccountType() == AccountType.PASSIVE) {
            //PASSIVE PASSIVE -> debit to credit
            debit.getSoll().add(amount);
            credit.getHaben().add(amount);
        } else if (debit.getAccountType() == AccountType.ACTIVE && credit.getAccountType() == AccountType.PASSIVE) {
            debit.getHaben().add(amount);
            credit.getHaben().add(amount);
        } else if (debit.getAccountType() == AccountType.PASSIVE && credit.getAccountType() == AccountType.ACTIVE) {
            debit.getSoll().add(amount);
            credit.getSoll().add(amount);
        } else {
            throw new RuntimeException("Error");
        }
        FinancialAccounting.addReceipt(new ChangeReceipt(debit, credit, amount, ActionType.BOOKING));
    }

}

