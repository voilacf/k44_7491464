public class Clerk extends User{
    private ICommand command;
    private Role role = Role.CLERK;
    private String name;

    public Clerk(String name, ICommand command){
        this.name = name;
        this.command = command;
        System.out.println("An Clerk has been created.");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //TODO:done??
}
