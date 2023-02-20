package memento;

public class MementoCareTaker {
    private PassiveAccountMemento mementoPassive;
    private ActiveAccountMemento mementoActive;

    public PassiveAccountMemento getMementoPassive(){
        return mementoPassive;
    }

    public void setMementoPassive(PassiveAccountMemento memento){
        mementoPassive = memento;
    }

    public ActiveAccountMemento getMementoActive(){
        return mementoActive;
    }

    public void setMementoActive(ActiveAccountMemento memento){
        mementoActive = memento;
    }
}
