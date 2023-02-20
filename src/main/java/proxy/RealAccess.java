package proxy;

import user.User;

public class RealAccess implements IAccess {
    private User user;

    public RealAccess(User user){
        this.user = user;
    }

    public void grant(){

    }
}
