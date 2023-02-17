public class ProxyAccess implements IAccess{
    private User user;
    private RealAccess realAccess;

    public ProxyAccess(User user, RealAccess realaccess){
        this.user = user;
        this.realAccess = realAccess;
    }

    public void grant(){

    }
}
