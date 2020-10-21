import java.util.Calendar;

/**
 * Internet contract entity
 */
public class InternetContract extends Contract {

    /**
     * Internet speed under the contract. Measured in megabits.
     * */
    private int speed;

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
        return "Contract{" +
                "ID: " + getId() +
                ", Start date: " + getDateFormat().format(getStartDate().getTime()) +
                ", End date: " + getDateFormat().format(getEndDate().getTime()) +
                ", Client: " + getClient() +
                '}';
    }
}
