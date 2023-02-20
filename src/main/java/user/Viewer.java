package user;

import command.ICommand;
import user.Role;
import user.User;

public class Viewer extends User {
    private ICommand command;
    private Role role = Role.VIEWER;
    private String name;
    private String password; //TODO: check, does this really belong here?

    public Viewer(String name, ICommand command){
        this.name = name;
        this.command = command;
        System.out.println("An user.Viewer has been created.");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    //TODO: done?
}
