package command;

import account.AccountType;
import account.IAccount;

import java.util.ArrayList;

public class ViewCommand implements ICommand {
    private final IAccount account;
    private ArrayList<Double> debit;
    private ArrayList<Double> credit;

    public ViewCommand(IAccount account) {
        this.account = account;
        debit = new ArrayList<>();
        credit = new ArrayList<>();
    }

    public void execute() {
        int size = 0;
        if (account.getAccountType() == AccountType.ACTIVE) {
            System.out.println("Account " + account.getName() + " initial balance: [" + account.getSoll().getOpeningBalance() + "]");
            System.out.println("Debit       ||     Credit");
            System.out.println("——————————————————————————");
            credit = account.getHaben().getContent();
            debit = account.getSoll().getContent();
        } else {
            System.out.println("Account " + account.getName() + " initial balance: [" + account.getHaben().getOpeningBalance() + "]");
            System.out.println("Debit       ||     Credit");
            System.out.println("——————————————————————————");
            credit = account.getHaben().getContent();
            debit = account.getSoll().getContent();
        }
        //TODO: DONE?
        if (debit.size() < credit.size()) {
            size = credit.size();
            int extranulls = size - debit.size();
            for (int i = 0; i < extranulls; i++) {
                debit.add(0.0);
            }
        } else {
            size = debit.size();
            int extranulls = size - credit.size();
            for (int i = 0; i < extranulls; i++) {
                credit.add(0.0);
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(debit.get(i) + "      ||     " + credit.get(i));
        }
        System.out.println("——————————————————————————");
        if (account.getAccountType() == AccountType.ACTIVE) {
            System.out.println(account.getSoll().getBalance() + "      ||   " + account.getHaben().getBalance());
            System.out.println("New Balance: [" + (account.getSoll().getBalance() - account.getHaben().getBalance()) + "]\n");
        } else {
            System.out.println(account.getSoll().getBalance() + "      ||   " + account.getHaben().getBalance());
            System.out.println("New Balance: [" + (account.getHaben().getBalance() - account.getSoll().getBalance()) + "]\n");
        }

    }

}
