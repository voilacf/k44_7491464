package command;

public class LoginCommand implements ICommand {
    private final String username;
    private final String password;

    public LoginCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void execute() {

    }
}
