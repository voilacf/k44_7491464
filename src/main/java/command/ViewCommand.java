package command;

import account.IAccount;

public class ViewCommand implements ICommand {
    private IAccount account;

    public ViewCommand(IAccount account){
        this.account = account;
    }

    //TODO: good like that?
    public void execute(){
        double[] content = account.getContent();
        for(int i = 0; i < 2; i++){
            System.out.println(content[i]);
        }
    }
}
