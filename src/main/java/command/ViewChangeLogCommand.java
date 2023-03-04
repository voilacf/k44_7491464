package command;

import account.ChangeReceipt;
import account.FinancialAccounting;

public class ViewChangeLogCommand implements ICommand {
    //Anzeige Änderungsprotokoll
    public void execute() {
        for (ChangeReceipt receipt : FinancialAccounting.getReceipts()) {
            receipt.printChangeReceipt();
        }
    }
}
