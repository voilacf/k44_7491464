package user;

public class Clerk extends User {
    public Clerk(String name, String encryptedPassword) {
        super(name, encryptedPassword, Role.CLERK);
        System.out.println("An Clerk has been created.");
    }
}
