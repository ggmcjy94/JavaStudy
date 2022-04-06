package kwon.abstracts;

import java.util.Scanner;

public class Scheduler {

    private int capacity = 10;
    public Event [] events = new Event[capacity];
    public int n = 0;
    Scanner kb;
    public void processCommand() {
        kb = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("addevent")) {
                String type = kb.next();
                if (type.equalsIgnoreCase("oneday"))
                    handleAddOneDayEvent();
                else if (type.equalsIgnoreCase("duration"))
                    handleAddDurationEvent();
                else if (type.equalsIgnoreCase("deadline"))
                    handleAddDeadlineEvent();

            } else if (command.equals("list")) {
                handleList();

            } else if (command.equals("show")) {
                handleShow();

            } else if (command.equals("exit")) {
                break;
            }
        }
        kb.close();
    }

    private void handleShow() {
        String dataString = kb.next();
        MyDate theData = parseDateString(dataString);
        for (int i = 0; i < n; i++) {
            if (events[i].isRelevant(theData)) {
                System.out.println(events[i].toString());
                // 모든 클래스틑 object 클래스를 상속하기 때문에 toString 이있음
                // 그래서 컴파일시는 문제없다 코드 실행시 다이나믹 바인딩 이 일어나 각각의 재정의 한 class 에
                // toString 으로 오버라이딩 됌
            }
        }
    }

    private void handleList() {
        for (int i = 0; i <n; i++) {
            System.out.println("  " + events[i].toString());
        }
    }

    private void handleAddDeadlineEvent() {
    }

    private void handleAddDurationEvent() {
    }

    private void handleAddOneDayEvent() {
        System.out.print("   when:   ");
        String dateString = kb.next();

        System.out.print("   title:   ");
        String title = kb.next();

        MyDate date = parseDateString(dateString);
        OneDayEvent ev = new OneDayEvent(title, date);

        addEvent(ev);
    }

    private void addEvent(OneDayEvent ev) {
        // 이렇게 뺀 이유는 배열의 재할당
        // 옮겨진후 버려직 배열은 쓰레기 데이터 그런대 자바는 가비지 컬렉션에 의해 정리 해줌
        if (n >= capacity)
            reallocate();
        events[n++] = ev;
    }

    private void reallocate() {

        Event [] tmp = new Event[capacity * 2];
        for (int i = 0; i < n; i++)
            tmp[i] = events[i];
        events = tmp;
        capacity *= 2;
    }

    private MyDate parseDateString(String dateString) {
        String[] tokens = dateString.split("/");
        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]);
        int day = Integer.parseInt(tokens[2]);
        return new MyDate(year, month, day);
    }

    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        scheduler.processCommand();
    }
}
