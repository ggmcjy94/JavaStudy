package kwon.abstracts;

public class OneDayEvent extends Event{
    public MyDate myDate;

    public OneDayEvent(String title, MyDate myDate) {
        super(title);
        this.myDate = myDate;
    }

    @Override
    public boolean isRelevant(MyDate date) {
       return this.myDate.compareTo(date) == 0;
    }

    @Override
    public String toString() {
        return title +", " + myDate.toString() ;
    }
}
