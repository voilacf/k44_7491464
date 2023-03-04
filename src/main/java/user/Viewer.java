package user;

public class Viewer extends User {
    public Viewer(String name, String encryptedPassword) {
        super(name, encryptedPassword, Role.VIEWER);
        System.out.println("An viewer has been created.");
    }
}
