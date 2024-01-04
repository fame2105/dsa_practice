package design.patterns.behavioral.observer.example1;

public interface Observable {
    void registerObserver(Observer o);
    void unRegisterObserver(Observer o);
    void notifyObservers();
}
