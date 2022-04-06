package kwon.abstracts;

public class DeadlinedEvent extends Event{

    public MyDate deadline;

    public DeadlinedEvent(String title, MyDate deadline) {
        super(title);
        this.deadline = deadline;
    }
    
    @Override
    public boolean isRelevant(MyDate date) {
        return deadline.compareTo(date) >= 0;
    }


    @Override
    public String toString() {
        return title + ", " + deadline.toString();
    }
}
