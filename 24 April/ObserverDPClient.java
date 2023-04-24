import java.util.ArrayList;
import java.util.List;

public class ObserverDPClient {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();
        NewsChannel newsChannel1 = new NewsChannel("NDTV");
        NewsChannel newsChannel2 = new NewsChannel("CNBC18");

        newsAgency.attach(newsChannel1);
        newsAgency.attach(newsChannel2);

        newsAgency.notifyObservers("COVID-19 vaccine approved by FDA");

        newsAgency.detach(newsChannel2);

        newsAgency.notifyObservers("Bitcoin hits all-time high");
    }
}
class NewsChannel implements Observer {
    private String news;
    private String Name;
    public NewsChannel(String _Name)
    {
        this.Name=_Name;
    }
    @Override
    public void update(String message) {
        this.news = message;
        display();
    }

    private void display() {
        System.out.println(this.Name+ " Breaking news: " + news);
    }
}
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

interface Observer {
    void update(String message);
}

interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(String message);
}