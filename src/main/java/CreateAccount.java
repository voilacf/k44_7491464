public class CreateAccount implements ICommand{
    private String name;
    private AccountType type;
    private double initialBalance;

    public CreateAccount(String name, AccountType type, double initialBalance){
        this.name = name;
        this.type = type;
        this.initialBalance = initialBalance;
    }

    public void execute(){

    }
}
