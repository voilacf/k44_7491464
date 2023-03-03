package command;

import account.ActionType;
import account.ChangeReceipt;
import account.FinancialAccounting;
import account.IAccount;
import memento.AccountMemento;
import memento.MementoCareTaker;

public class UndoCommand implements ICommand {

    //Letzte Buchung rückgängig machen
    public void execute(){
        //TODO: use memento to undo -> overload given account with what is saved in memento
        AccountMemento srcMemento = MementoCareTaker.getMementoActiveSrc();
        AccountMemento destMemento = MementoCareTaker.getMementoPassiveDest();

        IAccount src = FinancialAccounting.getAccount(srcMemento.getName());
        IAccount dest = FinancialAccounting.getAccount(destMemento.getName());

        double amount = Math.abs(src.getHaben().getBalance() - srcMemento.getCredit().getBalance());

        src.restore(srcMemento);
        dest.restore(destMemento);
        System.out.println(src);
        System.out.println(dest);

        FinancialAccounting.addReceipt(new ChangeReceipt(src, dest, amount, ActionType.CANCELLATION));
    }
}
