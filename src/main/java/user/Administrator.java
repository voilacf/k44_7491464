package user;


public class Administrator extends User {
    public Administrator(String name, String encryptedPassword){
        super(name, encryptedPassword, Role.ADMINISTRATOR);
        System.out.println("An viewer has been created.");
    }
}
