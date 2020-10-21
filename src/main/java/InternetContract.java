import java.util.Calendar;

public class InternetContract extends Contract {
    private int speed; //МБит

    public InternetContract(long id, Calendar startDate, Calendar endDate, Client client, int speed) {
        super(id, startDate, endDate, client);
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Контракт {" +
                "ID: " + getId() +
                ", Start date: " + getDateFormat().format(getStartDate().getTime()) +
                ", End date: " + getDateFormat().format(getEndDate().getTime()) +
                ", Client: " + getClient() +
                '}';
    }
}
