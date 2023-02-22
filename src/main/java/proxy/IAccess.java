package proxy;

public interface IAccess {
    void login(String name, String password);
    void grant();
}
