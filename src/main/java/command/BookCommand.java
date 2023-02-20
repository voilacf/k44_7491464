package command;

import command.ICommand;

public class BookCommand implements ICommand {
    private double debit;
    private double credit;
    private double amount;

    public BookCommand(double debit, double credit, double amount){
        this.debit = debit;
        this.credit = credit;
        this.amount = amount;
    }

    public void execute(){
        //TODO: make an booking
    }
}
