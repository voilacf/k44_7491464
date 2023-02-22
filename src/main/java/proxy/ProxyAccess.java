package proxy;

import command.ICommand;
import user.User;

public class ProxyAccess implements IAccess {
    private User user;
    private RealAccess realAccess;

    public ProxyAccess(User user, RealAccess realaccess){
        this.user = user;
        this.realAccess = realAccess;
    }

    public void login(String name, String password){

    }

    public void grant(){

    }
}
