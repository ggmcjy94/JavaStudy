package kwon.abstracts;

public abstract class Event {
    public String title;

    public abstract boolean isRelevant(MyDate date);

    public Event(String title) {
        this.title = title;
    }

}
