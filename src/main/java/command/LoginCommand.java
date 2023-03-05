package command;

import proxy.ProxyAccess;
import user.Role;
import user.User;

public class LoginCommand implements ICommand {
    private final String username;
    private final String password;

    public LoginCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void execute() {
        Role newRole = null;

        for (User user : ProxyAccess.getUsers()) {
            if (user.getName().equals(username)) {
                if (user.getEncryptedPassword().equals(ProxyAccess.md5(password))) {
                    newRole = user.getRole();
                } else {
                    System.out.println("Cannot login as " + username + " because of wrong password");
                    throw new RuntimeException("Cannot log in");
                }
            }
        }

        ProxyAccess.setCurrentUserRole(newRole);
    }
}
