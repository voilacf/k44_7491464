package memento;

public class MementoCareTaker {
    private static AccountMemento mementoPassiveDest;
    private static AccountMemento mementoActiveSrc;

    public static AccountMemento getMementoPassiveDest() {
        return mementoPassiveDest;
    }

    public static void setMementoPassiveDest(AccountMemento memento) {
        mementoPassiveDest = memento;
    }

    public static AccountMemento getMementoActiveSrc() {
        return mementoActiveSrc;
    }

    public static void setMementoActiveSrc(AccountMemento memento) {
        mementoActiveSrc = memento;
    }
}
