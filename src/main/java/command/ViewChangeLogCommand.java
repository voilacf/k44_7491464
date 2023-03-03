package command;

import account.ChangeReceipt;
import account.FinancialAccounting;
import command.ICommand;

public class ViewChangeLogCommand implements ICommand {
    //Anzeige Änderungsprotokoll
    public void execute(){
        for(ChangeReceipt receipt : FinancialAccounting.getReceipts()) {
            receipt.printChangeReceipt();
        }
    }
}
