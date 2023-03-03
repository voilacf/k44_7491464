package user;

public abstract class User {
    private final String name;
    private final String encryptedPassword;
    private final Role role;

    public User(String name, String encryptedPassword, Role role) {
        this.name = name;
        this.encryptedPassword = encryptedPassword;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public Role getRole() {
        return role;
    }
}
