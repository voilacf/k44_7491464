public abstract class Account {
    public abstract AccountMemento save();
    public abstract void restore(AccountMemento memento);
}
