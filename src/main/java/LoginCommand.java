public class LoginCommand implements ICommand{
    private String username;
    private String password;

    public LoginCommand(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void execute(){

    }
}
