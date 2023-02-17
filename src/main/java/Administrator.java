public class Administrator extends User{
    private ICommand command;
    private Role role = Role.ADMINISTRATOR;
    private String name;

    public Administrator(String name, ICommand command){
        this.name = name;
        this.command = command;
        System.out.println("An Administrator has been created.");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //TODO: done???
}
